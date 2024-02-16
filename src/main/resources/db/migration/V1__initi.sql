CREATE TABLE IF NOT EXISTS Users(
    id SERIAL PRIMARY KEY,
    first_Name VARCHAR(200) NOT NULL,
    last_Name VARCHAR(200) NOT NULL,
    email VARCHAR(100) NOT NULL,
    username VARCHAR(100)NOT NULL,
    password VARCHAR(50)NOT NULL
    );

CREATE TABLE IF NOT EXISTS device (
    id SERIAL PRIMARY KEY,
    latitude FLOAT NOT NULL,
    longitude FLOAT NOT NULL,
    timer Date NOT NULL
);
CREATE TABLE IF NOT EXISTS points(
    id SERIAL Primary Key,
    latitude FLOAT NOT NULL,
    longitude FLOAT NOT NULL,
    radius INT NOT NULL,
    color VARCHAR (20)
);








