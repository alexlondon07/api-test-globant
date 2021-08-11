create database if not exists `customer`;

USE `customer`;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `create_at` date NOT NULL,
  `direccion` varchar(90) DEFAULT NULL,
  `documento` varchar(10) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `nombre` varchar(60) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `tipo_documento` varchar(255) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `region_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `apellido`, `create_at`, `direccion`, `documento`, `email`, `fecha_nacimiento`, `img`, `nombre`, `telefono`, `tipo_documento`, `updated_at`, `region_id`) VALUES
(1, 'Londoño', '2020-08-01', 'Calle 65', '1038114501', 'alexlondon07@gmail.com', '2020-08-02', NULL, 'Alexander Londoño', '3122195522', 'CC', '2021-04-22 17:04:05', 1),
(2, 'Londoño', '2020-08-01', 'Calle 65', '1038114052', 'alexlondon08@gmail.com', '2020-08-02', NULL, 'Emiliana Londoño', '3122195522', 'CC', '2021-04-22 17:04:05', 2),
(3, 'Londoño', '2020-08-01', 'Calle 65', '1038114503', 'alexlondon09@gmail.com', '2020-08-02', NULL, 'Aracelly Londoño', '3122195522', 'CC', '2021-04-22 17:04:05', 3),
(4, 'Londoño', '2020-08-01', 'Calle 65', '103811404', 'alexlondon010@gmail.com', '2020-08-02', NULL, 'Jesus Londoño', '3122195522', 'CC', '2021-04-22 17:04:05', 1),
(5, 'Londoño', '2020-08-01', 'Calle 65', '1038114505', 'alexlondon011@gmail.com', '2020-08-02', NULL, 'Estefany Londoño', '3122195522', 'CC', '2021-04-22 17:04:05', 2),
(6, 'Londoño', '2020-08-01', 'Calle 65', '103811405', 'alexlondon012@gmail.com', '2020-08-02', NULL, 'Cristian Londoño', '3122195522', 'CC', '2021-04-22 17:04:05', 3),
(7, 'Londoño', '2020-08-01', 'Calle 65', '1038114506', 'alexlondon013@gmail.com', '2020-08-02', NULL, 'Isabel Londoño', '3122195522', 'CC', '2021-04-22 17:04:05', 1),
(8, 'Londoño', '2020-08-01', 'Calle 65', '103811407', 'alexlondon014@gmail.com', '2020-08-02', NULL, 'Sara Londoño', '3122195522', 'CC', '2021-04-22 17:04:05', 2),
(9, 'Londoño', '2020-08-01', 'Calle 65', '1038114508', 'alexlondon0715@gmail.com', '2020-08-02', NULL, 'Elisa Londoño', '3122195522', 'CC', '2021-04-22 17:04:05', 3),
(10, 'Londoño', '2020-08-01', 'Calle 65', '1038114059', 'alexlondon0716@gmail.com', '2020-08-02', NULL, 'La vieja julia', '3122195522', 'CC', '2021-04-22 17:04:05', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `id` bigint(20) NOT NULL,
  `create_at` date DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `observacion` varchar(255) DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`id`, `create_at`, `descripcion`, `observacion`, `cliente_id`) VALUES
(1, '2020-11-28', 'Factura compra de TV de Oficina 32 pulgadas', 'Ninguna', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas_items`
--

