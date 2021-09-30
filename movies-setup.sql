CREATE TABLE movies(id int NOT NULL AUTO_INCREMENT,
	title VARCHAR(30) NOT NULL,
	genre VARCHAR(40) NOT NULL,
	director VARCHAR(20) NOT NULL,
	producer VARCHAR(20),
	actors VARCHAR(60) NOT NULL,
	PRIMARY KEY (id)
); 

INSERT INTO movies 
VALUES(
	null, 
	"Tenet", 
	"Science Fiction, Action, Thriller", 
	"Christopher Nolan", 
	"Emma Thomas", 
	"John David Washington, Robert Pattinson, Elizabeth Debicki"
);

INSERT INTO movies 
VALUES(
	null, 
	"Wonder Woman 1984", 
	"Action, Adventure, Fantasy", 
	"Patty Jenkins", 
	"Zack Snyder", 
	"Gal Gadot, Chris Pine, Kristen Wiig"
);

INSERT INTO movies 
VALUES(
	null, 
	"Godzilla vs. Kong", 
	"Action, Sci-Fi, Thriller", 
	"Adam Wingard", 
	"Thomas Tull", 
	"Millie Bobby Brown, Kyle Chandler, Rebecca Hall"
);

INSERT INTO movies 
VALUES(
	null, 
	"Black Widow", 
	"Action, Adventure, Sci-Fi", 
	"Cate Shortland", 
	"Kevin Feige", 
	"Scarlett Johansson, Florence Pugh, David Harbour"
);

INSERT INTO movies 
VALUES(
	null, 
	"F9", 
	"Action, Adventure, Crime", 
	"Justin Lin", 
	"Neal H. Moritz", 
	"Vin Diesel, Charlize Theron, John Cena"
);

INSERT INTO movies 
VALUES(
	null, 
	"The Revenant", 
	"Action, Adventure, Drama", 
	"Alejandro González Iñárritu", 
	"Keith Redmon", 
	"Leonardo DiCaprio, Tom Hardy, Will Poulter"
);