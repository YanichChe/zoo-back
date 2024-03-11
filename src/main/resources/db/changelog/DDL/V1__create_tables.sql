create table public.staff_type
(
    id   serial
        primary key,
    type varchar(50) not null
        unique
        constraint staff_type_type_check
            check (length((type)::text) > 0)
);

comment on table public.staff_type is 'Тип сотрудника';

alter table public.staff_type
    owner to "user";

create table public.gender
(
    id     serial
        primary key,
    gender varchar(10) not null
        unique
        constraint gender_gender_check
            check (length((gender)::text) > 0)
);

comment on table public.gender is 'Гендер';

alter table public.gender
    owner to "user";

create table public.staff
(
    id          serial
        primary key,
    name        varchar(50) not null
        constraint staff_name_check
            check (length((name)::text) > 0),
    surname     varchar(50) not null
        constraint staff_surname_check
            check (length((surname)::text) > 0)
        constraint staff_surname_check1
            check (length((surname)::text) > 0),
    middle_name varchar(50),
    birthday    date        not null,
    gender_id   integer
                            references public.gender
                                on delete set null,
    constraint staff_check
        check (date_part('year'::text, age(('2003-03-06'::date)::timestamp with time zone)) > (16)::double precision)
);

comment on table public.staff is 'Сотрудники';
comment on column public.staff.name is 'Имя';
comment on column public.staff.surname is 'Фамилия';
comment on column public.staff.middle_name is 'Отчество';
comment on column public.staff.birthday is 'День рождения';
comment on column public.staff.gender_id is 'Пол';

alter table public.staff
    owner to "user";

create table public.staff_history
(
    staff_id   integer        not null
        references public.staff
            on delete cascade,
    date_start date           not null,
    date_end   date,
    salary     numeric(10, 2) not null
        constraint staff_history_salary_check
            check (salary > (0)::numeric),
    staff_type integer
                              references public.staff_type
                                  on delete set null,
    primary key (staff_id, date_start),
    constraint staff_history_check
        check (date_end > date_start)
);

comment on table public.staff_history is 'История сотрудников';
comment on column public.staff_history.staff_id is 'Сотрудник';
comment on column public.staff_history.date_start is 'Дата начала работы';
comment on column public.staff_history.salary is 'Месячная зп';
comment on column public.staff_history.staff_type is 'Тип сотрудника';

alter table public.staff_history
    owner to "user";

create table public.authority
(
    id        serial
        primary key,
    authority varchar(50) not null
        unique
        constraint authority_authority_check
            check (length((authority)::text) > 0)
);

comment on table public.authority is 'Права пользователей';
comment on column public.authority.authority is 'Названия права';

alter table public.authority
    owner to "user";

create table public.authority_staff_type
(
    authority_id  integer not null
        references public.authority
            on delete cascade,
    staff_type_id integer not null
        references public.staff_type
            on delete cascade,
    primary key (authority_id, staff_type_id)
);

comment on table public.authority_staff_type is 'Сопостовление прав типам сотрудников';
comment on column public.authority_staff_type.authority_id is 'Право';
comment on column public.authority_staff_type.staff_type_id is 'Должность';

alter table public.authority_staff_type
    owner to "user";

create table public.climate_zones
(
    id                serial
        primary key,
    is_cold_tolerance boolean      not null,
    climate_zone_name varchar(255) not null
        unique
        constraint climate_zones_climate_zone_name_check
            check (length((climate_zone_name)::text) > 0)
);

comment on table public.climate_zones is 'Климатические зоны';
comment on column public.climate_zones.is_cold_tolerance is 'Небходимость в отапливаемых помещения';
comment on column public.climate_zones.climate_zone_name is 'Название климатический зоны';

alter table public.climate_zones
    owner to "user";

create table public.nutrition_type
(
    id   serial
        primary key,
    type varchar(50) not null
        unique
        constraint nutrition_type_type_check
            check (length((type)::text) > 0)
);

comment on table public.nutrition_type is 'Тип питания';
comment on column public.nutrition_type.type is 'Название типа питания';

