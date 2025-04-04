DROP DATABASE IF EXISTS Taller_prueba_1;
CREATE DATABASE Taller_prueba_1;
USE Taller_prueba_1;

CREATE TABLE clientes(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone_num VARCHAR(15),
    shipping_location VARCHAR(200),
    registration_date DATE NOT NULL,
    entity_type CHAR
);

CREATE TABLE marcas(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
CREATE TABLE tipos_vehiculos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
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

CREATE TABLE servicios(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
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
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_objeto INT UNIQUE,
    FOREIGN KEY (id_objeto) REFERENCES objeto(id),
    cantidad INT NOT NULL DEFAULT 0
);

CREATE TABLE pedidos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_proveedor INT NOT NULL,
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id),
    compleated BOOLEAN DEFAULT FALSE
);
CREATE TABLE pedidos_aux(
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id),
    id_objeto INT NOT NULL,
    FOREIGN KEY (id_objeto) REFERENCES objeto(id),
    cantidad INT NOT NULL DEFAULT 0
);
CREATE TABLE tipos_transaccion(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);
CREATE TABLE transacciones(
    id INT AUTO_INCREMENT PRIMARY KEY,
    cantidad DOUBLE(10, 2) NOT NULL,
    concepto VARCHAR(200) NOT NULL,
    fecha DATE NOT NULL,
    tipo INT NOT NULL,
    FOREIGN KEY (tipo) REFERENCES tipos_transaccion(id),
    id_variable INT
);
INSERT INTO tipos_transaccion (id,nombre) VALUES (1, "Transaccion de correccion manual desde el programa de gestion");
INSERT INTO tipos_transaccion (id,nombre) VALUES (2, "Transaccion sin tipo especifico");
INSERT INTO tipos_transaccion (id,nombre) VALUES (3, "Pago de servicio");
INSERT INTO tipos_transaccion (id,nombre) VALUES (4, "Pago a proveedor");