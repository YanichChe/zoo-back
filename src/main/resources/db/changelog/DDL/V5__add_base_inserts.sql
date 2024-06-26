----------------------------------------------------------------------

--     _____   _______ __________  ___________
--     /  _/ | / / ___// ____/ __ \/_  __/ ___/
--    / //  |/ /\__ \/ __/ / /_/ / / /  \__ \
--   _/ // /|  /___/ / /___/ _, _/ / /  ___/ /
--  /___/_/ |_//____/_____/_/ |_| /_/  /____/

----------------------------------------------------------------------
INSERT INTO public.staff_type (id, type) 
VALUES (1, 'Ветеринары'),
 (2, 'Уборщики'),
 (3, 'Дрессировщики'),
 (4, 'Строители-работники'),
 (5, 'Работники администрации');
ALTER SEQUENCE public.staff_type_id_seq RESTART WITH 6;

INSERT INTO public.gender (id, gender) 
VALUES (1, 'FEMALE'),
       (2, 'MALE');

INSERT INTO public.staff (id, name, surname, middle_name, birthday, gender_id) 
VALUES (1, 'Яна', 'Шукшина', 'Александровна', '1999-01-01', 1),
(2, 'Мария', 'Достоевкая', 'Денисовна', '2000-08-31', 1),
(3, 'Екатерина', 'Пушкина', 'Сергеевга', '2003-03-06', 1),
(4, 'Дмитрий', 'Островский', 'Константинович', '1988-12-31', 2),
(5, 'Константин', 'Маяковский', 'Владиславович', '2000-01-30', 2),
(6, 'Алексей', 'Ким', 'Алексеевич', '1987-05-05', 2),
(7, 'Роман', 'Гоголь', 'Максимович', '1988-07-04', 2);
ALTER SEQUENCE public.staff_id_seq RESTART WITH 8;

INSERT INTO public.staff_history (staff_id, date_start, date_end, salary, staff_type) 
VALUES (2, '2020-01-01', null, 30000.00, 1),
 (3, '2020-01-01', null, 30000.00, 2),
 (4, '2020-01-01', null, 30000.00, 3),
 (5, '2020-01-01', null, 30000.00, 4),
 (5, '2019-01-01', '2020-01-01', 30000.00, 4),
 (6, '2020-01-01', null, 30000.00, 1),
 (7, '2020-01-01', null, 30000.00, 2),
 (1, '2016-01-01', null, 50000.00, 5);

INSERT INTO public.authority (id, authority) 
VALUES (1, 'Доступ в клетку'),
 (2, 'Проводить осмотр'),
 (3, 'Ставить прививку'),
 (4, 'Распоряжаться потомством'),
 (5, 'Доступ к инветарю'),
 (6, 'Доступ к строй-материалам'),
 (7, 'Дрессировать');
ALTER SEQUENCE public.authority_id_seq RESTART WITH 8;

INSERT INTO public.authority_staff_type (authority_id, staff_type_id) 
VALUES (1, 1),
 (1, 2),
 (1, 3),
 (1, 5),
 (2, 1),
 (3, 1),
 (4, 5),
 (5, 2),
 (5, 4),
 (6, 4),
 (7, 3);

INSERT INTO public.climate_zones (id, is_cold_tolerance, climate_zone_name) 
VALUES (1, true, 'Экваториальный'),
 (2, true, 'Субэкваториальный'),
 (3, true, 'Тропический'),
 (4, true, 'Субтропиечский'),
 (5, true, 'Умеренный'),
 (6, false, 'Субарктический'),
 (7, false, 'Арктический');
ALTER SEQUENCE public.climate_zones_id_seq RESTART WITH 8;

INSERT INTO public.nutrition_type (id, type) 
VALUES (1, 'Травоядный'),
       (2, 'Хищник'),
       (3, 'Всеядный');
ALTER SEQUENCE public.nutrition_type_id_seq RESTART WITH 4;

