-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-12-2018 a las 18:04:46
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `veterinariaes`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `idCitas` int(11) NOT NULL,
  `Fecha` datetime NOT NULL,
  `Motivos` varchar(100) NOT NULL,
  `idClienteCita` int(11) NOT NULL,
  `idMascotaCita` int(11) NOT NULL,
  `idEmpleadosCita` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apePat` varchar(20) NOT NULL,
  `apeMat` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `edad` int(11) NOT NULL,
  `sexo` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idCliente`, `nombre`, `apePat`, `apeMat`, `Email`, `telefono`, `edad`, `sexo`) VALUES
(1, 'Jose', 'Perez', 'Leon', 'ElQueSeFue@gmail.com', '6691276532', 12, 'Masculino'),
(2, 'Pedro David', 'Perez', 'Hernandez', 'koko_liso@hotmail.com', '6692873849', 12, 'Masculino'),
(3, 'Paulina', 'Perez', 'Chavez', 'LaTeacher_360@gmail.com', '6691782345', 12, 'Femenino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `idEmpleados` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `apePat` varchar(15) NOT NULL,
  `apeMat` varchar(15) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Contrasena` varchar(30) NOT NULL,
  `Sexo` varchar(15) NOT NULL,
  `Edad` int(11) NOT NULL,
  `idPuestoEmp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`idEmpleados`, `Nombre`, `apePat`, `apeMat`, `Email`, `Contrasena`, `Sexo`, `Edad`, `idPuestoEmp`) VALUES
