-- Verificar cual base de datos se está usando
SELECT current_database();

DROP TABLE vehiculos;

-- PARTE 3: Crear la tabla
CREATE TABLE vehiculos(
	placa VARCHAR(10) PRIMARY KEY,
	marca VARCHAR(50) NOT NULL,
	modelo VARCHAR(50) NOT NULL,
	anio INT NOT NULL,
	precio DOUBLE PRECISION NOT NULL,
	color VARCHAR(30),
	disponible BOOLEAN NOT NULL
);

SELECT * FROM vehiculos;

-- PARTE 12: agregar kilometraje
ALTER TABLE vehiculos ADD kilometraje INT;
