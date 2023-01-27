-- HackerRank MySQL
-- Query the list of CITY names from STATION that do not start with vowels. Your result cannot contain duplicates.

SELECT DISTINCT CITY FROM STATION 
WHERE CITY  regexp  '^[^aeiou]';

-- Weather Observation Station 6
SELECT DISTINCT CITY FROM STATION 
WHERE CITY  regexp  '^[aeiou]';

-- Average Population
select floor(avg(population))
from city;

-- Weather Observation Station 15
select round(LONG_W,4)
from station
where LAT_N = (select max(LAT_N) from station where LAT_N < 137.2345 );

-- Weather Observation Station 18
/*
 In a plane with p1 at (x1, y1) and p2 at (x2, y2),->   |x1 - x2| + |y1 - y2|
*/
select round((abs( min(LAT_N) - max(LAT_N)) + abs(min(LONG_W ) -  max(LONG_W ))), 4)
from station;

-- Weather Observation Station 19
-- Euclidean distance between two points P(x1, y1) and Q(x2, y2) ->  d =√[(x2 – x1)^2 + (y2 – y1)^2]   
select round(  sqrt ( power( min(LAT_N) - (max(LAT_N) ), 2) +  power( min(LONG_W) - (max(LONG_W)  ), 2)    )    , 4) 
from station;


-- 3. 3B Lists course
select c.name, count(s.id)
from course c
join studentCourse sc on c.id = sc.courseId
join student s on sc.studentId = s.id
GROUP by c.name
order by count(s.id) DESC, c.name;

-- 4. 3C1 list courses without faculties
select name
from course
where id not in (select courseId from facultyCourse)
order by name;


-- 5. 3C2
select c.name, count(s.id) 
from course c
join studentCourse sc on c.id = sc.courseId
join student s on s.id = studentId
where c.id not in (select courseId from facultyCourse)
GROUP by c.name
order by count(s.id) desc, c.name;

-- 6. 3D
select count(distinct studentId) Students, year(startDate) Year
from studentCourse
group by Year
order by Year, Students DESC;

select * from studentcourse;

-- 7. 3E
select startDate, count(distinct studentId)
from studentCourse
where month(startDate) = 8
GROUP by startDate
order by startDate, count(distinct studentId);


-- 8. 3F
SELECT s.firstname, s.lastname, count(distinct sc.courseId)
from student s
join studentCourse sc on s.id = sc.studentId
join course c on c.id = sc.courseId
where c.deptId =  s.majorId
GROUP by s.id
order by count(distinct sc.courseId) DESC, s.firstname, s.lastname;

select majorId from student;

-- 9. 3G Progress less then 50%
SELECT s.firstname, s.lastname, round(avg(sc.progress), 1) as avg_prg
from studentcourse sc
join student s on s.id =  sc.studentId
group by s.firstname, s.id
having avg(progress) < 50
ORDER by avg_prg DESC, s.firstname, s.lastname;

-- 10. 3H1
select c.name, round(avg(sc.progress), 1) AS avg_prg
from course c
JOIN studentCourse sc on c.id = sc.courseId
GROUP by c.name
order BY avg_prg DESC, c.name;

-- 11. 3H2
select c.name, round(avg(sc.progress), 1) AS avg_prg
from course c
JOIN studentCourse sc on c.id = sc.courseId
WHERE sc.progress = (select max(sc.progress) from studentCourse)
GROUP by c.name
order by avg_prg desc
limit 1;

-- 12. 3H3
select f.firstname, f.lastname, round(avg(sc.progress), 1) AS avg_prg
from faculty f
join facultyCourse fc on f.id = fc.facultyId
JOIN course c on c.id = fc.courseId
join studentCourse sc on c.id = sc.courseId
GROUP BY f.id 
ORDER BY avg_prg DESC,  f.firstname, f.lastname;


-- 13. 3I
select s.firstname, s.lastname, 

case when( min(sc.progress) < 40) then 'F'
        when( min(sc.progress) < 50) then 'D'
        when ( min(sc.progress) < 60) then 'C'
        when ( min(sc.progress) < 70) then 'B'
        when ( min(sc.progress) >= 70) then 'A'
end as min_gr, 

case when( max(sc.progress) < 40) then 'F'
        when( max(sc.progress) < 50) then 'D'
        when ( max(sc.progress) < 60) then 'C'
        when ( max(sc.progress) < 70) then 'B'
        when ( max(sc.progress) >= 70) then 'A'
end as max_gr
from student s
join studentCourse sc on s.id = sc.studentId
GROUP by s.id
ORDER by min_gr DESC, max_gr DESC, s.firstname, s.lastname;
