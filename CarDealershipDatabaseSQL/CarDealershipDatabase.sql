################ STEP 1 CREATE THE DATABASE ##############
CREATE DATABASE CarDealershipDatabase;

################ STEP 2 CREATING THE TABLES ##############
CREATE TABLE dealerships(
DealershipID INT AUTO_INCREMENT PRIMARY KEY,
Name VARCHAR(50),
Address VARCHAR(50),
Phone VARCHAR(15)
);

CREATE TABLE vehicles(
VIN VARCHAR(17) PRIMARY KEY,
Make VARCHAR(50),
Model VARCHAR(50),
Color VARCHAR(10),
Year INT,
Price DECIMAL(10, 2),
Sold BIT
);

CREATE TABLE inventory(
DealershipID INT,
VIN VARCHAR(17),
PRIMARY KEY (DealershipID, VIN),
FOREIGN KEY (DealershipID) REFERENCES dealerships(DealershipID),
FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);

CREATE TABLE salescontract(
ContractID INT auto_increment PRIMARY KEY,
VIN VARCHAR(17),
Saledate DATE,
Saleprice DECIMAL(10, 2),
FOREIGN KEY (VIN) REFERENCES vehicles(VIN)
);


################ STEP 3 POPULATING EACH TABLE WITH DATA ##############
INSERT INTO dealerships (Name, Address, Phone)
VALUES ('Paola Whips', '1234 Rich Ave', '817-555-9255'),
	   ('Benito Whips', '5321 Pink Blvd', '682-789-1234'),
       ('Sophies Auto', '2222 Moldavite Rd', '817-222-2913');

INSERT INTO vehicles (VIN, Make, Model, Color, Year, Price, Sold)
VALUES  ('WBS4Z9C55JD123456', 'BMW', 'M5', 'Black', 2023, 95000.00, 0),
        ('JTHCE1D21E5000001', 'Lexus', 'LC 500', 'Red', 2023, 110000.00, 1), 
        ('WUAZZZF59KN900000', 'Audi', 'R8', 'Green', 2023, 130000.00, 0);

INSERT INTO inventory (DealershipID, VIN)
VALUES (1, 'WBS4Z9C55JD123456'),
	   (2, 'JTHCE1D21E5000001'),
       (3, 'WUAZZZF59KN900000');

INSERT INTO salescontract (VIN, Saledate, Saleprice)
VALUES ('JTHCE1D21E5000001', '2023-03-17', '115000.00');






