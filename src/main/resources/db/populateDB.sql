DELETE FROM user_role;
DELETE FROM meals;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (user_id, datetime, description, calories)
VALUES (100000, TO_TIMESTAMP('2024-06-15 08:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'Завтрак юзера', 500),
       (100000, TO_TIMESTAMP('2024-06-15 12:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'Обед юзера', 1000),
       (100000, TO_TIMESTAMP('2024-06-15 18:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'Ужин юзера', 400),
       (100000, TO_TIMESTAMP('2024-06-16 08:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'Завтрак юзера', 500),
       (100000, TO_TIMESTAMP('2024-06-16 12:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'Обед юзера', 1000),
       (100000, TO_TIMESTAMP('2024-06-16 18:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'Ужин юзера', 600),
       (100001, TO_TIMESTAMP('2024-06-15 08:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'Завтрак админа', 500),
       (100001, TO_TIMESTAMP('2024-06-15 12:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'Обед админа', 1000),
       (100001, TO_TIMESTAMP('2024-06-15 18:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'Ужин админа', 400),
       (100001, TO_TIMESTAMP('2024-06-17 08:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'Завтрак админа', 800),
       (100001, TO_TIMESTAMP('2024-06-17 12:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'Обед админа', 1000),
       (100001, TO_TIMESTAMP('2024-06-17 18:30:00', 'YYYY-MM-DD HH24:MI:SS'), 'Ужин админа', 1000);