CREATE TABLE `facturas_items` (
  `id` bigint(20) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `producto_id` bigint(20) DEFAULT NULL,
  `factura_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `facturas_items`
--

INSERT INTO `facturas_items` (`id`, `cantidad`, `producto_id`, `factura_id`) VALUES
(1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` bigint(20) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `create_at` date DEFAULT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  `nombre` varchar(60) NOT NULL,
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `codigo`, `create_at`, `descripcion`, `nombre`, `precio`) VALUES
(1, '001', '2020-11-28', 'Televisor 32\'\'', 'TV 32', 20000000),
(2, '002', '2020-11-28', 'Televisor 39\'\'', 'TV 39', 20000000),
(3, '004', '2020-11-28', 'Televisor 45\'\'', 'TV 45', 20000000),
(4, '005', '2020-11-28', 'Televisor 55\'\'', 'TV 55', 20000000),
(5, '006', '2020-11-28', 'Bicicleta', 'Bicicleta', 500000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `region`
--

CREATE TABLE `region` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(90) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `region`
--

INSERT INTO `region` (`id`, `nombre`) VALUES
(1, 'Sudamérica'),
(2, 'Norteamérica'),
(3, 'Centroamérica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `nombre`) VALUES
(2, 'ROLE_ADMIN'),
(1, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tec_categories`
--

CREATE TABLE `tec_categories` (
  `id` bigint(20) NOT NULL,
  `code` varchar(20) NOT NULL,
  `created_at` date NOT NULL,
  `enable` varchar(2) DEFAULT NULL,
  `group_category` varchar(255) DEFAULT NULL,
  `image` varchar(155) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tec_categories`
--

INSERT INTO `tec_categories` (`id`, `code`, `created_at`, `enable`, `group_category`, `image`, `name`, `updated_at`) VALUES
(1, '001', '2021-04-17', 'si', 'CAMISAS', NULL, 'CAMISAS MUJER SUAREZ', '2021-04-18 02:54:08'),
(2, '002', '2021-04-17', 'si', 'LICRAS', NULL, 'LICRA HOMBRE', '2021-04-18 02:54:08'),
(3, '003', '2021-04-17', 'si', 'CAMISAS', NULL, 'CAMISAS XL', '2021-04-18 02:54:08'),
(4, '004', '2021-04-17', 'si', 'MEDIAS', NULL, 'MEDIAS SL', '2021-04-18 02:54:08'),
(5, '005', '2021-04-17', 'si', 'ENTERIZOS', NULL, 'ENTERIZO RIGO GOGO', '2021-04-18 02:54:08'),
(6, '006', '2021-04-17', 'si', 'TERMOS', NULL, 'TERMO ADIDAS', '2021-04-18 02:54:08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `apellido`, `email`, `enabled`, `nombre`, `password`, `username`) VALUES
(1, 'Londoño', 'alexlondon07@gmail.com', b'1', 'Alexander', '$2a$10$twWA4w6Cj5GNZIcBOJsw8eGxN9ZMSIjasZF4aHl0WcWoGv0Ws55LO', 'alexlondon07'),
(2, 'Londoño', 'emi@gmail.com', b'1', 'emi', '$2a$10$twWA4w6Cj5GNZIcBOJsw8eGxN9ZMSIjasZF4aHl0WcWoGv0Ws55LO', 'emi');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_x_roles`
--

CREATE TABLE `usuarios_x_roles` (
  `usuario_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios_x_roles`
--

INSERT INTO `usuarios_x_roles` (`usuario_id`, `role_id`) VALUES
(1, 1),
(1, 2),
(2, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_47fj0e5fbq2l3b80ij3rn1qss` (`documento`),
  ADD UNIQUE KEY `UK_1c96wv36rk2hwui7qhjks3mvg` (`email`),
  ADD KEY `FKao1aopw24yff2kuudsv9qwnuh` (`region_id`);

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1qiuk10rfkovhlfpsk7oic0v8` (`cliente_id`);

--
-- Indices de la tabla `facturas_items`
--
ALTER TABLE `facturas_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdumnm9x14hjfp9fufn7q8389r` (`producto_id`),
  ADD KEY `FKnv8ijya20df661b0p6drqcx7u` (`factura_id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_h04wpyqwddobltuqq56cp6s05` (`codigo`);

--
-- Indices de la tabla `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ldv0v52e0udsh2h1rs0r0gw1n` (`nombre`);

--
-- Indices de la tabla `tec_categories`
--
ALTER TABLE `tec_categories`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_7y2ldvt1ioru1ni6tkypkb3u5` (`code`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_kfsp0s1tflm1cwlj8idhqsad0` (`email`),
  ADD UNIQUE KEY `UK_m2dvbwfge291euvmk6vkkocao` (`username`);

--
-- Indices de la tabla `usuarios_x_roles`
--
ALTER TABLE `usuarios_x_roles`
  ADD UNIQUE KEY `UKcjyuxg8fpnci7e39q36xwf92n` (`usuario_id`,`role_id`),
  ADD KEY `FK7bnk8mbcok7wmyvn5ku9iqs9j` (`role_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `facturas`
--
ALTER TABLE `facturas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `facturas_items`
--
ALTER TABLE `facturas_items`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `region`
--
ALTER TABLE `region`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tec_categories`
--
ALTER TABLE `tec_categories`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `FKao1aopw24yff2kuudsv9qwnuh` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`);

--
-- Filtros para la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD CONSTRAINT `FK1qiuk10rfkovhlfpsk7oic0v8` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`);

--
-- Filtros para la tabla `facturas_items`
--
ALTER TABLE `facturas_items`
  ADD CONSTRAINT `FKdumnm9x14hjfp9fufn7q8389r` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`),
  ADD CONSTRAINT `FKnv8ijya20df661b0p6drqcx7u` FOREIGN KEY (`factura_id`) REFERENCES `facturas` (`id`);

--
-- Filtros para la tabla `usuarios_x_roles`
--
ALTER TABLE `usuarios_x_roles`
  ADD CONSTRAINT `FK7bnk8mbcok7wmyvn5ku9iqs9j` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKcpctdbqqgeme7jpr1qny4t3lq` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);
COMMIT;