DROP TABLE IF EXISTS admin;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(30) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `psw` varchar(255) NOT NULL,
  `role` int(10) DEFAULT NULL COMMENT '0代表管理员,1代表普通用户',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_only` (`account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS sub_poor;

CREATE TABLE `sub_poor` (
  `id` varchar(255) NOT NULL DEFAULT '',
  `province` varchar(255) DEFAULT '陕西省',
  `county` varchar(255) DEFAULT '米脂县',
  `village` varchar(255) DEFAULT NULL,
  `cun` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `id_card` varchar(32) DEFAULT NULL,
  `build_card` varchar(5) DEFAULT NULL COMMENT '是否建档立卡',
  `six_fifteen` varchar(10) DEFAULT NULL COMMENT '只能写是或者否',
  `head_of_house_num` varchar(50) DEFAULT NULL,
  `head_of_house_name` varchar(50) DEFAULT NULL,
  `head_of_house_id_card` varchar(50) DEFAULT NULL COMMENT '户主身份证号码',
  `head_of_house_tel` varchar(50) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `study_level` varchar(50) DEFAULT NULL,
  `grade` varchar(30) DEFAULT NULL,
  `clazz` varchar(50) DEFAULT NULL,
  `student_number` varchar(50) DEFAULT NULL COMMENT '学籍号',
  `study_way` varchar(50) DEFAULT NULL COMMENT '就读方式',
  `if_disability` varchar(10) DEFAULT NULL COMMENT '只能写是或者否',
  `disability_number` varchar(50) DEFAULT NULL,
  `not_in_school_reason` varchar(255) DEFAULT NULL,
  `poor_type` varchar(50) DEFAULT NULL,
  `if_village` varchar(50) DEFAULT NULL,
  `if_county` varchar(50) DEFAULT NULL,
  `if_province` varchar(50) DEFAULT NULL,
  `this_enjoy` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '本学期是否享受米脂资助 只能写是或者否',
  `account` varchar(255) DEFAULT NULL COMMENT '账号',
  `semester` varchar(50) NOT NULL COMMENT '学段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idcard` (`id_card`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS sub_subsidize;

CREATE TABLE `sub_subsidize` (
  `poor_id` varchar(255) NOT NULL,
  `subsidize_project` varchar(50) DEFAULT NULL COMMENT '资助项目',
  `subsidize_money` decimal(50,2) DEFAULT NULL COMMENT '补助金额',
  `nutrimeal_money` decimal(50,2) DEFAULT NULL COMMENT '营养餐金额',
  PRIMARY KEY (`poor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS sub_user;

CREATE TABLE `sub_user` (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `school` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL COMMENT '年级',
  `clazz` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '班级',
  `student_name` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `sex` varchar(5) DEFAULT NULL COMMENT '男或者女',
  `student_number` varchar(255) DEFAULT NULL COMMENT '学籍号',
  `school_uniforms` varchar(5) DEFAULT NULL COMMENT '是否享受校服',
  `model` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '型号',
  `homework` varchar(5) DEFAULT NULL COMMENT '是否享受作业本',
  `study_tool` varchar(5) DEFAULT NULL COMMENT '是否享受学具',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;