CREATE TABLE `data` (
  `id` bigint(20) NOT NULL auto_increment,
  `type` int(11) NOT NULL,
  `key` varchar(256) character set latin1 NOT NULL,
  `json` longtext character set latin1 NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
