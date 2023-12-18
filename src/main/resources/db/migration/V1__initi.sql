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
    longitude FLOAT NOT NULL
);
CREATE TABLE IF NOT EXISTS Red_point (
    id SERIAL PRIMARY KEY,
    Latitude FLOAT NOT NULL,
    Longitude FLOAT NOT NULL,
    device_id INT,
    information VARCHAR(500) NOT NULL
    FOREIGN KEY (device_id) REFERENCES device(id)
    );

CREATE TABLE IF NOT EXISTS Black_point (
    id SERIAL PRIMARY KEY,
    Latitude FLOAT NOT NULL,
    Longitude FLOAT NOT NULL,
    information VARCHAR(500) NOT NULL

);

CREATE TABLE IF NOT EXISTS Yellow_point (
    id SERIAL PRIMARY KEY,
    Latitude FLOAT NOT NULL,
    Longitude FLOAT NOT NULL,
    information VARCHAR(500) NOT NULL
);



CREATE TABLE IF NOT EXISTS Zones (
    id SERIAL PRIMARY KEY,
    information VARCHAR(500) NOT NULL,
    Black_point_id INT,
    Red_point_id INT,
    Yellow_point_id INT,
    FOREIGN KEY (Black_point_id) REFERENCES Black_point(id),
    FOREIGN KEY (Red_point_id) REFERENCES Red_point(id),
    FOREIGN KEY (Yellow_point_id) REFERENCES Yellow_point(id)
    );