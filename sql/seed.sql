CREATE TABLE clientes(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone_num VARCHAR(15),
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

CREATE TABLE citas(
    id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT NOT NULL,
    FOREIGN KEY (vehicle_id) REFERENCES vehiculos(id),
    date DATE NOT NULL,
    time TIME NOT NULL,
    service_id INT NOT NULL,
    FOREIGN KEY (service_id) REFERENCES servicios(id),
    compleated BOOLEAN DEFAULT FALSE
);

CREATE TABLE servicios(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

CREATE TABLE proveedores(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    mail VARCHAR(100)
);

CREATE TABLE objeto(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
CREATE TABLE inventario(
    id_objeto INT UNIQUE,
    FOREIGN KEY (id_objeto) REFERENCES objeto(id),
    cantidad INT NOT NULL DEFAULT 0
);