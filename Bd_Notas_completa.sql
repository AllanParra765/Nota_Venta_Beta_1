-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 25-08-2023 a las 00:34:00
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Bd_Notas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Notas3`
--

CREATE TABLE `Notas3` (
  `Id_Nota` int(11) NOT NULL,
  `Folio` varchar(20) NOT NULL,
  `NombreCliente` varchar(100) NOT NULL,
  `KilosRopa` int(11) NOT NULL,
  `Precio` double NOT NULL,
  `Total` double NOT NULL,
  `Comentario` varchar(500) NOT NULL,
  `FechaLlegada` date NOT NULL DEFAULT current_timestamp(),
  `FechaEntrega` date NOT NULL DEFAULT current_timestamp(),
  `Entregado` tinyint(1) NOT NULL DEFAULT 0,
  `Eliminado` tinyint(1) NOT NULL DEFAULT 0,
  `Servicios` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Notas3`
--

INSERT INTO `Notas3` (`Id_Nota`, `Folio`, `NombreCliente`, `KilosRopa`, `Precio`, `Total`, `Comentario`, `FechaLlegada`, `FechaEntrega`, `Entregado`, `Eliminado`, `Servicios`) VALUES
(6, 'F_Licha08', 'Licha', 12, 11, 132, 'rrrrrr', '2022-10-24', '2022-10-26', 0, 0, 'Ropa'),
(7, 'F_Alicia018', 'Alicia', 12, 11, 132, 'sssss', '2022-10-27', '2022-10-27', 0, 1, 'Cobertor'),
(8, 'F_Rma021', 'Rma', 17, 11, 187, 'lllllllls', '2022-10-24', '2022-10-22', 0, 0, 'Ropa'),
(9, 'F_vamonos09', 'vamonos', 18, 11, 198, 'qqqqqqqq', '2022-10-24', '2022-10-20', 0, 0, 'Ropa'),
(10, 'F_Alicia02', 'Alicia', 12, 11, 132, 'qqq1', '2022-10-24', '2022-10-15', 0, 1, 'Ropa'),
(11, 'F_Allan010', 'Allan', 10, 19, 190, 'aaaa', '2022-10-25', '2022-10-15', 0, 1, 'Ropa'),
(12, 'F_Allan02', 'Allan', 12, 11, 132, 'bbbbb', '2022-10-25', '2022-10-08', 0, 1, 'Ropa'),
(13, 'F_Animo06', 'Animo', 10, 11, 110, 'comentario de prueba para entregar el sábado', '2022-10-26', '2022-10-31', 0, 1, 'Ropa'),
(14, 'F_alin07', 'alin', 12, 11, 132, 'aaaaa', '2022-11-15', '2022-11-15', 1, 0, 'Ropa'),
(15, 'F_Gil01', 'Gil', 19, 11, 209, 'otra cosa', '2022-11-15', '2022-11-04', 0, 0, 'Ropa'),
(16, 'F_Prueba07', 'Prueba', 12, 11, 132, 'otro registro', '2022-11-15', '2022-11-19', 0, 1, 'Ropa'),
(17, 'F0001', 'Alicia', 12, 11, 132, 'aaaa', '2022-11-15', '2022-11-25', 0, 1, 'Ropa'),
(18, 'F_aaa05', 'aaa', 22, 11, 242, 'ssssssss', '2022-11-15', '2022-11-19', 0, 1, 'Ropa'),
(19, 'F_Alicia03', 'Manchado', 2, 1, 2, 'sssss', '2022-11-16', '2022-11-16', 0, 0, 'Ropa'),
(20, 'F_Alin021', 'Alin', 19, 12, 228, 'hdkhjd', '2022-12-08', '2022-12-09', 0, 0, 'Ropa'),
(21, 'F_probando016', 'probando', 12, 12, 144, 'comenarios de arroz', '2022-12-08', '2022-12-10', 0, 0, 'Ropa'),
(22, 'F_Alicia019', 'Alicia', 12, 12, 144, 'no hay comentarios', '2022-12-27', '2022-12-02', 1, 0, 'Ropa'),
(23, 'F_Lin chan018', 'Lin chan', 12, 12, 144, 's', '2022-12-27', '2022-12-29', 0, 1, 'Ropa'),
(24, 'F_Sofia001', 'Yulay', 13, 15.98, 1112.89, 'hdbhscbdbcdscbjhsbchjhcdbjds', '2022-12-28', '2022-12-29', 0, 0, 'Colchoneta'),
(29, 'F_AliciaManchado05', 'AliciaManchado', 12, 11, 132, 'otra cosa', '2022-12-30', '2022-12-23', 1, 0, 'Calzado'),
(30, 'F_otraCosa03', 'otraCosa', 12, 11, 132, 'aaaa', '2022-12-30', '2022-12-30', 0, 1, 'Cobertores'),
(36, 'F_Prueba019', 'Prueba', 12, 11, 132, 'wwwwww', '2022-12-30', '2022-12-15', 0, 1, 'Tintoreria'),
(37, 'F_Prueba019', 'Prueba', 12, 11, 132, '33333', '2022-12-30', '2022-12-15', 0, 1, 'Calzado'),
(38, 'F_Prueba019', 'Prueba', 12, 11, 132, '111111', '2022-12-30', '2022-12-15', 0, 1, 'Costura'),
(39, 'F_Magnolia017', 'Magnolia', 1, 25, 25, 'por la noche', '2022-12-30', '2022-12-31', 1, 0, 'Ropa'),
(40, 'F_Magnolia017', 'Magnolia', 1, 40, 40, 'solo una mochila', '2022-12-30', '2022-12-31', 1, 0, 'Mochila'),
(41, 'F_Magnolia013', 'Magnolia', 1, 12, 12, 'cuello y costura', '2023-01-02', '2023-01-02', 1, 0, 'Costura'),
(42, 'F_Magnolia013', 'Magnolia', 2, 120, 240, 'dos cobertores rosa y azul', '2023-01-02', '2023-01-02', 1, 0, 'Cobertores'),
(43, 'F_AliciaMachaca08', 'AliciaMachaca', 1, 12, 12, 'prueba', '2023-01-02', '2023-01-03', 1, 0, 'Tintoreria'),
(44, 'F_AliciaMachaca08', 'AliciaMachaca', 12, 112, 1344, 'dddddd', '2023-01-02', '2023-01-03', 1, 0, 'Tintoreria'),
(45, 'F0001', 'Teresa', 12, 11, 132, '1111', '2023-01-02', '2023-01-18', 0, 1, 'Calzado'),
(46, 'F0001', 'Teresa', 11, 12, 132, 'sssss', '2023-01-02', '2023-01-18', 0, 1, 'PInes'),
(47, 'F0001', 'Teresa', 12, 11, 132, '1111', '2023-01-02', '2023-01-18', 0, 1, 'Calzado'),
(48, 'F0001', 'Teresa', 11, 12, 132, 'sssss', '2023-01-02', '2023-01-18', 0, 1, 'PInes'),
(49, 'F_Ricardo01', 'Ricardo', 12, 11, 132, 'wwwww', '2023-01-02', '2023-01-19', 1, 0, 'Cobertores'),
(50, 'F_Ricardo01', 'Ricardo', 1, 17.9, 17.9, 'sssss', '2023-01-02', '2023-01-19', 1, 0, 'Corte y confección'),
(51, 'F_lin08', 'lin', 12, 21, 252, 'tennis', '2023-01-03', '2023-01-03', 0, 0, 'Calzado'),
(52, 'F_lin08', 'lin', 10, 25, 250, 'ropa delicada', '2023-01-03', '2023-01-03', 0, 1, 'Ropa'),
(53, 'F_Lee014', 'Lee', 12, 11, 132, 'ropa de corte', '2023-01-03', '2023-01-03', 0, 0, 'Corte'),
(54, 'F_Lee014', 'Lee', 1, 90, 90, 'cobertor naranja', '2023-01-03', '2023-01-11', 0, 1, 'Tintoreria'),
(55, 'F_Ale018', 'Ale', 1, 25, 25, 'ropa delicada', '2023-01-03', '2023-01-04', 0, 0, 'Ropa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Notas_OtroServicio`
--

CREATE TABLE `Notas_OtroServicio` (
  `id_Nota` int(11) NOT NULL,
  `Id_Folio_OS` varchar(15) DEFAULT NULL,
  `Nombre_Cliente_OS` varchar(100) NOT NULL,
  `Servicio` varchar(100) NOT NULL,
  `Precio` double NOT NULL,
  `Kilos_Pares_Piezas` int(11) NOT NULL,
  `Fecha_Llegada` date NOT NULL DEFAULT current_timestamp(),
  `Fecha_Entrega` date NOT NULL DEFAULT current_timestamp(),
  `Total` double NOT NULL,
  `Comentarios` text NOT NULL,
  `Entregado` tinyint(1) NOT NULL,
  `Eliminado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Notas_OtroServicio`
--

INSERT INTO `Notas_OtroServicio` (`id_Nota`, `Id_Folio_OS`, `Nombre_Cliente_OS`, `Servicio`, `Precio`, `Kilos_Pares_Piezas`, `Fecha_Llegada`, `Fecha_Entrega`, `Total`, `Comentarios`, `Entregado`, `Eliminado`) VALUES
(1, 'FOL_009', 'alicia', 'zapatos', 15.98, 12, '2022-12-01', '2022-12-27', 1112.89, 'swqdddfdsfdsfsf', 0, 0),
(2, 'FOL_0091', 'alicia2', 'zapatos2', 15.98, 12, '2022-12-01', '2022-12-27', 1112.89, 'swqdddfdsfdsfsf222222', 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Notas3`
--
ALTER TABLE `Notas3`
  ADD PRIMARY KEY (`Id_Nota`);

--
-- Indices de la tabla `Notas_OtroServicio`
--
ALTER TABLE `Notas_OtroServicio`
  ADD PRIMARY KEY (`id_Nota`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Notas3`
--
ALTER TABLE `Notas3`
  MODIFY `Id_Nota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT de la tabla `Notas_OtroServicio`
--
ALTER TABLE `Notas_OtroServicio`
  MODIFY `id_Nota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
