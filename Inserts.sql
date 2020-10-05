-- INSERT DE LUGAR

INSERT INTO lugar_7 VALUES (1,'Venezuela','País',NULL);

INSERT INTO lugar_7 VALUES (2,'Miranda','Estado',1);

INSERT INTO lugar_7 VALUES (3,'Lara','Estado',1);

INSERT INTO lugar_7 VALUES (4,'Nueva Esparta','Estado',1);

INSERT INTO lugar_7 VALUES (5,'Anzoategui','Estado',1);

INSERT INTO lugar_7 VALUES (6,'Mérida','Estado',1);

INSERT INTO lugar_7 VALUES (7,'Higuerote','Ciudad',2);

INSERT INTO lugar_7 VALUES (8,'Barquisimeto','Ciudad',3);

INSERT INTO lugar_7 VALUES (9,'Margarita','Ciudad',4);

INSERT INTO lugar_7 VALUES (10,'Puerto La Cruz','Ciudad',5);

INSERT INTO lugar_7 VALUES (11,'Mérida','Ciudad',6);

-- INSERT DE HOTEL

INSERT INTO hotel_7 VALUES (1,'Sun and Beach','****','Básico, Sólo Desayuno','Calle 8','Edificio Tropical','El Verano',NULL,7);

INSERT INTO hotel_7 VALUES (2,'The Tropical Sun','*****','Básico, Sólo Desayuno, Todo Incluido','Calle 44','Edificio El Coco','La Arena',NULL,9);

INSERT INTO hotel_7 VALUES (3,'El Playon','***','Básico','Calle 76','Edificio La Roca','Mochima',NULL,10);

INSERT INTO hotel_7 VALUES (4,'La Pastora','****','Básico, Sólo Desayuno','Calle 35','Edificio Moricha','El Guaro',NULL,8);

INSERT INTO hotel_7 VALUES (5,'El Frío','****','Básico, Sólo Desayuno, Todo Incluido','Calle 56','Edificio El Gocho','El Chinchorro',NULL,11);

-- Habitacion

INSERT INTO habitacion_7 VALUES (01,'Simple',TRUE,1,100000,1); 

INSERT INTO habitacion_7 VALUES (02,'Doble',TRUE,1,140000,2);

INSERT INTO habitacion_7 VALUES (03,'Familiar',FALSE,1,180000,5);

INSERT INTO habitacion_7 VALUES (01,'Simple',TRUE,2,110000,1);

INSERT INTO habitacion_7 VALUES (02,'Familiar',TRUE,2,190000,3);

INSERT INTO habitacion_7 VALUES (03,'Doble',TRUE,2,130000,2);

INSERT INTO habitacion_7 VALUES (01,'Simple',FALSE,3,100000,1);

INSERT INTO habitacion_7 VALUES (02,'Simple',FALSE,3,100000,1);

INSERT INTO habitacion_7 VALUES (03,'Simple',TRUE,3,100000,1);

INSERT INTO habitacion_7 VALUES (01,'Simple',FALSE,4,101000,1);

INSERT INTO habitacion_7 VALUES (02,'Doble',FALSE,4,115000,2);

INSERT INTO habitacion_7 VALUES (03,'Doble',FALSE,4,115000,2);

INSERT INTO habitacion_7 VALUES (01,'Familiar',TRUE,5,170000,4);

INSERT INTO habitacion_7 VALUES (02,'Familiar',FALSE,5,180000,5);

INSERT INTO habitacion_7 VALUES (03,'Doble',TRUE,5,165000,3);

-- INSERTS CLIENTE

INSERT INTO cliente_7 VALUES (2010,1,'20765923','Tomas','López','0212-5341232','0416-8675534','0212-7776589','1993/08/07','Venezolano','M','Ingeniero Civil','',7,1,1,'Calle 13','Edificio La Nube','La Playa');

INSERT INTO cliente_7 VALUES (2013,1,'22785628','Lucía','Pérez','0212-7025292','0426-9377510','0212-7906386','1995/04/12','Venezolano','F','Comunicadora Social','',9,1,1,'Calle 88','Edificio El Mar','El Pilar');

