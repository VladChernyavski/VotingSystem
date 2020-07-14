package by.chernyavski.repository.datajpa;

import by.chernyavski.model.Restaurant;
import by.chernyavski.repository.RestaurantRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {

    private CrudRestaurantRepository restaurantRepository;

    public DataJpaRestaurantRepository(CrudRestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }
}
