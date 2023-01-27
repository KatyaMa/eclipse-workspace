create database usersdb;

select * from user;
select * from employee;
select * from teacher;
select * from department;
select * from department_teacher;
select * from address;
select * from person;
select * from cohort;
select * from teacher;


INSERT INTO `usersdb`.`employee` (`addressLine`, `city`, `job`, `name`, `officeCode`, `salary`, `startDate`, `zipcode`) VALUES 
('24-10', 'NYC', 'Ceo', 'Tom Thele', 1, '25600', '2021-09-09 18:32:11.000000', '11102'),
('35-16', 'LA', 'Manager', 'Jenny Ji', 2, '15600', '2021-09-09 18:32:11.000000', '11103'),
('34-10', 'NJ', 'Cfo', 'M Joseph', 3, '16600', '2021-09-09 18:32:11.000000', '11583'),
('44-20', 'NYC', 'Manager', 'James Judge', 4, '185600', '2021-09-09 18:32:11.000000', '18983'),
('44-20', 'Dallas', 'Manager', 'Ramon Rio', 5, '36600', '2021-09-09 18:32:11.000000', '14783'),
('44-40', 'LA', 'Manager', 'James Santana', 6, '78600', '2021-09-09 18:32:11.000000', '18483'),
('484-40', 'LA', 'Manager', 'Elded Oreo', 6, '50089', '2021-09-09 18:32:11.000000', '155483');