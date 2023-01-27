-- Practice Assignment  #304.2.4 
-- https://www.w3resource.com/mysql-exercises/string-exercises/
-- 1,
select job_id, group_concat(EMPLOYEE_ID, ' ')  'Employees ID' from employees
group by job_id;

-- 2
update employees 
set PHONE_NUMBER = replace(PHONE_NUMBER, '124', '999')
where PHONE_NUMBER like '%124%';

-- 3
select * from employees
where length(FIRST_NAME) >=8;

-- 4
select job_id, lpad( MAX_SALARY, 7, '0'), lpad( MIN_SALARY, 7, '0')
from jobs;

-- 5
update employees
set EMAIL = concat(email, '@example.com' );
select * from employees;

-- 6
select EMPLOYEE_ID, FIRST_NAME, month(HIRE_DATE)
from employees;

-- 7
SELECT employee_id, REVERSE(SUBSTR(REVERSE(email), 4)) as Email_ID 
from employees;

-- 8
select * from employees
where FIRST_NAME =binary upper(FIRST_NAME);

-- 9
select substr(PHONE_NUMBER, -4) from employees;

-- 10
SELECT location_id, street_address, 
SUBSTRING_INDEX(REPLACE(REPLACE(REPLACE(street_address,',',' '),')',' '),'(',' '),' ',-1) 
AS 'Last--word-of-street_address' 
FROM locations;

-- 17
SELECT EMPLOYEE_ID,  FIRST_NAME, HIRE_DATE
FROM employees
where month(HIRE_DATE) = 07 or day(HIRE_DATE) = 07;
