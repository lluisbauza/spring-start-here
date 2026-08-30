CREATE TABLE IF NOT EXISTS ticket_sale (
    id INT AUTO_INCREMENT PRIMARY KEY,
    movieTitle varchar(100) NOT NULL,
    ticketPrice DECIMAL(10, 2) NOT NULL,
    seatsSold INTEGER NOT NULL
);