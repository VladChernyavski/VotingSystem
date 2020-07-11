DELETE
FROM user_roles;
DELETE
FROM meals;
DELETE
FROM users;
DELETE
FROM restaurant;
ALTER SEQUENCE global_seq RESTART WITH 1000;

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