INSERT INTO public.animals (id, animal_title, climate_zone_id, nutrition_type_id) 
VALUES (1, 'Лев', 1, 2),
 (2, 'Обезьяна', 2, 3),
 (3, 'Попугай', 3, 1),
 (4, 'Ящерица', 4, 3),
 (5, 'Олень', 5, 1),
 (6, 'Лиса', 6, 2),
 (7, 'Белый медведь', 7, 2),
 (8, 'Жираф', 1, 1),
 (9, 'Слон', 2, 3),
 (10, 'Дельфин', 3, 1),
 (11, 'Крокодил', 4, 2),
 (12, 'Кабан', 5, 2),
 (13, 'Коала', 6, 3),
 (14, 'Пингвин', 7, 1),
 (15, 'Тигр', 1, 2),
 (16, 'Гепард', 2, 2),
 (17, 'Анаконда', 3, 2),
 (18, 'Кенгуру', 4, 3),
 (19, 'Воробей', 5, 1),
 (20, 'Заяц', 6, 3),
 (21, 'Морж', 7, 1),
 (22, 'Шимпанзе', 2, 3),
 (23, 'Гиена', 3, 2),
 (24, 'Игуана', 4, 3),
 (25, 'Лось', 5, 1),
 (26, 'Волк', 6, 2);
ALTER SEQUENCE public.animals_id_seq RESTART WITH 27;

INSERT INTO public.files (id, path) 
VALUES (1, 'photos/anaconda.jpg'),
 (2, 'photos/ara.jpg'),
 (3, 'photos/crocodile.jpg'),
 (4, 'photos/default.png'),
 (5, 'photos/dolphin.jpg'),
 (6, 'photos/dragon.jpeg'),
 (7, 'photos/elephant.jpg'),
 (8, 'photos/fox.jpeg'),
 (9, 'photos/gepard.jpg'),
 (10, 'photos/giraffe.jpg'),
 (11, 'photos/huena.jpg'),
 (12, 'photos/kengoroo.jpeg'),
 (13, 'photos/koala.jpg'),
 (14, 'photos/lion.jpg'),
 (15, 'photos/lizard.jpg'),
 (16, 'photos/los.jpg'),
 (17, 'photos/monkey.jpg'),
 (18, 'photos/noa.jpg'),
 (19, 'photos/olen.jpg'),
 (20, 'photos/pig.JPG'),
 (21, 'photos/pingvin.png'),
 (22, 'photos/polar_bear.jpg'),
 (23, 'photos/schimpanse.jpg'),
 (24, 'photos/tiger.jpg'),
 (25, 'photos/vorobey.jpg'),
 (26, 'photos/wolf.jpeg'),
 (27, 'photos/zayaz.jpg'),
(28, 'photos/girl1.jpeg'),
(29, 'photos/girl2.jpeg'),
(30, 'photos/girl3.jpeg'),
(31, 'photos/man1.jpeg'),
(32, 'photos/man2.jpeg'),
(33, 'photos/man3.jpeg'),
(34, 'photos/man4.jpeg');
ALTER SEQUENCE public.files_id_seq RESTART WITH 35;

INSERT INTO public.physical_state (id, state) 
VALUES (1, 'Здоров'), (2, 'Болен');
ALTER SEQUENCE public.physical_state_id_seq RESTART WITH 2;

INSERT INTO public.individuals (id, name, date, animal_id, is_alive, height, weight, physical_state_id, photo_id, gender_id) 
VALUES (1, 'Гога', '2018-01-01', 1, true, 30, 10, 1, 4, 1),
 (2, 'Артем', '2021-01-01', 2, true, 10, 5, 1, 4, 2),
 (3, 'Аврора', '2023-01-01', 3, true, 15, 20, 1, 4, 1),
 (4, 'Настя', '2024-01-01', 4, true, 5, 40, 1, 4, 1),
 (5, 'Катя', '2019-01-01', 5, true, 20, 30, 1, 4, 1),
 (6, 'Максим', '2016-01-01', 6, true, 15, 30, 1, 4, 2),
 (7, 'Натали', '2020-02-01', 7, true, 50, 15, 1, 4, 1),
 (8, 'Антонио', '2021-01-01', 8, true, 20, 20, 1, 4, 2),
 (9, 'Артемий', '2023-03-01', 9, true, 17, 5, 1, 4, 2),
 (10, 'Ира', '2022-01-01', 10, true, 20, 25, 1, 4, 1),
 (11, 'Нана', '2020-04-01', 11, true, 23, 27, 1, 4, 1),
 (12, 'Кука', '2017-01-01', 12, true, 10, 5, 1, 4, 1),
 (13, 'Мари', '2020-01-01', 13, true, 55, 20, 1, 4, 1),
 (14, 'Жожо', '2023-05-01', 14, true, 20, 20, 1, 4, 2),
 (15, 'Муня', '2021-01-01', 15, true, 21, 26, 1, 4, 2),
 (16, 'Картер', '2020-01-01', 16, true, 27, 8, 1, 4, 1),
 (17, 'Зина', '2022-06-01', 17, true, 7, 8, 1, 4, 1),
 (18, 'Мухтар', '2023-01-01', 18, true, 14, 3, 1, 4, 2),
 (19, 'Рэкс', '2016-01-01', 19, true, 15, 5, 1, 4, 2),
 (20, 'Миник', '2018-02-01', 20, true, 22, 20, 1, 4, 2),
 (21, 'Кристина', '2020-01-01', 23, true, 80, 32, 1, 4, 1),
 (22, 'Муша', '2023-01-01', 24, true, 0, 0, 1, 4, 1),
 (23, 'Каш', '2022-01-01', 25, true, 0, 0, 1, 4, 2),
 (24, 'Куш', '2023-01-01', 26, true, 0, 0, 1, 4, 2);
