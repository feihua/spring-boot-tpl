package com.example.springboottpl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.springboottpl.entity.MenuBean;
import com.example.springboottpl.entity.UserBean;
import com.example.springboottpl.vo.req.UpdateUserStatusReqVo;

/**
 * 描述：用户信息
 * 作者：刘飞华
 * 日期：2025-01-10 14:58:36
 */
@Mapper
public interface UserDao {

    /**
     * 添加用户信息
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int addUser(UserBean user);

    /**
     * 删除用户信息
     *
     * @param ids 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int deleteUser(List<Long> ids);

    /**
     * 更新用户信息
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateUser(UserBean user);

    /**
     * 更新用户信息状态
     *
     * @param user 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    int updateUserStatus(UpdateUserStatusReqVo user);

    /**
     * 查询用户信息详情
     *
     * @param user 请求参数
     * @return User
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    UserBean queryUserDetail(UserBean user);

    /**
     * 根据id查询用户信息
     *
     * @param id 请求参数
     * @return User
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    UserBean queryUserById(@Param("id") Long id);

    /**
     * 根据name查询用户信息
     *
     * @param name 请求参数
     * @return User
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    UserBean queryUserByName(@Param("name") String name);

    /**
     * 根据手机号查询用户信息
     *
     * @param mobile 请求参数
     * @return User
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    UserBean queryUserByMobile(@Param("mobile") String mobile);


    /**
     * 根据email查询用户信息
     *
     * @param email 请求参数
     * @return User
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    UserBean queryUserByEmail(@Param("email") String email);

    /**
     * 查询用户信息列表
     *
     * @param user 请求参数
     * @return List<User>
     * @author 刘飞华
     * @date: 2025-01-10 14:58:36
     */
    List<UserBean> queryUserList(UserBean user);

    /**
     * 查询用户菜单
     *
     * @param userId 用户id
     * @return List<MenuBean>
     * @author 刘飞华
     * @date: 2023/9/20 14:14
     */
    List<MenuBean> queryUserMenus(long userId);

    /**
     * 查询用户角色
     *
     * @param userId 用户id
     * @return List<RoleBean>
     * @author 刘飞华
     * @date: 2023/3/29 18:10
     */
    List<Long> queryRoleIdsByUserId(@Param("userId") long userId);

    /**
     * 查询已分配用户角色列表
     *
     * @param roleId 请求参数
     * @return QueryUserListRespVo
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    List<UserBean> queryAllocatedList(@Param("roleId") long roleId, @Param("mobile") String mobile, @Param("userName") String userName);

    /**
     * 查询未分配用户角色列表
     *
     * @param roleId 请求参数
     * @return QueryUserListRespVo
     * @author 刘飞华
     * @date: 2025/01/15 15:09:35
     */
    List<UserBean> queryUnallocatedList(@Param("roleId") long roleId, @Param("mobile") String mobile, @Param("userName") String userName);

}
