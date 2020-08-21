package by.chernyavski.web.meal;

import by.chernyavski.model.Meal;
import by.chernyavski.model.Restaurant;
import by.chernyavski.repository.MealRepository;
import by.chernyavski.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/{restId}/meals")
public class MealController {
    private static final Logger log = LoggerFactory.getLogger(MealController.class);

    private final MealRepository mealRepository;
    private final RestaurantRepository restaurantRepository;

    public MealController(MealRepository mealRepository, RestaurantRepository restaurantRepository) {
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping
    public String getAll(Model model, @PathVariable(name = "restId") Integer restId){
        model.addAttribute("meals", mealRepository.getAll(restId));
//        log.info("getAll meals for restaurant {}", restaurantRepository.get(restId));
        return "meals";
    }

    @GetMapping("/create")
    public String create(Model model, @PathVariable(name = "restId") Integer restId){
        Restaurant restaurant = restaurantRepository.get(restId);
        Meal meal = new Meal();
        meal.setRestaurant(restaurant);
        model.addAttribute("meal", meal);
        return "mealForm";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable(name = "restId") Integer restId,
                         @PathVariable(name = "id") Integer id){
        model.addAttribute("meal", mealRepository.get(id, restId));
        return "mealForm";
    }

    @PostMapping
    public String createOrUpdate(HttpServletRequest request){
        Meal meal = new Meal();
        int restId = Integer.parseInt(request.getParameter("restId"));
        meal.setDishName(request.getParameter("dishName"));
        meal.setPrice(Double.parseDouble(request.getParameter("price")));
        if(!request.getParameter("id").isEmpty()){
           meal.setId(Integer.parseInt(request.getParameter("id")));
        }
        mealRepository.save(meal, restId);
        return "redirect:/" + restId + "/meals";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "restId") Integer restId,
                         @PathVariable(name = "id") Integer id){
        mealRepository.delete(id, restId);
        return "redirect:/" + restId + "/meals";
    }

}
