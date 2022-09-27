create table supplier (
	id int,
	companyname varchar(255),
	contactname varchar(255),
	companyphone varchar (20),
	product varchar(100),
	city varchar(100),
	country varchar(100),
	enable int
)

alter table supplier add primary key (id);

ALTER TABLE supplier MODIFY COLUMN id int auto_increment NOT NULL;

INSERT INTO supplier (companyname,contactname,companyphone,product,city,country,enable)
VALUES ('Frutas Gutierrez','Antonio Gutierrez','607454545','pera','Sao Paulo','Brasil',1);

INSERT INTO supplier (companyname,contactname,companyphone,product,city,country,enable)
VALUES ('Hortalizas del sur','Guillermo Morales','652854874','manzana','Santiago','Chile',1);

INSERT INTO supplier (companyname,contactname,companyphone,product,city,country,enable)
VALUES ('Azucarera Sevillana','Rodrigo Mendez','622525885','azucar','Sevilla','España',1);

INSERT INTO supplier (companyname,contactname,companyphone,product,city,country,enable)
VALUES ('Huevos Puebla','Araceli Arnedo','652879137','huevo','Puebla','Mexico',1);

INSERT INTO supplier (companyname,contactname,companyphone,product,city,country,enable)
VALUES ('Arroces La Cigala','Maria Alvarez','677889924','arroz','Trujillo','Peru',1);



select * from supplier