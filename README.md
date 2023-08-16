CREATE TABLE User (id int primary key, name varchar(100) , registrationDate varchar(100)); 

CREATE TABLE Address (id int primary key, user_id int, city varchar(100), state varchar(100), zipcode bigint);

CREATE TABLE Account (id int primary key, user_id int, account_type int, account_balance int);

INSERT INTO User (id, name, registrationDate)
VALUES ('1', 'Arun', '12-12-2003'),
('2', 'Ali', '10-10-2005'),
('3', 'Kirun','11-09-2004'),
('4', 'Jack' ,'10-09-2000'),
('5', 'Thomas', '09-02-2001'); 

insert into address (id,user_id,city,state,zipcode)
values(1,2,"delhi","delhi",400001),
(2,3,"mumbai","maharashtra",400002),
(3,1,"delhi","delhi",400003),
(4,4,"surat","gujrat",400004),
(5,5,"bhopal","mp",400005);

insert into Account (id,user_id,account_type,account_balance)
values(1,2,10,1000),
(2,3,20,2000),
(3,1,4,20001),
(4,4,50,3000),
(5,5,90,40000);

-- Q.find count of user who belongs to mumbai having accounts more than 2

select count(u.id) as c 
from user u 
join account ac on u.id= ac.user_id
join address a on u.id=a.user_id
where a.city="mumbai"
group by u.id
having count(ac.id>2);

select count(u.id) as c
 from user u 
 join address a ON u.id = a.user_id 
join account ac ON u.id = ac.user_id
 where a.city ="mumbai"
 group by u.id 
 having count(ac.id>2);




select 
 
-- retive all user data from user for recently 10 register user belonging to delhi.

-- Join...bydefault inner join 

SELECT * FROM user u
JOIN address a ON u.id = a.user_id
WHERE a.city = 'Delhi' limit 10;

-- left join
SELECT * FROM user u
left JOIN address a ON u.id = a.user_id;

-- right join
SELECT * FROM user u
right JOIN address a ON u.id = a.user_id;

CREATE VIEW u1 AS
SELECT city,state
FROM address
WHERE user_id=2;

CREATE VIEW accoutaddress AS
SELECT aa.state, aa.city,u.id
FROM address aa  
JOIN user u ON aa.user_id = u.id;
-- ----------------------------------------------------------------------------------------------------------------------- 
-- cars - id (PK) and name 
-- parts - pid(PK) , pname and cars_id(FK)
-- productparts - ppid(PK), pname and parts_id(FK)
CREATE TABLE cars (
    id INT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE parts (
    pid INT PRIMARY KEY,
    pname VARCHAR(255),
    cars_id INT,
    FOREIGN KEY (cars_id) REFERENCES cars(id)
);

CREATE TABLE productparts (
    ppid INT PRIMARY KEY,
    pname VARCHAR(255),
    parts_id INT,
    FOREIGN KEY (parts_id) REFERENCES parts(pid)
);
-- find the no of parts where car is swift and product is sumsung.

create table payment (id int primary key,
amount int ,
mode varchar(255),
cust_id int);
insert into payment (id,amount,mode)
values(1,50,"online"),
(2,90,"cash"),
(3,60,"free"),
(5,40,"online"),
(6,70,"cash"),
(7,90,"cash"),
(8,30,"phonepay"),
(9,40,"phonepay"),
(10,10,"free");

-- group by used with aggregate function like sun(),max(),min(),etc

select mode, sum(amount) as total from payment group by mode;

--  order by by default its asending without mention as asc we can print but for decending need to mentioned

select mode, sum(amount) as total from payment group by mode order by total desc;

select amount ,sum(amount) as count from payment group by mode having count >=200;

-- iner join ...==join
create table city (cid int,city varchar(250)); 
insert into city (cid ,city) values(1,"agra"),(2,"bhopal"),(3,"delhi"),(4,"noida");
create table student (id int,city int,age int ,name varchar(250),course int ); 
insert into student (id ,city, age, name,course) values(1,1,19,"ram",1),(2,2,18,"salman",3),(3,1,19,"mavra",1),(4,3,21,"sai",3);

select * from student s inner join city c on s.city=c.cid ;
select * from student s inner join city c on s.city=c.cid where c.city="agra";

select * from student s inner join city c on s.city=c.cid where c.city="agra" order by s.name;
-- inner join on 3 tables
create table courses (crid int ,course varchar(255));
insert into courses (crid,course) values(1,"Btech"),(2,"BCA"),(3,"BBA");

select * from student s inner join city c on s.city=c.cid
inner join courses cc on s.course=cc.crid;

-- print name of city whose student count is more than 1
select c.city ,count(c.cid) as total from student s inner join city c on s.city=c.cid
group by c.cid having count(c.cid)>1 ;

-- to print name of student who doing btech and mba by subquery

select name from student where course = (select crid from courses where course ="mba");
-- using in
select name from student where course in (select crid from courses where course in ("btech","mba"));

-- using exists ,not exists 
select * from student where not exists (select crid from courses where course ="mba");

-- print student whose age is in between...and condition
select * from student where age>=18 and age<=20;
 
 -- print student whose age ...or condition
select * from student where age=18 or age=19;

 -- using not
select * from student where not( age=18 or age=19);
  
select * from student s inner join city c on s.city=c.cid  where c.city="delhi" or c.city="agra";

select * from student s inner join city c on s.city=c.cid where (c.city="delhi" or c.city="agra") and age>18;

-- like operator here "" are importat for varchar
select name from student where name like "s%";
-- start with s 
select name from student where name like "%a";
-- end with a
select name from student where name like "_s%";
-- s on second position
select name from student where name like "%s%";
-- s is on any position
select name from student where name like "%an";
-- ends with an
