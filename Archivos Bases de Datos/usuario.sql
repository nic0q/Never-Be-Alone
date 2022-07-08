-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-07-2022 a las 03:55:48
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fingesodb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `email` text NOT NULL,
  `password` varchar(50) NOT NULL,
  `id_rol` int(11) NOT NULL,
  `id_estamento` int(11) NOT NULL,
  `nombres` varchar(150) NOT NULL,
  `apellidos` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `email`, `password`, `id_rol`, `id_estamento`, `nombres`, `apellidos`) VALUES
(0, 'francisco.alvarado@usach.cl', '1234', 0, 1, 'francisco', 'alvarado'),
(1, 'maria.alvarez@usach.cl', '1234', 0, 1, 'maria', 'alvarez'),
(2, 'valeska.farfan@usach.cl', '1234', 0, 1, 'valeska', 'farfan'),
(3, 'juan.pino@usach.cl', '1234', 2, 2, 'juan', 'pino'),
(4, 'jose.carcamo.c@usach.cl', '1234', 2, 2, 'jose', 'carcamo'),
(5, 'itziar.bejarano@usach.cl', '1234', 1, 0, 'itziar', 'bejarano'),
(6, 'maite.ubeda@usach.cl', '1234', 1, 0, 'maite', 'ubea'),
(7, 'gregoria.peralta@usach.cl', '1234', 3, 2, 'gregoria', 'peralta');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `email` (`email`) USING HASH,
  ADD KEY `id_rol` (`id_rol`),
  ADD KEY `id_estamento` (`id_estamento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
