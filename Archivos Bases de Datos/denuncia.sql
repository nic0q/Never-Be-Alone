-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-07-2022 a las 03:55:03
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
-- Estructura de tabla para la tabla `denuncia`
--

CREATE TABLE `denuncia` (
  `id_denuncia` int(11) NOT NULL,
  `id_denunciante` int(11) NOT NULL,
  `id_denunciado` int(11) NOT NULL,
  `id_estamento_denunciado` int(11) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `medidas` varchar(500) NOT NULL,
  `id_estado` int(11) NOT NULL,
  `fecha` text NOT NULL,
  `id_fiscal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `denuncia`
--

INSERT INTO `denuncia` (`id_denuncia`, `id_denunciante`, `id_denunciado`, `id_estamento_denunciado`, `descripcion`, `medidas`, `id_estado`, `fecha`, `id_fiscal`) VALUES
(0, 0, 1, 1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec iaculis, elit vitae vulputate dignissim, nibh purus finibus metus, non egestas tortor sem posuere diam.', 'Vestibulum lacus mauris, ultricies eget viverra elementum, vehicula ut ligula. Nunc consectetur consectetur arcu at elementum.', 3, '2022/06/28 14:28:00', 5),
(1, 0, 1, 1, 'Morbi mollis mollis magna, non pellentesque enim. Suspendisse a erat a risus eleifend accumsan sit amet eu arcu. Integer facilisis venenatis felis, nec posuere ipsum mattis nec.', 'Quisque massa ipsum, tempus at quam quis, aliquam suscipit nunc. Donec volutpat finibus ex feugiat consequat.', 2, '2022/06/28 12:12:49', 5),
(2, 0, 2, 1, 'Aenean vitae tincidunt ex. Curabitur risus nisl, mattis in ante vel, interdum ullamcorper odio. Vivamus at risus sed nisi fermentum tempor. ', 'Nullam pharetra hendrerit quam, at blandit erat viverra in.', 1, '2022/06/28 20:35:15', 6),
(3, 1, 0, 1, 'Nulla vel felis justo. Pellentesque et pellentesque odio. Quisque nisi purus, semper quis consectetur at, ultricies non justo. In hac habitasse platea dictumst.', 'Pellentesque non leo lectus. Curabitur in risus at quam scelerisque iaculis at id ante. ', 1, '2022/06/28 21:06:26', 5),
(4, 2, 1, 1, 'Pellentesque tristique erat vel lacus elementum suscipit. Pellentesque accumsan turpis eu ex ultrices, mattis posuere lacus sollicitudin.', 'In rutrum odio iaculis nisi venenatis pretium. Suspendisse facilisis luctus felis tristique lobortis.', 1, '2022/06/28 21:32:08', 6),
(5, 2, 0, 1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sit amet lacinia orci, a hendrerit eros. Vestibulum vehicula ac lorem non vestibulum.', 'Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.', 3, '2022/06/28 21:32:45', 6),
(6, 2, 0, 1, 'Suspendisse commodo egestas urna nec facilisis. Integer convallis convallis viverra. Quisque ut nisl at arcu pulvinar feugiat. In hac habitasse platea dictumst. Nulla luctus felis gravida, tincidunt nisi vel, pellentesque nunc. ', 'Praesent ac gravida ligula. Sed et euismod mauris, dictum pulvinar mauris. Pellentesque fermentum pretium dolor quis sodales.', 3, '2022/06/28 21:49:51', 5),
(7, 1, 2, 1, 'Aenean eleifend dui in efficitur ullamcorper. Donec scelerisque vitae erat malesuada fermentum. Morbi nulla ante, pellentesque in nunc a, ultricies scelerisque risus', 'Donec tincidunt, tortor vitae vulputate auctor, mauris ligula dapibus lorem, iaculis sagittis mi est vel purus.', 2, '2022/06/28 21:49:52', 6),
(8, 0, 1, 1, 'Aenean ac felis dui. Nulla finibus ultrices odio, id auctor sem tristique in. Aliquam dictum purus at orci iaculis fringilla. ', 'Nullam vulputate mollis sem, et porta nulla ultrices eget. Integer egestas ante orci, in tincidunt tortor ultrices ac. ', 0, '2022/06/28 21:49:52', 5),
(9, 0, 1, 1, 'Ut vestibulum eros nisi, a eleifend lorem euismod euismod. Sed mattis accumsan justo, a porttitor enim dapibus vitae. Vestibulum dapibus sapien id felis ultricies, quis varius tortor eleifend.', 'Quisque maximus erat risus, eu tempus nisi tincidunt id. Vivamus posuere vitae felis sagittis dapibus.', 0, '2022/06/28 21:49:52', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `denuncia`
--
ALTER TABLE `denuncia`
  ADD PRIMARY KEY (`id_denuncia`),
  ADD KEY `id_denunciante` (`id_denunciante`),
  ADD KEY `id_denunciado` (`id_denunciado`),
  ADD KEY `id_estamento_denunciado` (`id_estamento_denunciado`),
  ADD KEY `id_estado` (`id_estado`),
  ADD KEY `id_fiscal` (`id_fiscal`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
