create function public.insert_or_update_diet_trigger_function() returns trigger
    language plpgsql
as
$$
BEGIN
    IF NOT EXISTS (select nutrition_type.type, feed_type.type
                   from diet_characteristics
                            join animals on diet_characteristics.animal_id = animals.id
                            join nutrition_type on animals.nutrition_type_id = nutrition_type.id
                            join food on new.food_id = food.id
                            join feed_type on food.feed_type_id = feed_type.id
                   WHERE (nutrition_type.type = 'Травоядный' AND
                          (feed_type.type = 'Живой' or feed_type.type = 'Мясо' and diet_characteristics.id = new.diet_characteristics_id))) THEN
        INSERT INTO diet
        VALUES (new.id, new.diet_characteristics_id, new.food_id, new.count, new.dimension_id, new.time)
        ON CONFLICT (id) DO UPDATE SET diet_characteristics_id = EXCLUDED.diet_characteristics_id,
                                       food_id                 = EXCLUDED.food_id,
                                       count                   = excluded.count,
                                       dimension_id            = excluded.dimension_id,
                                       time                    = excluded.time;
END IF;
RETURN NEW;
END;
$$;

alter function public.insert_or_update_diet_trigger_function() owner to "user";

create function public.prevent_live_food_insert() returns trigger
    language plpgsql
as
$$
BEGIN
    IF EXISTS (SELECT 1
               FROM food
                        JOIN feed_type on food.feed_type_id = feed_type.id
                        join diet_characteristics on diet_characteristics.id = NEW.diet_characteristics_id
                        join animals on diet_characteristics.animal_id = animals.id
                        join nutrition_type on animals.nutrition_type_id = nutrition_type.id

               WHERE food.id = NEW.food_id
                 AND (feed_type.type = 'Живой' or feed_type.type = 'Мясо')
                 and nutrition_type.type = 'Травоядный') THEN
        RAISE EXCEPTION 'Травоядный не может есть мясо';
END IF;
RETURN NEW;
END;
$$;

alter function public.prevent_live_food_insert() owner to "user";

create function public.prevent_individuals_vaccinations_insert() returns trigger
    language plpgsql
as
$$
BEGIN
    IF (SELECT date_appearance
        FROM individual_full_info
        where id = NEW.individual_id) > NEW.date OR (SELECT date_disappearance
        FROM individual_full_info
        where id = NEW.individual_id) < NEW.date THEN
    RAISE EXCEPTION 'Неверная дата вакцинации в текущем зоопарке';
END IF; RETURN NEW;
END;
$$;

alter function public.prevent_individuals_vaccinations_insert() owner to "user";

create function public.truncate_tables(username character varying) returns void
    language plpgsql
as
$$
DECLARE
statements CURSOR FOR
SELECT tablename FROM pg_tables
WHERE tableowner = username AND schemaname = 'public';
BEGIN
FOR stmt IN statements LOOP
        EXECUTE 'TRUNCATE TABLE ' || quote_ident(stmt.tablename) || ' CASCADE;';
END LOOP;
END;
$$;

alter function public.truncate_tables(varchar) owner to "user";

create function public.prevent_cell_history_appearance_insert() returns trigger
    language plpgsql
as
$$
BEGIN
    IF (SELECT date_appearance
        FROM individual_full_info where id = NEW.individual_id) > NEW.date_start THEN
        RAISE EXCEPTION 'Животное не могло начать жить в клетке до того, как появилось в зоопарке';
END IF;
RETURN NEW;
END;
$$;

alter function public.prevent_cell_history_appearance_insert() owner to "user";

create function public.prevent_cell_history_disappearance_insert() returns trigger
    language plpgsql
as
$$
BEGIN
    IF (SELECT date_disappearance
        FROM individual_full_info where id = NEW.individual_id) < NEW.date_end THEN
        RAISE EXCEPTION 'Животное не могло выселиться из клетки после того, как исчезло из зоопарка';
END IF;
RETURN NEW;
END;
$$;

alter function public.prevent_cell_history_disappearance_insert() owner to "user";

create function public.prevent_disease_start_insert() returns trigger
    language plpgsql
as
$$
BEGIN
    IF (SELECT date_appearance
        FROM individual_full_info where id = NEW.individual_id) > NEW.date_start THEN
        RAISE EXCEPTION 'Животное не могло заболеть перед тем, как попасть в зоопарк';
END IF;
RETURN NEW;
END;
$$;

alter function public.prevent_disease_start_insert() owner to "user";

create function public.prevent_disease_end_insert() returns trigger
    language plpgsql
as
$$
BEGIN
    IF (SELECT date_disappearance
        FROM individual_full_info where id = NEW.individual_id) < NEW.date_end THEN
        RAISE EXCEPTION 'Животное не могло перестать болеть после того, как исчезло из зоопарка';
END IF;
RETURN NEW;
END;
$$;

alter function public.prevent_disease_end_insert() owner to "user";

create function public.prevent_responsible_animals_insert() returns trigger
    language plpgsql
as
$$
BEGIN
    IF (SELECT date_appearance
        FROM individual_full_info
        where id = NEW.individual_id) > NEW.date_start OR (SELECT date_disappearance
        FROM individual_full_info
        where id = NEW.individual_id) < NEW.date_end THEN
    RAISE EXCEPTION 'Неверная дата периода в таблице ответственных за животных';
END IF; RETURN NEW;
END;
$$;

alter function public.prevent_responsible_animals_insert() owner to "user";

CREATE FUNCTION prevent_access_animals_insert()
    RETURNS TRIGGER AS
$$
BEGIN
    IF (SELECT date_appearance
        FROM individual_full_info
        where id = NEW.individual_id) > NEW.date_start OR (SELECT date_disappearance
                                                           FROM individual_full_info
                                                           where id = NEW.individual_id) < NEW.date_end THEN
        RAISE EXCEPTION 'Неверная дата периода в таблице с доступом к животным';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE FUNCTION prevent_access_animals_logic_insert()
    RETURNS TRIGGER AS
$$
BEGIN
    IF NOT EXISTS(select staff_id, staff_type.type, authority_id
                  from staff_history
                           join staff_type on staff_history.staff_type = staff_type.id
                           JOIN authority_staff_type ON staff_type.id = authority_staff_type.staff_type_id
                  where staff_id = NEW.staff_id
                    and ((date_start <= NEW.date_start AND NEW.date_start <= date_end)
                      or (NEW.date_start >= date_start AND date_end is null))
                    and authority_id = 1) THEN
        RAISE EXCEPTION 'У данного типа сотрудника нет доступа в клетку';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE FUNCTION prevent_individual_vaccination()
    RETURNS TRIGGER AS
$$
BEGIN
    IF NOT EXISTS(select staff_id, staff_type.type, authority_id
                  from staff_history
                           join staff_type on staff_history.staff_type = staff_type.id
                           JOIN authority_staff_type ON staff_type.id = authority_staff_type.staff_type_id
                  where staff_id = NEW.staff_id
                    and ((date_start <= NEW.date AND NEW.date <= date_end)
                      or (NEW.date >= date_start AND date_end is null))
                    and authority_id = 3) THEN
        RAISE EXCEPTION 'Данный сотрудник не может ставить прививки';
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;
