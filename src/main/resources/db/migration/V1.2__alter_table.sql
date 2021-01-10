alter table `sub_user` add  build_card varchar(5) comment '是否建档立卡';
alter table `sub_poor` add  head_of_house_id_card varchar(50) comment '户主身份证号码' after head_of_house_name;
alter table `sub_poor` add  semester varchar(50) not null comment '学段';