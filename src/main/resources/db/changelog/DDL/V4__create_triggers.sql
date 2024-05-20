create trigger check_prevent_individuals_vaccinations_insert_trigger
    before insert or update
                         on public.individuals_vaccinations
                         for each row
                         execute procedure public.prevent_individuals_vaccinations_insert();

create trigger check_individuals_vaccinations_insert_trigger
    before insert or update
                         on public.individuals_vaccinations
                         for each row
                         execute procedure public.prevent_individuals_vaccinations_insert();

create trigger check_prevent_disease_start_insert_trigger
    before insert or update
                         on public.disease_history
                         for each row
                         execute procedure public.prevent_disease_start_insert();

create trigger check_prevent_disease_end_insert_trigger
    before insert or update
                         on public.disease_history
                         for each row
                         execute procedure public.prevent_disease_end_insert();
create trigger check_prevent_cell_history_appearance_insert_trigger
    before insert or update
                         on public.cell_history
                         for each row
                         execute procedure public.prevent_cell_history_appearance_insert();

create trigger check_prevent_cell_history_disappearance_insert_trigger
    before insert or update
                         on public.cell_history
                         for each row
                         execute procedure public.prevent_cell_history_disappearance_insert();
create trigger check_responsible_animals_insert_trigger
    before insert or update
                         on public.responsible_animals
                         for each row
                         execute procedure public.prevent_responsible_animals_insert();

CREATE OR REPLACE TRIGGER check_access_animals_insert_insert_trigger
    BEFORE INSERT OR UPDATE
    ON access_animals
    FOR EACH ROW
EXECUTE FUNCTION prevent_access_animals_insert();

CREATE OR REPLACE TRIGGER check_access_animals_insert_logic_trigger
    BEFORE INSERT OR UPDATE
    ON access_animals
    FOR EACH ROW
EXECUTE FUNCTION prevent_access_animals_logic_insert();

create trigger check_live_food_trigger
    before insert or update
    on public.diet
    for each row
execute procedure public.prevent_live_food_insert();

create trigger check_individual_vaccination
    before insert or update
    on public.individuals_vaccinations
    for each row
execute procedure public.prevent_individual_vaccination();
