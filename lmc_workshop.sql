DROP DATABASE lmc_workshop;

CREATE DATABASE lmc_workshop;

USE lmc_workshop;


-- Table for company profile
CREATE table company_profile(
	id int(10) not null auto_increment PRIMARY KEY,
	company_name varchar(50) not null,
	owner_name varchar(50) not null,
	no_telfon varchar(13) not null,
	address varchar(300) not null,
	description varchar(500) not null
);

-- Table user or admin 
CREATE table user(
	id varchar(40) not null PRIMARY KEY, 
	user_name varchar(20) not null,
	fullname varchar(35) not null,
	password varchar(10) not null,
	email varchar(20) not null
);

-- Table to save image
-- --CREATE table image_file(
-- --	id int(10) not null auto_increment PRIMARY KEY, 
-- --	file_name varchar(100) not null,
-- --	file_type varchar(30) not null,
-- --	url varchar(100),
-- --	byte varchar(500) not null
-- --);

-- Table category for product
CREATE table category( 
	id int(10) not null auto_increment PRIMARY KEY,
	category_name varchar(50) not null	UNIQUE
);

-- Table detail product
CREATE table product(
	id varchar(40) not null PRIMARY KEY, 
	name varchar(100) not null UNIQUE,
	category_id int(10),
	image_file varchar(100),
	material varchar(40),
	description varchar(500) not null,
	
	CONSTRAINT `fk_product_category` FOREIGN KEY (category_id) REFERENCES category (id)
);



---------------------------- INSERTING VALUE ----------------------------

INSERT into company_profile(company_name, owner_name, no_telfon, address, description)
	VALUES
		('LUKI MANDIRI CORP', 'Riswanto', '82139510449', 'Jl. Gadel Timur II/48 Surabaya', 'Bengkel Las imoet' );

INSERT into user(id, user_name, fullname, password, email)
	VALUES
		(uuid(), 'ryehel7', 'Bie Chan', 'nununu', 'bie@gmail.com');

-- INSERT into image_file(file_name, file_type, url, byte)
-- 	VALUES 
-- 		('gumbal.jpg', 'application/jpg', '/home/upload', 'ABCGAGHAA3772GGG');

INSERT into category(category_name)
	VALUES
			('Iron'),
			('Wood');

INSERT into product(id, name, category_id, image_file, material, description)
	VALUES 
		(uuid(), 'Pagar', 1, 'gumbal.jpg', 'Iron', 'Pagar untuk jaga rumah dari tikus liar');

SELECT * FROM company_profile;
SELECT * FROM user;
SELECT * FROM category;
SELECT * FROM product;

SELECT  
	p.name as PRODUCT_NAME, c.category_name, p.material, p.description, p.image_file 
FROM
	product p
JOIN 
	category c on c.id = p.category_id
;
	
