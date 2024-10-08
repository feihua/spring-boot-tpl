create table sys_menu
(
    id          bigint auto_increment comment '主键'
        primary key,
    menu_name   varchar(50)                            not null comment '菜单名称',
    menu_type   tinyint      default 1                 not null comment '菜单类型(1：目录   2：菜单   3：按钮)',
    status   tinyint      default 1                 not null comment '状态(1:正常，0:禁用)',
    sort        int          default 1                 not null comment '排序',
    parent_id   bigint                                 not null comment '父ID',
    menu_url    varchar(255) default ''                null comment '路由路径',
    api_url     varchar(255) default ''                null comment '接口URL',
    menu_icon   varchar(255)                           null comment '菜单图标',
    remark              varchar(500) default ''                not null comment '备注',
    create_dept         bigint                                 not null comment '创建部门',
    create_by           bigint                                 not null comment '创建者',
    create_time         timestamp    default CURRENT_TIMESTAMP not null comment '创建时间',
    update_by           bigint                                 null comment '更新者',
    update_time         datetime                               null on update CURRENT_TIMESTAMP comment '更新时间'
)
    comment '菜单信息';

INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (1, '首页', 1, 1, 0, 0, '/welcome', '', 'SmileOutlined', '首页', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (2, '权限管理', 1, 1, 1, 0, '/system', '', 'SettingOutlined', '权限管理', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (3, '用户管理', 2, 1, 1, 2, '/system/user/list', '/tpl/user/queryUserList', '', '用户管理', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (4, '角色管理', 2, 1, 2, 2, '/system/role/list', '/tpl/role/queryRoleList', '', '角色管理', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (5, '菜单管理', 2, 1, 3, 2, '/system/menu/list', '/tpl/menu/queryMenuList', '', '菜单管理', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (6, '保存用户接口', 3, 1, 1, 3, '', '/tpl/user/saveUser', '', '添加用户接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (7, '删除用户接口', 3, 1, 2, 3, '', '/tpl/user/deleteUser', '', '删除用户接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (8, '更新用户接口', 3, 1, 3, 3, '', '/tpl/user/updateUser', '', '更新用户接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (9, '保存用户角色', 3, 1, 4, 3, '', '/tpl/user/updateUserRole', '', '更新用户角色接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (10, '用户关联的角色', 3, 1, 5, 3, '', '/tpl/user/queryUserRole', '', '查询用户角色接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (11, '查询用户菜单接口', 3, 1, 6, 3, '', '/tpl/user/queryUserMenu', '', '查询用户菜单接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (12, '保存角色接口', 3, 1, 1, 4, '', '/tpl/role/saveRole', '', '添加角色接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (13, '删除角色接口', 3, 1, 2, 4, '', '/tpl/role/deleteRole', '', '删除角色接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (14, '更新角色接口', 3, 1, 3, 4, '', '/tpl/role/updateRole', '', '更新角色接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (15, '角色菜单关联', 3, 1, 4, 4, '', '/tpl/role/queryRoleMenuList', '', '角色菜单关联', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (16, '保存角色菜单关联', 3, 5, 1, 4, '', '/tpl/role/updateRoleMenuList', '', '角色菜单关联接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (17, '保存菜单接口', 3, 1, 1, 5, '', '/tpl/menu/saveMenu', '', '添加菜单接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (18, '删除菜单接口', 3, 1, 2, 5, '', '/tpl/menu/deleteMenu', '', '删除菜单接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (19, '更新菜单接口', 3, 1, 3, 5, '', '/tpl/menu/updateMenu', '', '更新菜单接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (20, '日志管理', 1, 1, 2, 0, '/log', '', 'SettingOutlined', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (21, '登录日志', 2, 1, 1, 20, '/log/loginLog/list', '/tpl/loginLog/queryLoginLogList', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (22, '操作日志', 2, 1, 2, 20, '/log/operationLog/list', '/tpl/operationLog/queryOperationLogList', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (23, '常用图表', 1, 1, 3, 0, '/line1', '', 'SettingOutlined', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (24, '饼图', 2, 1, 1, 23, '/bar', '', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (25, '线图', 2, 1, 1, 23, '/line', '', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (26, '柱状图', 2, 1, 1, 23, '/pie', '', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (27, '个人中心', 1, 1, 4, 0, '/center1', '', 'SettingOutlined', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (28, '个人信息', 2, 1, 1, 27, '/center', '', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (29, '个人设置', 2, 1, 2, 27, '/setting', '', 'Setting', '', current_timestamp, current_timestamp);

INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (30, '删除登录日志', 3, 1, 1, 21, '', '/tpl/loginLog/deleteLoginLog', '', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu (id, menu_name, menu_type, status, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES (31, '删除操作日志', 3, 1, 1, 22, '', '/tpl/operationLog/deleteOperationLog', '', '', current_timestamp, current_timestamp);
