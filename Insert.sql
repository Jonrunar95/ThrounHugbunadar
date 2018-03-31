INSERT INTO Hotel (
    name,
    location,
    stars,
    photo_url,
    conveniences
)
VALUES (
    "Hótel Gullfoss",
    "Tungufell",
    5,
    "",
    "Wi-fi;Morgunmatur;Tv;Spa;Airport"
),
(
    "Hótel Laki",
    "Kirkjubæjarklaustur",
    4,
    "",
    "Wi-fi;Fotlun;Morgunmatur;Likamsraekt;Gonguleidr"
),
(
    "Hótel Reykjavík",
    "Reykjavík",
    3,
    "",
    "Morgunmatur;Midbaer;Sturta"
);

INSERT INTO Room (
    size,
    price,
    hotelId
)
VALUES (
    100,
    10000,
    1
),
(
    900,
    8000,
    1
),
(
    100,
    10000,
    3
),
(
    100,
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

INSERT INTO RESERVATION (
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