package by.chernyavski.repository;

import by.chernyavski.model.Meal;
import by.chernyavski.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);

    // false if meal do not belong to userId
    boolean delete(int id);

    // null if meal do not belong to userId
    Restaurant get(int id);

    // ORDERED dateTime desc
    List<Restaurant> getAll();
}
