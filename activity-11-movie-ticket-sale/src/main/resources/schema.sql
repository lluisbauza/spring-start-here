CREATE TABLE IF NOT EXISTS ticketSale (
    id INT PRIMARY KEY,
    movieTitle varchar(50) NOT NULL,
    ticketPrice double NOT NULL,
    seatsSold numeric NOT NULL
    );