-- Eliminar tablas si existen (para evitar errores al ejecutar varias veces)
DROP TABLE IF EXISTS order_detail;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS users;

-- Tabla usuarios
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefono VARCHAR(20)
);

-- Tabla productos
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio NUMERIC(10,2) NOT NULL,
    stock INT NOT NULL
);

-- Tabla órdenes
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    fecha TIMESTAMP NOT NULL,
    user_id INT NOT NULL,
    subtotal NUMERIC(10,2),
    iva NUMERIC(10,2),
    total NUMERIC(10,2),
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
        REFERENCES users(id)
);

-- Tabla detalle de órdenes
CREATE TABLE order_detail (
    id SERIAL PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    cantidad INT NOT NULL,
    CONSTRAINT fk_order
        FOREIGN KEY(order_id)
        REFERENCES orders(id),
    CONSTRAINT fk_product
        FOREIGN KEY(product_id)
        REFERENCES products(id)
);