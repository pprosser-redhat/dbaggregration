CREATE TABLE `alerts` (
  `areference` int(11) DEFAULT NULL,
  `anumber` int(11) NOT NULL,
  `thetime` datetime DEFAULT NULL,
  `id` varchar(45) NOT NULL,
  `refdescription` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
