package by.chernyavski.web.restaurant;

import by.chernyavski.model.Restaurant;
import by.chernyavski.model.Vote;
import by.chernyavski.repository.MealRepository;
import by.chernyavski.repository.RestaurantRepository;
import by.chernyavski.repository.VoteRepository;
import by.chernyavski.util.VoteCounterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "/restaurants")
public class RestaurantController {
    private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);

    private final RestaurantRepository restaurantRepository;
    private final MealRepository mealRepository;
    private final VoteRepository voteRepository;

    public RestaurantController(RestaurantRepository restaurantRepository, MealRepository mealRepository, VoteRepository voteRepository) {
        this.restaurantRepository = restaurantRepository;
        this.mealRepository = mealRepository;
        this.voteRepository = voteRepository;
    }

    @GetMapping
    public String getAll(Model model){
        List<Vote> votes = voteRepository.getAllByDateWithRest(LocalDate.now());
        model.addAttribute("restaurantsTo", VoteCounterUtil.getTo(restaurantRepository.getAll(),
                votes));
        model.addAttribute("meals", mealRepository.getAllWithoutId());
        model.addAttribute("votesSize", votes.size());
        log.info("getAll restaurants");
        return "restaurantBoot";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id){
        restaurantRepository.delete(id);
        return "redirect:/restaurants";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("restaurant", new Restaurant());
        return "restaurantForm";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable(name = "id") Integer id){
        model.addAttribute("restaurant", restaurantRepository.get(id));
        return "restaurantForm";
    }

    @PostMapping
    public String createOrUpdate(HttpServletRequest request){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getParameter("name"));
        if(!request.getParameter("id").isEmpty()){
            restaurant.setId(Integer.parseInt(request.getParameter("id")));
        }
        restaurantRepository.save(restaurant);
        return "redirect:/restaurants";
    }


}