alter table public.nutrition_type
    owner to "user";

create table public.animals
(
    id                serial
        primary key,
    animal_title      varchar(255) not null
        unique
        constraint animals_animal_title_check
            check (length((animal_title)::text) > 0),
    climate_zone_id   integer
                                   references public.climate_zones
                                       on delete set null,
    nutrition_type_id integer
                                   references public.nutrition_type
                                       on delete set null
);

comment on table public.animals is 'Животные';
comment on column public.animals.animal_title is 'Название животного';

alter table public.animals
    owner to "user";

create table public.files
(
    id   serial
        primary key,
    path varchar(255) not null
        unique
        constraint files_path_check
            check (length((path)::text) > 0)
);

comment on table public.files is 'Файлы приложения';
comment on column public.files.path is 'Путь до файла';

alter table public.files
    owner to "user";

create table public.physical_state
(
    id    serial
        primary key,
    state varchar(255) not null
        unique
        constraint physical_state_state_check
            check (length((state)::text) > 0)
);

comment on table public.physical_state is 'Физическое состояние особи';
comment on column public.physical_state.state is 'Описание физического состояния особи';

alter table public.physical_state
    owner to "user";

create table public.individuals
(
    id                serial
        primary key,
    name              varchar(255)         not null
        constraint individuals_name_check
            check (length((name)::text) > 0),
    date              date                 not null
        constraint individuals_date_check
            check (date <= CURRENT_DATE),
    animal_id         integer
        references public.animals
            on delete restrict,
    is_alive          boolean default true not null,
    height            real
        constraint individuals_height_check
            check (height >= (0)::double precision),
    weight            real
        constraint individuals_weight_check
            check (weight >= (0)::double precision),
    physical_state_id integer default 1    not null
        references public.physical_state
            on delete restrict,
    photo_id          integer default 4
                                           references public.files
                                               on delete set null,
    gender_id         integer
        references public.gender
            on delete restrict
);

comment on table public.individuals is 'Особи зоопарка';
comment on column public.individuals.name is 'Кличка животного';
comment on column public.individuals.is_alive is 'Признак живой / неживой';
comment on column public.individuals.height is 'Рост';
comment on column public.individuals.weight is 'Вес';
comment on column public.individuals.physical_state_id is 'Признак больной / не больной';
comment on column public.individuals.photo_id is 'Фотография';

alter table public.individuals
    owner to "user";

create table public.prohibited_combinations_settlement
(
    animal_id_1 integer not null
        references public.animals
            on delete cascade,
    animal_id_2 integer not null
        references public.animals
            on delete cascade,
    primary key (animal_id_1, animal_id_2)
);

comment on table public.prohibited_combinations_settlement is 'Запрещенные сочетания расселения';
comment on column public.prohibited_combinations_settlement.animal_id_1 is 'Животное 1';
comment on column public.prohibited_combinations_settlement.animal_id_2 is 'Животоно 2';
alter table public.prohibited_combinations_settlement
    owner to "user";

create table public.season
(
    id     serial
        primary key,
    season varchar(255) not null
        unique
        constraint season_season_check
            check (length((season)::text) > 0)
);

comment on table public.season is 'Сезон';
comment on column public.season.season is 'Название сезона';
alter table public.season
    owner to "user";

create table public.diet_characteristics
(
    id                serial
        primary key,
    age               integer not null
        constraint diet_characteristics_age_check
            check (age >= 0),
    physical_state_id integer
        references public.physical_state
            on delete restrict,
    season_id         integer
        references public.season
            on delete restrict,
    animal_id         integer
        references public.animals
            on delete cascade
);

comment on table public.diet_characteristics is 'Характеристики рациона';
comment on column public.diet_characteristics.age is 'Возраст особи';
comment on column public.diet_characteristics.physical_state_id is 'id физического состояния';
comment on column public.diet_characteristics.season_id is 'id сезона';
comment on column public.diet_characteristics.animal_id is 'id животного';

