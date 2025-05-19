create table sys_operation_log
(
    id             bigint auto_increment comment '主键'
        primary key,
    title          varchar(32) null comment '系统模块',
    user_id        bigint null comment '操作人员',
    user_name      varchar(32) null comment '操作人员',
    dept_id        bigint null comment '部门id',
    dept_name      varchar(32) null comment '部门名称',
    platform       varchar(50) default '' null comment '平台信息',
    os             varchar(50) default '' null comment '操作系统',
    browser        varchar(50) default '' null comment '浏览器类型',
    version        varchar(50) default '' null comment '浏览器版本',
    engine         varchar(50) default '' null comment '渲染引擎信息',
    operate_ip     varchar(32) null comment 'IP地址',
    operation_url  varchar(64) null comment '请求URL',
    request_method varchar(32) null comment '请求方式',
    operation_desc varchar(64) null comment '操作描述',
    status         tinyint     DEFAULT 0 null COMMENT '操作状态(0:异常,正常)',
    operate_param  text null comment '请求参数',
    json_result    text null comment '操作结果',
    error_msg      text null comment '异常消息',
    err_msg_detail text null comment '详细的异常信息',
    cost_time      bigint null comment '耗时',
    operate_time   datetime    default CURRENT_TIMESTAMP null comment '操作时间'

) comment '操作日志';


