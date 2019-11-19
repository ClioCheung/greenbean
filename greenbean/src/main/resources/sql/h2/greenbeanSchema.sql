DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority`
(
    `user_id`   int(11)     NOT NULL COMMENT '用户ID，参照t_user表用户ID字段',
    `authority` varchar(45) NOT NULL COMMENT '权限',
    PRIMARY KEY (`user_id`, `authority`)
);

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
    `id`       int(11)      NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `username` varchar(45)  NOT NULL COMMENT '用户名',
    `password` varchar(100) NOT NULL COMMENT '用户密码',
    `enabled`  varchar(45)  NOT NULL COMMENT '用户权限',
    PRIMARY KEY (`id`),
    UNIQUE KEY `username_UNIQUE` (`username`)
);