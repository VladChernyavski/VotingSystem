package by.chernyavski;

import by.chernyavski.model.Meal;
import by.chernyavski.model.Restaurant;

import java.util.*;

import static by.chernyavski.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {

    /*
    INSERT INTO users (name, email, password)
    VALUES ('User', 'user@gmail.com', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

    INSERT INTO user_roles (role, user_id)
    VALUES ('USER', 1000),
       ('ADMIN', 1001);

    INSERT INTO restaurant (id, name)
    VALUES (1002, 'Italy restaurant'),
       (1003, 'Franc restaurant'),
               (1004, 'Russian restaurant');

    INSERT INTO meals (dish_name, price, restaurant_id)
    VALUES ('Картошка', 500, 1004),
       ('Мясо', 900, 1004),
               ('Макароны', 600, 1002),
               ('Пицца', 570, 1002),
               ('Булочка', 100, 1003);
    */

    public static final int NOT_FOUND = 10;
    public static final int RESTAURANT_ID = START_SEQ;

    public static final Meal meal1 = new Meal(1002, "Картошка", 500d);
    public static final Meal meal2 = new Meal(1003, "Мясо", 900d);
    public static final Meal meal3 = new Meal(1004, "Макароны", 600d);
    public static final Meal meal4 = new Meal(1005, "Пицца", 570d);
    public static final Meal meal5 = new Meal(1006, "Булочка", 100d);

    public static final Restaurant restaurant1 = new Restaurant(1002, "Italy restaurant", new ArrayList<>(){{
        add(meal3);
        add(meal4);
    }});
    public static final Restaurant restaurant2 = new Restaurant(1003, "Franc restaurant", new ArrayList<>(){{
        add(meal5);
    }});
    public static final Restaurant restaurant3 = new Restaurant(1004, "Russian restaurant", new ArrayList<>(){{
        add(meal1);
        add(meal2);
    }});

    public static List<Restaurant> restaurants = new ArrayList<>(){{
       add(restaurant1);
       add(restaurant2);
       add(restaurant3);
    }};


}
