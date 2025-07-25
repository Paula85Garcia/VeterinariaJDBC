CREATE DATABASE veterinaria;

USE veterinaria;    
CREATE TABLE personas (
    documento VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100),
    telefono VARCHAR(20),
    direccion VARCHAR(100)
);

CREATE TABLE mascotas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    documento VARCHAR(20), -- documento del dueño
    nombreMascota VARCHAR(50),
    especie VARCHAR(30),
    raza VARCHAR(30),
    edad INT,
    FOREIGN KEY (documento) REFERENCES personas(documento)
);
select * from personas;