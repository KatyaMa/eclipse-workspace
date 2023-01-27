
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`SBA_MOCKUP` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `SBA_MOCKUP`;

/*Table structure for table `customers` */

CREATE TABLE USERS (
USER_ID INTEGER PRIMARY KEY,
FIRST_NAME VARCHAR(30),
LAST_NAME VARCHAR(30),
CITY VARCHAR(60)
);

CREATE TABLE STORES (
STORE_ID INTEGER PRIMARY KEY,
NAME VARCHAR(100),
CITY VARCHAR(60),
SALES_TAX_RATE FLOAT(6,5)
);

CREATE TABLE ITEMS (
ITEM_ID INTEGER PRIMARY KEY,
NAME VARCHAR(30),
PRICE FLOAT(5,2)
);

CREATE TABLE ORDERS (
ORDER_ID INTEGER PRIMARY KEY,
USER_ID INTEGER,
STORE_ID INTEGER,
CONSTRAINT FK_UserID FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID),
CONSTRAINT FK_StoreID FOREIGN KEY (STORE_ID) REFERENCES STORES(STORE_ID)
);

CREATE TABLE ORDER_ITEMS (
ORDER_ID INTEGER,
ITEM_ID INTEGER,
QUANTITY INTEGER,
CONSTRAINT PK_Order_Items PRIMARY KEY (ORDER_ID, ITEM_ID),
CONSTRAINT FK_OrderID FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ORDER_ID),
CONSTRAINT FK_ItemID FOREIGN KEY (ITEM_ID) REFERENCES ITEMS(ITEM_ID)
);



INSERT INTO USERS VALUES (1, 'Lucien', 'Arnolfi', 'New York');
INSERT INTO USERS VALUES (2, 'Susila', 'Foster', 'Stamford');
INSERT INTO USERS VALUES (3, 'Marion', 'Cole', 'New York');
INSERT INTO USERS VALUES (4, 'Edna', 'Kay', 'New York');
INSERT INTO USERS VALUES (5, 'Meridith', 'Stefanov', 'Stamford');
INSERT INTO USERS VALUES (6, 'Mike', 'G', 'New York');

INSERT INTO STORES VALUES (1, 'Bronx Location', 'New York', 0.08875);
INSERT INTO STORES VALUES (2, 'Financial District', 'New York', 0.08875);
INSERT INTO STORES VALUES (3, 'Harlem Location', 'New York', 0.08875);
INSERT INTO STORES VALUES (4, 'North Stamford Location', 'Stamford', 0.0635);
INSERT INTO STORES VALUES (5, 'South Stamford Location', 'Stamford', 0.0635);

INSERT INTO ITEMS VALUES (1,'Hotdog',1.35);
INSERT INTO ITEMS VALUES (2,'Hamburger', 2.00);
INSERT INTO ITEMS VALUES (3,'Cheeseburger',2.50);
INSERT INTO ITEMS VALUES (4,'Fries',1.00);
INSERT INTO ITEMS VALUES (5,'Soda',1.00);


INSERT INTO ORDERS VALUES(1,1,1);
INSERT INTO ORDERS VALUES(2,3,1);
INSERT INTO ORDERS VALUES(3,3,3);
INSERT INTO ORDERS VALUES(4,2,5);
INSERT INTO ORDERS VALUES(5,4,1);
INSERT INTO ORDERS VALUES(6,5,5);
INSERT INTO ORDERS VALUES(7,1,2);
INSERT INTO ORDERS VALUES(8,5,4);

INSERT INTO ORDER_ITEMS VALUES(1,1,2);
INSERT INTO ORDER_ITEMS VALUES(1,4,1);
INSERT INTO ORDER_ITEMS VALUES(1,5,1);
INSERT INTO ORDER_ITEMS VALUES(2,3,1);
INSERT INTO ORDER_ITEMS VALUES(2,5,1);
INSERT INTO ORDER_ITEMS VALUES(3,4,8);
INSERT INTO ORDER_ITEMS VALUES(4,3,1);
INSERT INTO ORDER_ITEMS VALUES(4,4,1);
INSERT INTO ORDER_ITEMS VALUES(5,5,1);
INSERT INTO ORDER_ITEMS VALUES(6,1,2);
INSERT INTO ORDER_ITEMS VALUES(7,1,2);
INSERT INTO ORDER_ITEMS VALUES(8,1,2);


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;




-- JD Module 304.4 - Practice Assignment - Mock SQL SBA
-- 1. Create a query to return all orders made by users with the first name of “Marion”
select ORDER_ID, USER_ID, STORE_ID from orders
left join users using(user_id)
where first_name = 'Marion';

-- 2. Create a query to select all users that have not made an order
-- select * from orders;
select USER_ID, FIRST_NAME, LAST_NAME, CITY
from users
left join orders using(USER_ID)
where ORDER_ID is null;

-- 3. Create a Query to select the names and prices of all items that have been part of 2 or more separate orders.
select distinct NAME, PRICE from items
left join order_items using(ITEM_ID)
left join orders using(ORDER_ID)
where ORDER_ID > 1;


-- 4. Create a query to return the Order Id, Item name, Item Price, and Quantity from orders
-- made at stores in the city “New York”. Order by Order Id in ascending order.
select ORDER_ID, i.NAME, PRICE, QUANTITY 
from orders
left join order_items using(ORDER_ID)
left join items i using(ITEM_ID)
left join stores s using(STORE_ID)
where s.CITY = 'New York'
order by ORDER_ID;



/* 5. Your boss would like you to create a query that calculates the total revenue generated
by each item. Revenue for an item can be found as (Item Price * Total Quantity
Ordered). Please return the first column as ‘ITEM_NAME’ and the second column as
‘REVENUE’. */
select NAME ITEM_NAME, sum(PRICE * QUANTITY) as REVENUE
from items
left join order_items using(ITEM_ID)
group by 1
having REVENUE > 0
order by 2 desc;

/* 
6. Create a query with the following output:
a. Column 1 - Store Name
	i. The name of each store
b. Column 2 - Order Quantity
	i. The number of times an order has been made in this store
c. Column 3 - Sales Figure
	i. If the store has been involved in more than 3 orders, mark as ‘High’
	ii. If the store has been involved in less than 3 orders but more than 1 order,
mark as ‘Medium’
	iii. If the store has been involved with 1 or less orders, mark as ‘Low’
d. Should be ordered by the Order Quantity in Descending Order
*/
select * from orders ;
select s.NAME, count(ORDER_ID) as ORDER_QUANTITY, 
case 
	when (count(ORDER_ID) > 3) then 'High'
	when (count(ORDER_ID) between 2 and 3) then 'Medium'
	when (count(ORDER_ID) < 2) then 'Low'
END AS SALES_FIGURE
 
from stores s 
left join orders o using(STORE_ID)
group by STORE_ID
order by 2 desc;

