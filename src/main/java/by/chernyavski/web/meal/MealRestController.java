package by.chernyavski.web.meal;

import by.chernyavski.model.Meal;
import by.chernyavski.repository.MealRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/restaurants/{restId}/meals", produces = MediaType.APPLICATION_JSON_VALUE)
public class MealRestController {

    private final MealRepository mealRepository;

    public MealRestController(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @GetMapping
    public List<Meal> getAll(@PathVariable(value = "restId") int id){
        return mealRepository.getAll(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id, @PathVariable int restId){
        mealRepository.delete(id, restId);
    }

    @GetMapping("/{id}")
    public Meal get(@PathVariable int id, @PathVariable int restId){
        return mealRepository.get(id, restId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Meal create(@RequestBody Meal meal, @PathVariable int restId){
        return mealRepository.save(meal, restId);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Meal meal, @PathVariable int restId){
        mealRepository.save(meal, restId);
    }
}
