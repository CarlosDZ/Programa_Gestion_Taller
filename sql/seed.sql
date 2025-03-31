CREATE TABLE clientes(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone_num VARCHAR(9),
    shipping_location VARCHAR(200),
    registration_date DATE NOT NULL,
    entity_type CHAR
);

CREATE TABLE vehiculos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_brand INT NOT NULL,
    FOREIGN KEY (id_brand) REFERENCES marcas(id),
    model VARCHAR(100) NOT NULL,
    year INT NOT NULL,
    license_plate VARCHAR(10) UNIQUE NOT NULL,
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES clientes(id),
    id_type INT NOT NULL,
    FOREIGN KEY (id_type) REFERENCES tipos_vehiculos(id)
);

CREATE TABLE marcas(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
CREATE TABLE tipos_vehiculos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);