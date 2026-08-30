CREATE TABLE IF NOT EXISTS ticket_sale (
    id INT AUTO_INCREMENT PRIMARY KEY,
    movie_title varchar(100) NOT NULL,
    ticket_price DECIMAL(10, 2) NOT NULL,
    seats_sold INTEGER NOT NULL
);