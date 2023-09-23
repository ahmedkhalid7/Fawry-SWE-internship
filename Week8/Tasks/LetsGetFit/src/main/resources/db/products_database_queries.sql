CREATE TABLE ProductsDatabase.Product (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(255),
 price DOUBLE NOT NULL,
 PRIMARY KEY (id)
) ENGINE=MyISAM;


CREATE TABLE `HospitalDatabase`.`Hospital` (
    hospital_id INT PRIMARY KEY,
    hospital_name VARCHAR(255),
    hospital_location VARCHAR(255),
    hospital_contact VARCHAR(255)
);

ALTER TABLE ProductsDatabase.product
DROP COLUMN image;

DROP TABLE ProductsDatabase.product;

ALTER TABLE ProductsDatabase.product MODIFY id INT NOT NULL AUTO_INCREMENT;

INSERT INTO ProductsDatabase.product (id, name, price)
VALUES
(1, 'iPhone 13 Pro', 999),
(2, 'Samsung Galaxy S22 Ultra', 1199),
(3, 'Apple Watch Series 7', 399),
(4, 'Sony PlayStation 5', 499),
(5, 'Nintendo Switch OLED', 349);

SELECT * FROM ProductsDatabase.product;
