-- LAB - 304.2.2 - Aggregate Functions

-- Using MOD() function.
-- The following statement finds whether the quantity of products, which customers ordered, is odd or even
select * from orderdetails ;

SELECT orderNumber, SUM(quantityOrdered) as Qty,
    IF(MOD(SUM(quantityOrdered),2),'Odd', 'Even') as oddOrEven
FROM    orderdetails
GROUP BY    orderNumber
ORDER BY    orderNumber; 

-- TRUNCATE() Function
SELECT TRUNCATE(1.555,1);

-- ROUND() function
SELECT     productCode,
  ROUND(AVG(quantityOrdered * priceEach)) as avg_order_item_value
FROM     orderDetails
GROUP BY    productCode;    

-- SQL TRUNCATE() vs. ROUND()
SELECT   TRUNCATE(1.999,1),  ROUND(1.999,1);

-- REPLACE() Function
UPDATE products 
SET productDescription = REPLACE(productDescription,'abuot','about');

-- DATEDIFF() function
SELECT DATEDIFF('2011-08-17','2011-08-17');  
#Result  :   0 day

SELECT DATEDIFF('2011-08-17','2011-08-08'); 
#Result:  9 days

SELECT DATEDIFF('2011-08-08','2011-08-17');  
#Result:  -9 days

SELECT orderNumber, DATEDIFF(requiredDate, shippedDate) as  daysLeft
FROM     orders
ORDER BY  daysLeft DESC;

SELECT orderNumber, DATEDIFF(requiredDate, orderDate) as remaining_days
FROM    orders
WHERE    status = 'In Process'
ORDER BY remaining_days;

-- For calculating an interval in week or month, you can divide value of the DATEDIFF() function by 7 or 30
SELECT 
    orderNumber,
    ROUND(DATEDIFF(requiredDate, orderDate) / 7, 2),
    ROUND(DATEDIFF(requiredDate, orderDate) / 30,2)
FROM     orders 
WHERE    status = 'In Process';



SELECT 
    orderNumber,
    DATE_FORMAT(orderdate, '%Y-%m-%d') orderDate,
    DATE_FORMAT(requireddate, '%a %D %b %Y') requireddate,
    DATE_FORMAT(shippedDate, '%W %D %M %Y') shippedDate
FROM    orders;


-- LPAD(str, len, padstr)
SELECT LPAD('hi',4,'??');       #Result   -> '??hi'

SELECT LPAD('hi',1,'??');     # Result -> 'h'

SELECT firstName, LPAD(firstName,10,'kk'), LPAD(firstName,5,'kk'), LPAD(firstName,4,'kk')  				                    
FROM classicmodels.employees;

-- YEAR() Function 
SELECT YEAR('2002-01-01');

SELECT YEAR(shippeddate) as year,  COUNT(ordernumber) as orderQty
FROM    orders 
GROUP BY YEAR(shippeddate)
ORDER BY YEAR(shippeddate);

SELECT  DAY(orderdate) as dayofmonth, COUNT(*)
FROM    orders
WHERE    YEAR(orderdate) = 2004
GROUP BY dayofmonth
ORDER BY dayofmonth;
