create database if not exists `book_manager`;

USE `springjpa_db`;

INSERT INTO `region` (`id`, `nombre`) VALUES(1, 'Sudamérica');
INSERT INTO `region` (`id`, `nombre`) VALUES(2, 'Norteamérica');
INSERT INTO `region` (`id`, `nombre`) VALUES(3, 'Centroamérica');

INSERT INTO `roles` (`nombre`) VALUES('ROLE_USER');
INSERT INTO `roles` (`nombre`) VALUES('ROLE_ADMIN');

INSERT INTO `usuarios` (`id`, `apellido`, `email`, `enabled`, `nombre`, `password`, `username`) VALUES ('1', 'Londoño', 'alexlondon07@gmail.com', b'1', 'Alexander', '$2a$10$twWA4w6Cj5GNZIcBOJsw8eGxN9ZMSIjasZF4aHl0WcWoGv0Ws55LO', 'alexlondon07');
INSERT INTO `usuarios` (`id`, `apellido`, `email`, `enabled`, `nombre`, `password`, `username`) VALUES ('2', 'Londoño', 'emi@gmail.com', b'1', 'emi', '$2a$10$twWA4w6Cj5GNZIcBOJsw8eGxN9ZMSIjasZF4aHl0WcWoGv0Ws55LO', 'emi');

INSERT INTO `usuarios_x_roles` (`usuario_id`,`role_id`) VALUES(1,1);
INSERT INTO `usuarios_x_roles` (`usuario_id`,`role_id`) VALUES(1,2);
INSERT INTO `usuarios_x_roles` (`usuario_id`,`role_id`) VALUES(2,1);

INSERT INTO `clientes` (`region_id`, `apellido`, `create_at`, `direccion`, `documento`, `email`, `fecha_nacimiento`, `nombre`, `telefono`, `tipo_documento`) VALUES (1,'Londoño', '2020-08-01', 'Calle 65', '1038114501', 'alexlondon07@gmail.com', '2020-08-02', 'Alexander Londoño', '3122195522', 'CC');
INSERT INTO `clientes` (`region_id`, `apellido`, `create_at`, `direccion`, `documento`, `email`, `fecha_nacimiento`, `nombre`, `telefono`, `tipo_documento`) VALUES (2,'Londoño', '2020-08-01', 'Calle 65', '1038114052', 'alexlondon08@gmail.com', '2020-08-02', 'Emiliana Londoño', '3122195522', 'CC');
INSERT INTO `clientes` (`region_id`,`apellido`, `create_at`, `direccion`, `documento`, `email`, `fecha_nacimiento`, `nombre`, `telefono`, `tipo_documento`) VALUES (3,'Londoño', '2020-08-01', 'Calle 65', '1038114503', 'alexlondon09@gmail.com', '2020-08-02', 'Aracelly Londoño', '3122195522', 'CC');
INSERT INTO `clientes` (`region_id`, `apellido`, `create_at`, `direccion`, `documento`, `email`, `fecha_nacimiento`, `nombre`, `telefono`, `tipo_documento`) VALUES (1,'Londoño', '2020-08-01', 'Calle 65', '103811404', 'alexlondon010@gmail.com', '2020-08-02', 'Jesus Londoño', '3122195522', 'CC');
INSERT INTO `clientes` (`region_id`,`apellido`, `create_at`, `direccion`, `documento`, `email`, `fecha_nacimiento`, `nombre`, `telefono`, `tipo_documento`) VALUES (2,'Londoño', '2020-08-01', 'Calle 65', '1038114505', 'alexlondon011@gmail.com', '2020-08-02', 'Estefany Londoño', '3122195522', 'CC');
INSERT INTO `clientes` (`region_id`, `apellido`, `create_at`, `direccion`, `documento`, `email`, `fecha_nacimiento`, `nombre`, `telefono`, `tipo_documento`) VALUES (3,'Londoño', '2020-08-01', 'Calle 65', '103811405', 'alexlondon012@gmail.com', '2020-08-02', 'Cristian Londoño', '3122195522', 'CC');
INSERT INTO `clientes` (`region_id`,`apellido`, `create_at`, `direccion`, `documento`, `email`, `fecha_nacimiento`, `nombre`, `telefono`, `tipo_documento`) VALUES (1,'Londoño', '2020-08-01', 'Calle 65', '1038114506', 'alexlondon013@gmail.com', '2020-08-02', 'Isabel Londoño', '3122195522', 'CC');
INSERT INTO `clientes` (`region_id`, `apellido`, `create_at`, `direccion`, `documento`, `email`, `fecha_nacimiento`, `nombre`, `telefono`, `tipo_documento`) VALUES (2,'Londoño', '2020-08-01', 'Calle 65', '103811407', 'alexlondon014@gmail.com', '2020-08-02', 'Sara Londoño', '3122195522', 'CC');
INSERT INTO `clientes` (`region_id`,`apellido`, `create_at`, `direccion`, `documento`, `email`, `fecha_nacimiento`, `nombre`, `telefono`, `tipo_documento`) VALUES (3,'Londoño', '2020-08-01', 'Calle 65', '1038114508', 'alexlondon0715@gmail.com', '2020-08-02', 'Elisa Londoño', '3122195522', 'CC');
INSERT INTO `clientes` (`region_id`, `apellido`, `create_at`, `direccion`, `documento`, `email`, `fecha_nacimiento`, `nombre`, `telefono`, `tipo_documento`) VALUES (1,'Londoño', '2020-08-01', 'Calle 65', '1038114059', 'alexlondon0716@gmail.com', '2020-08-02', 'La vieja julia', '3122195522', 'CC');

