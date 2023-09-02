create table if not exists skills(
    name varchar(255) primary key,
    created_at timestamp,
    updated_at timestamp default current_timestamp
);

insert into skills(name, created_at) values ('java',now());
insert into skills(name, created_at) values ('spring boot',now());
insert into skills(name, created_at) values ('docker',now());
insert into skills(name, created_at) values ('AWS',now());
insert into skills(name, created_at) values ('GCP',now());
insert into skills(name, created_at) values ('javascript',now());
insert into skills(name, created_at) values ('python',now());
insert into skills(name, created_at) values ('git',now());