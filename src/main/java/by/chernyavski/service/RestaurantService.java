package by.chernyavski.service;

import by.chernyavski.repository.RestaurantRepository;

public class RestaurantService {

    private RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

}
