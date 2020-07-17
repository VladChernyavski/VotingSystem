package by.chernyavski.repository.meal;

import by.chernyavski.model.Meal;
import by.chernyavski.repository.MealRepository;
import by.chernyavski.repository.restaurant.CrudRestaurantRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DataJpaMealRepository implements MealRepository {

    private CrudMealRepository mealRepository;
    private CrudRestaurantRepository restaurantRepository;

    public DataJpaMealRepository(CrudMealRepository mealRepository, CrudRestaurantRepository restaurantRepository){
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    @Transactional
    public Meal save(Meal meal, int restaurantId) {
        if(!meal.isNew() && get(meal.getId(), restaurantId) == null){
            return null;
        }
        meal.setRestaurant(restaurantRepository.getOne(restaurantId));
        return mealRepository.save(meal);
    }

    @Override
    public boolean delete(int id, int restaurantId) {
        return mealRepository.delete(id, restaurantId) != 0;
    }

    @Override
    public Meal get(int id, int restaurantId) {
        return mealRepository.findById(id)
                .filter(meal -> meal.getRestaurant().getId() == restaurantId)
                .orElse(null);
    }

    @Override
    public List<Meal> getAll(int restaurantId) {
        return mealRepository.getAll(restaurantId);
    }
}