INSERT INTO cliente_7 VALUES (2010,2,'23827031','Daniela','Gómez','0212-9351286','0424-4285798','','1994/11/24','Colombiano','M','Ingeniero Electrónico','',8,1,4,'Calle 100','Edificio La Rosa','El Algodón');

INSERT INTO cliente_7 VALUES (2012,1,'6563234','Oscar','Zambrano','0212-5231566','0426-8247594','0212-8765439','1963/06/25','Venezolano','M','Ingeniero Civil','',10,1,4,'Calle 17','Edificio El Caballito','El Rompeolas');

INSERT INTO cliente_7 VALUES (2009,1,'15653324','Ricardo','Yañez','0212-7834942','0416-9087654','0212-4368395','1987/10/07','Español','M','Letras','',11,1,3,'Calle 29','Edificio El Caño','La Pereza');

INSERT INTO cliente_7 VALUES (2015,1,'21123456','Andrea','Parra','0212-9428350','0414-2345789','','1993/12/29','Venezolano','F','Ingeniero Telecomunicaciones','',8,1,3,'Calle 56','Edificio El Palito','La Tortuga');

INSERT INTO cliente_7 VALUES (2010,3,'20888988','Carlos','Iribarren','0212-7556065','0412-8634614','','1992/10/30','Venezolano','M','Ingeniero Civil','',7,1,2,'Calle 76','Edificio La Fortaleza','La Claridad');

INSERT INTO cliente_7 VALUES (2016,1,'19673432','Juan','Di Giacomo','0212-1988656','0416-1256789','0212-3459709','1989/08/09','Italiano','M','Ingeniero Informático','',9,1,2,'Calle 13','Edificio La Nube','La Playa');

INSERT INTO cliente_7 VALUES (2010,4,'8765098','Elsa','Campestre','0212-1234567','0426-1567380','0212-3450967','1968/05/17','Italiano','F','Educación','',8,1,5,'Calle 1','Edificio La Estrella','Las Frutas');

INSERT INTO cliente_7 VALUES (2014,1,'10345875','Gabriela','Placencia','0212-8901234','042-7584925','','1970/01/07','Venezolano','F','Ingeniero Civil','',11,1,5,'Calle 3','Edificio La Valla','La Tormenta');

-- INSERTS DE RESERVA

INSERT INTO reserva_7 VALUES (1,1,'2017/05/15','2017/08/09','2017/08/17',456876.50,TRUE,2010);

INSERT INTO reserva_7 VALUES (2,1, '2017/04/19', '2017/08/19', '2017/08/28',461676.75,TRUE, 2013);

INSERT INTO reserva_7 VALUES (3,2, '2017/06/20', '2017/09/15', '2017/09/30',596866.50,TRUE, 2010);

INSERT INTO reserva_7 VALUES (4,1, '2017/03/20', '2017/08/09', '2017/08/17',456876.50,FALSE, 2012);

INSERT INTO reserva_7 VALUES (5,1, '2017/06/01', '2017/08/20', '2017/09/05',675313.50,FALSE, 2009);

-- INSERTS DE ACOMPAÑANTE

INSERT INTO acompañante_7 VALUES ('23849238','Camilo','Rodríguez', '1996/06/14','Primo');

INSERT INTO acompañante_7 VALUES ('20145986','María','Esposito', '1993/11/27','Hermana');

INSERT INTO acompañante_7 VALUES ('9456865','Roberto','Fernández', '1967/02/01','Padre');

INSERT INTO acompañante_7 VALUES ('15098345','Iñaqui','Tovar', '1986/04/09','Amigo');

INSERT INTO acompañante_7 VALUES ('18479145','Fernanda','Barone', '1989/08/30','Sobrino');

-- INSERTS DE COMPRA

INSERT INTO compra_7 VALUES (01,'2017/06/16','2017/08/09','2017/08/17',456876.50,1, 2010,1); 

INSERT INTO compra_7 VALUES (02,NULL,'2017/08/19','2017/08/28',461676.75,2, 2013,1);

