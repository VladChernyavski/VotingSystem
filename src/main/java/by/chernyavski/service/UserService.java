package by.chernyavski.service;

import by.chernyavski.repository.UserRepository;

public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

}
