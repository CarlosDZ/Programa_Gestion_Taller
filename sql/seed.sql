CREATE TABLE clientes(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone_num VARCHAR(9),
    shipping_location VARCHAR(200),
    registration_date DATE NOT NULL,
    entity_type CHAR
)