INSERT INTO compra_7 VALUES (03,NULL,'2017/08/01','2017/08/16',596866.50,NULL, 2010,2);

INSERT INTO compra_7 VALUES (04,NULL,'2017/07/29','2017/08/12',456876.50,NULL, 2012,1);

INSERT INTO compra_7 VALUES (05,NULL,'2017/08/20','2017/09/05',675313.50,5, 2009,1);

-- INSERTS DE PAGO

INSERT INTO pago_7 VALUES (100000,'Cheque','2017/05/01',01);

INSERT INTO pago_7 VALUES (100000,'Efectivo','2017/05/05',01);

INSERT INTO pago_7 VALUES (100000,'Tarjeta de Crédito','2017/05/10',01);

INSERT INTO pago_7 VALUES (100000,'Tarjeta de Débito','2017/05/15',01);

INSERT INTO pago_7 VALUES (56876.50,'Cheque','2017/06/16',01);

-- INSERTS DE COMPAÑIA

INSERT INTO compañia_7 VALUES ('J-54326860-9','Clean C.A.','Calle 123','El Color','Edificio Cristal','0212-8753208','Limpieza',7);

INSERT INTO compañia_7 VALUES ('J-84372893-8','El Brillo C.A.','Calle 897','El Brillo','Edificio Carbon','0212-8123575','Proveedor',8);

INSERT INTO compañia_7 VALUES ('J-12399405-3','Pulitura C.A.','Calle 114','El Eslabón','Edificio Polo','0212-8326646','Proveedor',9);

INSERT INTO compañia_7 VALUES ('J-54356960-9','Easy White C.A.','Calle 65','El Cañon','Edificio El Barco','0212-2352245','Proveedor',10);

INSERT INTO compañia_7 VALUES ('J-59818914-4','LavaTodo C.A.','Calle 644','El León','Edificio Las Palmas','0212-2563156','Limpieza',11);

-- INSERTS DE FACTURA_LIMPIEZA

INSERT INTO factura_limpieza_7 VALUES (1, '2017/05/15', '2017/05/30', '2017/05/10',1,'J-54326860-9',null,null);

INSERT INTO factura_limpieza_7 VALUES (2, '2017/06/01', '2017/06/20', '2017/05/25',1,'J-54326860-9','Cheque','2017/06/02');

INSERT INTO factura_limpieza_7 VALUES (3, '2017/06/01', '2017/06/20', '2017/05/25',1,'J-54326860-9','Tarjeta de Crédito','2017/06/15');

INSERT INTO factura_limpieza_7 VALUES (4, '2017/04/20', '2017/05/20', '2017/04/10',5,'J-59818914-4','Tarjeta de Debito','2017/05/19');

INSERT INTO factura_limpieza_7 VALUES (5, '2017/07/01', '2017/07/30', '2017/06/25',5,'J-59818914-4','Efectivo','2017/07/15');

-- INSERTS DE PRODUCTO_IMPLEMENTO

INSERT INTO producto_implemento_7 VALUES (1,'Matapiojitos',150,200,203, '2017/04/03',4);

INSERT INTO producto_implemento_7 VALUES (6,'Escoba',120,210,213, '2017/04/03',4);

INSERT INTO producto_implemento_7 VALUES (7,'Cloro 1 LT',130,190,186, '2017/04/03',4);

INSERT INTO producto_implemento_7 VALUES (16,'Desinfectante',120,150,0,NULL,4);

INSERT INTO producto_implemento_7 VALUES (2,'Red',100,300,353, '2017/04/15',2);

INSERT INTO producto_implemento_7 VALUES (8,'Cloro 1 LT',120,210,203, '2017/04/15',2);

INSERT INTO producto_implemento_7 VALUES (9,'Matapiojitos',130,200,153, '2017/04/15',2);

INSERT INTO producto_implemento_7 VALUES (17,'Esponjas',100,120,0, NULL,2);

INSERT INTO producto_implemento_7 VALUES (3,'Coleto',200,450,400, '2017/03/10',3);