alter table public.diet_characteristics
    owner to "user";

create table public.feed_type
(
    id   serial
        primary key,
    type varchar(255) not null
        unique
        constraint feed_type_type_check
            check (length((type)::text) > 0)
);

comment on table public.feed_type is 'Тип корма';
comment on column public.feed_type.type is 'Название типа';
alter table public.feed_type
    owner to "user";

create table public.food
(
    id               serial
        primary key,
    food_name        varchar(255) not null
        unique
        constraint food_food_name_check
            check (length((food_name)::text) > 0),
    feed_type_id     integer
                                  references public.feed_type
                                      on delete set null,
    self_sufficiency boolean default false
);

comment on table public.food is 'Пища';
comment on column public.food.food_name is 'Название еды';
comment on column public.food.feed_type_id is 'id типа корма';
comment on column public.food.self_sufficiency is 'Самообеспечение';

alter table public.food
    owner to "user";

create table public.dimension
(
    id        serial
        primary key,
    dimension varchar(50) not null
        unique
        constraint dimension_dimension_check
            check (length((dimension)::text) > 0)
);

comment on table public.dimension is 'Измерения еды';
comment on column public.dimension.dimension is 'Название единицы измерения';
alter table public.dimension
    owner to "user";

create table public.diet
(
    id                      serial
        primary key,
    diet_characteristics_id integer
        references public.diet_characteristics
            on delete cascade,
    food_id                 integer
        references public.food
            on delete cascade,
    count                   integer not null
        constraint diet_count_check
            check (count > 0),
    dimension_id            integer
        references public.dimension
            on delete restrict,
    time                    time    not null
);

comment on table public.diet is 'Рацион';
comment on column public.diet.diet_characteristics_id is 'id характеристики рациона';
comment on column public.diet.food_id is 'id пищи';
comment on column public.diet.count is 'Количество еды';
comment on column public.diet.dimension_id is 'id размерности';
comment on column public.diet.time is 'Время приема пищи';

alter table public.diet
    owner to "user";

create table public.food_providers
(
    id       serial
        primary key,
    provider varchar(255) not null
        unique
        constraint food_providers_provider_check
            check (length((provider)::text) > 0)
);

comment on table public.food_providers is 'Поставщики еды';
comment on column public.food_providers.provider is 'Название поставщика';

alter table public.food_providers
    owner to "user";

create table public.provider_history
(
    id           serial
        primary key,
    date         timestamp with time zone not null
        constraint provider_history_date_check
            check (date < CURRENT_DATE),
    food_id      integer
                                          references public.food
                                              on delete set null,
    provider_id  integer
        references public.food_providers
            on delete restrict,
    number       integer
        constraint provider_history_number_check
            check (number > 0),
    dimension_id integer
        references public.dimension
            on delete restrict,
    price        numeric(10, 2)           not null
        constraint provider_history_price_check
            check (price > (0)::numeric)
);

comment on table public.provider_history is 'История поставок';
comment on column public.provider_history.date is 'Дата поставки';
comment on column public.provider_history.food_id is 'id пищи';
comment on column public.provider_history.provider_id is 'id поставщика';
comment on column public.provider_history.number is 'количество поставок';
comment on column public.provider_history.dimension_id is 'id измерения';
comment on column public.provider_history.price is 'Цена поставки';

alter table public.provider_history
    owner to "user";

create table public.vaccinations
(
    id               serial
        primary key,
    vaccination_name varchar(255) not null
        unique
        constraint vaccinations_vaccination_name_check
            check (length((vaccination_name)::text) > 0)
);

comment on table public.vaccinations is 'Прививки';
comment on column public.vaccinations.vaccination_name is 'Название прививки';

alter table public.vaccinations
    owner to "user";

create table public.individuals_vaccinations
(
    individual_id  integer not null
        references public.individuals
            on delete cascade,
    vaccination_id integer not null
        references public.vaccinations
            on delete restrict,
    date           date    not null
        constraint individuals_vaccinations_date_check
            check (date <= CURRENT_DATE),
    staff_id       integer
        references public.staff
            on delete restrict,
    primary key (individual_id, vaccination_id, date)
);

