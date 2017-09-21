DROP TABLE IF EXISTS Stores;
DROP TABLE IF EXISTS Divisions;

-- Use the specified DB
USE BigBox;

-- Create the Tables
CREATE TABLE Divisions (
  ID INT NOT NULL AUTO_INCREMENT,
  DivisionNumber VARCHAR(3) NOT NULL,
  Name VARCHAR(45) NOT NULL,
  Address VARCHAR(45) NOT NULL,
  City VARCHAR(45) NOT NULL,
  State VARCHAR(2) NOT NULL,
  ZipCode INT(5) NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE INDEX (DivisionNumber ASC)
);

CREATE TABLE Stores (
  ID INT NOT NULL AUTO_INCREMENT,
  DivisionID INT NOT NULL,
  StoreNumber VARCHAR(5) NOT NULL,
  Sales DOUBLE(10,2) NOT NULL,
  Name VARCHAR(45) NOT NULL,
  Address VARCHAR(45) NOT NULL,
  City VARCHAR(45) NOT NULL,
  State VARCHAR(2) NOT NULL,
  ZipCode INT(5) NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE INDEX (ID, DivisionID ASC),
  FOREIGN KEY (DivisionID) REFERENCES Divisions(ID)
);

-- Insert Data Into Table
INSERT INTO Divisions
-- (ID,DivisionNumber,Name,Address,City,State,ZipCode)
VALUES
(1,'001','Cincinnati Division','1111 Division St.','Cincinnati','OH',45555),
(2,'111','Louisville Division','1222 Washington St.','Louisville','OH',40205);

INSERT INTO Stores
(DivisionID,StoreNumber,Sales,Name,Address,City,State,ZipCode)
VALUES
(1, '00011', 25000, 'Mason BigBox', '5711 Fields Ertel Rd.', 'Mason', 'OH', 45249),
(1, '00255', 27500, 'Downtown BigBox', '9330 Main St.', 'Cincinnati', 'OH', 45202),
(1, '00172', 32555.55, 'Goshen BigBox', '6777 Goshen Rd.', 'Goshen', 'OH', 45122),
(1, '00075', 21425.37, 'Bridgetown BigBox', '3888 Race Rd.', 'Cincinnati', 'OH', 45211),
(2, '00001', 14432.77, 'Louisville BigBox', '1111 Washington St.', 'Louisville', 'KY', 40206),
(2, '00044', 17555.11, 'Lawrenceburg BigBox', '8000 Liberty St.', 'Louisville', 'KY', 40204);


