# Host: localhost  (Version 5.7.21)
# Date: 2019-02-24 18:26:06
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "categorias"
#

DROP TABLE IF EXISTS `categorias`;
CREATE TABLE `categorias` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

#
# Data for table "categorias"
#

INSERT INTO `categorias` VALUES (1,'LOS PLATOS MAS SUCULENTOS','platosFondo.jpg','PLATOS DE FONDO'),(2,'LAS MEJORES BEBIDAS','bebidas.jpg','BEBIDAS'),(3,'AÑADE MAS SABOR A TUS COMIDAS','adicionales.jpg','ADICONALES'),(4,'LOS POSTRES MAS DELICIOSOS','postres.jpg','POSTRES');

#
# Structure for table "clientes"
#

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `distrito` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

#
# Data for table "clientes"
#

INSERT INTO `clientes` VALUES (1,'ORELLANA MENDEZ','ADMIN','AV LAS PRADERAS','ATE','42541254','RODOLFO@GMAIL.COM',NULL,'RODOLFO'),(2,'CALDERON MONTAÑO','DIGIMON','AV LAS LUNAS','COMAS','23521202','MARCOS@GMAIL.COM',NULL,'MARCOS'),(6,'Sanchez Meza','rodericksn','Av las cumbres 176','Cieneguilla','48840031','rodericksa@hotmail.com','2019-02-09','Roderick');

#
# Structure for table "pedidos"
#

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE `pedidos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  `fecha_pedido` date DEFAULT NULL,
  `id_cliente` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdnomiluem4t3x66t6b9aher47` (`id_cliente`),
  CONSTRAINT `FKdnomiluem4t3x66t6b9aher47` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

#
# Data for table "pedidos"
#

INSERT INTO `pedidos` VALUES (1,'INABILITADO','2019-02-02',1),(2,'INABILITADO','2019-02-08',1),(3,'INABILITADO','2019-02-08',1),(4,'INABILITADO','2019-02-08',1),(5,'INABILITADO','2019-02-08',1),(6,'INABILITADO','2019-02-10',6),(7,'INABILITADO','2019-02-10',6),(8,'INABILITADO','2019-02-10',6),(9,'INABILITADO','2019-02-10',6),(10,'INABILITADO','2019-02-10',6),(11,'INABILITADO','2019-02-10',6),(12,'INABILITADO','2019-02-10',6),(13,'INABILITADO','2019-02-10',6),(14,'INABILITADO','2019-02-10',6),(15,'INABILITADO','2019-02-10',6),(16,'INABILITADO','2019-02-10',6),(17,'INABILITADO','2019-02-10',6),(18,'INABILITADO','2019-02-10',6),(19,'INABILITADO','2019-02-10',6),(20,'INABILITADO','2019-02-10',6),(21,'INABILITADO','2019-02-10',6),(22,'INABILITADO','2019-02-10',6);

#
# Structure for table "productos"
#

DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `id_categoria` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdtoa37luoxhhvbicrfiu5ygbj` (`id_categoria`),
  CONSTRAINT `FKdtoa37luoxhhvbicrfiu5ygbj` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

#
# Data for table "productos"
#

INSERT INTO `productos` VALUES (1,'INKA COLA PERSONAL','HELADA','inkaCola450ml.jpg','INKA COLA 1/2 LITRO',3,2),(2,'INKA COLA PARA COMPARTIR','HELADA','inkaCola1000ml.jpg','INKA COLA 1 LITRO',6,2),(3,'INKA COLA FAMILIAR','HELADA','inkaCola1500ml.jpg','INKA COLA 1 1/2 LITRO',8.5,2),(4,'COCA COLA PERSONAL','HELADA','cocaCola500ml.jpg','COCA COLA 1/2 LITRO',3,2),(5,'COCA COLA PARA COMPARTIR','HELADA','cocaCola1000ml.jpg','COCA COLA 1 LITRO',6,2),(6,'COCA COLA FAMILIAR','HELADA','cocaCola1500ml.jpg','COCA COLA 1 1/2 LITRO',8.5,2),(7,'LOMO DE RES CON PAPAS FRITAS Y ARROZ','CALIENTES','lomoSaltado.jpg','LOMO SALTADO',15.5,1),(8,'POLLO ADEREZADO CON CREMA A LA HUANCAINA Y ARROZ','CALIENTES','arrozConPollo.jpg','ARROZ CON POLLO',14.5,1),(9,'LOMO DE CABALLA, CAMOTE, CHOCLO, CANCHA Y DEMAS','MEDIO','cebicheMixto.jpg','CEBICHE',22.5,1),(10,'TEQUEÑOS EN SALSA DE GUACAMOLE','PORCION','tequeños.jpg','TEQUEÑOS',3.5,3),(11,'CORAZON DE RES','POR PALO','anticuchos.jpg','ANTICUCHO',5.5,3),(12,'TROZOS DE PERNIL','PORCION','chicharrones.jpg','CHICHARRONES',8.5,3),(13,'DULCE LIMEÑO','PORCION','arrozConLeche.jpg','ARROZ CON LECHE',6.8,4),(14,'DULCE LIMEÑO','3 AROS','picarones.jpg','PICARONES',3.5,4),(15,'HELADO DE FRESA O CHOCOLATE','PORCION','helados.jpg','HELADO 12 OZ.',5.5,4);

#
# Structure for table "pedido_detalle"
#

DROP TABLE IF EXISTS `pedido_detalle`;
CREATE TABLE `pedido_detalle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `precio` double NOT NULL,
  `id_pedido` bigint(20) DEFAULT NULL,
  `id_producto` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl49mqib582ysly8ypc2apayyx` (`id_pedido`),
  KEY `FK12bt2irvhowooq7gjphuwmgw5` (`id_producto`),
  CONSTRAINT `FK12bt2irvhowooq7gjphuwmgw5` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`),
  CONSTRAINT `FKl49mqib582ysly8ypc2apayyx` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

#
# Data for table "pedido_detalle"
#

INSERT INTO `pedido_detalle` VALUES (1,1,15.5,1,7),(2,2,6,1,1),(3,2,15.5,1,15),(4,2,12.5,7,13),(5,0,15.5,15,7),(6,0,3.5,15,10),(7,0,22.5,16,9),(8,0,3,16,4),(9,0,15.5,17,7),(10,0,5.5,17,15),(11,0,15.5,19,7),(12,0,15.5,20,7),(13,0,5.5,20,11),(14,0,15.5,21,7),(15,0,15.5,22,7),(16,0,8.5,22,6);
