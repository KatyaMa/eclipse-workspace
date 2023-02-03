CREATE DATABASE socialNetDB;
USE socialNetDB;
drop DATABASE IF EXISTS socialNetDB;

create table user(
 id INTEGER NOT NULL AUTO_INCREMENT,
 name TEXT(30) NOT NULL,
 email TEXT(30) NOT NULL,
 password TEXT(30) NOT NULL
 )