INSERT INTO producto_implemento_7 VALUES (10,'Matapiojitos',100,250,200, '2017/03/10',3);

INSERT INTO producto_implemento_7 VALUES (11,'Cloro 1 LT',150,250,200, '2017/03/10',3);

INSERT INTO producto_implemento_7 VALUES (18,'Limpia Baldosas',110,130,0, NULL,3);

INSERT INTO producto_implemento_7 VALUES (4,'Matapiojitos',250,270,268, '2017/01/30',5);

INSERT INTO producto_implemento_7 VALUES (12,'Cloro 1 LT',200,280,278, '2017/01/30',5);

INSERT INTO producto_implemento_7 VALUES (13,'Esponjas',150,200,198, '2017/01/30',5);

INSERT INTO producto_implemento_7 VALUES (5,'Cloro 1 LT',170,290,253, '2017/05/13',1);

INSERT INTO producto_implemento_7 VALUES (14,'Jabón',180,200,190, '2017/05/13',1);

INSERT INTO producto_implemento_7 VALUES (15,'Matapiojitos',150,200,163, '2017/05/13',1);

-- INSERTS DE ORDEN_COMPRA

INSERT INTO orden_compra_7 VALUES (1, '2017/02/26', null,'J-84372893-8',1);

INSERT INTO orden_compra_7 VALUES (2, '2017/04/01', null,'J-12399405-3',2);

INSERT INTO orden_compra_7 VALUES (3, '2017/01/15', null,'J-12399405-3',3);

INSERT INTO orden_compra_7 VALUES (4, '2017/03/26', '2017/03/29','J-54356960-9',4);

INSERT INTO orden_compra_7 VALUES (5, '2017/06/13', '2017/06/18','J-54356960-9',5);

-- INSERTS DE DETALLE_ORDEN_COMPRA

INSERT INTO detalle_orden_compra_7 VALUES (1,1,700000.00,40);

INSERT INTO detalle_orden_compra_7 VALUES (2,3,550000.00,50);

INSERT INTO detalle_orden_compra_7 VALUES (3,5,860000.00,48);

INSERT INTO detalle_orden_compra_7 VALUES (4,2,970000.00,35);

INSERT INTO detalle_orden_compra_7 VALUES (5,4,900000.00,20);

-- INSERTS DE AJUSTE

INSERT INTO ajuste_7 VALUES ( '2017/02/27',390,'Faltante',3);

INSERT INTO ajuste_7 VALUES ( '2017/04/22',360,'Sobrante',2);

INSERT INTO ajuste_7 VALUES ( '2017/07/10',200,'Faltante',5);

INSERT INTO ajuste_7 VALUES ( '2017/04/05',250,'Sobrante',1);

INSERT INTO ajuste_7 VALUES ( '2017/02/15',250,'Faltante',4);

-- INSERTS DE PERSONAL

INSERT INTO personal_7 VALUES ('16434566','Daniel','Pérez','Calle 32','Edificio La Tormenta','Los Caracoles','M', '1979/10/09', '2005/05/01','Supervisor',NULL,3,10,false,NULL);

INSERT INTO personal_7 VALUES ('19826123','Camila','González','Calle 54','Edificio El Sol','Los Diamantes','F', '1980/11/19', '2010/07/20','Administradora','Universitarios',3,10,false,'16434566');

INSERT INTO personal_7 VALUES ('19125865','Guillermo','Jones','Calle 512','Edificio La Luna ','Terrazas De Montaña','M', '1980/01/12', '2010/07/20','Gerente',NULL,3,10,false,'16434566');

INSERT INTO personal_7 VALUES ('21372961','Pablo','Brito','Calle 12','Edificio EL Tronco','El Camino','M', '1991/08/22', '2016/02/05','Piscinero',NULL,3,10,false,'16434566');

INSERT INTO personal_7 VALUES ('17125469','Ernesto','Silva','Calle 315','Edificio Royal','La Rinconada','M', '1980/12/31', '2009/06/04','Supervisor',NULL,4,8,false,NULL);

