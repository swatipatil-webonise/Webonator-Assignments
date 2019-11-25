DROP TABLE IF EXISTS user;
 
CREATE TABLE user (
	id VARCHAR(10) PRIMARY KEY,
  	name VARCHAR(20) NOT NULL,
	age int not null 
);

insert into user (id, name, age) values('1','swati',23);
insert into user (id, name, age) values('2','akshay',34);
insert into user (id, name, age) values('3','arijit',34);
insert into user (id, name, age) values('4','ankita',34);
insert into user (id, name, age) values('5','ameya',34);