ALTER SEQUENCE public.individuals_id_seq RESTART WITH 25;

INSERT INTO public.prohibited_combinations_settlement (animal_id_1, animal_id_2) 
VALUES (1, 5),
       (1, 26),
       (1, 2);

INSERT INTO public.season (id, season) 
VALUES (1, 'ЗИМА'),
       (2, 'ВЕСНА'),
       (3, 'ЛЕТО'),
       (4, 'ОСЕНЬ');

INSERT INTO public.diet_characteristics (id, age, physical_state_id, season_id, animal_id)
VALUES (1, 2, 1, 1, 1),
 (2, 2, 1, 2, 1),
 (3, 2, 1, 3, 1),
 (4, 2, 1, 4, 1),
 (5, 2, 2, 1, 1),
 (6, 2, 2, 2, 1),
 (7, 2, 2, 3, 1),
 (8, 2, 2, 4, 1),
 (9, 2, 1, 1, 2),
 (10, 2, 1, 2, 2),
 (11, 2, 1, 3, 2),
 (12, 2, 1, 4, 2),
 (13, 2, 2, 1, 2),
 (14, 2, 2, 2, 2),
 (15, 2, 2, 3, 2),
 (16, 2, 2, 4, 2);
ALTER SEQUENCE public.diet_characteristics_id_seq RESTART WITH 17;

INSERT INTO public.feed_type (id, type) 
VALUES (1, 'Растительный'),
 (2, 'Живой'),
 (3, 'Мясо'),
 (4, 'Комбикорм');
ALTER SEQUENCE public.feed_type_id_seq RESTART WITH 5;

INSERT INTO public.food (id, food_name, feed_type_id, self_sufficiency) 
VALUES (1, 'Яблоко', 1, false),
 (2, 'Банан', 1, false),
 (3, 'Огурец', 1, false),
 (4, 'Помидор', 1, false),
 (5, 'Зерно', 1, false),
 (6, 'Сено', 1, false),
 (7, 'Мышь', 2, false),
 (8, 'Птица', 2, false),
 (9, 'Корм для рыб', 2, false),
 (10, 'Комбикорм', 3, false);
ALTER SEQUENCE public.food_id_seq RESTART WITH 11;

INSERT INTO public.dimension (id, dimension) 
VALUES (1, 'кг'),
 (2, 'сток'),
 (3, 'лопата'),
 (4, 'ведро');
ALTER SEQUENCE public.dimension_id_seq RESTART WITH 5;

INSERT INTO public.diet (id, diet_characteristics_id, food_id, count, dimension_id, time)
VALUES (1, 1, 2, 3, 4, '04:05:06');
ALTER SEQUENCE public.diet_id_seq RESTART WITH 2;

INSERT INTO public.food_providers (id, provider) 
VALUES (1, 'ООО ФудСтрит'),
 (2, 'ПАО Фуд'),
 (3, 'ООО АниЛав'),
 (4, 'Зоопарк');
ALTER SEQUENCE public.food_providers_id_seq RESTART WITH 5;

