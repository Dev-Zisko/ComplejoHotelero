
-- Clave foranea Lugar
ALTER TABLE Lugar_7
add constraint fkLugar_Lugar
foreign key (Codigo1)
references Lugar_7(Codigo);

-- Clave foranea Producto Piscina
alter table Producto_Piscina_7
add constraint fkProducto
foreign key (Codigo)
references Producto_Implemento_7(Codigo);

alter table Producto_Piscina_7
add constraint fkLimpiezaPisc
foreign key (Fecha,CI)
references Limpieza_Piscina_7(Fecha,CI);



-- Clave foranea Limpieza Piscina
alter table Limpieza_Piscina_7
add constraint fkLimpiezaPiscina_Piscinero
foreign key (CI)
references Personal_7(CI);

alter table Limpieza_Piscina_7
add constraint fkLimpiezaPiscina_HotelServicio
foreign key (CodigoS,CodigoHS)
references Hotel_Servicio_7(CodigoS,CodigoH);

-- Clave foranea Detalle Orden compra
alter table Detalle_Orden_Compra_7
add constraint fkDetalleOrdenCompra_OrdenCompra
foreign key (Numero)
references Orden_Compra_7(Numero);

alter table Detalle_Orden_Compra_7
add constraint fkDetalleOrdenCompra_Producto
foreign key (Codigo)
references Producto_Implemento_7(Codigo);

-- Clave foranea Hotel
alter table Hotel_7
add constraint fkHotel_Lugar
foreign key (CodigoL)
references Lugar_7(Codigo);

alter table Hotel_7
add constraint fkHotel_Gerente
foreign key (CI_Gerente)
references Personal_7(CI);



-- Clave foranea Habitacion
alter table Habitacion_7
add constraint fkHabitacion_Hotel
foreign key (CodigoH)
references Hotel_7(Codigo);

-- Clave foranea Cliente
alter table Cliente_7
add constraint fkCliente_Lugar_Dir
foreign key (CodigoL)
references Lugar_7(Codigo);

alter table Cliente_7
add constraint fkCliente_Lugar_Nac
foreign key (CodigoLu)
references Lugar_7(Codigo);

alter table Cliente_7
add constraint fkCliente_Hotel
foreign key (CodigoH)
references Hotel_7(Codigo);

-- Clave foranea Reserva
alter table Reserva_7
add constraint fkReserva_Cliente
foreign key (Consecutivo,Año_Ingreso)
references Cliente_7(Consecutivo,Año_Ingreso);

-- Clave foranea Paquete/Reserva
alter table Paquete_Reserva_7
add constraint fkPaqueteReserva_Reserva
foreign key (CodigoR)
references Reserva_7(Codigo);

alter table Paquete_Reserva_7
add constraint fkPaqueteReserva_HP
foreign key (CodigoP,CodigoH)
references HP_7(CodigoP,CodigoH);

-- Clave foranea Servicio Reserva
alter table Servicio_Reserva_7
add constraint fkServicioReserva_HotelServicio
foreign key (CodigoS,CodigoH)
references Hotel_Servicio_7(CodigoS,CodigoH);

alter table Servicio_Reserva_7
add constraint fkServicioReserva_Reserva
foreign key(CodigoR)
references Reserva_7(Codigo);

-- Clave foranea Compra
alter table Compra_7
add constraint fkCompra_Reserva
foreign key (CodigoR)
references Reserva_7(Codigo);

alter table Compra_7
add constraint fkCompra_Cliente
foreign key (Consecutivo,Año_Ingreso)
references Cliente_7(Consecutivo,Año_Ingreso);

-- Clave Foranea Pago:
alter table Pago_7
add constraint fkPago_Compra
foreign key(CodigoC)
references Compra_7(Codigo);

-- Clave foranea Factura Limpieza
alter table Factura_Limpieza_7
add constraint fkFacturaLimpieza_Hotel
foreign key (CodigoH)
references Hotel_7(Codigo);

alter table Factura_Limpieza_7
add constraint fkFacturaLimpieza_Compañia
foreign key (RIF)
references Compañia_7(RIF);

-- clave foranea Orden de Compra
alter table Orden_Compra_7
add constraint fkOrdenCompra_Proveedor
foreign key (RIF)
references Compañia_7(RIF);

alter table Orden_Compra_7
add constraint fkOrdenCompra_Hotel
foreign key (CodigoH)
references Hotel_7(Codigo);

-- Clave foranea Compañia
alter table Compañia_7
add constraint fkCompañia_Lugar
foreign key(CodigoL)
references Lugar_7(Codigo);

-- clave foranea Producto/Implemento
alter table Producto_Implemento_7
add constraint fkProducto_Hotel
foreign key (CodigoH)
references Hotel_7(Codigo);

-- Clave foranea Ajuste
alter table Ajuste_7
add constraint fkAjuste_Producto
foreign key (CodigoP)
references Producto_Implemento_7(Codigo);

-- Clave foranea Personal
alter table Personal_7
add constraint fkPersonal_Hotel
foreign key(CodigoH)
references Hotel_7(Codigo);

