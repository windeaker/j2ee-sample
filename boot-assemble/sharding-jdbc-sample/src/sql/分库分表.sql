create database if not exists edu_db_1;
CREATE TABLE "edu_db_1".course_1(
    cid bigint(20) primary key ,
    cname varchar(50) not null ,
    user_id bigint(20) not null ,
    cstatus varchar(10) not null
);
CREATE TABLE "edu_db_1".course_2(
    cid bigint(20) primary key ,
    cname varchar(50) not null ,
    user_id bigint(20) not null ,
    cstatus varchar(10) not null
);
create database if not exists edu_db_2;
CREATE TABLE "edu_db_2".course_1(
    cid bigint(20) primary key ,
    cname varchar(50) not null ,
    user_id bigint(20) not null ,
    cstatus varchar(10) not null
);
CREATE TABLE "edu_db_2".course_2(
    cid bigint(20) primary key ,
    cname varchar(50) not null ,
    user_id bigint(20) not null ,
    cstatus varchar(10) not null
);