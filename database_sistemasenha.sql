-- --------------------------------------------------------
-- Servidor:                     localhost
-- Versão do servidor:           5.6.13 - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para bd_hospital
CREATE DATABASE IF NOT EXISTS `bd_hospital` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bd_hospital`;

-- Copiando estrutura para tabela bd_hospital.tb01_senha
CREATE TABLE IF NOT EXISTS `tb01_senha` (
  `tb01_num` int(11) NOT NULL,
  `id01_tipo` varchar(50) NOT NULL,
  `id01_status` varchar(50) DEFAULT NULL,
  `tb01_data` date DEFAULT NULL,
  `tb01_hora` time DEFAULT NULL,
  PRIMARY KEY (`tb01_num`,`id01_tipo`),
  KEY `FK_tb01_senha_tb03_status` (`id01_status`),
  CONSTRAINT `FK_tb01_senha_tb03_status` FOREIGN KEY (`id01_status`) REFERENCES `tb03_status` (`id03_status`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela bd_hospital.tb02_tipo
CREATE TABLE IF NOT EXISTS `tb02_tipo` (
  `id02_tipo` varchar(50) DEFAULT NULL,
  `tb02_descricao` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

-- Copiando estrutura para tabela bd_hospital.tb03_status
CREATE TABLE IF NOT EXISTS `tb03_status` (
  `id03_status` varchar(50) NOT NULL,
  `tb03_descricao` varchar(50) NOT NULL,
  PRIMARY KEY (`id03_status`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