(1, 'Jose Daniel', 'Perez', 'Reyes', 'jose_Prz@gmail.com', 'josejose', 'Masculino', 22, 1),
(2, 'Miguel Angel', 'Tortuga', 'Ninja', 'LaTortuga_Mutante@outlock.com', 'somoscuatro', 'Masculino', 18, 1),
(3, 'Anabel', 'Chavez', 'Berumen', 'AnChBe_MC@gmail.com', 'acbmc', 'Femenino', 28, 2),
(4, 'gfhdfghdfh', 'dfghfg', 'fghdgh', 'gfhdf@dfasdf.com', 'asdf', 'Masculino', 6, 2),
(5, 'Akira Rei', 'Reyes', 'Guijarro', 'okol_sedlab@gmail.com', 'lokoshon', 'Masculino', 29, 2),
(6, 'efsadf', 'dfsd', 'fsdf', 'aaf_tu2@hotmail.com', 'fdgdfgd', 'Masculino', 24, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especie`
--

CREATE TABLE `especie` (
  `idEspecie` int(11) NOT NULL,
  `Especie` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `especie`
--

INSERT INTO `especie` (`idEspecie`, `Especie`) VALUES
(1, 'Perro'),
(2, 'Gato');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascotas`
--

CREATE TABLE `mascotas` (
  `idMascota` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `idEspecieMascota` int(11) NOT NULL,
  `Sexo` varchar(15) NOT NULL,
  `Edad` int(11) NOT NULL,
  `idClienteMascota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `mascotas`
--

INSERT INTO `mascotas` (`idMascota`, `Nombre`, `idEspecieMascota`, `Sexo`, `Edad`, `idClienteMascota`) VALUES
(1, 'Firulais', 1, 'Femenino', 3, 2),
(2, 'Buddy', 2, 'Femenino', 18, 1),
(3, 'Terry', 1, 'Masculino', 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentos`
--

CREATE TABLE `medicamentos` (
  `idMedicamento` int(11) NOT NULL,
  `Medicamento` varchar(30) NOT NULL,
  `Precio` int(11) NOT NULL,
  `Metodo` varchar(30) NOT NULL,
  `Cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `medicamentos`
--

INSERT INTO `medicamentos` (`idMedicamento`, `Medicamento`, `Precio`, `Metodo`, `Cantidad`) VALUES
(1, 'Paracetamol', 167, 'Tabletas', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puestos`
--

CREATE TABLE `puestos` (
  `idPuestos` int(11) NOT NULL,
  `Puesto` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `puestos`
--

INSERT INTO `puestos` (`idPuestos`, `Puesto`) VALUES
(1, 'Cajero'),
(2, 'Administrador'),
(3, 'Medico'),
(4, 'Terapeuta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `idServicio` int(11) NOT NULL,
  `Servicio` varchar(20) NOT NULL,
  `Precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`idServicio`, `Servicio`, `Precio`) VALUES
(1, 'Castracion', 5000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamientos`
--

CREATE TABLE `tratamientos` (
  `idTratamiento` int(11) NOT NULL,
  `Tratamiento` varchar(30) NOT NULL,
  `Precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tratamientos`
--

INSERT INTO `tratamientos` (`idTratamiento`, `Tratamiento`, `Precio`) VALUES
(1, 'BañoCachorro', 300);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idVenta` int(11) NOT NULL,
  `idMedicamentoVenta` int(11) NOT NULL,
  `idTratamientoVenta` int(11) NOT NULL,
  `idServicioVenta` int(11) NOT NULL,
  `FechaVenta` date NOT NULL,
  `idClienteVenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`idCitas`),
  ADD KEY `idClienteCita` (`idClienteCita`),
  ADD KEY `idMascotaCita` (`idMascotaCita`),
  ADD KEY `idEmpleadosCita` (`idEmpleadosCita`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`idEmpleados`),
  ADD KEY `idPuestoEmp` (`idPuestoEmp`);

--
-- Indices de la tabla `especie`
--
ALTER TABLE `especie`
  ADD PRIMARY KEY (`idEspecie`);

--
-- Indices de la tabla `mascotas`
--
ALTER TABLE `mascotas`
  ADD PRIMARY KEY (`idMascota`),
  ADD KEY `idClienteMascota` (`idClienteMascota`),
  ADD KEY `idEspecieMascota` (`idEspecieMascota`);

--
-- Indices de la tabla `medicamentos`
--
ALTER TABLE `medicamentos`
  ADD PRIMARY KEY (`idMedicamento`);

--
-- Indices de la tabla `puestos`
--
ALTER TABLE `puestos`
  ADD PRIMARY KEY (`idPuestos`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`idServicio`);

--
-- Indices de la tabla `tratamientos`
--
ALTER TABLE `tratamientos`
  ADD PRIMARY KEY (`idTratamiento`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `idMedicamentoVenta` (`idMedicamentoVenta`),
  ADD KEY `idTratamientoVenta` (`idTratamientoVenta`),
  ADD KEY `idServicioVenta` (`idServicioVenta`),
  ADD KEY `idClienteVenta` (`idClienteVenta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `idCitas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `idEmpleados` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `especie`
--
ALTER TABLE `especie`
  MODIFY `idEspecie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `mascotas`
--
ALTER TABLE `mascotas`
  MODIFY `idMascota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `medicamentos`
--
ALTER TABLE `medicamentos`
  MODIFY `idMedicamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `puestos`
--
ALTER TABLE `puestos`
  MODIFY `idPuestos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `servicios`
--
ALTER TABLE `servicios`
  MODIFY `idServicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tratamientos`
--
ALTER TABLE `tratamientos`
  MODIFY `idTratamiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`idClienteCita`) REFERENCES `clientes` (`idCliente`),
  ADD CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`idMascotaCita`) REFERENCES `mascotas` (`idMascota`),
  ADD CONSTRAINT `citas_ibfk_3` FOREIGN KEY (`idEmpleadosCita`) REFERENCES `empleados` (`idEmpleados`);

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`idPuestoEmp`) REFERENCES `puestos` (`idPuestos`);

--
-- Filtros para la tabla `mascotas`
--
ALTER TABLE `mascotas`
  ADD CONSTRAINT `mascotas_ibfk_1` FOREIGN KEY (`idEspecieMascota`) REFERENCES `especie` (`idEspecie`),
  ADD CONSTRAINT `mascotas_ibfk_2` FOREIGN KEY (`idClienteMascota`) REFERENCES `clientes` (`idCliente`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`idMedicamentoVenta`) REFERENCES `medicamentos` (`idMedicamento`),
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`idTratamientoVenta`) REFERENCES `tratamientos` (`idTratamiento`),
  ADD CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`idServicioVenta`) REFERENCES `servicios` (`idServicio`),
  ADD CONSTRAINT `ventas_ibfk_4` FOREIGN KEY (`idClienteVenta`) REFERENCES `clientes` (`idCliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