INSERT INTO public.provider_history (id, date, food_id, provider_id, number, dimension_id, price)
VALUES (1, '2019-01-01 00:00:00.000000 +00:00', 1, 1, 3, 1, 1545.52),
 (2, '2019-01-01 00:00:00.000000 +00:00', 2, 1, 15, 1, 5000.52),
 (3, '2020-01-01 00:00:00.000000 +00:00', 3, 1, 33, 1, 84567.52),
 (4, '2020-01-01 00:00:00.000000 +00:00', 4, 2, 40, 1, 5000.52),
 (5, '2020-01-01 00:00:00.000000 +00:00', 5, 2, 16, 1, 4589.52),
 (6, '2020-01-01 00:00:00.000000 +00:00', 6, 2, 18, 1, 78945.52),
 (7, '2020-01-01 00:00:00.000000 +00:00', 7, 1, 20, 1, 5000.52),
 (8, '2020-01-01 00:00:00.000000 +00:00', 8, 1, 32, 1, 32567.52),
 (9, '2020-01-01 00:00:00.000000 +00:00', 9, 1, 33, 1, 5000.52),
 (10, '2021-01-01 00:00:00.000000 +00:00', 10, 2, 35, 1, 4823.52),
 (11, '2022-01-01 00:00:00.000000 +00:00', 1, 2, 50, 1, 8529.52),
 (12, '2019-01-01 00:00:00.000000 +00:00', 1, 1, 3, 1, 1545.52),
 (13, '2019-01-01 00:00:00.000000 +00:00', 2, 1, 15, 1, 5000.52),
 (14, '2020-01-01 00:00:00.000000 +00:00', 3, 1, 33, 1, 84567.52),
 (15, '2020-01-01 00:00:00.000000 +00:00', 4, 2, 40, 1, 5000.52),
 (16, '2020-01-01 00:00:00.000000 +00:00', 5, 2, 16, 1, 4589.52),
 (17, '2020-01-01 00:00:00.000000 +00:00', 6, 2, 18, 1, 78945.52),
 (18, '2020-01-01 00:00:00.000000 +00:00', 7, 1, 20, 1, 5000.52),
 (19, '2020-01-01 00:00:00.000000 +00:00', 8, 1, 32, 1, 32567.52),
 (20, '2020-01-01 00:00:00.000000 +00:00', 9, 1, 33, 1, 5000.52),
 (21, '2021-01-01 00:00:00.000000 +00:00', 10, 2, 35, 1, 4823.52),
 (22, '2022-01-01 00:00:00.000000 +00:00', 1, 2, 50, 1, 8529.52);
ALTER SEQUENCE public.provider_history_id_seq RESTART WITH 23;

INSERT INTO public.vaccinations (id, vaccination_name) 
VALUES (1, 'АнтиГрипп'),
 (2, 'СтопАнгин'),
 (3, 'АнтиБлох');
ALTER SEQUENCE public.vaccinations_id_seq RESTART WITH 4;

INSERT INTO public.individuals_vaccinations (individual_id, vaccination_id, date, staff_id) 
VALUES (2, 1, '2024-01-01', 2),
 (3, 1, '2024-01-01', 2),
 (4, 2, '2024-01-01', 6),
 (5, 2, '2024-01-01', 6),
 (6, 2, '2024-01-01', 2),
 (7, 1, '2024-01-01', 2),
 (8, 1, '2024-01-01', 2),
 (9, 1, '2024-01-01', 6),
 (10, 1, '2024-01-01', 6),
 (11, 3, '2024-01-01', 2),
 (12, 3, '2024-01-01', 2),
 (13, 1, '2024-01-01', 2),
 (14, 1, '2024-01-01', 6),
 (15, 2, '2024-01-01', 6),
 (16, 2, '2024-01-01', 6),
 (17, 2, '2024-01-01', 2),
 (18, 1, '2024-01-01', 2),
 (19, 1, '2024-01-01', 6),
 (20, 3, '2024-01-01', 6);

