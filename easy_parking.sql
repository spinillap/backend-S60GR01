CREATE database easy_parking;
CREATE TABLE rol(
id_rol VARCHAR (15) NOT NULL,
nombre_rol VARCHAR (50) NOT NULL,
CONSTRAINT rol_pk PRIMARY KEY (id_rol));
CREATE TABLE usuario(
id_usuario VARCHAR (15) NOT NULL,
nombre_usu VARCHAR (50) NOT NULL,
telefono_usu VARCHAR (10) NOT NULL,
email_usu VARCHAR (80) NOT NULL,
direccion_usu VARCHAR (50) NOT NULL,
id_rol VARCHAR (15) NOT NULL,
user VARCHAR (30) NOT NULL,
password VARCHAR (50) NOT NULL,
CONSTRAINT id_usuario_pk PRIMARY KEY (id_usuario),
CONSTRAINT usuario_id_rol_fk FOREIGN KEY (id_rol) REFERENCES rol(id_rol));
CREATE TABLE tarifa(
id_tarifa VARCHAR (15) NOT NULL,
valor_tar DOUBLE,
nombre_tar VARCHAR (15) NOT NULL,
CONSTRAINT id_tarifa_pk PRIMARY KEY (id_tarifa));
CREATE TABLE plaza(
id_plaza VARCHAR (15) NOT NULL,
numero_pla INT (3) NOT NULL,
estado_pla VARCHAR (30) NOT NULL,
CONSTRAINT id_plaza_pk PRIMARY KEY (id_plaza));
CREATE TABLE tipo_vehiculo(
id_tipo_veh VARCHAR (15) NOT NULL,
nombre_tipo_veh VARCHAR (50) NOT NULL,
CONSTRAINT id_tipo_veh_pk PRIMARY KEY (id_tipo_veh));
CREATE TABLE placa(
id_vehiculo VARCHAR (6) NOT NULL,
id_tipo_veh VARCHAR (15) NOT NULL,
CONSTRAINT id_vehiculo_pk PRIMARY KEY (id_vehiculo),
CONSTRAINT tipo_vehiculo_id_tipo_veh_fk FOREIGN KEY (id_tipo_veh) REFERENCES tipo_vehiculo (id_tipo_veh));
CREATE TABLE ticket(
id_ticket VARCHAR (15) NOT NULL,
hora_ent DATETIME,
id_vehiculo VARCHAR (6) NOT NULL,
id_plaza VARCHAR (15) NOT NULL,
CONSTRAINT id_ticket_pk PRIMARY KEY (id_ticket),
CONSTRAINT placa_id_vehiculo_fk FOREIGN KEY (id_vehiculo) REFERENCES placa (id_vehiculo),
CONSTRAINT plaza_id_plaza_fk FOREIGN KEY (id_plaza) REFERENCES plaza (id_plaza));
CREATE TABLE factura(
id_factura VARCHAR (15) NOT NULL,
hora_sal DATETIME,
id_usuario VARCHAR (15) NOT NULL,
id_tarifa VARCHAR (15) NOT NULL,
id_ticket VARCHAR (15) NOT NULL,
valor_tot DOUBLE,
CONSTRAINT id_factura_pk PRIMARY KEY (id_factura),
CONSTRAINT usuario_id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
CONSTRAINT tarifa_id_tarifa_fk FOREIGN KEY (id_tarifa) REFERENCES tarifa (id_tarifa),
CONSTRAINT ticket_id_ticket_fk FOREIGN KEY (id_ticket) REFERENCES ticket (id_ticket));
DROP TABLE tarifa;
