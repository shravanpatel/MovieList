-- movies_on_the_list --
-- movie_details --
-- theater -- 
ALTER TABLE movies
ADD release_date DATE;

CREATE TABLE theater(
	theater_id int NOT NULL AUTO_INCREMENT,
	theater_name VARCHAR(30) NOT NULL,
	PRIMARY KEY(theater_id)
);

CREATE TABLE movie_list_details(
	list_id int NOT NULL AUTO_INCREMENT,
	list_name VARCHAR(30), 
	theater_id int, 
	PRIMARY KEY(list_id ),
	FOREIGN KEY(theater_id) REFERENCES theater(theater_id)
);

CREATE TABLE movies_on_list(
	movie_id int NOT NULL, 
	list_id int NOT NULL,
	FOREIGN KEY(list_id) REFERENCES movie_list_details(list_id),
	FOREIGN KEY(movie_id) REFERENCES movies(id)
);
