#后台管理系统
create database 2201tradedb;

#-----------权限管理---------------
#部门表
create table department(
id bigint primary key auto_increment comment '主键',
dep_name varchar(10) not null unique comment '部门名称',
dep_num int default 0 comment '部门人数',
create_time datetime not null comment '创建时间',
update_time datetime not null comment '修改时间',
status tinyint default 0 comment '状态',
del_flag tinyint default 0 comment '删除标识'
) comment '部门表';

#职工表
create table employee(
id bigint primary key auto_increment comment '主键',
username varchar(20) not null unique comment '用户名',
password char(64) not null comment '密码',
dep_id bigint not null comment '部门id',
name varchar(10) not null comment '员工姓名',
age int comment '年龄',
sex int comment '性别',
header text comment '头像',
create_time datetime not null comment '创建时间',
update_time datetime not null comment '修改时间',
status tinyint default 0 comment '状态',
del_flag tinyint default 0 comment '删除标识'
) comment '职工表';

#职工-角色-中间表
create table emp_role_table(
eid bigint not null comment '职工的id',
rid bigint not null comment '角色id',
create_time datetime not null comment '创建时间',
update_time datetime not null comment '修改时间',
status tinyint default 0 comment '状态',
del_flag tinyint default 0 comment '删除标识',
primary key(eid, rid) #联合主键
);

#角色表
create table role(
id bigint primary key auto_increment comment '主键',
dep_id bigint not null comment '部门id',
role_name varchar(10) not null unique comment '角色名称',
role_tag varchar(20) not null unique comment '角色标识',
create_time datetime not null comment '创建时间',
update_time datetime not null comment '修改时间',
status tinyint default 0 comment '状态',
del_flag tinyint default 0 comment '删除标识'
) comment '角色表';

#角色-权限-中间表
create table role_power_table(
rid bigint not null comment '角色id',
pid bigint not null comment '权限id',
create_time datetime not null comment '创建时间',
update_time datetime not null comment '修改时间',
status tinyint default 0 comment '状态',
del_flag tinyint default 0 comment '删除标识',
primary key(rid, pid)
);

#权限表 - 权限树
create table power(
id bigint primary key auto_increment comment '主键',
pid bigint comment '父级权限的id',
power_name varchar(20) not null comment '权限名称',
power_tag varchar(20) comment '权限的标识',
power_resource text comment '权限资源',
type tinyint default 1 comment '权限的类型 1-一级权限 2-二级权限 3-三级权限（页面的各种按钮）',
create_time datetime not null comment '创建时间',
update_time datetime not null comment '修改时间',
status tinyint default 0 comment '状态',
del_flag tinyint default 0 comment '删除标识'
);


#添加超级管理员
insert into employee value (
null, "admin", "123456", "超级管理员", null, null, null, now(), now(), 0, 0
)


#新建微信用户表
create table user(
                     id bigint primary key auto_increment comment '用户id',
                     open_id varchar(50) not null unique comment '微信的开放id',
                     session_key varchar(50) not null comment '微信用户的数据加密密钥',
                     header text comment '微信头像',
                     nick_name varchar(20) comment '用户昵称',
                     create_time datetime not null comment '创建时间',
                     update_time datetime not null comment '最后修改时间',
                     status int not null comment '状态',
                     del_flag int not null comment '删除标识'
)