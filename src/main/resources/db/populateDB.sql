DELETE
FROM user_roles;
DELETE
FROM meals;
DELETE
FROM users;
DELETE
FROM restaurants;
ALTER SEQUENCE global_seq RESTART WITH 1000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@gmail.com', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 1000),
       ('ADMIN', 1001);

INSERT INTO restaurants (id, name)
VALUES (1002, 'Italy restaurant'),
       (1003, 'France restaurant'),
       (1004, 'Russian restaurant');

INSERT INTO meals (dish_name, price, restaurant_id)
VALUES ('Оливье', 500, 1004),
       ('Мясо', 900, 1004),
       ('Макароны', 600, 1002),
       ('Пицца', 570, 1002),
       ('Круассан', 100, 1003);

INSERT INTO votes (date, user_id, restaurant_id)
VALUES ('2020-08-17', 1001, 1004),
       ('2020-08-17', 1000, 1004),
       ('2020-08-18', 1000, 1002);
