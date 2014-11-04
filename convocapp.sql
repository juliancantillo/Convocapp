-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-11-2014 a las 23:29:27
-- Versión del servidor: 5.6.20
-- Versión de PHP: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `convocapp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `convocatory`
--

CREATE TABLE IF NOT EXISTS `convocatory` (
`identificacion` int(250) NOT NULL,
  `name` varchar(128) NOT NULL,
  `open_time` date DEFAULT NULL,
  `closet_time` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
`id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `active` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `name`, `active`) VALUES
(1, 'Administrador', 1),
(2, 'Digitador', 1),
(3, 'Supervisor', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`id` int(11) NOT NULL,
  `identification` varchar(45) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `cellphone` varchar(20) DEFAULT NULL,
  `active` tinyint(4) NOT NULL DEFAULT '1',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `identification`, `username`, `password`, `email`, `firstname`, `lastname`, `address`, `phone`, `cellphone`, `active`, `create_time`, `update_time`) VALUES
(1, '14495546', 'pepe', 'd8578edf8458ce06fbc5bb76a58c5ca4', 'pepe@gmail.com', 'Pepe', 'Perez', 'Calle 3 # 13 - 32', '3247598', '3197842535', 1, '2014-10-18 07:40:27', '2014-10-18 08:13:06'),
(2, 'Mauro', 'mauro', 'e10adc3949ba59abbe56e057f20f883e', '', '', '', '', '', '', 1, '2014-11-04 21:58:38', '2014-11-04 22:00:01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_has_roles`
--

CREATE TABLE IF NOT EXISTS `user_has_roles` (
`id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `roles_id` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `user_has_roles`
--

INSERT INTO `user_has_roles` (`id`, `user_id`, `roles_id`) VALUES
(1, 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `convocatory`
--
ALTER TABLE `convocatory`
 ADD PRIMARY KEY (`identificacion`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user_has_roles`
--
ALTER TABLE `user_has_roles`
 ADD PRIMARY KEY (`id`,`user_id`,`roles_id`), ADD KEY `fk_user_has_roles_roles1_idx` (`roles_id`), ADD KEY `fk_user_has_roles_user_idx` (`user_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `convocatory`
--
ALTER TABLE `convocatory`
MODIFY `identificacion` int(250) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `user_has_roles`
--
ALTER TABLE `user_has_roles`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `user_has_roles`
--
ALTER TABLE `user_has_roles`
ADD CONSTRAINT `fk_user_has_roles_roles1` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_user_has_roles_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
