create table sys_menu
(
    id          bigint auto_increment comment '主键'
        primary key,
    menu_name   varchar(50)                            not null comment '菜单名称',
    menu_type   tinyint      default 1                 not null comment '菜单类型(1：目录   2：菜单   3：按钮)',
    status_id   tinyint      default 1                 not null comment '状态(1:正常，0:禁用)',
    sort        int          default 1                 not null comment '排序',
    parent_id   bigint                                 not null comment '父ID',
    menu_url    varchar(255) default ''                null comment '路由路径',
    api_url     varchar(255) default ''                null comment '接口URL',
    menu_icon   varchar(255)                           null comment '菜单图标',
    remark      varchar(255)                           null comment '备注',
    create_time datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '修改时间',
    constraint menu_name
        unique (menu_name)
)
    comment '菜单信息';

INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('首页', 1, 1, 0, 0, '/home', '', 'SmileOutlined', '首页', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('权限管理', 1, 1, 1, 0, '/sys', '', 'SettingOutlined', '权限管理', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('用户管理', 2, 0, 3, 2, '/user', '/tpl/user/queryUserList', '', '用户管理', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('角色管理', 2, 1, 2, 2, '/role', '/tpl/role/queryRoleList', '', '角色管理', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('菜单管理', 2, 1, 1, 2, '/menu', '/tpl/menu/queryMenuList', '', '菜单管理', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('保存用户接口', 3, 1, 1, 3, '', '/tpl/user/saveUser', '', '添加用户接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('删除用户接口', 3, 1, 1, 3, '', '/tpl/user/deleteUser', '', '删除用户接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('更新用户接口', 3, 1, 1, 3, '', '/tpl/user/updateUser', '', '更新用户接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('保存用户角色', 3, 1, 1, 3, '', '/tpl/user/updateUserRole', '', '更新用户角色接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('用户关联的角色', 3, 1, 1, 3, '', '/tpl/user/queryUserRole', '', '查询用户角色接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('查询用户菜单接口', 3, 1, 1, 3, '', '/tpl/user/queryUserMenu', '', '查询用户菜单接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('保存角色接口', 3, 1, 1, 4, '', '/tpl/role/saveRole', '', '添加角色接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('删除角色接口', 3, 1, 1, 4, '', '/tpl/role/deleteRole', '', '删除角色接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('更新角色接口', 3, 1, 1, 4, '', '/tpl/role/updateRole', '', '更新角色接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('菜单角色关联', 3, 1, 1, 4, '', '/tpl/role/queryRoleMenuList', '', '菜单角色关联', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('保存角色菜单关联', 3, 1, 1, 4, '', '/tpl/role/updateRoleMenuList', '', '角色菜单关联接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('保存菜单接口', 3, 1, 1, 5, '', '/tpl/menu/saveMenu', '', '添加菜单接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('删除菜单接口', 3, 1, 1, 5, '', '/tpl/menu/deleteMenu', '', '删除菜单接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('更新菜单接口', 3, 1, 1, 5, '', '/tpl/menu/updateMenu', '', '更新菜单接口', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('日志管理', 1, 1, 1, 0, '/log1', '', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('登录日志', 2, 1, 1, 63, '/log', '', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('常用图表', 1, 1, 1, 0, '/line1', '', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('饼图', 2, 1, 1, 65, '/bar', '', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('线图', 2, 1, 1, 65, '/line', '', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('柱状图', 2, 1, 1, 65, '/pie', '', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('个人中心', 1, 1, 1, 0, '/center1', '', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('个人信息', 2, 1, 1, 69, '/center', '', 'Setting', '', current_timestamp, current_timestamp);
INSERT INTO sys_menu ( menu_name, menu_type, status_id, sort, parent_id, menu_url, api_url, menu_icon, remark, create_time, update_time) VALUES ('个人设置', 2, 1, 1, 69, '/setting', '', 'Setting', '', current_timestamp, current_timestamp);
