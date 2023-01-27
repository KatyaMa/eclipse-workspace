-- Lab - 304.2.1 - ORDER BY Clause
-- Example One: Sort a result set by an expression.

SELECT    orderNumber, orderlinenumber, 
quantityOrdered * priceEach AS subtotal
FROM    orderdetails
ORDER BY   subtotal DESC;


-- Example 2: MySQL ORDER BY and NULL values
SELECT firstName, lastName, reportsTo
FROM    employees
ORDER BY reportsTo;

select status, count(status) as count_status
from orders
group by status
order by count_status desc;


select * from orders
limit 10;

select year(orderDate) year, count(orderNumber)
from orders
group by year;


SELECT ordernumber, 
      SUM(quantityOrdered) AS itemsCount, 
      SUM(priceeach*quantityOrdered) AS total 
FROM orderdetails 
     GROUP BY ordernumber 
     HAVING total > 20000;


Select customerNumber, avg(amount)  as avgAmount
from payments p1
group by customerNumber
	having avg(amount) > (
		Select avg(amount) from payments p2
	) order by 2 desc;

-- Select avg(amount) from payments 

SELECT * FROM Products WHERE (buyPrice BETWEEN 10 AND 20)
AND NOT productLine IN (1,2,3);


SELECT * FROM Products
WHERE ProductName 
BETWEEN 'Carnarvon Tigers' AND 'Mozzarella di Giovanni'
ORDER BY ProductName;


/*
304.2.3 - Practice Assignment - Simple Queries

1. Write a query to display the name, product line, and buy price of all products. 
The output columns should display as “Name,” “Product Line,” and “Buy Price.” 
The output should display the most expensive items first.
*/
-- select * from products limit 10;
select productName 'Name', productLine 'Product Line', buyPrice 'Buy Price'
from products
order by buyPrice desc;


/*
2. Write a query to display the first name, last name, and city name of all customers from Germany. 
Columns should display as “First Name,” “Last Name,” and “City.” The output should be sorted by “Last Name” (ascending).
*/
-- select * from customers;
select contactFirstName 'First Name', contactLastName 'Last Name', city 'City'
from customers
where country = 'Germany'
order by contactLastName;



/*
3. Write a query to display each of the unique values of the status field in the orders table. 
The output should be sorted alphabetically, increasing. Hint: The output should show exactly six rows.
*/
-- select * from orders;
select distinct status from orders
order by status asc;



/*
4. Select all fields from the payments table for payments made on or after January 1, 2005. 
The output should be sorted by increasing the payment date.
*/
select * from payments
where paymentDate >= '2005-01-01'
order by paymentDate;



/*
5. Write a query to display the Last Name, First Name, Email Address, and Job Title of all employees 
working out of the San Francisco office. Output should be sorted by “Last Name.”
*/
select * from employees;
select * from offices;
select lastName 'Last Name', firstName 'First Name', email 'Email Address', jobTitle 'Job Title' from employees
where officeCode  = 1
order by 1;



/*
6. Write a query to display the Name, Product Line, Scale, and Vendor of all of the Car products – both classic and vintage. 
The output should display all vintage cars first (sorted alphabetically by name), 
and all classic cars last (also sorted alphabetically by name). 
Note: For question number 6 , you must know SQL JOIN, if you do not know joins, We will learn  SQL joins in later lectures, 
you can attempt this question later.
*/
-- select * from products;
select productName, productLine, productScale, productVendor from products
where productLine in ('Classic Cars', 'Vintage Cars')
order by productLine desc, productName;

