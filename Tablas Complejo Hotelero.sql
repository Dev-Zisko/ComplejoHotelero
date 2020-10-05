-- create database Comp_Hotelero

use Comp_Hotelero;

-- CREAR TABLA DE LUGAR

-- CREATE TABLE Lugar (
-- 	Codigo INT NOT NULL,
--  Descripcion VARCHAR(1000),
--  Tipo VARCHAR(1000) NOT NULL,
--  Codigo' INT NOT NULL,
-- )

-- CREAR TABLA DE PRODUCTO PISCINA

CREATE TABLE Producto_Piscina (
	Codigo INT NOT NULL,
    Fecha DATE NOT NULL,
    CI INT NOT NULL,
    Cantidad INT NOT NULL,
    CONSTRAINT pkproductopisc
    PRIMARY KEY (Codigo,Fecha,CI,Cantidad)
) ENGINE=InnoDB;

-- CREAR TABLA DE LIMPIEZA PISCINA

CREATE TABLE Limpieza_Piscina (
	Fecha DATE NOT NULL,
    CI INT NOT NULL,
    Hora TIME NOT NULL,
    CONSTRAINT pkLimpiezapisc
    PRIMARY KEY (Fecha,CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE DETALLE DE ORDEN DE COMPRA

CREATE TABLE Detalle_Orden_Compra (
	Numero INT NOT NULL,
    Codigo INT NOT NULL,
    Costo INT NOT NULL,
    CONSTRAINT pkdetallecomp
    PRIMARY KEY (Numero,Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE HOTEL

CREATE TABLE Hotel (
	Codigo INT NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Categoria VARCHAR(100) NOT NULL,
    Tipo_Servicio VARCHAR(1000) NOT NULL,
    Calle VARCHAR(100) NOT NULL,
    Edificio VARCHAR(100) NOT NULL,
    Urbanizacion VARCHAR(100) NOT NULL,
    Gerente VARCHAR(100) NOT NULL,
    Informacion_Servicios VARCHAR(1000) NOT NULL,
    Informacion_Paquetes VARCHAR(1000) NOT NULL,
    CodigoL INT NOT NULL,
    CHECK(Categoria In ('***','****','****')),
    CONSTRAINT pkhotel
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE HABITACION

CREATE TABLE Habitacion (
	Numero INT NOT NULL,
    Tipo VARCHAR(100) NOT NULL,
    Disponible BOOL NOT NULL,
    CodigoH INT NOT NULL,
    CHECK(Tipo In ('Simple','Doble','Triple','Familiar')),
    CONSTRAINT pkhabitacion
    PRIMARY KEY (Numero,CodigoH)
) ENGINE=InnoDB;

-- CREAR TABLA DE SERVICIO

CREATE TABLE Servicio (
	Tipo VARCHAR(1000) NOT NULL,
    Descripcion VARCHAR(1000),
    Equipo_Especial VARCHAR(1000) NOT NULL,
    Tarifa INT NOT NULL,
    CONSTRAINT pkservicio
    PRIMARY KEY (Tipo)
) ENGINE=InnoDB;

-- CREAR TABLA DE CLIENTE

CREATE TABLE Cliente (
	Año_Ingreso DATE NOT NULL,
    Consecutivo INT NOT NULL,
    CI_Pasaporte INT NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Telefono_Local INT,
    Telefono_Celular INT,
    Telefono_Oficina INT,
    Fecha_Nacimiento DATE NOT NULL,
    Pais_Origen VARCHAR(100) NOT NULL,
    Direccion VARCHAR(100) NOT NULL,
    Sexo BOOl NOT NULL,
    Profesion VARCHAR(100),
    Informacion_General VARCHAR(1000),
    CodigoL INT NOT NULL,
    CodigoLu INT NOT NULL,
    CodigoH INT NOT NULL,
    CONSTRAINT pkcliente
    PRIMARY KEY (Año_Ingreso,Consecutivo)
) ENGINE=InnoDB;

-- CREAR TABLA DE RESERVA

CREATE TABLE Reserva (
	Codigo INT NOT NULL,
    Fecha_Reserva DATE NOT NULL,
    Fecha_Inicio DATE NOT NULL,
    Fecha_Final DATE NOT NULL,
    Monto_Total INT NOT NULL,
    estatus VARCHAR(100) NOT NULL,
    Año_Ingreso DATE NOT NULL,
    Consecutivo INT NOT NULL,
    CONSTRAINT pkreserva
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA PAQUETE-RESERVA
CREATE TABLE Paquete_Reserva (
	Costo INT NOT NULL,
	CodigoR INT NOT NULL,
    CodigoP INT NOT NULL,
    CodigoH INT NOT NULL,
    CONSTRAINT pkpaquetereser
    PRIMARY KEY (CodigoR,CodigP,CodigoH)
) ENGINE=InnoDB;

-- CREAR TABLA SERVICIO-RESERVA

CREATE TABLE Servicio_Reserva (
	Costo INT NOT NULL,
    Tipo VARCHAR(100) NOT NULL,
    CodigoH INT NOT NULL,
    CodigoR INT NOT NULL,
) ENGINE=InnoDB;

-- CREAR TABLA DE ACOMPAÑANTE

CREATE TABLE Acompañante (
	CI INT NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Fecha_Nacimiento DATE NOT NULL,
    Parentesco VARCHAR(100) NOT NULL,
    CONSTRAINT pkacompañante
    PRIMARY KEY (CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE COMPRA

CREATE TABLE Compra (
	Codigo INT NOT NULL,
    Tipo_Pago VARCHAR(100) NOT NULL,
    Monto_Total INT NOT NULL,
    CodigoR INT NOT NULL,
    Año_Ingreso DATE NOT NULL,
    Consecutivo INT NOT NULL,
    CONSTRAINT pkcompra
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE FACTURA LIMPIEZA

CREATE TABLE Factura_Limpieza (
	Codigo INT NOT NULL,
    Fecha_Inicio DATE NOT NULL,
    Fecha_Final DATE NOT NULL,
    Fecha_Emision DATE NOT NULL,
    Descripcion_Trabajo VARCHAR(1000) NOT NULL,
    Tipo_Pago VARCHAR(100) NOT NULL,
    Fecha_Pago DATE NOT NULL,
    CodigoH INT NOT NULL,
    RIF INT NOT NULL,
    CHECK(Tipo_Pago In ('Efectivo','Cheque','Tarjeta de Debito','Tarjeta de Credito')),
    CONSTRAINT pkfacturalimp
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE PRECIO TRABAJO

CREATE TABLE Precio_Trabajo (
	Codigo INT NOT NULL,
    Fecha_Inicio DATE NOT NULL,
    Fecha_Final DATE NOT NULL,
    Fecha_Emision DATE NOT NULL,
    Fecha_Vencimiento DATE NOT NULL,
    Tipo_Pago VARCHAR(100) NOT NULL,
    Fecha_Pago DATE NOT NULL,
    CodigoH INT NOT NULL,
    Fecha_Trabajo DATE NOT NULL,
    CONSTRAINT pkpreciotrab
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE ORDEN DE COMPRA

CREATE TABLE Orden_Compra (
	Numero INT NOT NULL,
    Fecha_Orden DATE NOT NULL,
    Cantidad INT NOT NULL,
    Fecha_Pago DATE NOT NULL,
    RIF INT NOT NULL,
    CodigoH INT NOT NULL,
    CONSTRAINT pkordencompra
    PRIMARY KEY (Numero)
) ENGINE=InnoDB;

-- CREAR TABLA COMPAÑIA

CREATE TABLE Compañia (
	RIF INT NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Calle VARCHAR(100) NOT NULL,
    Urbanizacion VARCHAR(100) NOT NULL,
    Edificio VARCHAR(100) NOT NULL,
    Telefono INT NOT NULL,
    Tipo_Compañia VARCHAR(100) NOT NULL,
    CHECK(Tipo_Compañia IN ('CL','PR')),
    CONSTRAINT pkcompañia
    PRIMARY KEY (RIF)
) ENGINE=InnoDB;

-- CREAR TABLA PRODUCTO/IMPLEMENTO

CREATE TABLE Producto_Implemento (
	Codigo INT NOT NULL,
    Cantidad_Minima INT NOT NULL,
    Cantidad_Teorica INT NOT NULL,
    Cantidad_Fisica INT NOT NULL,
    Fecha_Inventario DATE NOT NULL,
    CodigoH INT NOT NULL,
    CONSTRAINT pkproductoimpl
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA AJUSTE 

CREATE TABLE Ajuste (
	Fecha DATE NOT NULL,
    Cantidad INT NOT NULL,
    Tipo VARCHAR(100) NOT NULL,
    CodigoP INT NOT NULL,
    CONSTRAINT pkajusta
    PRIMARY KEY (Fecha)
) ENGINE=InnoDB;

-- CREAR TABLA PERSONAL

CREATE TABLE Personal (
	CI INT NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Calle VARCHAR(100) NOT NULL,
    Edificio VARCHAR(100) NOT NULL,
    Urbanizacion VARCHAR(100) NOT NULL,
    Sexo VARCHAR(100) NOT NULL,
    Fecha_Nacimiento DATE NOT NULL,
    Fecha_Inicio DATE NOT NULL,
    Cargo VARCHAR(100) NOT NULL,
    Nivel_Estudio VARCHAR(100) NOT NULL,
    CodigoH INT NOT NULL,
    CodigoL INT NOT NULL,
    CI_Supervisor INT NOT NULL,
    CHECK(Sexo In ('Maculino','Femenino')),
    CHECK(Cargo In ('Administrador','Gerente','Encargado','Supervisor','Limpieza','Piscinero')),
    CONSTRAINT pkpersonal
    PRIMARY KEY (CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE EXPERIENCIA

CREATE TABLE Experiencia (
	Compañia VARCHAR(100) NOT NULL,
    Cargo VARCHAR(100) NOT NULL,
    Fecha_Inicio DATE NOT NULL,
    Fecha_Fin DATE NOT NULL,
    CI INT NOT NULL,
    CONSTRAINT pkexperiencia
    PRIMARY KEY (Compañia,Cargo,Fecha_Inicio,Fecha_Fin,CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE HP

CREATE TABLE HP (
	CodigoP INT NOT NULL,
    CodigoH INT NOT NULL,
	CONSTRAINT pkhp
	PRIMARY KEY (CodigoP,CodigoH)
) ENGINE=InnoDB;

-- CREAR TABLA DE HOTEL SERVICIO

CREATE TABLE Hotel_Servicio (
	Costo INT NOT NULL,
    Tipo VARCHAR(1000) NOT NULL,
    CodigoH INT NOT NULL,
    Tipo_Servicio VARCHAR(100) NOT NULL,
    Capacidad INT NOT NULL,
    CI INT NOT NULL,
    CONSTRAINT pkhotelservice
    PRIMARY KEY (Tipo,Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE DETALLE FACTURA

CREATE TABLE Detalle_Factura (
	CodigoFL INT NOT NULL,
    CodigoTL INT NOT NULL,
    Costo INT NOT NULL,
    RIF INT NOT NULL,
    CONSTRAINT pkdetallefactura
    PRIMARY KEY (CodigoFl,CodigoTL,RIF)
) ENGINE=InnoDB;

-- CREAR TABLA DE HC

CREATE TABLE HC (
	CodigoC INT NOT NULL,
    Numero INT NOT NULL,
    CodigoH INT NOT NULL,
    CONSTRAINT pkhc
    PRIMARY KEY (CodigoC,Numero,CodigH)
) ENGINE=InnoDB;

-- CREAR TABLA LENGUAJE

CREATE TABLE Lenguaje (
	Idioma INT NOT NULL,
    CI INT NOT NULL,
    CONSTRAINT pklenguaje
    PRIMARY KEY (Idioma,CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE PISCINA

CREATE TABLE Piscina (
	Capacidad INT NOT NULL,
    CI INT NOT NULL,
    CONSTRAINT pkpiscina
    PRIMARY KEY (Capacidad,CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE AMONESTACION

CREATE TABLE Amonestacion (
	Numero INT NOT NULL,
    Fecha DATE NOT NULL,
    Razon VARCHAR(1000) NOT NULL,
    CI INT NOT NULL,
    CONSTRAINT pkamonestacion
    PRIMARY KEY (Numero,CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE HORARIO

CREATE TABLE Horario (
	Dia DATE NOT NULL,
    Mes DATE NOT NULL,
    Hora_Inicial TIME NOT NULL,
    Hora_Final TIME NOT NULL,
    CI INT NOT NULL,
    CONSTRAINT pkhorario
    PRIMARY KEY (Dia,CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE TRABAJO/COMPAÑIA

CREATE TABLE Trabajo_Compañia (
	CodigoTL INT NOT NULL,
    RIF INT NOT NULL,
    CONSTRAINT pktrabajocompañia
    PRIMARY KEY (CodigoTL,RIF)
) ENGINE=InnoDB;

-- CREAR TABLA DE PAQUETE

CREATE TABLE Paquete (
	Codigo INT NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Descripcion VARCHAR(1000) NOT NULL,
    CONSTRAINT pkpaquete
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE CH

CREATE TABLE CH (
	CodigoC INT NOT NULL,
    CodigoHH INT NOT NULL,
    Numero INT NOT NULL,
    CONSTRAINT pkch
    PRIMARY KEY (CodigoC,CodigoHH,Numero)
) ENGINE=InnoDB;

-- CREAR TABLA DE RA
 
 CREATE TABLE RA (
	CodigoR INT NOT NULL,
    CI INT NOT NULL,
    CONSTRAINT pkra
    PRIMARY KEY (CodigoR,CI)
 ) ENGINE=InnoDB;
 
 CREATE TABLE HR (
	CodigoR INT NOT NULL,
    Numero INT NOT NULL,
    CONSTRAINT pkhr
    PRIMARY KEY (CodigoR,Numero)
 ) ENGINE=InnoDB;
 
-- CREAR TABLA DE SERVICIO COMPRA

CREATE TABLE Servicio_Compra (
	CodigoC INT NOT NULL,
    CodigoHS INT NOT NULL,
    Tipo VARCHAR(100) NOT NULL,
    CONSTRAINT pkserviciocompra
    PRIMARY KEY (CodigoC,CodigoHS,Tipo)
) ENGINE=InnoDB;

-- CREAR TABLA DE PAQUETE COMPRA

CREATE TABLE Paquete_Compra (
	CodigoC INT NOT NULL,
    CodigoHPH INT NOT NULL,
    CodigoHPP INT NOT NULL,
    CONSTRAINT pkpaquetecompra
    PRIMARY KEY (CodigoC,CodigoHPH,CodigoHPP)
) ENGINE=InnoDB;