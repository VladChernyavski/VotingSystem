package by.chernyavski.service;

import by.chernyavski.repository.MealRepository;

public class MealService {

    private MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

}
