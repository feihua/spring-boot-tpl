create table sys_login_log
(
    id bigint auto_increment comment '主键'
        primary key,
    user_id      bigint      null comment '用户ID',
    user_name    varchar(32) null comment '用户姓名',
    ip_address   varchar(32) null comment '用户IP地址',
    create_time  datetime    not null comment '操作时间'
)
    comment '登录日志';