INSERT INTO `productos` ( `codigo`, `create_at`, `descripcion`, `nombre`, `precio`) VALUES ('001', '2020-11-28', 'Televisor 32\'\'', 'TV 32', '20000000');
INSERT INTO `productos` ( `codigo`, `create_at`, `descripcion`, `nombre`, `precio`) VALUES ('002', '2020-11-28', 'Televisor 39\'\'', 'TV 39', '20000000');
INSERT INTO `productos` ( `codigo`, `create_at`, `descripcion`, `nombre`, `precio`) VALUES ('004', '2020-11-28', 'Televisor 45\'\'', 'TV 45', '20000000');
INSERT INTO `productos` ( `codigo`, `create_at`, `descripcion`, `nombre`, `precio`) VALUES ('005', '2020-11-28', 'Televisor 55\'\'', 'TV 55', '20000000');
INSERT INTO `productos` ( `codigo`, `create_at`, `descripcion`, `nombre`, `precio`) VALUES ('006', '2020-11-28', 'Bicicleta', 'Bicicleta', '500000');




INSERT INTO `facturas` ( `create_at`, `descripcion`, `observacion`, `cliente_id`) VALUES ('2020-11-28', 'Factura compra de TV de Oficina 32 pulgadas', 'Ninguna', '1');
INSERT INTO `facturas_items` (`cantidad`, `producto_id`, `factura_id`) VALUES ( '1', '1', '1');


INSERT INTO `tec_categories` (`code`, `created_at`, `enable`, `group_category`, `image`, `name`, `updated_at`) VALUES ('001', '2021-04-17', 'si', 'CAMISAS', NULL, 'CAMISAS MUJER SUAREZ', '2021-04-17 21:54:08');
INSERT INTO `tec_categories` (`code`, `created_at`, `enable`, `group_category`, `image`, `name`, `updated_at`) VALUES ('002', '2021-04-17', 'si', 'LICRAS', NULL, 'LICRA HOMBRE', '2021-04-17 21:54:08');
INSERT INTO `tec_categories` (`code`, `created_at`, `enable`, `group_category`, `image`, `name`, `updated_at`) VALUES ('003', '2021-04-17', 'si', 'CAMISAS', NULL, 'CAMISAS XL', '2021-04-17 21:54:08');
INSERT INTO `tec_categories` (`code`, `created_at`, `enable`, `group_category`, `image`, `name`, `updated_at`) VALUES ('004', '2021-04-17', 'si', 'MEDIAS', NULL, 'MEDIAS SL', '2021-04-17 21:54:08');
INSERT INTO `tec_categories` (`code`, `created_at`, `enable`, `group_category`, `image`, `name`, `updated_at`) VALUES ('005', '2021-04-17', 'si', 'ENTERIZOS', NULL, 'ENTERIZO RIGO GOGO', '2021-04-17 21:54:08');
INSERT INTO `tec_categories` (`code`, `created_at`, `enable`, `group_category`, `image`, `name`, `updated_at`) VALUES ('006', '2021-04-17', 'si', 'TERMOS', NULL, 'TERMO ADIDAS', '2021-04-17 21:54:08');