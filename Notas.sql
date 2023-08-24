CREATE TABLE `Notas` (
  `Id_Nota` int(11) NOT NULL,
  `Folio`varchar(25) NOT NULL,
  `NombreCliente` varchar(100) NOT NULL,
  `KilosRopa` double NOT NULL,
  `Precio` double NOT NULL,
  `Total` double NOT NULL,
  `Comentario`varchar(500) NOT NULL,
  `FechaLlegada` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `FechaEntrega` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


ALTER TABLE `Notas`
ADD PRIMARY KEY (`Id_Nota`);


ALTER TABLE `Notas`
MODIFY `Id_Nota` int(11) NOT NULL AUTO_INCREMENT;


INSERT INTO `Notas` (`Id_Nota`, `Folio`, `NombreCliente`, `KilosRopa`, `Precio`, `Total`, `Comentario`, `FechaLlegada`, `FechaEntrega`) VALUES (NULL, 'F_Sofia001', 'Ali', '12.90', '15.98', '1112.89', 'Comentarios', current_timestamp(), '2022-10-29 14:57:04');