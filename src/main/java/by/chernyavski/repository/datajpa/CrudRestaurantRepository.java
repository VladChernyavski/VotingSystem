package by.chernyavski.repository.datajpa;

import by.chernyavski.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {



}
