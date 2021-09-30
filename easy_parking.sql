CREATE TABLE `placa` (
  `id_vehiculo` varchar(6) NOT NULL,
  `id_tipo_veh` varchar(15) NOT NULL,
  PRIMARY KEY (`id_vehiculo`),
  KEY `tipo_vehiculo_id_tipo_veh_fk` (`id_tipo_veh`),
  CONSTRAINT `tipo_vehiculo_id_tipo_veh_fk` FOREIGN KEY (`id_tipo_veh`) REFERENCES `tipo_vehiculo` (`id_tipo_veh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM easy_parking.placa;