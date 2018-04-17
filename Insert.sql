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
),
(
    4,
    "Hótel Saga",
    "Reykjavík",
    4,
    "",
    "Wi-fi;Tv"
),
(
    5,
    "Grand Hotel Reyjkavík",
    "Reykjavík",
    5,
    "",
    "Fotlun;Wi-fi;Likamsraekt;Morgunmatur;Midbaer;Spa;Sturta;Tv"
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
),
(
    5,
    2,
    1,
    20000,
    5
),
(
    6,
    2,
    1,
    25000,
    5
),
(
    7,
    2,
    1,
    18000,
    5
),
(
    8,
    2,
    1,
    10000,
    4
),
(
    9,
    2,
    1,
    8000,
    4
);

INSERT INTO User (
    id,
    name,
    ssn,
    username,
    password
)
VALUES (
    1,
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