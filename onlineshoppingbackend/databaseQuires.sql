CREATE TABLE category(
id IDENTITY,
name VARCHAR(50),
description VARCHAR(350),
image_url VARCHAR(50),
is_active BOOLEAN,
CONSTRAINT pk_category_id PRIMARY KEY (id)
);


insert into category(name,description,image_url,is_active) values('Mobile','Description of List of All Mobiles','CAT1.png',true);
insert into category(name,description,image_url,is_active) values('Laptop','Description of List of All Laptop','CAT2.png',true);
insert into category(name,description,image_url,is_active) values('Television','Description of List of All Television','CAT3.png',true);


CREATE TABLE user_detail(
id IDENTITY,
first_name VARCHAR(50),
last_name VARCHAR(50),
role VARCHAR(50),
email VARCHAR(100),
password VARCHAR(100),
contact VARCHAR(50),
enabled BOOLEAN,
CONSTRAINT pk_user_id PRIMARY KEY (id)
);


insert into user_detail(first_name,last_name,role,email,password,contact,enabled) values('Virat','Kohli','ADMIN','vk@gmail.com','admin','8877',true);
insert into user_detail(first_name,last_name,role,email,password,contact,enabled) values('Ram','Kumar','SUPPLIER','rk@gmail.com','password','89877',true);
insert into user_detail(first_name,last_name,role,email,password,contact,enabled) values('Ankit','Kumar','SUPPLIER','ak@gmail.com','password','896877',true);


CREATE TABLE product(
id IDENTITY,
name VARCHAR(50),
code VARCHAR(50),
brand VARCHAR(50),
description VARCHAR(400),
unit_price decimal(10,2),
is_active BOOLEAN,
category_id INT,
supplier_id INT,
purchases INT default 0,
views INT default 0,
CONSTRAINT pk_product_id PRIMARY KEY (id),
CONSTRAINT pk_product_category_id FOREIGN  KEY (category_id) REFERENCES category(id),
CONSTRAINT pk_product_supplier_id FOREIGN  KEY (supplier_id) REFERENCES user_detail(id)
);


insert into product(name,code,brand,description,unit_price,is_active,category_id,supplier_id,purchases,views) values('iPhone5s','ABCD3ED','Apple','best phone','38000',true,1,2,30,50);

insert into product(name,code,brand,description,unit_price,is_active,category_id,supplier_id,purchases,views) values('Motorola','WER3ED','Motorola','best phone','28000',true,1,3,30,50);

insert into product(name,code,brand,description,unit_price,is_active,category_id,supplier_id,purchases,views) values('Explorer','EXPLD3ED','HTC','best phone','8000',true,1,2,30,50);

insert into product(name,code,brand,description,unit_price,is_active,category_id,supplier_id,purchases,views) values('redmiPrime','REDBCD3ED','Redmi','best phone','18000',true,1,3,50,50);


insert into product(name,code,brand,description,unit_price,is_active,category_id,supplier_id,purchases,views) values('LgCRT','LGCD3ED','Lg','best TV','38000',true,3,2,30,50);

insert into product(name,code,brand,description,unit_price,is_active,category_id,supplier_id,purchases,views) values('Samung LCD','SAMER3ED','Samsung','best Tv','28000',true,3,3,30,50);

insert into product(name,code,brand,description,unit_price,is_active,category_id,supplier_id,purchases,views) values('Sony Tv','SONYLD3ED','SONY','Sony tv','80000',true,3,2,30,50);

insert into product(name,code,brand,description,unit_price,is_active,category_id,supplier_id,purchases,views) values('SmartTv','DEEDBCD3ED','VEDIOCON','Vediocon','8000',true,3,3,50,50);





