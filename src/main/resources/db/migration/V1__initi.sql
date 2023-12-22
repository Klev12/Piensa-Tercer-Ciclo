CREATE TABLE IF NOT EXISTS Users(
    id SERIAL PRIMARY KEY,
    FirstName VARCHAR(200) NOT NULL,
    lastName VARCHAR(200) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(50) NOT NULL,
    latitude FLOAT,
    longitude FLOAT
    );

CREATE TABLE IF NOT EXISTS device (
    id SERIAL PRIMARY KEY,
    latitude FLOAT NOT NULL,
    longitude FLOAT NOT NULL,
    timer Date NOT NULL
);
CREATE TABLE IF NOT EXISTS Redpoint(
    id SERIAL PRIMARY KEY,
    Latitude FLOAT NOT NULL,
    Longitude FLOAT NOT NULL,
    device_id INT,
    information VARCHAR(500) NOT NULL,
    FOREIGN KEY (device_id) REFERENCES device(id)
    );

CREATE TABLE IF NOT EXISTS Blackpoint (
    id SERIAL PRIMARY KEY,
    Latitude FLOAT NOT NULL,
    Longitude FLOAT NOT NULL,
    information VARCHAR(500) NOT NULL

);

CREATE TABLE IF NOT EXISTS Yellowpoint (
    id SERIAL PRIMARY KEY,
    Latitude FLOAT NOT NULL,
    Longitude FLOAT NOT NULL,
    information VARCHAR(500) NOT NULL
);



CREATE TABLE IF NOT EXISTS Zones (
    id SERIAL PRIMARY KEY,
    information VARCHAR(500) NOT NULL,
    Blackpoint_id INT,
    Redpoint_id INT,
    Yellowpoint_id INT,
    FOREIGN KEY (Blackpoint_id) REFERENCES Blackpoint(id),
    FOREIGN KEY (Redpoint_id) REFERENCES Redpoint(id),
    FOREIGN KEY (Yellowpoint_id) REFERENCES Yellowpoint(id)
    );