CREATE TABLE `tb_paint`
(
    `paint_id`    INT(10) NOT NULL AUTO_INCREMENT,
    `paint_name`  VARCHAR(10)   NOT NULL,
    `user_id`     INT(10) NOT NULL,
    `create_time` DATE          NOT NULL,
    `last_time`   DATE          NOT NULL,
    `json_data`   VARCHAR(1024) NOT NULL,
    `img_path`    VARCHAR(30)   NOT NULL,
    UNIQUE KEY `paint_id`(`paint_id`)
)ENGINE=INNODB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8



CREATE TABLE `tb_user`
(
    `user_id`  int(10) NOT NULL AUTO_INCREMENT,
    `username` varchar(10) NOT NULL,
    `password` varchar(20) NOT NULL,
    `email`    varchar(25) NOT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8

CREATE TABLE `tb_user_have_paint`
(
    `have_id`  INT(10) NOT NULL AUTO_INCREMENT,
    `user_id`  INT(10) NOT NULL,
    `paint_id` INT(10) NOT NULL,
    UNIQUE KEY `have_id`(`have_id`)
)ENGINE=INNODB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8

CREATE TABLE `tb_user_collect_paint`
(
    `collect_id` INT(10) NOT NULL AUTO_INCREMENT,
    `user_id`    INT(10) NOT NULL,
    `publish_id` INT(10) NOT NULL,
    UNIQUE KEY `collect_id`(`collect_id`)
)ENGINE=INNODB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8

CREATE TABLE `tb_user_abandon_paint`
(
    `abandon_id` INT(10) NOT NULL AUTO_INCREMENT,
    `user_id`    INT(10) NOT NULL,
    `paint_id`   INT(10) NOT NULL,
    UNIQUE KEY `abandon_id`(`abandon_id`)
)ENGINE=INNODB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8

CREATE TABLE `tb_publish`
(
    `publish_id`   INT(10) NOT NULL AUTO_INCREMENT,
    `paint_name`   VARCHAR(10)   NOT NULL,
    `user_id`      INT(10) NOT NULL,
    `username`     varchar(10)   NOT NULL,
    `collect_num`  INT(10) NOT NULL,
    `like_num`     INT(10) NOT NULL,
    `publish_time` DATE          NOT NULL,
    `json_data`    VARCHAR(1024) NOT NULL,
    `img_path`     VARCHAR(30)   NOT NULL,
    UNIQUE KEY `publish_id`(`publish_id`)
)ENGINE=INNODB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8