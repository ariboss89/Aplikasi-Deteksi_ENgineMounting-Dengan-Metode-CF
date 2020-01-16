# Host: localhost  (Version: 5.5.8)
# Date: 2020-01-16 20:27:09
# Generator: MySQL-Front 5.3  (Build 4.81)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "detailriwayat"
#

DROP TABLE IF EXISTS `detailriwayat`;
CREATE TABLE `detailriwayat` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `idriwayat` varchar(20) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `jenismobil` varchar(20) DEFAULT NULL,
  `gejala` varchar(255) DEFAULT NULL,
  `keterangan` varchar(50) DEFAULT NULL,
  `nilai` float DEFAULT NULL,
  `cfold` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Data for table "detailriwayat"
#

INSERT INTO `detailriwayat` VALUES (1,'RWY-0001','ENGINE MOUNTING','AUTOMATIC','Getaran pada bodi mobil terasa lebih kencang dari biasanya','SANGAT YAKIN',1,''),(2,'RWY-0001','ENGINE MOUNTING','AUTOMATIC','Mesin di starter bunyi gluduk-gluduk','YAKIN',0.64,'1.0'),(3,'RWY-0002','ENGINE MOUNTING','AUTOMATIC','Getaran pada bodi mobil terasa lebih kencang dari biasanya','YAKIN',0.8,''),(4,'RWY-0002','ENGINE MOUNTING','AUTOMATIC','Mesin di starter bunyi gluduk-gluduk','CUKUP YAKIN',0.48,'0.896'),(5,'RWY-0003','ENGINE MOUNTING','AUTOMATIC','Getaran pada bodi mobil terasa lebih kencang dari biasanya','SANGAT YAKIN',1,''),(6,'RWY-0003','ENGINE MOUNTING','AUTOMATIC','Mesin di starter bunyi gluduk-gluduk','CUKUP YAKIN',0.48,'1.0'),(7,'RWY-0004','ENGINE MOUNTING','AUTOMATIC','Getaran pada bodi mobil terasa lebih kencang dari biasanya','CUKUP YAKIN',0.6,''),(8,'RWY-0004','ENGINE MOUNTING','AUTOMATIC','Ketika mobil di gigi 1, timbul bunyi dug dug','SEDIKIT YAKIN',0.32,'0.72800004');

#
# Structure for table "gejala"
#

