-- Insertar clientes
INSERT INTO clientes (name, phone_num, shipping_location, registration_date, entity_type) 
VALUES 
("Juan Pérez", "123456789", "Calle Falsa 123", "2025-01-01", 1),
("María López", "987654321", "Avenida Siempre Viva 742", "2025-02-15", 1);

-- Insertar marcas
INSERT INTO marcas (name) 
VALUES 
("Toyota"), 
("Ford");

-- Insertar tipos de vehículos
INSERT INTO tipos_vehiculos (name) 
VALUES 
("Sedán"), 
("SUV");

-- Insertar vehículos
INSERT INTO vehiculos (id_brand, model, year, license_plate, client_id, id_type) 
VALUES 
(1, "Corolla", 2020, "ABC123", 1, 1), 
(2, "Explorer", 2021, "XYZ789", 2, 2);

-- Insertar servicios
INSERT INTO servicios (name, price) 
VALUES 
("Cambio de aceite", 50.00), 
("Alineación de ruedas", 30.00);

-- Insertar citas
INSERT INTO citas (vehicle_id, date, time, service_id, compleated) 
VALUES 
(1, "2025-04-05", "10:00:00", 1, FALSE), 
(2, "2025-04-06", "14:00:00", 2, FALSE);

-- Insertar proveedores
INSERT INTO proveedores (name, mail) 
VALUES 
("Proveedor A", "proveedorA@example.com"), 
("Proveedor B", "proveedorB@example.com");

-- Insertar objetos
INSERT INTO objeto (name) 
VALUES 
("Filtro de aceite"), 
("Neumático");

-- Insertar inventario
INSERT INTO inventario (id_objeto, cantidad) 
VALUES 
(1, 10), 
(2, 5);

-- Insertar pedidos
INSERT INTO pedidos (id_proveedor, compleated) 
VALUES 
(1, FALSE), 
(2, TRUE);

-- Insertar pedidos_aux
INSERT INTO pedidos_aux (id_pedido, id_objeto, cantidad) 
VALUES 
(1, 1, 5), 
(2, 2, 3);

-- Insertar transacciones
INSERT INTO transacciones (cantidad, concepto, fecha, tipo, id_variable) 
VALUES 
(100.00, "Pago inicial", "2025-04-01", 1, NULL), 
(50.00, "Pago de servicio", "2025-04-02", 3, 1), 
(30.00, "Pago a proveedor", "2025-04-03", 4, 1);