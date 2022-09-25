show tables

create table users (
	id int,
	name varchar(255),
	lastname varchar(255),
	username varchar (20),
	pass varchar(100),
	tipDoc char(5),
	nroDoc varchar(20),
	enable int
)

alter table users add primary key (id);

ALTER TABLE ep1.users MODIFY COLUMN id int auto_increment NOT NULL;

INSERT INTO USERS (name,lastname,username,pass,tipDoc,nroDoc,enable)
VALUES ('Jose','Zuniga','DNI73267572','123456','DNI','73267572',1);

INSERT INTO USERS (name,lastname,username,pass,tipDoc,nroDoc,enable)
VALUES ('Maria','Santillan','DNI46299021','123456','DNI','46299021',1);

update users set name='Mariana' where username='DNI46299021';

delete from users where username='DNI73267572';

select * from users