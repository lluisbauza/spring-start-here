CREATE TABLE IF NOT EXISTS warehouse_stock (
    id INT AUTO_INCREMENT PRIMARY KEY,
    warehouse VARCHAR(25) NOT NULL,
    product VARCHAR(25) NOT NULL,
    quantity INTEGER NOT NULL
    );