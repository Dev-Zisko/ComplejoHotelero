CREATE DATABASE COMPLEJO_HOTELERO;
 
 use COMPLEJO_HOTELERO;

-- CREAR TABLA DE LUGAR

CREATE TABLE Lugar_7 (
 	Codigo INT NOT NULL,
    Descripcion VARCHAR(1000),
    Tipo VARCHAR(1000) NOT NULL,
    Codigo1 INT,
    CONSTRAINT pklugar
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE PRODUCTO PISCINA

CREATE TABLE Producto_Piscina_7 (
	Codigo INT NOT NULL,
    Fecha DATE NOT NULL,
    CI VARCHAR(15) NOT NULL,
    Cantidad INT NOT NULL,
    CONSTRAINT pkproductopisc
    PRIMARY KEY (Codigo,Fecha,CI,Cantidad)
) ENGINE=InnoDB;

-- CREAR TABLA DE LIMPIEZA PISCINA

CREATE TABLE Limpieza_Piscina_7 (
	Fecha DATE NOT NULL,
    CI VARCHAR(15) NOT NULL,
    Hora TIME NOT NULL,
    CodigoS INT NOT NULL,
    CodigoHS INT NOT NULL,
    CONSTRAINT pkLimpiezapisc
    PRIMARY KEY (Fecha,CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE DETALLE DE ORDEN DE COMPRA

CREATE TABLE Detalle_Orden_Compra_7 (
	Numero INT NOT NULL,
    Codigo INT NOT NULL,
    Costo FLOAT NOT NULL,
	Cantidad INT NOT NULL,
    CONSTRAINT pkdetallecomp
    PRIMARY KEY (Numero,Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE HOTEL

CREATE TABLE Hotel_7 (
	Codigo INT NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Categoria VARCHAR(100) NOT NULL,
    Tipo_Servicio VARCHAR(1000) NOT NULL,
    Calle VARCHAR(100) NOT NULL,
    Edificio VARCHAR(100) NOT NULL,
    Urbanizacion VARCHAR(100) NOT NULL,
	CI_Gerente VARCHAR(15),
    CodigoL INT NOT NULL,
    -- CHECK(Categoria In ('***','****','*****')),
    -- CHECK(Tipo_Servicio IN ('basico', 'solo desayuno' , 'todo incluido' , 'transporte aeropuerto'));
    CONSTRAINT pkhotel
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE HABITACION

CREATE TABLE Habitacion_7 (
	Numero INT NOT NULL,
    Tipo VARCHAR(100) NOT NULL,
    Disponible BOOL NOT NULL,
    CodigoH INT NOT NULL,
    Costo float not null,
    cantidad_personas int not null,
    -- CHECK(Tipo In ('Simple','Doble','Triple','Familiar')),
    CONSTRAINT pkhabitacion
    PRIMARY KEY (Numero,CodigoH)
) ENGINE=InnoDB;

-- CREAR TABLA DE SERVICIO

CREATE TABLE Servicio_7 (
	Codigo INT NOT NULL AUTO_INCREMENT,
    Descripcion VARCHAR(1000),
    Equipo_Especial BOOL NOT NULL,
    Tarifa FLOAT NOT NULL,
    CONSTRAINT pkservicio
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE CLIENTE


CREATE TABLE Cliente_7 (
    Año_Ingreso INT NOT NULL,
    Consecutivo INT NOT NULL,
    CI_Pasaporte VARCHAR(15) NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Telefono_Local VARCHAR(15),
    Telefono_Celular VARCHAR(15),
    Telefono_Oficina VARCHAR(15),
    Fecha_Nacimiento DATE NOT NULL,
    Nacionalidad VARCHAR(100) NOT NULL,
    Sexo VARCHAR(9) NOT NULL,
    Profesion VARCHAR(100),
    Informacion_General VARCHAR(1000),
    CodigoL INT NOT NULL,
    CodigoLu INT NOT NULL,
    CodigoH INT NOT NULL,
    Calle VARCHAR(100) NOT NULL,
    Edificio VARCHAR(100) NOT NULL,
    Urbanizacion VARCHAR(100) NOT NULL,
    CONSTRAINT pkcliente
    PRIMARY KEY (Consecutivo,Año_Ingreso)
) ENGINE=InnoDB;

-- CREAR TABLA DE RESERVA

CREATE TABLE Reserva_7 (
    Codigo INT NOT NULL,
    Consecutivo INT NOT NULL,
    Fecha_Reserva DATE NOT NULL,
    Fecha_Inicio DATE NOT NULL,
    Fecha_Final DATE NOT NULL,
    Monto_Total FLOAT NOT NULL,
    estatus BOOL NOT NULL,
    Año_Ingreso INT NOT NULL,
    CONSTRAINT pkreserva
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA PAQUETE-RESERVA

CREATE TABLE Paquete_Reserva_7 (
	Costo FLOAT NOT NULL,
	CodigoR INT NOT NULL,
    CodigoP INT NOT NULL,
    CodigoH INT NOT NULL,
    CONSTRAINT pkpaquetereser
    PRIMARY KEY (CodigoR,CodigoP,CodigoH)
) ENGINE=InnoDB;

-- CREAR TABLA SERVICIO-RESERVA

CREATE TABLE Servicio_Reserva_7 (
	Costo FLOAT NOT NULL,
    CodigoS INT NOT NULL,
    CodigoH INT NOT NULL,
    CodigoR INT NOT NULL,
    CONSTRAINT pkservicioreserva
    PRIMARY KEY (CodigoS,CodigoH,CodigoR)
) ENGINE=InnoDB;

-- CREAR TABLA DE ACOMPAÑANTE

CREATE TABLE Acompañante_7 (
	CI VARCHAR(15) NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Fecha_Nacimiento DATE NOT NULL,
    Parentesco VARCHAR(100) NOT NULL,
    CONSTRAINT pkacompañante
    PRIMARY KEY (CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE COMPRA

CREATE TABLE Compra_7 (
	Codigo INT NOT NULL,
    Fecha_Compra DATE,
    Fecha_Inicio DATE NOT NULL,
    Fecha_Final DATE NOT NULL,
    Monto_Total FLOAT NOT NULL,
    CodigoR INT,
    Año_Ingreso INT NOT NULL,
    Consecutivo INT NOT NULL,
    CONSTRAINT pkcompra
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE PAGO

CREATE TABLE Pago_7(
	Monto float not null,
    Tipo_Pago Varchar(100) not null,
    Fecha_Pago DATE not null,
    CodigoC int not null,
    constraint pkpago
    primary key(CodigoC,Fecha_Pago)
) Engine=InnoDB;

-- CREAR TABLA DE FACTURA LIMPIEZA

CREATE TABLE Factura_Limpieza_7 (
	Codigo INT NOT NULL,
    Fecha_Inicio DATE NOT NULL,
    Fecha_Final DATE NOT NULL,
    Fecha_Emision DATE NOT NULL,
    CodigoH INT NOT NULL,
    RIF VARCHAR(15) NOT NULL,
    Tipo_Pago VARCHAR(100),
    Fecha_Pago DATE ,
    -- CHECK(Tipo_Pago In ('Efectivo','Cheque','Tarjeta de Debito','Tarjeta de Credito')),
    CONSTRAINT pkfacturalimp
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE PRECIO TRABAJO

-- CREATE TABLE Precio_Trabajo (
-- 	Codigo INT NOT NULL,
--  Fecha_Inicio DATE NOT NULL,
 -- Fecha_Final DATE NOT NULL,
--    Fecha_Emision DATE NOT NULL,
--    Fecha_Vencimiento DATE NOT NULL,
--    Tipo_Pago VARCHAR(100) NOT NULL,
--    Fecha_Pago DATE NOT NULL,
--    CodigoH INT NOT NULL,
--    Fecha_Trabajo DATE NOT NULL,
--    CONSTRAINT pkpreciotrab
--    PRIMARY KEY (Codigo)
-- ) ENGINE=InnoDB;

-- CREAR TABLA DE ORDEN DE COMPRA

CREATE TABLE Orden_Compra_7 (
	Numero INT NOT NULL AUTO_INCREMENT,
    Fecha_Orden DATE NOT NULL,
    Fecha_Pago DATE ,
    RIF VARCHAR(15) NOT NULL,
    CodigoH INT NOT NULL,
    CONSTRAINT pkordencompra
    PRIMARY KEY (Numero)
) ENGINE=InnoDB;

-- CREAR TABLA COMPAÑIA

CREATE TABLE Compañia_7 (
	RIF VARCHAR(15) NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    Calle VARCHAR(100) NOT NULL,
    Urbanizacion VARCHAR(100) NOT NULL,
    Edificio VARCHAR(100) NOT NULL,
    Telefono VARCHAR(15) NOT NULL,
    Tipo_Compañia VARCHAR(100) NOT NULL,
    CodigoL INT NOT NULL,
    CONSTRAINT pkcompañia
    PRIMARY KEY (RIF)
) ENGINE=InnoDB;

-- CREAR TABLA PRODUCTO/IMPLEMENTO

CREATE TABLE Producto_Implemento_7 (
	Codigo INT NOT NULL,
    Nombre VARCHAR(1000) NOT NULL,
    Cantidad_Minima INT NOT NULL,
    Cantidad_Teorica INT NOT NULL,
    Cantidad_Fisica INT NOT NULL,
    Fecha_Inventario DATE,
    CodigoH INT NOT NULL,
    CONSTRAINT pkproductoimpl
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA AJUSTE 

CREATE TABLE Ajuste_7 (
	Fecha DATE NOT NULL,
    Cantidad INT NOT NULL,
    Tipo VARCHAR(100) NOT NULL,
    CodigoP INT NOT NULL,
    CONSTRAINT pkajusta
    PRIMARY KEY (Fecha,CodigoP)
) ENGINE=InnoDB;

-- CREAR TABLA PERSONAL

CREATE TABLE Personal_7 (
	CI VARCHAR(15), -- Not NULL LUEGO
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Calle VARCHAR(100) NOT NULL,
    Edificio VARCHAR(100) NOT NULL,
    Urbanizacion VARCHAR(100) NOT NULL,
    Sexo VARCHAR(9) NOT NULL,
    Fecha_Nacimiento DATE NOT NULL,
    Fecha_Inicio DATE NOT NULL,
    Cargo VARCHAR(100) NOT NULL,
    Nivel_Estudio VARCHAR(100),
    CodigoH INT NOT NULL,
    CodigoL INT NOT NULL,
    Despedido BOOL NOT NULL,
    CI_Supervisor VARCHAR(15),
    -- CHECK(Sexo In ('Maculino','Femenino')),
    -- CHECK(Cargo In ('Administrador','Gerente','Encargado','Supervisor','Limpieza','Piscinero')),
    CONSTRAINT pkpersonal
    PRIMARY KEY (CI)
) ENGINE=InnoDB;

ALTER TABLE Personal_7 alter CI set default 'null';

-- CREAR TABLA DE EXPERIENCIA

CREATE TABLE Experiencia_7 (
	Compañia VARCHAR(100) NOT NULL,
    Cargo VARCHAR(100) NOT NULL,
    Fecha_Inicio DATE NOT NULL,
    Fecha_Fin DATE NOT NULL,
    CI VARCHAR(15) NOT NULL,
    CONSTRAINT pkexperiencia
    PRIMARY KEY (Compañia,Cargo,Fecha_Inicio,Fecha_Fin,CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE HP

CREATE TABLE HP_7 (
	CodigoP INT NOT NULL,
    CodigoH INT NOT NULL,
    Costo float not null,
    Cupos int not null,
	CONSTRAINT pkhp
	PRIMARY KEY (CodigoP,CodigoH)
) ENGINE=InnoDB;

-- CREAR TABLA DE HOTEL SERVICIO

CREATE TABLE Hotel_Servicio_7 (
	Costo FLOAT NOT NULL,
    CodigoH INT NOT NULL,
    CodigoS INT NOT NULL,
    TipoServicio VARCHAR(1000),
    Capacidad INT NOT NULL,
    CI VARCHAR(15) NOT NULL,
    CONSTRAINT pkhotelservice
    PRIMARY KEY (CodigoS,CodigoH)
) ENGINE=InnoDB;

-- CREAR TABLA DE DETALLE FACTURA

CREATE TABLE Detalle_Factura_7 (
	CodigoFL INT NOT NULL,
    CodigoTL INT NOT NULL,
    Costo FLOAT NOT NULL,
    CONSTRAINT pkdetallefactura
    PRIMARY KEY (CodigoFl,CodigoTL)
) ENGINE=InnoDB;

-- CREAR TABLA DE HC

CREATE TABLE HC_7 (
	Numero INT NOT NULL,
    CodigoC INT NOT NULL,
    CodigoH INT NOT NULL,
    CONSTRAINT pkhc
    PRIMARY KEY (Numero,CodigoC,CodigoH)
) ENGINE=InnoDB;

-- CREAR TABLA LENGUAJE

CREATE TABLE Lenguaje_7 (
	Idioma VARCHAR(100) NOT NULL,
    CI VARCHAR(15) NOT NULL,
    CONSTRAINT pklenguaje
    PRIMARY KEY (Idioma,CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE COMODIDAD

CREATE TABLE Comodidad_7 (
	Codigo INT NOT NULL,
    Nombre VARCHAR(100) NOT NULL,
    CONSTRAINT pkcomodidad
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE AMONESTACION

CREATE TABLE Amonestacion_7 (
	Numero INT NOT NULL AUTO_INCREMENT,
    Fecha DATE NOT NULL,
    Razon VARCHAR(1000) NOT NULL,
    CI VARCHAR(15) NOT NULL,
    CONSTRAINT pkamonestacion
    PRIMARY KEY (Numero,CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE HORARIO

CREATE TABLE Horario_7 (
	Dia_Semana VarChar(10) NOT NULL,
    Hora TIME NOT NULL,
    CI VARCHAR(15) NOT NULL,
    CONSTRAINT pkhorario
    PRIMARY KEY (Dia_Semana,CI)
) ENGINE=InnoDB;

-- CREAR TABLA DE TRABAJO/COMPAÑIA

CREATE TABLE Trabajo_Compañia_7 (
	CodigoTL INT NOT NULL,
    RIF VARCHAR(15) NOT NULL,
    Costo float NOT NULL,
    CONSTRAINT pktrabajocompañia
    PRIMARY KEY (CodigoTL,RIF)
) ENGINE=InnoDB;

-- CREAR TABLA DE PAQUETE

CREATE TABLE Paquete_7 (
	Codigo INT NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Descripcion VARCHAR(1000) NOT NULL,
    CONSTRAINT pkpaquete
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

-- CREAR TABLA DE CH

CREATE TABLE CH_7 (
	Numero INT NOT NULL,
    CodigoC INT NOT NULL,
    CodigoHH INT NOT NULL,
    Costo float not null,
    CodigoR INT,
    CONSTRAINT pkch
    PRIMARY KEY (Numero,CodigoC,CodigoHH)
) ENGINE=InnoDB;

-- CREAR TABLA DE RA
 
 CREATE TABLE RA_7 (
	CodigoR INT NOT NULL,
    CI VARCHAR(15) NOT NULL,
    CONSTRAINT pkra
    PRIMARY KEY (CodigoR,CI)
 ) ENGINE=InnoDB;
 
 CREATE TABLE HR_7 (
	Numero INT NOT NULL,
    CodigoR INT NOT NULL,
    CodigoH INT NOT NULL,
    Costo float not null,
    CONSTRAINT pkhr
    PRIMARY KEY (Numero,CodigoR)
 ) ENGINE=InnoDB;
 
-- CREAR TABLA DE SERVICIO COMPRA

CREATE TABLE Servicio_Compra_7 (
	CodigoC INT NOT NULL,
    CodigoHS INT NOT NULL,
    CodigoS INT NOT NULL,
    Costo float not null,
    CodigoR INT,
    CONSTRAINT pkserviciocompra
    PRIMARY KEY (CodigoC,CodigoHS,CodigoS)
) ENGINE=InnoDB;

-- CREAR TABLA DE PAQUETE COMPRA

CREATE TABLE Paquete_Compra_7 (
	CodigoC INT NOT NULL,
    CodigoHPH INT NOT NULL,
    CodigoHPP INT NOT NULL,
    Costo float not null,
    CodigoR INT,
    CONSTRAINT pkpaquetecompra
    PRIMARY KEY (CodigoC,CodigoHPH,CodigoHPP)
) ENGINE=InnoDB;

-- CREAR TABLA DE TRABAJO LIMPIEZA

CREATE TABLE Trabajo_Limpieza_7 (
	Codigo INT NOT NULL,
    Descripcion VARCHAR(1000) NOT NULL,
    CONSTRAINT pktrabajolimpieza
    PRIMARY KEY (Codigo)
) ENGINE=InnoDB;

 CREATE TABLE CA_7 (
	CodigoC INT NOT NULL,
    CI VARCHAR(15) NOT NULL,
    CONSTRAINT pkra
    PRIMARY KEY (CodigoC,CI)
 ) ENGINE=InnoDB;
 
 CREATE TABLE PP_7 (
	CodigoP INT NOT NULL,
    RIF VARCHAR(15) NOT NULL,
    CONSTRAINT pkpp
    primary key (CodigoP,RIF)
) engine=InnoDB;