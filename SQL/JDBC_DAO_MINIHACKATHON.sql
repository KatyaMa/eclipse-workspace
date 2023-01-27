CREATE database JDBC_DAO_MINIHACKATHON;

CREATE TABLE Customer (
    id int PRIMARY KEY auto_increment,
    email varchar(50), 
    fname varchar(50), 
    lname varchar(50) );

select * from Customer;
delete from Customer;

CREATE TABLE Item (
    id int PRIMARY KEY auto_increment,
    name varchar(50), 
    price DECIMAL(4,2) ) ;

select * from Item;
delete from Item;