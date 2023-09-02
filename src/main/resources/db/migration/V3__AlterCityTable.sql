delete from city where name = 'Warsaw';

insert into city(name, country_name, created_at)
 values ('Warsaw', 'Poland', now());

ALTER TABLE city
    ADD CONSTRAINT unique_city_name_country_name UNIQUE (name, country_name);
