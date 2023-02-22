create table sys_role_user
(
    id           bigint unsigned auto_increment comment '主键'
        primary key,
    gmt_create   datetime         default CURRENT_TIMESTAMP not null comment '创建时间',
    gmt_modified datetime         default CURRENT_TIMESTAMP not null comment '修改时间',
    status_id    tinyint unsigned default 1                 not null comment '状态(1:正常，0:禁用)',
    sort         int unsigned     default 1                 not null comment '排序',
    role_id      bigint unsigned                            not null comment '角色ID',
    user_id      bigint unsigned  default 0                 not null comment '用户ID'
)
    comment '角色用户关联表' charset = utf8mb4;

INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147910, '2022-07-15 14:13:46', '2022-07-15 14:13:46', 1, 1, 3, 2);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147923, '2022-07-30 16:51:55', '2022-07-30 16:51:55', 1, 1, 3, 12);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147931, '2022-07-30 17:03:55', '2022-07-30 17:03:55', 1, 1, 4, 13);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147932, '2022-07-30 17:03:55', '2022-07-30 17:03:55', 1, 1, 3, 13);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147933, '2022-07-30 17:03:55', '2022-07-30 17:03:55', 1, 1, 1, 13);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147934, '2022-12-12 14:58:43', '2022-12-12 14:58:43', 1, 1, 5, 33);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147935, '2022-12-12 14:58:43', '2022-12-12 14:58:43', 1, 1, 4, 33);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147945, '2023-01-13 15:30:37', '2023-01-13 15:30:37', 1, 1, 23, 93);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147946, '2023-01-13 15:30:37', '2023-01-13 15:30:37', 1, 1, 21, 93);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147947, '2023-01-13 15:30:37', '2023-01-13 15:30:37', 1, 1, 5, 93);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147948, '2023-01-13 15:30:37', '2023-01-13 15:30:37', 1, 1, 4, 93);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147949, '2023-01-13 15:30:37', '2023-01-13 15:30:37', 1, 1, 3, 93);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147950, '2023-01-13 15:30:37', '2023-01-13 15:30:37', 1, 1, 1, 93);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147957, '2023-01-16 14:35:16', '2023-01-16 14:35:16', 1, 1, 23, 102);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147958, '2023-01-16 14:35:16', '2023-01-16 14:35:16', 1, 1, 21, 102);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147959, '2023-01-16 14:35:16', '2023-01-16 14:35:16', 1, 1, 5, 102);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147960, '2023-01-16 14:35:16', '2023-01-16 14:35:16', 1, 1, 4, 102);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147961, '2023-01-16 14:35:16', '2023-01-16 14:35:16', 1, 1, 3, 102);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147962, '2023-01-16 14:35:16', '2023-01-16 14:35:16', 1, 1, 1, 102);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147972, '2023-01-18 14:31:33', '2023-01-18 14:31:33', 1, 1, 5, 106);
INSERT INTO rustdb.sys_role_user (id, gmt_create, gmt_modified, status_id, sort, role_id, user_id) VALUES (1145889062897147981, '2023-02-08 11:01:18', '2023-02-08 11:01:18', 1, 1, 12, 81);
