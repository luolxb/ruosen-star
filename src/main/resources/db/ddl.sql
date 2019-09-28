-- 系统用户SQL
-- 2019-09-28
create table sys_user
(
    id        int(10) auto_increment comment 'ID',
    user_name varchar(32) not null comment '用户姓名',
    password  varchar(64) not null comment '用户密码',
    nick_name varchar(64) not null comment '昵称',
    age       int(2)      not null comment '年龄',
    sex       varchar(4)  null comment '性别',
    primary key (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='系统用户表';

-- 公共字段抽离
alter table sys_user
    add remark1 varchar(500) null comment '备用字段';

alter table sys_user
    add remark2 varchar(500) null;

alter table sys_user
    add remark3 varchar(500) null;

alter table sys_user
    add remark4 varchar(500) null;

alter table sys_user
    add remark5 varchar(500) null;

alter table sys_user
    add create_date date not null comment '创建时间';

alter table sys_user
    add create_by varchar(64) null comment '创建人';

alter table sys_user
    add update_date date null comment '修改时间';

alter table sys_user
    add update_by varchar(64) null comment '修改人';

alter table sys_user
    add is_delete varchar(2) default 'N' not null comment '是否删除 Y：删除 ；N：没有删除';

alter table sys_user
    add enable varchar(2) default 'Y' not null comment '是否启用 Y：是 ；N：否';




