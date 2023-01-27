CREATE database library;

CREATE TABLE books (
    id int PRIMARY KEY auto_increment,
    isbn int Unique Key NOT NULL,
    bookName VARCHAR(50)  );

select * from books;