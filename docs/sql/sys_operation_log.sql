create table tpl.sys_operation_log
(
    id                 bigint auto_increment comment '主键'
        primary key,
    user_id            bigint      null comment '操作者ID',
    user_name          varchar(32) null comment '操作者姓名',
    ip_address         varchar(32) null comment 'IP地址',
    operation_url      varchar(64) null comment '操作url',
    operation_method   varchar(32) null comment '操作方法',
    operation_desc     varchar(64) not null comment '操作类型',
    request_params     text        null comment '请求参数',
    response_params    text        null comment '操作结果',
    err_message        text        null comment '异常消息',
    err_message_detail text        null comment '详细的异常信息',
    create_time        datetime    not null comment '操作时间'
)
    comment '操作日志';

