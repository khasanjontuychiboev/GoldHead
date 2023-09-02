CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table if not exists city(
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name varchar(255),
    country_name varchar(255) not null references country (name),
    created_at timestamp,
    updated_at timestamp default current_timestamp
);



insert into city(name, country_name, created_at)
 values ('Tashkent', 'Uzbekistan', now());


insert into city(name, country_name, created_at)
values ('Istanbul', 'Turkey', now());



insert into city(name, country_name, created_at)
values ('Prague', 'Czechia', now());


insert into city(name, country_name, created_at)
values ('Kyiv', 'Ukrain', now());


insert into city(name, country_name, created_at)
values ('Warsaw', 'Poland', now());


insert into city(name, country_name, created_at)
values ('Warsaw', 'Poland', now());


DELETE FROM country WHERE name = 'Russina';


insert into country(name, created_at, updated_at)
values ('Russia', now(),now());


insert into city(name, country_name, created_at)
values ('Moscow', 'Russia', now());

