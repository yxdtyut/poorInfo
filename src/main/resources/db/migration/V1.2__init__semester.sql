DROP TABLE IF EXISTS sub_semester;

CREATE TABLE `sub_semester` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `locked` varchar(20) DEFAULT NULL COMMENT '0代表未锁定,1代表锁定',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;

insert into sub_semester (name, locked) values ('2021春', '0');
insert into sub_semester (name, locked) values ('2021秋', '0');
insert into sub_semester (name, locked) values ('2022春', '0');
insert into sub_semester (name, locked) values ('2022秋', '0');
insert into sub_semester (name, locked) values ('2023春', '0');
insert into sub_semester (name, locked) values ('2023秋', '0');
insert into sub_semester (name, locked) values ('2024春', '0');
insert into sub_semester (name, locked) values ('2024秋', '0');
insert into sub_semester (name, locked) values ('2025春', '0');
insert into sub_semester (name, locked) values ('2025秋', '0');
insert into sub_semester (name, locked) values ('2026春', '0');
insert into sub_semester (name, locked) values ('2026秋', '0');
insert into sub_semester (name, locked) values ('2027春', '0');
insert into sub_semester (name, locked) values ('2027秋', '0');
insert into sub_semester (name, locked) values ('2028春', '0');
insert into sub_semester (name, locked) values ('2028秋', '0');
insert into sub_semester (name, locked) values ('2029春', '0');
insert into sub_semester (name, locked) values ('2029秋', '0');
insert into sub_semester (name, locked) values ('2030春', '0');
insert into sub_semester (name, locked) values ('2030秋', '0');
insert into sub_semester (name, locked) values ('2031春', '0');
insert into sub_semester (name, locked) values ('2031秋', '0');
insert into sub_semester (name, locked) values ('2032春', '0');
insert into sub_semester (name, locked) values ('2032秋', '0');
insert into sub_semester (name, locked) values ('2033春', '0');
insert into sub_semester (name, locked) values ('2033秋', '0');
insert into sub_semester (name, locked) values ('2034春', '0');
insert into sub_semester (name, locked) values ('2034秋', '0');
insert into sub_semester (name, locked) values ('2035春', '0');
insert into sub_semester (name, locked) values ('2035秋', '0');