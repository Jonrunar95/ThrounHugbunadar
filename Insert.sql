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
    "https://notendur.hi.is/athh15/MyndirHotel/hotelTungufell.jpg",
    "Free Wi-fi;Breakfast included;Tv in room;Spa in Hotel;Airport pickup/dropoff"
),
(
    2,
    "Hótel Laki",
    "Kirkjubæjarklaustur",
    4,
    "https://notendur.hi.is/athh15/MyndirHotel/HotelLaki.png",
    "Free Wi-fi;Wheelchair accessability;Breakfast included;Gym in Hotel;Walking paths"
),
(
    3,
    "Hótel Reykjavík",
    "Reykjavík",
    3,
    "https://notendur.hi.is/athh15/MyndirHotel/hotelReykjavik.jpg",
    "Breakfast included;Downtown;Shower in Rooms"
),
(
    4,
    "Hótel Reykjavík Center",
    "Reykjavík",
    4,
    "https://notendur.hi.is/athh15/MyndirHotel/hotelPlaza.jpg",
    "Free Wi-fi;Breakfast included;Tv in Rooms;Spa in Hotel;Gym in Hotel"
),
(
    5,
    "Grand Hotel Reyjkavík",
    "Reykjavík",
    5,
    "https://notendur.hi.is/athh15/MyndirHotel/GrandHotel.jpg",
    "Wheelchair accessability;Free Wi-fi;Gym in Hotel;Breakfast included;Downtown;Spa in Hotel;Shower in Rooms;Tv in Rooms"
),
(
    6,
    "Hótel Saga",
    "Reykjavík",
    4,
    "https://notendur.hi.is/athh15/MyndirHotel/HotelSaga.jpg",
    "Free Wi-fi;Tv in Rooms"
);

INSERT INTO Room (
    id,
    size,
    tvibreitt,
    price,
    hotelId,
    photo_url
)
VALUES (
    1,
    2,
    1,
    10000,
    4,
    "https://notendur.hi.is/athh15/MyndirHotel/roomReykjavik.jpg"
),
(
    2,
    3,
    1,
    12500,
    1,
    "https://notendur.hi.is/athh15/MyndirHotel/roomTungufell.jpg"
),
(
    3,
    2,
    0,
    10500,
    1,
    "https://notendur.hi.is/athh15/MyndirHotel/roomTungufell.jpg"
),
(
    4,
    1,
    0,
    8500,
    2,
    "https://notendur.hi.is/athh15/MyndirHotel/roomPlaza.jpg"
),
(
    5,
    2,
    1,
    10000,
    2,
    "https://notendur.hi.is/athh15/MyndirHotel/roomPlaza2.jpg"
),
(
    6,
    2,
    1,
    25000,
    5,
    "https://notendur.hi.is/athh15/MyndirHotel/HerbergiGrand-1.jpg"
),
(
    7,
    2,
    1,
    18000,
    5,
    "https://notendur.hi.is/athh15/MyndirHotel/HerbergiGrand-2.jpg"
),
(
    8,
    2,
    1,
    10000,
    3,
    "https://notendur.hi.is/athh15/MyndirHotel/roomReykjavik.jpg"
),
(
    9,
    2,
    1,
    8000,
    6,
    "https://notendur.hi.is/athh15/MyndirHotel/HerbergiSaga-1.jpg"
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
    "Rosa flott hótel"
),
(
    1,
    2,
    2,
    "Ekkert spes"
),
(
    1,
    3,
    5,
    "Frábært!"
),
(
    1,
    4,
    1,
    "ojj"
),
(
    1,
    5,
    3,
    "meh"
),
(
    2,
    5,
    5,
    "Vááá!"
),
(
    2,
    3,
    3,
    "Ágætt"
),
(
    2,
    1,
    4,
    "Flott"
);