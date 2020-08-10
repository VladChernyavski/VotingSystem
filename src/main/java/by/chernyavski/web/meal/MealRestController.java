package by.chernyavski.web.meal;

import by.chernyavski.model.Meal;
import by.chernyavski.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/{restId}/meals", produces = MediaType.APPLICATION_JSON_VALUE)
public class MealRestController {

    private final MealRepository mealRepository;

    public MealRestController(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @GetMapping
    public List<Meal> getAll(@PathVariable(value = "restId") int id){
        return mealRepository.getAll(id);
    }
}
