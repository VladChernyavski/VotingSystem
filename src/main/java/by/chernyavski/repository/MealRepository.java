package by.chernyavski.repository;

import by.chernyavski.model.Meal;

import java.util.List;

public interface MealRepository {

    Meal save(Meal meal, int restaurantId);

    boolean delete(int id, int restaurantId);

    Meal get(int id, int restaurantId);

    List<Meal> getAll(int restaurantId);

    List<Meal> getAllWithoutId();
}
