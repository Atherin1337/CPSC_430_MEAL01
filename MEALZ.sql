DROP DATABASE IF EXISTS MEALZ;
CREATE DATABASE IF NOT EXISTS MEALZ;
USE MEALZ;
GRANT ALL ON *.* TO 'meal2013'@'localhost' IDENTIFIED BY 'password';





DROP TABLE IF EXISTS `CookBook`;
CREATE TABLE `CookBook` (
	`CRN` int(5) NOT NULL,
	`Name` varchar(20) NOT NULL,
	`MType` varchar(20) NOT NULL default 'Unknown Food',
	`Often_Used` int(5) NOT NULL default 0,
	`Favorite` enum('T','F') NOT NULL default 'F',
	PRIMARY KEY (CRN)
);


DROP TABLE IF EXISTS `Ingredients`;
CREATE TABLE `Ingredients` (
	`CRN` int(5) NOT NULL,
	`Ingre_Name` varchar(20) NOT NULL,
	`Ingre_Type` varchar(20) NOT NULL default 'Unknown Food',
	`Ingre_Ammount` int(5) NOT NULL,
	`Ingre_Ammount_Messure` varchar(10) NOT NULL
);





INSERT INTO CookBook VALUES (00001, 'Test_Recipe01', 'Chiken', 0, 'T');
INSERT INTO CookBook VALUES (00002, 'Test_Recipe02', 'Beef!', 0, 'F');
INSERT INTO CookBook VALUES (00003, 'Test_Recipe03', 'Phish', 0, 'F');
INSERT INTO CookBook VALUES (00004, 'Test_Recipe04', 'Chiken', 0, 'F');
INSERT INTO CookBook VALUES (00005, 'Test_Recipe05', 'Beef!', 0, 'F');
INSERT INTO CookBook VALUES (00006, 'Test_Recipe06', 'Phish', 0, 'T');
INSERT INTO CookBook VALUES (00007, 'Test_Recipe07', 'Chiken', 0, 'F');
INSERT INTO CookBook VALUES (00008, 'Test_Recipe08', 'Beef!', 0, 'F');
INSERT INTO CookBook VALUES (00009, 'Test_Recipe09', 'Phish', 0, 'F');
INSERT INTO CookBook VALUES (00010, 'Test_Recipe10', 'Chiken', 0, 'F');
INSERT INTO CookBook VALUES (00011, 'Test_Recipe11', 'Beef!', 0, 'T');
INSERT INTO CookBook VALUES (00012, 'Test_Recipe12', 'Phish', 0, 'F');
INSERT INTO CookBook VALUES (00013, 'Nachos del Awsome', 'Mexican', 0, 'F');
INSERT INTO CookBook VALUES (00014, 'Pizza ala Moody', 'Italian', 0, 'F');
INSERT INTO CookBook VALUES (00015, 'Ice Cream Sundays!!!', 'Sweets', 0, 'F');


INSERT INTO Ingredients VALUES (00001, 'Chicken', 'Poultry', '5', 'Breast');
INSERT INTO Ingredients VALUES (00001, 'Tomato', 'Vegitable', '1', 'Single');
INSERT INTO Ingredients VALUES (00001, 'Garlic', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00001, 'Salt', 'Seasoning', '1', 'Tsp');

INSERT INTO Ingredients VALUES (00002, 'Ground Beef', 'Beef', '5', 'lbs');
INSERT INTO Ingredients VALUES (00002, 'Tomato', 'Vegitable', '1', 'Single');
INSERT INTO Ingredients VALUES (00002, 'Garlic', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00002, 'Salt', 'Seasoning', '1', 'Tsp');

INSERT INTO Ingredients VALUES (00003, 'Flounder', 'Fish', '5', 'lbs');
INSERT INTO Ingredients VALUES (00003, 'Tomato', 'Vegitable', '1', 'Single');
INSERT INTO Ingredients VALUES (00003, 'Garlic', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00003, 'Salt', 'Seasoning', '1', 'Tsp');

