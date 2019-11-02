-- 系统用户表
create table sys_user
(
    id        int(10) auto_increment comment 'ID',
    name      varchar(32) not null comment '用户姓名',
    password  varchar(64) not null comment '用户密码',
    nick_name varchar(64) not null comment '昵称',
    age       int(2)      not null comment '年龄',
    sex       varchar(4)  null comment '性别',
    phone     varchar(11) null comment '电话',
    email     varchar(64) null comment '邮箱',
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
    add update_date dateTime null comment '修改时间';

alter table sys_user
    add update_by varchar(64) null comment '修改人';

alter table sys_user
    add is_delete varchar(2) default 'N' not null comment '是否删除 Y：删除 ；N：没有删除';

alter table sys_user
    add enable varchar(2) default 'Y' not null comment '是否启用 Y：是 ；N：否';


-- 角色表
create table sys_role
(
    id        int auto_increment,
    role_code varchar(32) null,
    role_name varchar(32) null,
    constraint sys_role_pk
        primary key (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '角色表';

-- 公共字段抽离
alter table sys_role
    add remark1 varchar(500) null comment '备用字段';

alter table sys_role
    add remark2 varchar(500) null;

alter table sys_role
    add remark3 varchar(500) null;

alter table sys_role
    add remark4 varchar(500) null;

alter table sys_role
    add remark5 varchar(500) null;

alter table sys_role
    add create_date dateTime not null comment '创建时间';

alter table sys_role
    add create_by varchar(64) null comment '创建人';

alter table sys_role
    add update_date dateTime null comment '修改时间';

alter table sys_role
    add update_by varchar(64) null comment '修改人';

alter table sys_role
    add is_delete varchar(2) default 'N' not null comment '是否删除 Y：删除 ；N：没有删除';

alter table sys_role
    add enable varchar(2) default 'Y' not null comment '是否启用 Y：是 ；N：否';


-- 用户角色关联表
create table sys_user_role
(
    id      int auto_increment,
    role_id int not null,
    user_id int not null,
    constraint sys_user_role_pk
        primary key (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '用户角色关联表';

-- 公共字段抽离
alter table sys_user_role
    add remark1 varchar(500) null comment '备用字段';

alter table sys_user_role
    add remark2 varchar(500) null;

alter table sys_user_role
    add remark3 varchar(500) null;

alter table sys_user_role
    add remark4 varchar(500) null;

alter table sys_user_role
    add remark5 varchar(500) null;

alter table sys_user_role
    add create_date dateTime not null comment '创建时间';

alter table sys_user_role
    add create_by varchar(64) null comment '创建人';

alter table sys_user_role
    add update_date dateTime null comment '修改时间';

alter table sys_user_role
    add update_by varchar(64) null comment '修改人';

alter table sys_user_role
    add is_delete varchar(2) default 'N' not null comment '是否删除 Y：删除 ；N：没有删除';

alter table sys_user_role
    add enable varchar(2) default 'Y' not null comment '是否启用 Y：是 ；N：否';

-- 菜单表
create table sys_menu
(
    id          int auto_increment,
    menu_code   varchar(32)            null comment '菜单编号',
    menu_name   varchar(32)            null comment '菜单名称',
    url         varchar(64)            null comment '路径',
    levels      varchar(16)            null comment '菜单类型 1：菜单 2：按钮',
    parent_code varchar(32)            null comment '父菜单编号',
    sort_num    int                    null comment '排序标识',
    icon        varchar(64)            null comment '图标',
    is_public   varchar(2) DEFAULT 'N' null comment '是否公开 Y:是 N：否',
    constraint sys_menu_pk
        primary key (id)
)
    comment '菜单表';

-- 公共字段抽离
alter table sys_menu
    add remark1 varchar(500) null comment '备用字段';

alter table sys_menu
    add remark2 varchar(500) null;

alter table sys_menu
    add remark3 varchar(500) null;

alter table sys_menu
    add remark4 varchar(500) null;

alter table sys_menu
    add remark5 varchar(500) null;

alter table sys_menu
    add create_date dateTime not null comment '创建时间';

alter table sys_menu
    add create_by varchar(64) null comment '创建人';

alter table sys_menu
    add update_date dateTime null comment '修改时间';

alter table sys_menu
    add update_by varchar(64) null comment '修改人';

alter table sys_menu
    add is_delete varchar(2) default 'N' not null comment '是否删除 Y：删除 ；N：没有删除';

alter table sys_menu
    add enable varchar(2) default 'Y' not null comment '是否启用 Y：是 ；N：否';

-- 角色菜单关联表
create table sys_role_menu
(
    id      int auto_increment,
    role_id int null,
    menu_id int null,
    constraint sys_role_menu_pk
        primary key (id)
);

create index sys_menu_code_index
    on sys_menu (menu_code);

create index sys_menu_name_index
    on sys_menu (menu_name);


-- 公共字段抽离
alter table sys_role_menu
    add remark1 varchar(500) null comment '备用字段';

alter table sys_role_menu
    add remark2 varchar(500) null;

alter table sys_role_menu
    add remark3 varchar(500) null;

alter table sys_role_menu
    add remark4 varchar(500) null;

alter table sys_role_menu
    add remark5 varchar(500) null;

alter table sys_role_menu
    add create_date dateTime not null comment '创建时间';

alter table sys_role_menu
    add create_by varchar(64) null comment '创建人';

alter table sys_role_menu
    add update_date dateTime null comment '修改时间';

alter table sys_role_menu
    add update_by varchar(64) null comment '修改人';

alter table sys_role_menu
    add is_delete varchar(2) default 'N' not null comment '是否删除 Y：删除 ；N：没有删除';

alter table sys_role_menu
    add enable varchar(2) default 'Y' not null comment '是否启用 Y：是 ；N：否';


-- 品类表
create table category
(
    id            int auto_increment,
    category_name varchar(64) null comment '品类名称',
    category_code varchar(64) null comment '品类编码',
    parent_code   varchar(64) null comment '父级编码',
    constraint category_pk
        primary key (id)
)
    comment '品类表';

create index category_code_index
    on category (category_code);

create index category_name_index
    on category (category_name);


-- 公共字段抽离
alter table category
    add remark1 varchar(500) null comment '备用字段';

alter table category
    add remark2 varchar(500) null;

alter table category
    add remark3 varchar(500) null;

alter table category
    add remark4 varchar(500) null;

alter table category
    add remark5 varchar(500) null;

alter table category
    add create_date dateTime not null comment '创建时间';

alter table category
    add create_by varchar(64) null comment '创建人';

alter table category
    add update_date dateTime null comment '修改时间';

alter table category
    add update_by varchar(64) null comment '修改人';

alter table category
    add is_delete varchar(2) default 'N' not null comment '是否删除 Y：删除 ；N：没有删除';

alter table category
    add enable varchar(2) default 'Y' not null comment '是否启用 Y：是 ；N：否';

-- 商品表
create table product
(
    id             int auto_increment
        primary key,
    product_name   varchar(64)  null comment '商品名称',
    product_code   varchar(64)  null comment '商品编码',
    `describe`     varchar(255) null comment '描述',
    `status`       int(11)      null comment '状态',
    product_price  double       null comment '商品价格',
    product_detail varchar(500) null comment '商品详情'
)
    comment '商品类';


-- 公共字段抽离
alter table product
    add remark1 varchar(500) null comment '备用字段';

alter table product
    add remark2 varchar(500) null;

alter table product
    add remark3 varchar(500) null;

alter table product
    add remark4 varchar(500) null;

alter table product
    add remark5 varchar(500) null;

alter table product
    add create_date dateTime not null comment '创建时间';

alter table product
    add create_by varchar(64) null comment '创建人';

alter table product
    add update_date dateTime null comment '修改时间';

alter table product
    add update_by varchar(64) null comment '修改人';

alter table product
    add is_delete varchar(2) default 'N' not null comment '是否删除 Y：删除 ；N：没有删除';

alter table product
    add enable varchar(2) default 'Y' not null comment '是否启用 Y：是 ；N：否';


-- 品类商品关联表
create table category_product
(
    id          int auto_increment
        primary key,
    category_id int null,
    product_id  int null
)
    comment '品类商品关联表';


-- 公共字段抽离
alter table category_product
    add remark1 varchar(500) null comment '备用字段';

alter table category_product
    add remark2 varchar(500) null;

alter table category_product
    add remark3 varchar(500) null;

alter table category_product
    add remark4 varchar(500) null;

alter table category_product
    add remark5 varchar(500) null;

alter table category_product
    add create_date dateTime not null comment '创建时间';

alter table category_product
    add create_by varchar(64) null comment '创建人';

alter table category_product
    add update_date dateTime null comment '修改时间';

alter table category_product
    add update_by varchar(64) null comment '修改人';

alter table category_product
    add is_delete varchar(2) default 'N' not null comment '是否删除 Y：删除 ；N：没有删除';

alter table category_product
    add enable varchar(2) default 'Y' not null comment '是否启用 Y：是 ；N：否';


-- 附件表
create table attachment
(
    id              int auto_increment
        primary key,
    attachment_key  varchar(255) null,
    attachment_size int          null,
    attachment_url  varchar(255) null
)
    comment '附件表';


-- 公共字段抽离
alter table attachment
    add remark1 varchar(500) null comment '备用字段';

alter table attachment
    add remark2 varchar(500) null;

alter table attachment
    add remark3 varchar(500) null;

alter table attachment
    add remark4 varchar(500) null;

alter table attachment
    add remark5 varchar(500) null;

alter table attachment
    add create_date dateTime not null comment '创建时间';

alter table attachment
    add create_by varchar(64) null comment '创建人';

alter table attachment
    add update_date dateTime null comment '修改时间';

alter table attachment
    add update_by varchar(64) null comment '修改人';

alter table attachment
    add is_delete varchar(2) default 'N' not null comment '是否删除 Y：删除 ；N：没有删除';

alter table attachment
    add enable varchar(2) default 'Y' not null comment '是否启用 Y：是 ；N：否';


-- 附件关联表
create table attachment_associated
(
    id              int auto_increment,
    module_id       int null,
    attachment_id   int null,
    module_type     int null,
    attachment_type int null,
    constraint attachment_associated_pk
        primary key (id)
)
    comment '附件关联表';


-- 公共字段抽离
alter table attachment_associated
    add remark1 varchar(500) null comment '备用字段';

alter table attachment_associated
    add remark2 varchar(500) null;

alter table attachment_associated
    add remark3 varchar(500) null;

alter table attachment_associated
    add remark4 varchar(500) null;

alter table attachment_associated
    add remark5 varchar(500) null;

alter table attachment_associated
    add create_date dateTime not null comment '创建时间';

alter table attachment_associated
    add create_by varchar(64) null comment '创建人';

alter table attachment_associated
    add update_date dateTime null comment '修改时间';

alter table attachment_associated
    add update_by varchar(64) null comment '修改人';

alter table attachment_associated
    add is_delete varchar(2) default 'N' not null comment '是否删除 Y：删除 ；N：没有删除';

alter table attachment_associated
    add enable varchar(2) default 'Y' not null comment '是否启用 Y：是 ；N：否';


-- 公共序列表
create table common_sequence
(
    id int auto_increment,
    constraint common_sequence_pk
        primary key (id)
)
    comment '序列表';

alter table common_sequence
    add code varchar(64) null;


-- 系统数据字典
create table sys_dict
(
    id         int auto_increment,
    code       varchar(32)  null comment '字典值',
    value      varchar(64)  null comment '字典值',
    parent_id  int          null comment '父级ID',
    type       int          null comment '0 父级   1 子级',
    `describe` varchar(256) null comment '描述',
    constraint sys_dict_pk
        primary key (id)
)
    comment '系统数据字典';


-- 公共字段抽离
alter table sys_dict
    add remark1 varchar(500) null comment '备用字段';

alter table sys_dict
    add remark2 varchar(500) null;

alter table sys_dict
    add remark3 varchar(500) null;

alter table sys_dict
    add remark4 varchar(500) null;

alter table sys_dict
    add remark5 varchar(500) null;

alter table sys_dict
    add create_date dateTime not null comment '创建时间';

alter table sys_dict
    add create_by varchar(64) null comment '创建人';

alter table sys_dict
    add update_date dateTime null comment '修改时间';

alter table sys_dict
    add update_by varchar(64) null comment '修改人';

alter table sys_dict
    add is_delete varchar(2) default 'N' not null comment '是否删除 Y：删除 ；N：没有删除';

alter table sys_dict
    add enable varchar(2) default 'Y' not null comment '是否启用 Y：是 ；N：否';

-- in your Quartz properties file, you'll need to set org.quartz.jobStore.driverDelegateClass = org.quartz.impl.jdbcjobstore.StdJDBCDelegate
-- 你需要在你的quartz.properties文件中设置org.quartz.jobStore.driverDelegateClass = org.quartz.impl.jdbcjobstore.StdJDBCDelegate
-- StdJDBCDelegate说明支持集群，所有的任务信息都会保存到数据库中，可以控制事物，还有就是如果应用服务器关闭或者重启，任务信息都不会丢失，并且可以恢复因服务器关闭或者重启而导致执行失败的任务
-- This is the script from Quartz to create the tables in a MySQL database, modified to use INNODB instead of MYISAM
-- 这是来自quartz的脚本，在MySQL数据库中创建以下的表，修改为使用INNODB而不是MYISAM
-- 你需要在数据库中执行以下的sql脚本
DROP TABLE IF EXISTS QRTZ_FIRED_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_PAUSED_TRIGGER_GRPS;
DROP TABLE IF EXISTS QRTZ_SCHEDULER_STATE;
DROP TABLE IF EXISTS QRTZ_LOCKS;
DROP TABLE IF EXISTS QRTZ_SIMPLE_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_SIMPROP_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_CRON_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_BLOB_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_JOB_DETAILS;
DROP TABLE IF EXISTS QRTZ_CALENDARS;
-- 存储每一个已配置的Job的详细信息
CREATE TABLE QRTZ_JOB_DETAILS
(
    SCHED_NAME        VARCHAR(120) NOT NULL,
    JOB_NAME          VARCHAR(200) NOT NULL,
    JOB_GROUP         VARCHAR(200) NOT NULL,
    DESCRIPTION       VARCHAR(250) NULL,
    JOB_CLASS_NAME    VARCHAR(250) NOT NULL,
    IS_DURABLE        VARCHAR(1)   NOT NULL,
    IS_NONCONCURRENT  VARCHAR(1)   NOT NULL,
    IS_UPDATE_DATA    VARCHAR(1)   NOT NULL,
    REQUESTS_RECOVERY VARCHAR(1)   NOT NULL,
    JOB_DATA          BLOB         NULL,
    PRIMARY KEY (SCHED_NAME, JOB_NAME, JOB_GROUP)
)
    ENGINE = InnoDB;
-- 存储已配置的Trigger的信息
CREATE TABLE QRTZ_TRIGGERS
(
    SCHED_NAME     VARCHAR(120) NOT NULL,
    TRIGGER_NAME   VARCHAR(200) NOT NULL,
    TRIGGER_GROUP  VARCHAR(200) NOT NULL,
    JOB_NAME       VARCHAR(200) NOT NULL,
    JOB_GROUP      VARCHAR(200) NOT NULL,
    DESCRIPTION    VARCHAR(250) NULL,
    NEXT_FIRE_TIME BIGINT(13)   NULL,
    PREV_FIRE_TIME BIGINT(13)   NULL,
    PRIORITY       INTEGER      NULL,
    TRIGGER_STATE  VARCHAR(16)  NOT NULL,
    TRIGGER_TYPE   VARCHAR(8)   NOT NULL,
    START_TIME     BIGINT(13)   NOT NULL,
    END_TIME       BIGINT(13)   NULL,
    CALENDAR_NAME  VARCHAR(200) NULL,
    MISFIRE_INSTR  SMALLINT(2)  NULL,
    JOB_DATA       BLOB         NULL,
    PRIMARY KEY (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME, JOB_NAME, JOB_GROUP)
        REFERENCES QRTZ_JOB_DETAILS (SCHED_NAME, JOB_NAME, JOB_GROUP)
)
    ENGINE = InnoDB;
-- 存储已配置的Simple Trigger的信息
CREATE TABLE QRTZ_SIMPLE_TRIGGERS
(
    SCHED_NAME      VARCHAR(120) NOT NULL,
    TRIGGER_NAME    VARCHAR(200) NOT NULL,
    TRIGGER_GROUP   VARCHAR(200) NOT NULL,
    REPEAT_COUNT    BIGINT(7)    NOT NULL,
    REPEAT_INTERVAL BIGINT(12)   NOT NULL,
    TIMES_TRIGGERED BIGINT(10)   NOT NULL,
    PRIMARY KEY (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
)
    ENGINE = InnoDB;
-- 存储Cron Trigger，包括Cron表达式和时区信息
CREATE TABLE QRTZ_CRON_TRIGGERS
(
    SCHED_NAME      VARCHAR(120) NOT NULL,
    TRIGGER_NAME    VARCHAR(200) NOT NULL,
    TRIGGER_GROUP   VARCHAR(200) NOT NULL,
    CRON_EXPRESSION VARCHAR(120) NOT NULL,
    TIME_ZONE_ID    VARCHAR(80),
    PRIMARY KEY (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
)
    ENGINE = InnoDB;
CREATE TABLE QRTZ_SIMPROP_TRIGGERS
(
    SCHED_NAME    VARCHAR(120)   NOT NULL,
    TRIGGER_NAME  VARCHAR(200)   NOT NULL,
    TRIGGER_GROUP VARCHAR(200)   NOT NULL,
    STR_PROP_1    VARCHAR(512)   NULL,
    STR_PROP_2    VARCHAR(512)   NULL,
    STR_PROP_3    VARCHAR(512)   NULL,
    INT_PROP_1    INT            NULL,
    INT_PROP_2    INT            NULL,
    LONG_PROP_1   BIGINT         NULL,
    LONG_PROP_2   BIGINT         NULL,
    DEC_PROP_1    NUMERIC(13, 4) NULL,
    DEC_PROP_2    NUMERIC(13, 4) NULL,
    BOOL_PROP_1   VARCHAR(1)     NULL,
    BOOL_PROP_2   VARCHAR(1)     NULL,
    PRIMARY KEY (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
)
    ENGINE = InnoDB;
--  Trigger作为Blob类型存储(用于Quartz用户用JDBC创建他们自己定制的Trigger类型，JobStore并不知道如何存储实例的时候)
CREATE TABLE QRTZ_BLOB_TRIGGERS
(
    SCHED_NAME    VARCHAR(120) NOT NULL,
    TRIGGER_NAME  VARCHAR(200) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    BLOB_DATA     BLOB         NULL,
    PRIMARY KEY (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP),
    INDEX (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP),
    FOREIGN KEY (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
        REFERENCES QRTZ_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP)
)
    ENGINE = InnoDB;
-- 以Blob类型存储Quartz的Calendar日历信息,quartz可配置一个日历来指定一个时间范围
CREATE TABLE QRTZ_CALENDARS
(
    SCHED_NAME    VARCHAR(120) NOT NULL,
    CALENDAR_NAME VARCHAR(200) NOT NULL,
    CALENDAR      BLOB         NOT NULL,
    PRIMARY KEY (SCHED_NAME, CALENDAR_NAME)
)
    ENGINE = InnoDB;
-- 存储已暂停的Trigger组的信息
CREATE TABLE QRTZ_PAUSED_TRIGGER_GRPS
(
    SCHED_NAME    VARCHAR(120) NOT NULL,
    TRIGGER_GROUP VARCHAR(200) NOT NULL,
    PRIMARY KEY (SCHED_NAME, TRIGGER_GROUP)
)
    ENGINE = InnoDB;
-- 存储与已触发的Trigger相关的状态信息，以及相联Job的执行信息
CREATE TABLE QRTZ_FIRED_TRIGGERS
(
    SCHED_NAME        VARCHAR(120) NOT NULL,
    ENTRY_ID          VARCHAR(95)  NOT NULL,
    TRIGGER_NAME      VARCHAR(200) NOT NULL,
    TRIGGER_GROUP     VARCHAR(200) NOT NULL,
    INSTANCE_NAME     VARCHAR(200) NOT NULL,
    FIRED_TIME        BIGINT(13)   NOT NULL,
    SCHED_TIME        BIGINT(13)   NOT NULL,
    PRIORITY          INTEGER      NOT NULL,
    STATE             VARCHAR(16)  NOT NULL,
    JOB_NAME          VARCHAR(200) NULL,
    JOB_GROUP         VARCHAR(200) NULL,
    IS_NONCONCURRENT  VARCHAR(1)   NULL,
    REQUESTS_RECOVERY VARCHAR(1)   NULL,
    PRIMARY KEY (SCHED_NAME, ENTRY_ID)
)
    ENGINE = InnoDB;
-- 存储少量的有关 Scheduler的状态信息，和别的 Scheduler 实例(假如是用于一个集群中)
CREATE TABLE QRTZ_SCHEDULER_STATE
(
    SCHED_NAME        VARCHAR(120) NOT NULL,
    INSTANCE_NAME     VARCHAR(200) NOT NULL,
    LAST_CHECKIN_TIME BIGINT(13)   NOT NULL,
    CHECKIN_INTERVAL  BIGINT(13)   NOT NULL,
    PRIMARY KEY (SCHED_NAME, INSTANCE_NAME)
)
    ENGINE = InnoDB;
-- 存储程序的非观锁的信息(假如使用了悲观锁)
CREATE TABLE QRTZ_LOCKS
(
    SCHED_NAME VARCHAR(120) NOT NULL,
    LOCK_NAME  VARCHAR(40)  NOT NULL,
    PRIMARY KEY (SCHED_NAME, LOCK_NAME)
)
    ENGINE = InnoDB;
CREATE INDEX IDX_QRTZ_J_REQ_RECOVERY ON QRTZ_JOB_DETAILS (SCHED_NAME, REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_J_GRP ON QRTZ_JOB_DETAILS (SCHED_NAME, JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_J ON QRTZ_TRIGGERS (SCHED_NAME, JOB_NAME, JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_JG ON QRTZ_TRIGGERS (SCHED_NAME, JOB_GROUP);
CREATE INDEX IDX_QRTZ_T_C ON QRTZ_TRIGGERS (SCHED_NAME, CALENDAR_NAME);
CREATE INDEX IDX_QRTZ_T_G ON QRTZ_TRIGGERS (SCHED_NAME, TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_T_STATE ON QRTZ_TRIGGERS (SCHED_NAME, TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_STATE ON QRTZ_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_N_G_STATE ON QRTZ_TRIGGERS (SCHED_NAME, TRIGGER_GROUP, TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NEXT_FIRE_TIME ON QRTZ_TRIGGERS (SCHED_NAME, NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST ON QRTZ_TRIGGERS (SCHED_NAME, TRIGGER_STATE, NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_MISFIRE ON QRTZ_TRIGGERS (SCHED_NAME, MISFIRE_INSTR, NEXT_FIRE_TIME);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE ON QRTZ_TRIGGERS (SCHED_NAME, MISFIRE_INSTR, NEXT_FIRE_TIME, TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_T_NFT_ST_MISFIRE_GRP ON QRTZ_TRIGGERS (SCHED_NAME, MISFIRE_INSTR, NEXT_FIRE_TIME, TRIGGER_GROUP,
                                                             TRIGGER_STATE);
CREATE INDEX IDX_QRTZ_FT_TRIG_INST_NAME ON QRTZ_FIRED_TRIGGERS (SCHED_NAME, INSTANCE_NAME);
CREATE INDEX IDX_QRTZ_FT_INST_JOB_REQ_RCVRY ON QRTZ_FIRED_TRIGGERS (SCHED_NAME, INSTANCE_NAME, REQUESTS_RECOVERY);
CREATE INDEX IDX_QRTZ_FT_J_G ON QRTZ_FIRED_TRIGGERS (SCHED_NAME, JOB_NAME, JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_JG ON QRTZ_FIRED_TRIGGERS (SCHED_NAME, JOB_GROUP);
CREATE INDEX IDX_QRTZ_FT_T_G ON QRTZ_FIRED_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP);
CREATE INDEX IDX_QRTZ_FT_TG ON QRTZ_FIRED_TRIGGERS (SCHED_NAME, TRIGGER_GROUP);
commit;




