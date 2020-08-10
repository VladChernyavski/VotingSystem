package by.chernyavski.repository;

import by.chernyavski.model.Meal;

import java.util.List;

public interface MealRepository {
    // null if updated meal do not belong to userId
    Meal save(Meal meal, int restaurantId);

    // false if meal do not belong to userId
    boolean delete(int id, int restaurantId);

    // null if meal do not belong to userId
    Meal get(int id, int restaurantId);

    // ORDERED dateTime desc
    List<Meal> getAll(int restaurantId);

    List<Meal> getAllWithoutId();
}
