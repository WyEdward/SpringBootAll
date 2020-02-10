CREATE TABLE permission(
	id INT NOT NULL,
	url VARCHAR(64) NULL,
	NAME VARCHAR(32) NULL
);

ALTER TABLE permission MODIFY url VARCHAR(64) NULL COMMENT 'url地址';
ALTER TABLE permission MODIFY NAME VARCHAR(32) NULL COMMENT 'url描述';

CREATE TABLE USER(
	id INT NOT NULL,
	username VARCHAR NULL,
	PASSWORD VARCHAR NULL,
	create_time DATA NULL,
	STATUS VARCHAR NULL DEFAULT '1'
);
CREATE TABLE role(
	id INT NOT NULL,
	NAME VARCHAR(64) NULL COMMENT '角色名称',
	memo VARCHAR(64) NULL COMMENT '角色描述'
);

CREATE TABLE role_permission(
	rid INT NULL COMMENT '映射角色表的id',
	pid INT NULL COMMENT '映射权限表的id'
);

CREATE TABLE user_role(
	uid INT NULL COMMENT '映射用户表的id',
	rid INT NULL COMMENT '映射角色表的id'
);

INSERT INTO role VALUES(1,'admin','超级管理员');
INSERT INTO role VALUES(2,'test','测试账户');

INSERT INTO permission VALUES(1, '/user', 'user:user');
INSERT INTO permission VALUES(2, '/user/add', 'user:add');
INSERT INTO permission VALUES(3, '/user/delete', 'user:delete');

INSERT INTO role_permission VALUES(1,1);
INSERT INTO role_permission VALUES(1,2);
INSERT INTO role_permission VALUES(1,3);
INSERT INTO role_permission VALUES(2,1);

INSERT INTO user_role VALUES(1,1);
INSERT INTO user_role VALUES(2,2);