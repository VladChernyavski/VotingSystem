package by.chernyavski.repository;

import by.chernyavski.RestaurantTestData;
import by.chernyavski.model.Restaurant;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.List;

import static by.chernyavski.RestaurantTestData.*;
import static org.junit.Assert.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
public class RestaurantRepositoryTest {

    @Autowired
    private RestaurantRepository repository;

    @Test
    public void save() {

    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
        Restaurant restaurant = repository.get(1003);
        Assertions.assertThat(restaurant).isEqualToIgnoringGivenFields(restaurant2, "meals");
    }

    @Test
    public void getAll() {
        List<Restaurant> restaurants = repository.getAll();
        Assertions.assertThat(RestaurantTestData.restaurants).usingElementComparatorIgnoringFields("meals").isEqualTo(restaurants);
    }
}