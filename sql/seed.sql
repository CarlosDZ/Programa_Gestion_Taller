CREATE TABLE cliente(
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    shipping_location VARCHAR(200),
    registration_date DATE NOT NULL,
    entity_type CHAR,
)