INSERT INTO public.disease (id, disease_name) 
VALUES (1, 'Лишай'),
 (2, 'Грипп'),
 (3, 'Болезнь глаз'),
 (4, 'Болезнь щитовидки'),
 (5, 'Насморк'),
 (6, 'Перелом'),
 (7, 'Лишай'),
 (8, 'Грипп'),
 (9, 'Болезнь глаз'),
 (10, 'Болезнь щитовидки'),
 (11, 'Насморк'),
 (12, 'Перелом'),
 (13, 'Лишай'),
 (14, 'Грипп'),
 (15, 'Болезнь глаз'),
 (16, 'Болезнь щитовидки'),
 (17, 'Насморк'),
 (18, 'Перелом'),
 (19, 'Лишай'),
 (20, 'Грипп'),
 (21, 'Болезнь глаз'),
 (22, 'Болезнь щитовидки'),
 (23, 'Насморк'),
 (24, 'Перелом'),
 (25, 'Лишай'),
 (26, 'Грипп'),
 (27, 'Болезнь глаз'),
 (28, 'Болезнь щитовидки'),
 (29, 'Насморк'),
 (30, 'Перелом');
ALTER SEQUENCE public.disease_id_seq RESTART WITH 31;

INSERT INTO public.disease_history (id, individual_id, date_start, date_end, disease_id) 
VALUES (1, 2, '2022-01-01', '2021-02-01', 5),
 (2, 3, '2023-05-01', '2023-05-15', 1),
 (4, 5, '2019-01-01', '2019-01-01', 5),
 (5, 18, '2023-01-01', '2023-01-20', 6),
 (6, 22, '2023-06-06', '2023-07-10', 6),
 (7, 10, '2023-01-01', '2023-01-03', 2),
 (8, 15, '2022-08-05', '2022-09-03', 3),
 (9, 23, '2023-05-09', '2023-08-09', 4),
 (3, 3, '2023-01-01', '2023-01-12', 2);
ALTER SEQUENCE public.disease_history_id_seq RESTART WITH 10;

INSERT INTO public.offspring_factors (id, animal_id, physical_state_id, age_start, age_end) 
VALUES (1, 1, 1, 2, 20),
       (2, 1, 2, 10, 15);
ALTER SEQUENCE public.offspring_factors_id_seq RESTART WITH 3;

INSERT INTO public.type_relationship (id, relationship) 
VALUES (1, 'Брат/Сестра'),(2, 'Мать/Ребенок'),(3, 'Отец/Ребенок');
ALTER SEQUENCE public.type_relationship_id_seq RESTART WITH 2;

INSERT INTO public.cell_history (id, individual_id, date_start, date_end, cell_number) 
VALUES (57, 1, '2021-01-01', null, 2),
 (56, 1, '2020-01-01', '2021-01-01', 1),
 (60, 3, '2023-01-01', '2024-01-01', 4),
 (58, 2, '2021-01-01', '2023-01-01', 1),
 (62, 5, '2019-01-01', null, 6),
 (59, 2, '2023-01-01', null, 3),
 (65, 8, '2021-01-01', null, 9),
 (66, 9, '2023-03-01', null, 10),
 (67, 10, '2022-01-01', null, 11),
 (68, 11, '2020-04-01', null, 12),
 (69, 12, '2017-01-01', null, 13),
 (70, 13, '2020-01-01', null, 14),
 (71, 14, '2023-05-01', null, 15),
 (72, 15, '2021-01-01', null, 16),
 (73, 16, '2020-01-01', null, 17),
 (74, 17, '2022-06-01', null, 18),
 (75, 18, '2023-01-01', null, 19),
 (76, 19, '2016-01-01', null, 20),
 (77, 20, '2018-02-01', null, 21),
 (78, 21, '2020-01-01', null, 22),
 (79, 22, '2023-01-01', null, 23),
 (80, 23, '2022-01-01', null, 24),
 (81, 24, '2023-01-01', null, 25),
 (63, 6, '2016-01-01', null, 7),
 (61, 4, '2024-01-01', null, 5),
 (64, 7, '2020-02-01', null, 8);
ALTER SEQUENCE public.cell_history_id_seq RESTART WITH 90;

INSERT INTO public.responsible_animals (staff_id, individual_id, date_start, date_end) 
VALUES (1, 1, '2020-01-01', null),
 (1, 2, '2021-01-01', null),
 (1, 3, '2023-01-01', '2024-01-01'),
 (1, 4, '2024-01-01', null),
 (1, 5, '2019-01-01', null),
 (1, 6, '2016-01-01', null),
 (1, 7, '2020-02-01', null),
 (1, 8, '2021-01-01', null),
 (1, 9, '2023-03-01', null),
 (1, 10, '2022-01-01', null),
 (1, 11, '2020-04-01', null),
 (1, 12, '2017-01-01', null),
 (1, 13, '2020-01-01', null),
 (1, 14, '2023-05-01', null),
 (1, 15, '2021-01-01', null),
 (1, 16, '2020-01-01', null),
 (1, 17, '2022-06-01', null),
 (1, 18, '2023-01-01', null),
 (1, 19, '2016-01-01', null),
 (1, 20, '2018-02-01', null),
 (1, 21, '2020-01-01', null),
 (1, 22, '2023-01-01', null),
 (1, 23, '2022-01-01', null),
 (1, 24, '2023-01-01', null);

