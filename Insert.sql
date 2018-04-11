INSERT INTO Hotel (
    id,
    name,
    location,
    stars,
    photo_url,
    conveniences
)
VALUES (
    1,
    "Hótel Gullfoss",
    "Tungufell",
    5,
    "",
    "Wi-fi;Morgunmatur;Tv;Spa;Airport"
),
(
    2,
    "Hótel Laki",
    "Kirkjubæjarklaustur",
    4,
    "",
    "Wi-fi;Fotlun;Morgunmatur;Likamsraekt;Gonguleidr"
),
(
    3,
    "Hótel Reykjavík",
    "Reykjavík",
    3,
    "",
    "Morgunmatur;Midbaer;Sturta"
);

INSERT INTO Room (
    id,
    size,
    tvibreitt,
    price,
    hotelId
)
VALUES (
    1,
    2,
    1,
    10000,
    1
),
(
    2,
    1,
    0,
    8000,
    1
),
(
    3,
    4,
    1,
    10000,
    3
),
(
    4,
    2,
    1,
    10000,
    2
);

INSERT INTO User (
    name,
    ssn,
    username,
    password
)
VALUES (
    "Jón Rúnar",
    "0102953439",
    "jrb",
    "123"
);

INSERT INTO Reservation (
    roomId,
    userId,
    date
)
VALUES(
    1,
    1,
    2018-04-02
);

INSERT INTO HotelReview (
    userId,
    hotelId,
    starReview,
    textReview
)
VALUES(
    1,
    1,
    4,
    "blablablabla"
);