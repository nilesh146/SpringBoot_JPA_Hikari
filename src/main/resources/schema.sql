drop table if  exists person;
create table person(
person_id bigint auto_increment  NOT NULL primary key,
first_name varchar(225) NOT NULL,
last_name varchar(225) NOT NULL,
age  int NOT NULL,
mobile varchar(225) NOT NULL,
email varchar(225) NOT NULL

);