DROP TABLE IF EXISTS `gejala`;
CREATE TABLE `gejala` (
  `Id` varchar(11) NOT NULL DEFAULT '',
  `nama` varchar(50) DEFAULT NULL,
  `jenismobil` varchar(11) DEFAULT NULL,
  `gejala` varchar(255) DEFAULT NULL,
  `nilai` float DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "gejala"
#

INSERT INTO `gejala` VALUES ('GJL-0001','ENGINE MOUNTING','AUTOMATIC','Getaran pada bodi mobil terasa lebih kencang dari biasanya',1),('GJL-0002','ENGINE MOUNTING','AUTOMATIC','Mesin di starter bunyi gluduk-gluduk',0.8),('GJL-0003','ENGINE MOUNTING','AUTOMATIC','Ketika mobil di gigi 1, timbul bunyi dug dug',0.8),('GJL-0004','ENGINE MOUNTING','AUTOMATIC','Ketika mobil melewati jalan kasar, terdengar bunyi tidak lazim dari ruang mesin',0.2),('GJL-0005','ENGINE MOUNTING','MANUAL','Getaran pada bodi mobil terasa kencang dari biasanya',1),('GJL-0006','ENGINE MOUNTING','MANUAL','Mesin distarter bunyi gluduk-gluduk',0.7),('GJL-0007','ENGINE MOUNTING','MANUAL','Ketika mobil di gigi 1, saat melepas kopling timbul bunyi dug dug',0.4),('GJL-0008','ENGINE MOUNTING','MANUAL','Ketika mobil melewati jalan kasar, terdengar bunyi tidak lazim dari ruang mesin',0.3);

#
# Structure for table "kerusakan"
#

DROP TABLE IF EXISTS `kerusakan`;
CREATE TABLE `kerusakan` (
  `Id` varchar(9) NOT NULL DEFAULT '',
  `nama` varchar(50) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `solusi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

#
# Data for table "kerusakan"
#

/*!40000 ALTER TABLE `kerusakan` DISABLE KEYS */;
INSERT INTO `kerusakan` VALUES ('KRSK-0001','ENGINE MOUNTING','Engine mounting adalah komponen yang bertugas sebagai \ndudukan mesin pada chasis atau rangka, pada \numumnya komponen ini terbuat dari bahan yang \nmemiliki elastisitas seperti karet','Periksakan segera mobil ke tempat servis agar\nengine mounting pada mobil segera di ganti');
/*!40000 ALTER TABLE `kerusakan` ENABLE KEYS */;

#
# Structure for table "login"
#

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(255) NOT NULL DEFAULT '',
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "login"
#


#
# Structure for table "pengguna"
#

DROP TABLE IF EXISTS `pengguna`;
CREATE TABLE `pengguna` (
  `nama` varchar(50) DEFAULT NULL,
  `usia` int(3) DEFAULT NULL,
  `username` varchar(11) NOT NULL DEFAULT '',
  `password` varchar(50) DEFAULT NULL,
  `konfirmasi` varchar(50) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "pengguna"
#

INSERT INTO `pengguna` VALUES ('ADMIN',99,'admin','manise','manise','ADMIN'),('ari ramadhan',23,'ariboss89','123456','123456','PENGGUNA'),('bening',22,'bening123','1234567','1234567','PENGGUNA'),('Joko',21,'joko21','1234567','1234567','PENGGUNA');

#
# Structure for table "riwayat"
#

DROP TABLE IF EXISTS `riwayat`;
CREATE TABLE `riwayat` (
  `Id` varchar(11) NOT NULL DEFAULT '',
  `nama` varchar(50) DEFAULT NULL,
  `jenismobil` varchar(11) DEFAULT NULL,
  `jumlahgejala` int(11) DEFAULT NULL,
  `nilai` float DEFAULT NULL,
  `kesimpulan` varchar(255) DEFAULT NULL,
  `solusi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Data for table "riwayat"
#

INSERT INTO `riwayat` VALUES ('RWY-0001','ENGINE MOUNTING','AUTOMATIC',2,1,'ENGINE MOUNTING MOBIL MATIC ANDA MENGALAMI KERUSAKAN SEBESAR 100.0%','PERIKSAKAN SEGERA MOBIL ANDA KE TEMPAT SERVIS AGAR ENGINE MOUNTING PADA MOBIL ANDA SEGERA DIGANTI'),('RWY-0002','ENGINE MOUNTING','AUTOMATIC',2,0.896,'ENGINE MOUNTING MOBIL MATIC ANDA MENGALAMI KERUSAKAN SEBESAR 89.600006%','PERIKSAKAN SEGERA MOBIL ANDA KE TEMPAT SERVIS AGAR ENGINE MOUNTING PADA MOBIL ANDA SEGERA DIGANTI'),('RWY-0003','ENGINE MOUNTING','AUTOMATIC',2,1,'ENGINE MOUNTING MOBIL MATIC ANDA MENGALAMI KERUSAKAN SEBESAR 100.0%','PERIKSAKAN SEGERA MOBIL ANDA KE TEMPAT SERVIS AGAR ENGINE MOUNTING PADA MOBIL ANDA SEGERA DIGANTI'),('RWY-0004','ENGINE MOUNTING','AUTOMATIC',2,0.728,'ENGINE MOUNTING MOBIL MATIC ANDA MENGALAMI KERUSAKAN SEBESAR 72.8%','PERIKSAKAN SEGERA MOBIL ANDA KE TEMPAT SERVIS AGAR ENGINE MOUNTING PADA MOBIL ANDA SEGERA DIGANTI');

#
# Structure for table "sementara"
#

DROP TABLE IF EXISTS `sementara`;
CREATE TABLE `sementara` (
  `Id` varchar(11) NOT NULL DEFAULT '',
  `idriwayat` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `jenismobil` varchar(255) DEFAULT NULL,
  `gejala` varchar(255) DEFAULT NULL,
  `keterangan` varchar(255) DEFAULT NULL,
  `nilai` float DEFAULT NULL,
  `cfold` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "sementara"
#

