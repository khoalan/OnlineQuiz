use quiztest;

DROP TABLE IF EXISTS users;
create table if not exists users (
	user_id int auto_increment primary key,
    user_name varchar(50),
    user_password varchar(50),
    first_name varchar(50),
    last_name varchar(50)    
);