INSERT INTO personal_7 VALUES ('20132135','Luis','De Freitas','Calle 124','Edificio Palace','La Mina','M', '1979/12/01', '2007/08/15','Gerente',NULL,4,8,false,'17125469');

INSERT INTO personal_7 VALUES ('20432853','Simón','Mijares','Calle 345','Edificio EL Pino','El Mármol','M', '1990/11/10', '2016/01/09','Piscinero',NULL,4,8,false,'17125469');

INSERT INTO personal_7 VALUES ('16843234','Julia','Juarez','Calle 313','Edificio Milagro','La Rinconada','F', '1980/12/31', '2008/09/09','Supervisor',NULL,2,9,false,NULL);

INSERT INTO personal_7 VALUES ('14547542','Alberto','Colmenares','Calle 13','Edificio Castillo','La Isla','M', '1975/10/01', '2006/10/11','Gerente',NULL,2,9,false,'16843234');

INSERT INTO personal_7 VALUES ('12323752','María','Estrada','Calle 32','Edificio Medieval','El Río','F', '1976/11/20', '2010/10/08','Encargado',NULL,2,9,false,'16843234');

INSERT INTO personal_7 VALUES ('21348510','Jhonathan','Henderson','Calle 38','Edificio Grano','La Montaña','M', '1990/04/19', '2015/06/18','Supervisor',NULL,1,7,false,NULL);

INSERT INTO personal_7 VALUES ('20896348','Miguel','García','Calle 173','Edificio La Brisa','El Jardín','M', '1990/01/06', '2016/10/11','Gerente',NULL,1,7,false,'21348510');

INSERT INTO personal_7 VALUES ('22324963','Ramiro','Ramírez','Calle 5','Edificio EL Trono','El Reino','M', '1992/04/12', '2016/06/15','Piscinero',NULL,1,7,false,'21348510');

INSERT INTO personal_7 VALUES ('19245543','Elena','Flores','Calle 8','Edificio Palo Verde','La Sombrilla','F', '1988/02/18', '2015/05/13','Supervisor',NULL,5,11,false,NULL);

INSERT INTO personal_7 VALUES ('21926820','Roberto','Fariñez','Calle 19','Edificio Las Risas','El Poder','M', '1990/07/26', '2016/03/11','Gerente',NULL,5,11,false,'19245543');

INSERT INTO personal_7 VALUES ('20309363','Lucas','Villegas','Calle 32','Edificio Tower','El Resplandor','M', '1990/08/19', '2016/09/08','Supervisor de Limpieza',NULL,5,11,false,'19245543');

UPDATE Hotel_7 set CI_Gerente = '19125865' WHERE (Codigo = 3);

UPDATE Hotel_7 set CI_Gerente = '20132135' WHERE (Codigo = 4);

UPDATE Hotel_7 set CI_Gerente = '14547542' WHERE (Codigo = 2);

UPDATE Hotel_7 set CI_Gerente = '20896348' WHERE (Codigo = 1);

UPDATE Hotel_7 set CI_Gerente = '21926820' WHERE (Codigo = 5);

-- INSERTS DE EXPERIENCIA

INSERT INTO experiencia_7 VALUES ('Hotel Elegant','Sub-Gerente', '2008/08/12', '2010/04/15','19125865');

INSERT INTO experiencia_7 VALUES ('Hotel Suite Palace','Supervisor', '2003/05/02', '2007/04/01','20132135');

INSERT INTO experiencia_7 VALUES ('Hotel Il Palazzo','Sub-Gerente', '2001/07/01', '2006/04/19','14547542');

INSERT INTO experiencia_7 VALUES ('Hotel Aguamar','Sub-Gerente', '2015/03/01', '2016/01/09','20896348');

INSERT INTO experiencia_7 VALUES ('Hotel Suave Agua','Supervisor', '2014/08/14', '2016/02/29','21926820');

-- INSERTS DE LENGUAJE

INSERT INTO lenguaje_7 VALUES ('Italiano','12323752');