INSERT INTO Ingredients VALUES (00004, 'Chicken', 'Poultry', '5', 'Breast');
INSERT INTO Ingredients VALUES (00004, 'Tomato', 'Vegitable', '1', 'Single');
INSERT INTO Ingredients VALUES (00004, 'Garlic', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00004, 'Salt', 'Seasoning', '1', 'Tsp');

INSERT INTO Ingredients VALUES (00005, 'Ground Beef', 'Beef', '5', 'lbs');
INSERT INTO Ingredients VALUES (00005, 'Tomato', 'Vegitable', '1', 'Single');
INSERT INTO Ingredients VALUES (00005, 'Garlic', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00005, 'Salt', 'Seasoning', '1', 'Tsp');

INSERT INTO Ingredients VALUES (00006, 'Flounder', 'Fish', '5', 'lbs');
INSERT INTO Ingredients VALUES (00006, 'Tomato', 'Vegitable', '1', 'Single');
INSERT INTO Ingredients VALUES (00006, 'Garlic', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00006, 'Salt', 'Seasoning', '1', 'Tsp');

INSERT INTO Ingredients VALUES (00007, 'Chicken', 'Poultry', '5', 'Breast');
INSERT INTO Ingredients VALUES (00007, 'Tomato', 'Vegitable', '1', 'Single');
INSERT INTO Ingredients VALUES (00007, 'Garlic', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00007, 'Salt', 'Seasoning', '1', 'Tsp');

INSERT INTO Ingredients VALUES (00008, 'Ground Beef', 'Beef', '5', 'lbs');
INSERT INTO Ingredients VALUES (00008, 'Tomato', 'Vegitable', '1', 'Single');
INSERT INTO Ingredients VALUES (00008, 'Garlic', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00008, 'Salt', 'Seasoning', '1', 'Tsp');

INSERT INTO Ingredients VALUES (00009, 'Flounder', 'Fish', '5', 'lbs');
INSERT INTO Ingredients VALUES (00009, 'Tomato', 'Vegitable', '1', 'Single');
INSERT INTO Ingredients VALUES (00009, 'Garlic', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00009, 'Salt', 'Seasoning', '1', 'Tsp');

INSERT INTO Ingredients VALUES (00010, 'Chicken', 'Poultry', '5', 'Breast');
INSERT INTO Ingredients VALUES (00010, 'Tomato', 'Vegitable', '1', 'Single');
INSERT INTO Ingredients VALUES (00010, 'Garlic', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00010, 'Salt', 'Seasoning', '1', 'Tsp');

INSERT INTO Ingredients VALUES (00011, 'Ground Beef', 'Beef', '5', 'lbs');
INSERT INTO Ingredients VALUES (00011, 'Tomato', 'Vegitable', '1', 'Single');
INSERT INTO Ingredients VALUES (00011, 'Garlic', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00011, 'Salt', 'Seasoning', '1', 'Tsp');

INSERT INTO Ingredients VALUES (00012, 'Flounder', 'Fish', '5', 'lbs');
INSERT INTO Ingredients VALUES (00012, 'Tomato', 'Vegitable', '1', 'Single');
INSERT INTO Ingredients VALUES (00012, 'Garlic', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00012, 'Salt', 'Seasoning', '1', 'Tsp');


INSERT INTO Ingredients VALUES (00013, 'Taco Shell', 'Pre-Packaged', '1', 'box');
INSERT INTO Ingredients VALUES (00013, 'Tomato', 'Vegitable', '1', 'Single');
INSERT INTO Ingredients VALUES (00013, 'Garlic', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00013, 'Salt', 'Seasoning', '1', 'Tsp');
INSERT INTO Ingredients VALUES (00013, 'Ground Beef', 'Meat', '15', 'lbs');


















