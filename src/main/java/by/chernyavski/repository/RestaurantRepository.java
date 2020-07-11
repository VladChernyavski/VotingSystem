package by.chernyavski.repository;

import by.chernyavski.model.Meal;
import by.chernyavski.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant, int userId);

    // false if meal do not belong to userId
    boolean delete(int id, int userId);

    // null if meal do not belong to userId
    Restaurant get(int id, int userId);

    // ORDERED dateTime desc
    List<Restaurant> getAll(int userId);
}