INSERT INTO lenguaje_7 VALUES ('Ingles','12323752');

INSERT INTO lenguaje_7 VALUES ('Frances','12323752');

INSERT INTO lenguaje_7 VALUES ('Alemán','12323752');

INSERT INTO lenguaje_7 VALUES ('Portugues','12323752');

-- INSERTS DE SERVICIO

INSERT INTO servicio_7 VALUES (1,'Piscina, Cancha de Voleibol, Tenis y Fútbol, Spa, Discotecas, Restaurantes',TRUE,100000.00);

INSERT INTO servicio_7 VALUES (2,'Piscina, Cancha de Voleibol y Fútbol, Tiendas, Actividades Acuáticas',False,155000.00);

INSERT INTO servicio_7 VALUES (3,'Piscina, Spa',TRUE,80000.00);

INSERT INTO servicio_7 VALUES (4,'Piscina, Cancha de Voleibol, Tenis y Fútbol, Restaurantes',False,145000.00);

INSERT INTO servicio_7 VALUES (5,'Piscina, Cancha de Tenis y Fútbol',TRUE,90000.00);

-- INSERTS DE PAQUETE

INSERT INTO paquete_7 VALUES (1,'Full Day','Sitios Turísticos, incluye traslado, toldo, silla, bebidas nacionales, snack y actividad');

INSERT INTO paquete_7 VALUES (2,'2X1','Pague para dos personas por el precio de 1');

INSERT INTO paquete_7 VALUES (3,'3 días y 2 noches','Pase 3 días y 2 noches en Familia o con su Pareja con Desayuno incluido');

INSERT INTO paquete_7 VALUES (4,'Weekend','Pase un Fin de Semana de completo relax con todo incluido o sólo desayuno');

INSERT INTO paquete_7 VALUES (5,'Niños a Mitad de Precio','Venga a pasar sus Vacaciones en Familia donde sus hijos además de tener completa diversión tendrán un descuento de 50%');

-- INSERTS DE HP 

INSERT INTO hp_7 VALUES (1,1,130000,20); 

INSERT INTO hp_7 VALUES (1,2,120000,15);

INSERT INTO hp_7 VALUES (1,3,124000,10);

INSERT INTO hp_7 VALUES (2,4,150000,15);

INSERT INTO hp_7 VALUES (2,2,136000,20);

INSERT INTO hp_7 VALUES (2,5,125000,10);

INSERT INTO hp_7 VALUES (3,2,200000,5);

INSERT INTO hp_7 VALUES (3,5,130000,30);

INSERT INTO hp_7 VALUES (4,1,200000,20);

INSERT INTO hp_7 VALUES (4,2,160000,15);

INSERT INTO hp_7 VALUES (4,3,124500,40);

INSERT INTO hp_7 VALUES (5,4,230000,5);

INSERT INTO hp_7 VALUES (5,2,200000,2);

INSERT INTO hp_7 VALUES (5,3,104000,5);

-- INSERTS DE HOTEL_SERVICIO

INSERT INTO hotel_servicio_7 VALUES (100000.00,1,2,'Piscina',300,'16843234');

INSERT INTO hotel_servicio_7 VALUES (155000.00,2,2,'Piscina',400,'16843234');

INSERT INTO hotel_servicio_7 VALUES (80000.00,3,2,'Piscina',450,'16843234');

INSERT INTO hotel_servicio_7 VALUES (145000.00,4,2,'Piscina',500,'16843234');

INSERT INTO hotel_servicio_7 VALUES (90000.00,5,2,'Piscina',550,'16843234');

-- INSERTS DE HORARIO

INSERT INTO horario_7 VALUES ('Lunes','9:00','16434566');

INSERT INTO horario_7 VALUES ('Martes','7:00','16434566');

INSERT INTO horario_7 VALUES ('Miercoles','8:00','16434566');

INSERT INTO horario_7 VALUES ('Jueves','8:30','16434566');

INSERT INTO horario_7 VALUES ('Viernes','10:00','16434566');

-- INSERTS DE AMONESTACION