comment on table public.individuals_vaccinations is 'История прививок';
comment on column public.individuals_vaccinations.individual_id is 'id особи';
comment on column public.individuals_vaccinations.vaccination_id is 'id прививки';
comment on column public.individuals_vaccinations.date is 'Дата прививки';
comment on column public.individuals_vaccinations.staff_id is 'id сотрудника, делавшего прививку';
alter table public.individuals_vaccinations
    owner to "user";


create table public.disease
(
    id           serial
        primary key,
    disease_name varchar(255) not null
        constraint disease_disease_name_check
            check (length((disease_name)::text) > 0)
);

comment on table public.disease is 'Болезни';
comment on column public.disease.disease_name is 'Название болезни';
alter table public.disease
    owner to "user";

create table public.disease_history
(
    id            serial
        primary key,
    individual_id integer
        references public.individuals
            on delete cascade,
    date_start    date not null,
    date_end      date not null
        constraint disease_history_date_end_check
            check (date_end <= CURRENT_DATE),
    disease_id    integer
        references public.disease
            on delete restrict
);

comment on table public.disease_history is 'История болезни';
comment on column public.disease_history.individual_id is 'id особи';
comment on column public.disease_history.date_start is 'Дата заболевания';
comment on column public.disease_history.date_end is 'Дата выздоровления';
comment on column public.disease_history.disease_id is 'id болезни';
alter table public.disease_history
    owner to "user";


create table public.offspring_factors
(
    id                serial
        primary key,
    animal_id         integer
        references public.animals
            on delete cascade,
    physical_state_id integer
        references public.physical_state
            on delete restrict,
    age_start         integer not null
        constraint offspring_factors_age_start_check
            check (age_start > 0),
    age_end           integer not null
        constraint offspring_factors_age_end_check
            check (age_end > 0),
    constraint offspring_factors_check
        check (age_end >= age_start)
);

comment on table public.offspring_factors is 'Показатели размножения';
comment on column public.offspring_factors.animal_id is 'id животного';
comment on column public.offspring_factors.physical_state_id is 'id физического состояния';
comment on column public.offspring_factors.age_start is 'Дата возможного начала';
comment on column public.offspring_factors.age_end is 'Конец периода размножения';
alter table public.offspring_factors
    owner to "user";

create table public.type_relationship
(
    id           serial
        primary key,
    relationship varchar(50) not null
        unique
        constraint type_relationship_relationship_check
            check (length((relationship)::text) > 0)
);

comment on table public.type_relationship is 'Тип семейных отношений';
comment on column public.type_relationship.relationship is 'Название типа отношений';
alter table public.type_relationship
    owner to "user";

create table public.family_relationships
(
    id                   serial
        primary key,
    individual_id_1      integer
        references public.individuals
            on delete cascade,
    individual_id_2      integer
        references public.individuals
            on delete cascade,
    type_relationship_id integer
        references public.type_relationship
            on delete restrict
);

comment on table public.family_relationships is 'Семейные отношения';
comment on column public.family_relationships.individual_id_1 is 'id особь 1';
comment on column public.family_relationships.individual_id_2 is 'id особь 2';
comment on column public.family_relationships.type_relationship_id is 'id типа отношений';
alter table public.family_relationships
    owner to "user";

create table public.cell_history
(
    id            serial
        primary key,
    individual_id integer
                          references public.individuals
                              on delete set null,
    date_start    date,
    date_end      date
        constraint cell_history_date_end_check
            check (date_end <= CURRENT_DATE),
    cell_number   integer not null
        constraint cell_history_cell_number_check
            check (cell_number > 0)
);

comment on table public.cell_history is 'История проживания в клетках';
comment on column public.cell_history.individual_id is 'id особи';
comment on column public.cell_history.date_start is 'Дата начала проживания';
comment on column public.cell_history.date_end is 'Дата конца проживания';
comment on column public.cell_history.cell_number is 'Номер клетки';
alter table public.cell_history
    owner to "user";


