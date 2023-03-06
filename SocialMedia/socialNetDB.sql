CREATE DATABASE socialNetDB;
USE socialNetDB;
drop DATABASE IF EXISTS socialNetDB;

create table user(
 id INTEGER NOT NULL AUTO_INCREMENT,
 name TEXT(30) NOT NULL,
 email TEXT(30) NOT NULL,
 password TEXT(30) NOT NULL
 );
 
 select * from user;
 select * from posts;
 select * from messages;
 select * from likes;
 select * from friends;
 select * from comments;
 select * from friends;
 select * from photo;
 select * from role;
--  select * from groups;