INSERT INTO amonestacion_7 VALUES (1, '2017/04/11','No llego al trabajo','22324963');

INSERT INTO amonestacion_7 VALUES (2, '2017/09/12','No llego al trabajo','22324963');

INSERT INTO amonestacion_7 VALUES (1,'2017/06/11','Uso indevido de los productos','21372961');

INSERT INTO amonestacion_7 VALUES (2,'2017/08/11','Uso indevido de los productos','21372961');

INSERT INTO amonestacion_7 VALUES (1,'2017/02/01','No llego a tiempo','20432853');

INSERT INTO amonestacion_7 VALUES (2,'2017/04/05','No llego al trabajo','20432853');

-- INSERTS DE TRABAJO_LIMPIEZA

INSERT INTO trabajo_limpieza_7 VALUES (1,'Lavandería y limpieza de Habitaciones');

INSERT INTO trabajo_limpieza_7 VALUES (2,'Limpieza de Habitaciones y Alrededores');

INSERT INTO trabajo_limpieza_7 VALUES (3,'Limpieza de Habitaciones y Pasillos');

INSERT INTO trabajo_limpieza_7 VALUES (4,'Lavandería, limpieza de Habitaciones y Alrededores');

INSERT INTO trabajo_limpieza_7 VALUES (5,'Lavandería y Alrededores');

-- INSERTS DE TRABAJO_COMPAÑIA

INSERT INTO trabajo_compañia_7 VALUES (1,'J-54326860-9',300000);

INSERT INTO trabajo_compañia_7 VALUES (2,'J-59818914-4',350000);

INSERT INTO trabajo_compañia_7 VALUES (3,'J-54326860-9',400000);

INSERT INTO trabajo_compañia_7 VALUES (4,'J-59818914-4',250000);

INSERT INTO trabajo_compañia_7 VALUES (5,'J-54356960-9',275000);

-- INSERTS DE COMODIDAD

INSERT INTO comodidad_7 VALUES (1,'WiFi,Cocina,Cable,Tv');

INSERT INTO comodidad_7 VALUES (2,'WiFi,Cocina,Tv');

INSERT INTO comodidad_7 VALUES (3,'WiFi,Cable,Tv');

INSERT INTO comodidad_7 VALUES (4,'WiFi,Cocina');

INSERT INTO comodidad_7 VALUES (5,'Cocina,Cable,Tv');

-- INSERTS LIMPIEZA_PISCINA

INSERT INTO limpieza_piscina_7 VALUES ( '2016/06/18','22324963','15:00',2,1);

INSERT INTO limpieza_piscina_7 VALUES ( '2016/07/09','22324963','08:00',2,2);

INSERT INTO limpieza_piscina_7 VALUES ( '2016/07/30','22324963','07:00',2,3);

INSERT INTO limpieza_piscina_7 VALUES ( '2016/08/20','22324963','06:00',2,4);

INSERT INTO limpieza_piscina_7 VALUES ( '2016/09/10','22324963','06:30',2,5);

-- INSERTS DE PRODUCTO PISCINA

INSERT INTO producto_piscina_7 VALUES (5, '2016/06/18','22324963',200);

INSERT INTO producto_piscina_7 VALUES (5, '2016/07/09','22324963',190);

INSERT INTO producto_piscina_7 VALUES (5, '2016/07/30','22324963',180);

INSERT INTO producto_piscina_7 VALUES (5, '2016/08/20','22324963',170);

INSERT INTO producto_piscina_7 VALUES (5, '2016/09/10','22324963',160);

-- INSERTS DE CH

INSERT INTO ch_7 VALUES (01,01,1,100000,1); -- ARREGLAR

INSERT INTO ch_7 VALUES (02,02,2,110000,2);

INSERT INTO ch_7 VALUES (01,03,3,120000,3);

INSERT INTO ch_7 VALUES (03,04,4,115000,4);

INSERT INTO ch_7 VALUES (02,05,5,125000,5);

-- INSERTS PAQUETE_RESERVA

INSERT INTO paquete_reserva_7 VALUES (500000.00,1,1,1);

