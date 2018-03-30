CREATE TABLE Hotel (
    id              serial primary key,
    name            varchar(65) UNIQUE NOT NULL,
    location        varchar(255) NOT NULL,
    stars           smallint CHECK (stars >= 1 AND stars <= 5) NOT NULL,
    photo_url       varchar(65) NOT NULL,
    conveniences    varchar(65) NOT NULL
);

CREATE TABLE Room (
    id              serial primary key,
    size            int NOT NULL,
    price           int NOT NULL,
    hotelId        int NOT NULL,
    FOREIGN KEY (hotelId) REFERENCES Hotel(id) 
);

CREATE TABLE User (
    id              serial primary key,
    name            text UNIQUE NOT NULL,
    ssn             varchar(10) CHECK (length(ssn) = 10) UNIQUE NOT NULL,
    username        varchar(65),
    password        varchar(65)
);

CREATE TABLE Reservation (
    roomId          int NOT NULL,
    userId          int NOT NULL,
    date            date NOT NULL,
    FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (roomId) REFERENCES Room(id)
);

CREATE TABLE HotelReview (
    userId          int NOT NULL,
    hotelId         int NOT NULL,
    starReview      smallint CHECK (starReview >= 1 AND starReview <= 5) NOT NULL,
    textReview      varchar(255)
);