create table public.responsible_animals
(
    staff_id      integer not null
        references public.staff
            on delete cascade,
    individual_id integer not null
        references public.individuals
            on delete cascade,
    date_start    date    not null
        constraint responsible_animals_date_start_check
            check (date_start < CURRENT_DATE),
    date_end      date,
    primary key (staff_id, individual_id, date_start),
    constraint responsible_animals_check
        check (date_end >= date_start)
);

comment on table public.responsible_animals is 'Доступ сотрудников к животным';
comment on column public.responsible_animals.staff_id is 'Сотрудник';
comment on column public.responsible_animals.individual_id is 'Особь';
comment on column public.responsible_animals.date_start is 'Начало периода';
comment on column public.responsible_animals.date_end is 'Конец периода';
alter table public.responsible_animals
    owner to "user";

create table public.staff_type_attributes
(
    attribute_name varchar(255) not null,
    staff_type_id  integer      not null
        references public.staff_type
            on delete cascade,
    primary key (attribute_name, staff_type_id)
);

comment on table public.staff_type_attributes is 'Уникальные атрибуты';
comment on column public.staff_type_attributes.attribute_name is 'Название атрибутов';
comment on column public.staff_type_attributes.staff_type_id is 'Профессия, к которой относится атрибут';
alter table public.staff_type_attributes
    owner to "user";

create table public.staff_attributes_value
(
    staff_id        integer      not null
        references public.staff
            on delete cascade,
    staff_type_id   integer      not null,
    attribute_name  varchar(255) not null,
    attribute_value varchar(255) not null,
    primary key (staff_id, staff_type_id, attribute_name),
    foreign key (attribute_name, staff_type_id) references public.staff_type_attributes(attribute_name, staff_type_id)
        on delete cascade
);

comment on table public.staff_attributes_value is 'Значение уникальных атрибутов сотрудников';
comment on column public.staff_attributes_value.staff_id is 'id сотрудника';
comment on column public.staff_attributes_value.staff_type_id is 'id типа сотрудника';
comment on column public.staff_attributes_value.attribute_name is 'Название атрибута';
comment on column public.staff_attributes_value.attribute_value is 'Значение уникального атрибута';
alter table public.staff_attributes_value
    owner to "user";

create table public.access_animals
(
    staff_id      integer not null
        references public.staff
            on delete cascade,
    individual_id integer not null
        references public.individuals
            on delete cascade,
    date_start    date    not null
        constraint access_animals_date_start_check
            check (date_start < CURRENT_DATE),
    date_end      date,
    primary key (staff_id, individual_id, date_start),
    constraint access_animals_check
        check (date_end >= date_start)
);
alter table public.access_animals
    owner to "user";

create table public.individual_receipt_status
(
    id          serial
        primary key,
    status_name varchar(255) not null
        unique
);

comment on table public.individual_receipt_status is 'Статусы появления животного в зоопарке';
comment on column public.individual_receipt_status.status_name is 'Название статуса';
alter table public.individual_receipt_status
    owner to "user";

create table public.zoos
(
    id   serial
        primary key,
    name varchar(255) not null
        unique
);

comment on table public.zoos is 'Список зоопарков';

alter table public.zoos
    owner to "user";

create table public.individual_history
(
    id                serial
        primary key,
    receipt_date      date not null,
    individual_id     integer
        references public.individuals
            on delete cascade,
    individual_status integer
        references public.individual_receipt_status
            on delete restrict,
    zoo_id            integer
        references public.zoos
            on delete restrict
);

comment on table public.individual_history is 'История появления и отправки животных в зоопарке';
comment on column public.individual_history.receipt_date is 'Дата изменения';
comment on column public.individual_history.individual_id is 'id особи';
comment on column public.individual_history.individual_status is 'id статуса изменения';
comment on column public.individual_history.zoo_id is 'id зоопарка';
alter table public.individual_history
    owner to "user";