-- alter table Personal
-- add constraint fkGerente_Hotel
-- foreign key (CodigoG)
-- references Hotel(Codigo);

alter table Personal_7
add constraint fkPersonal_Lugar
foreign key (CodigoL)
references Lugar_7(Codigo);

alter table Personal_7
add constraint fkPersonal_Supervisor
foreign key (CI_Supervisor)
references Personal_7(CI);

-- Clave foranea Experiencia
alter Table Experiencia_7
add constraint fkExperiencia_Gerente
foreign key (CI)
references Personal_7(CI);

-- Clave foranea HP
alter table HP_7
add constraint fkHP_Paquete
foreign key(CodigoP)
references Paquete_7(Codigo);

alter table HP_7
add constraint fkHP_Hotel
foreign key (CodigoH)
references Hotel_7(Codigo);

-- Clave foranea Hotel Servicio
alter table Hotel_Servicio_7
add constraint fkHotelServicio_Hotel
foreign key (CodigoH)
references Hotel_7(Codigo);

alter table Hotel_Servicio_7
add constraint fkHotelServicio_Servicio
foreign key(CodigoS)
references Servicio_7(Codigo);

alter table Hotel_Servicio_7
add constraint fkHotelServicio_encargado
foreign key (CI)
references Personal_7(CI);

-- Clave foranea Detalle Factura
alter table Detalle_Factura_7
add constraint fkDetalleFactura_FacturaLimpieza
foreign key (CodigoFL) 
references Factura_Limpieza_7(Codigo);

alter table Detalle_Factura_7
add constraint fkDetalleFactura_TrabajoLimpieza
foreign key (CodigoTL) 
references Trabajo_Limpieza_7(Codigo); 

-- Clave foranea HC 
alter table HC_7
add constraint fkHC_Comodidad
foreign key (CodigoC)
references Comodidad_7(Codigo);

alter table HC_7
add constraint fkHC_Habitacion
foreign key (CodigoH,Numero)
references Habitacion_7(CodigoH,Numero);

-- Clave foranea Lenguaje
alter table Lenguaje_7
add constraint fkLenguaje_Encargado
foreign key (CI)
references Personal_7(CI);

-- Clave foranea Amonestacion
alter table Amonestacion_7
add constraint fkAmonestacion_Piscinero
foreign key (CI)
references Personal_7(CI);

-- Clave Foranea Horario
alter table Horario_7
add constraint fkHorario_Personal
foreign key (CI)
references Personal_7(CI);

-- Clave foranea Trabajo/Compañia
alter table Trabajo_Compañia_7
add constraint fkTrabajoCompañia_TrabajoLimpieza
foreign key (CodigoTL)
references Trabajo_Limpieza_7(Codigo);

alter table Trabajo_Compañia_7
add constraint fkTrabajoCompañia_CompañiaLimpieza
foreign key (RIF)
references Compañia_7(RIF);

-- Clave foranea CH
alter table CH_7
add constraint fkCH_Compra
foreign key (CodigoC)
references Compra_7(Codigo);

alter table CH_7
add constraint fkCH_Habitacion
foreign key (Numero,CodigoHH)
references Habitacion_7(Numero,CodigoH);

-- Clave foranea RA
alter table RA_7
add constraint fkRA_Reserva
foreign key (CodigoR)
references Reserva_7(Codigo);

alter table RA_7
add constraint fkRA_Acompañante
foreign key (CI)
references Acompañante_7(CI);

-- Clave foranea CA
alter table CA_7
add constraint fkCA_Acompañante
foreign key (CI)
references Acompañante_7(CI);

alter table CA_7
add constraint fkCA_Compra
foreign key(CodigoC)
references Compra_7(Codigo);

-- Clave foranea HR
alter table HR_7
add constraint fkHR_Reserva
foreign key(CodigoR)
references Reserva_7(Codigo);

alter table HR_7
add constraint fkHR_Habitacion
foreign key (Numero,CodigoH)
references Habitacion_7(Numero,CodigoH); 

-- Clave foranea Servicio Compra
alter table Servicio_Compra_7
add constraint fkServicioCompra_Compra
foreign key (codigoC)
references Compra_7(Codigo);

alter table Servicio_Compra_7
add constraint fkServicioCompra_HS
foreign key (CodigoS,CodigoHS)
references Hotel_Servicio_7(CodigoS,codigoH);

-- clave foranea Paquete Compra
alter Table Paquete_Compra_7
add constraint fkPaqueteCompra_Compra
foreign key (CodigoC)
references Compra_7(Codigo);

alter table Paquete_Compra_7
add constraint fkPaqueteCompra_HP
foreign key (CodigoHPH,CodigoHPP)
references HP_7(CodigoH,CodigoP);

-- Clave Foranea Producto Proveedor
Alter table PP_7
add constraint fkPP_Producto
foreign key (CodigoP)
references Producto_Implemento_7(Codigo);

Alter table PP_7
add constraint fkPP_Proveedor
foreign key (RIF)
references Compañia_7(RIF);