INSERT INTO public.staff_type_attributes (attribute_name, staff_type_id) 
    VALUES ('Специализация', 1),
    ('Должность', 5);

INSERT INTO public.staff_attributes_value (staff_id, staff_type_id, attribute_name, attribute_value) 
VALUES (2, 1, 'Специализация', 'Хирург'),(6, 1, 'Специализация', 'Хирург'),(1, 5, 'Должность', 'Директор');

INSERT INTO public.access_animals (staff_id, individual_id, date_start, date_end) 
VALUES (1, 1, '2020-01-01', null),
 (1, 2, '2021-01-01', null),
 (1, 3, '2023-01-01', '2024-01-01'),
 (1, 4, '2024-01-01', null),
 (1, 5, '2019-01-01', null),
 (1, 6, '2016-01-01', null),
 (1, 7, '2020-02-01', null),
 (1, 8, '2021-01-01', null),
 (1, 9, '2023-03-01', null),
 (1, 10, '2022-01-01', null),
 (1, 11, '2020-04-01', null),
 (1, 12, '2017-01-01', null),
 (1, 13, '2020-01-01', null),
 (1, 14, '2023-05-01', null),
 (1, 15, '2021-01-01', null),
 (1, 16, '2020-01-01', null),
 (1, 17, '2022-06-01', null),
 (1, 18, '2023-01-01', null),
 (1, 19, '2016-01-01', null),
 (1, 20, '2018-02-01', null),
 (1, 21, '2020-01-01', null),
 (1, 22, '2023-01-01', null),
 (1, 23, '2022-01-01', null),
 (1, 24, '2023-01-01', null);

INSERT INTO public.individual_receipt_status (id, status_name)
VALUES (1, 'Родился в зоопарке'), 
       (2, 'Обмен в другой зоопарк'),
       (3, 'Отдан в другой зоопарк'),
       (4, 'Обмен из другого зоопарка');
ALTER SEQUENCE public.individual_receipt_status_id_seq RESTART WITH 5;

INSERT INTO public.zoos (id, name) VALUES (1, 'Текущий зоопарк'), (2, 'Новосибирский зоопарк');

INSERT INTO public.individual_history (id, receipt_date, individual_id, individual_status, zoo_id) 
VALUES (1, '2020-01-01', 1, 4, 2),
 (2, '2021-01-01', 2, 1, 1),
 (3, '2024-01-01', 3, 3, 2),
 (4, '2024-01-01', 4, 1, 1),
 (5, '2019-01-01', 5, 1, 1),
 (6, '2016-01-01', 6, 1, 1),
 (7, '2020-02-01', 7, 1, 1),
 (8, '2021-01-01', 8, 1, 1),
 (9, '2023-03-01', 9, 1, 1),
 (10, '2022-01-01', 10, 1, 1),
 (11, '2020-04-01', 11, 1, 1),
 (12, '2017-01-01', 12, 1, 1),
 (13, '2020-01-01', 13, 1, 1),
 (14, '2023-05-01', 14, 1, 1),
 (15, '2021-01-01', 15, 1, 1),
 (16, '2020-01-01', 16, 1, 1),
 (17, '2022-06-01', 17, 1, 1),
 (18, '2023-01-01', 18, 1, 1),
 (19, '2016-01-01', 19, 1, 1),
 (20, '2018-02-01', 20, 1, 1),
 (21, '2020-01-01', 21, 1, 1),
 (22, '2023-01-01', 22, 1, 1),
 (23, '2022-01-01', 23, 1, 1),
 (24, '2023-01-01', 24, 1, 1),
 (25, '2023-01-01', 3, 1, 1);
ALTER SEQUENCE public.individual_history_id_seq RESTART WITH 26;