INSERT INTO paquete_reserva_7 VALUES (450000.00,2,2,4);

INSERT INTO paquete_reserva_7 VALUES (200000.00,4,3,5);

INSERT INTO paquete_reserva_7 VALUES (500000.00,5,4,3);

INSERT INTO paquete_reserva_7 VALUES (500000.00,3,5,2);

-- INSERTS DE RA

INSERT INTO ra_7 VALUES (1,'23849238');

INSERT INTO ra_7 VALUES (2,'20145986');

INSERT INTO ra_7 VALUES (3,'9456865');

INSERT INTO ra_7 VALUES (4,'15098345');

INSERT INTO ra_7 VALUES (5,'18479145');

-- INSERTS DE HR

INSERT INTO hr_7 VALUES (01,1,1,120000); -- ARREGLAR

INSERT INTO hr_7 VALUES (02,2,2,110000);

INSERT INTO hr_7 VALUES (01,3,3,125000);

INSERT INTO hr_7 VALUES (03,4,4,100000);

INSERT INTO hr_7 VALUES (02,3,5,105000);

-- INSERTS DE SERVICIO_COMPRA

INSERT INTO servicio_compra_7 VALUES (01,1,2,30000,1); -- ARREGLAR

INSERT INTO servicio_compra_7 VALUES (02,2,2,20000,2);

INSERT INTO servicio_compra_7 VALUES (03,3,2,40000,3);

INSERT INTO servicio_compra_7 VALUES (04,4,2,80000,4);

INSERT INTO servicio_compra_7 VALUES (05,5,2,100000,5);

-- INSERTS DE SERVICIO_RESERVA

INSERT INTO servicio_reserva_7 VALUES (100000.00,2,1,1);

INSERT INTO servicio_reserva_7 VALUES (155000.00,2,2,2);

INSERT INTO servicio_reserva_7 VALUES (80000.00,2,3,3);

INSERT INTO servicio_reserva_7 VALUES (145000.00,2,4,4);

INSERT INTO servicio_reserva_7 VALUES (90000.00,2,5,5);

-- INSERTS DE PAQUETE_COMPRA

INSERT INTO paquete_compra_7 VALUES (01,1,1,30000,1); -- ARREGLAR

INSERT INTO paquete_compra_7 VALUES (02,2,5,40000,2);

INSERT INTO paquete_compra_7 VALUES (03,3,4,60000,3);

INSERT INTO paquete_compra_7 VALUES (04,4,2,70000,4);

INSERT INTO paquete_compra_7 VALUES (05,5,3,90000,5);

-- INSERTS DE HC

INSERT INTO hc_7 VALUES (01,1,1);

INSERT INTO hc_7 VALUES (02,2,1);

INSERT INTO hc_7 VALUES (03,3,1);

INSERT INTO hc_7 VALUES (01,4,2);

INSERT INTO hc_7 VALUES (02,5,2);

-- INSERTS DE CA

INSERT INTO ca_7 VALUES (1,'23849238');

INSERT INTO ca_7 VALUES (2,'20145986');

INSERT INTO ca_7 VALUES (3,'9456865');

INSERT INTO ca_7 VALUES (4,'15098345');

INSERT INTO ca_7 VALUES (5,'18479145');

-- INSERTS DE PP

INSERT INTO pp_7 VALUES (1,'J-84372893-8');

INSERT INTO pp_7 VALUES (2,'J-84372893-8');

INSERT INTO pp_7 VALUES (3,'J-12399405-3');

INSERT INTO pp_7 VALUES (4,'J-54356960-9');

INSERT INTO pp_7 VALUES (5,'J-54356960-9');

-- INSERTS DE DETALLE_FACTURA

INSERT INTO detalle_factura_7 VALUES (1,1,120000);

INSERT INTO detalle_factura_7 VALUES (2,3,140000);

INSERT INTO detalle_factura_7 VALUES (3,2,120000);

INSERT INTO detalle_factura_7 VALUES (4,5,120000);

INSERT INTO detalle_factura_7 VALUES (5,4,120000);