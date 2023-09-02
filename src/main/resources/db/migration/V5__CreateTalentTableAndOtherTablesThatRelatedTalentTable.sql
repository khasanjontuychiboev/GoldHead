CREATE TYPE work_location_type AS ENUM ('ONSITE', 'REMOTE', 'HYBRID');
CREATE TYPE employment_type AS ENUM ('FULL TIME', 'PART TIME', 'CONTRACT','INTERNSHIP','TEMPRORY','APPRENTICESHIP');


create table if not exists talent
(
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    first_name varchar,
    last_name varchar,
    headline varchar,
    email varchar,
    phone varchar,
    city_id uuid not null references city(id),
    open_to_work_active boolean,
    open_to_work_location_type work_location_type,
    open_to_work_employment_type employment_type,
    open_to_work_start_date varchar,
    created_at timestamp,
    updated_at timestamp default current_timestamp
);


create table if not exists talent_skills(
    id uuid DEFAULT uuid_generate_v4() PRIMARY KEY,
    talent_id uuid not null references talent(id),
    skill_name varchar not null references skills(name),
    created_at timestamp,
    updated_at timestamp default current_timestamp
);


create table if not exists open_to_work_job_titles(
    id uuid default uuid_generate_v4() primary key ,
    talent_id uuid not null references talent(id),
    title varchar,
    created_at timestamp,
    updated_at timestamp default current_timestamp
);

create table if not exists open_to_work_remote_locations (
  id uuid default uuid_generate_v4() primary key ,
  talent_id uuid not null references talent(id),
  city_id uuid not null references city(id),
  created_at timestamp,
  updated_at timestamp default current_timestamp
);

create table if not exists open_to_work_onsite_locations (
  id uuid default uuid_generate_v4() primary key ,
  talent_id uuid not null references talent(id),
  city_id uuid not null references city(id),
  created_at timestamp,
  updated_at timestamp default current_timestamp
);

create table if not exists company (
  id uuid default uuid_generate_v4() primary key ,
  name varchar,
  city_id uuid not null references city(id),
  description text,
  created_at timestamp,
  updated_at timestamp default current_timestamp

);


create table if not exists experience (
  id uuid default uuid_generate_v4() primary key ,
  talent_id uuid not null references talent(id),
  title varchar,
  company_name varchar,
  company_id uuid not null references company(id),
  city_id uuid not null references city(id),
  work_location_type work_location_type,
  employment_type employment_type,
  start_date timestamp,
  end_date timestamp,
  current_work_here boolean,
  description text,
  created_at timestamp,
  updated_at timestamp default current_timestamp
);



create table if not exists experience_skills(
  id uuid default uuid_generate_v4() primary key,
  experience_id uuid not null references experience(id),
  skill_name varchar references skills(name),
  created_at timestamp,
  updated_at timestamp default current_timestamp
);

create table if not exists degree (
  name varchar primary key,
  created_at timestamp,
  updated_at timestamp default current_timestamp
);


create table if not exists school (
  id uuid default uuid_generate_v4() primary key,
  name varchar,
  description text,
  city_id uuid not null references city(id),
  created_at timestamp,
  updated_at timestamp default current_timestamp
);

create table if not exists school_field (
  id uuid default uuid_generate_v4() primary key,
  school_id uuid not null references school(id),
  name varchar,
  description text,
  created_at timestamp,
  updated_at timestamp default current_timestamp
);

create table if not exists education (
  id uuid default uuid_generate_v4() primary key,
  school_name varchar,
  school_id uuid not null references school(id),
  talent_id uuid not null references talent(id),
  degree varchar not null references degree(name),
  school_field_name varchar,
  school_field_id uuid not null references school_field(id),
  start_date timestamp,
  still_here boolean default false,
  grade numeric(5,2),
  description text,
  end_date timestamp,
  created_at timestamp,
  updated_at timestamp default current_timestamp
);


create table if not exists education_skills(
  id uuid default uuid_generate_v4() primary key,
  education_id uuid not null references education(id),
  skill_name varchar not null references skills(name),
  created_at timestamp,
  updated_at timestamp default current_timestamp
);
