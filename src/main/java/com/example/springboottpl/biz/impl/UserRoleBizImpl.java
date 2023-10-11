package com.example.springboottpl.biz.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.springboottpl.enums.StatusEnum.enable;

import com.example.springboottpl.biz.UserRoleBiz;
import com.example.springboottpl.dao.UserRoleDao;
import com.example.springboottpl.entity.UserRoleBean;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.UserRoleAddReqVo;
import com.example.springboottpl.vo.req.UserRoleListReqVo;
import com.example.springboottpl.vo.req.UserRoleReqVo;
import com.example.springboottpl.vo.resp.UserRoleRespVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：角色用户关联表
 * 作者：刘飞华
 * 日期：2023-09-20 10:44:26
 */
@Service
public class UserRoleBizImpl implements UserRoleBiz {

	@Autowired
	private UserRoleDao userRoleDao;

	/**
	 * 添加角色用户关联表
	 *
	 * @param userRole 请求参数
	 * @return int
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public int saveUserRole(UserRoleAddReqVo userRole) {
		UserRoleBean bean = new UserRoleBean();
		bean.setUserId(userRole.getUserId());
		bean.setRoleId(userRole.getRoleId());
		//添加的时候默认为正常状态
		bean.setStatusId(enable.getCode());
		bean.setSort(userRole.getSort());
		bean.setCreateTime(userRole.getCreateTime());
		bean.setUpdateTime(userRole.getUpdateTime());

		return userRoleDao.saveUserRole(bean);
	}

	/**
	 * 删除角色用户关联表
	 *
	 * @param userId 请求参数
	 * @return int
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public int deleteUserRole(Integer userId) {
		return userRoleDao.deleteUserRole(userId);
	}

	/**
	 * 查询角色用户关联表
	 *
	 * @param userRole 请求参数
	 * @return UserRoleResp
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public UserRoleRespVo queryUserRole(UserRoleReqVo userRole) {
		UserRoleBean bean = new UserRoleBean();
		//bean.setId(userRole.getId());
		//bean.setUserId(userRole.getUserId());
		//bean.setRoleId(userRole.getRoleId());
		//bean.setStatusId(userRole.getStatusId());
		//bean.setSort(userRole.getSort());
		//bean.setCreateTime(userRole.getCreateTime());
		//bean.setUpdateTime(userRole.getUpdateTime());

		UserRoleBean query = userRoleDao.queryUserRole(bean);

		return UserRoleRespVo.builder().build();
	}

	/**
	 * 查询角色用户关联表列表
	 *
	 * @param userRole 请求参数
	 * @return UserRoleResp
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public ResultPage<UserRoleRespVo> queryUserRoleList(UserRoleListReqVo userRole) {
		UserRoleBean bean = new UserRoleBean();
		//bean.setId(userRole.getId());
		//bean.setUserId(userRole.getUserId());
		//bean.setRoleId(userRole.getRoleId());
		//bean.setStatusId(userRole.getStatusId());
		//bean.setSort(userRole.getSort());
		//bean.setCreateTime(userRole.getCreateTime());
		//bean.setUpdateTime(userRole.getUpdateTime());

		PageHelper.startPage(userRole.getPageNo(), userRole.getPageSize());
		List<UserRoleBean> query = userRoleDao.queryUserRoleList(bean);
		PageInfo<UserRoleBean> pageInfo = new PageInfo<>(query);

		List<UserRoleRespVo> list = pageInfo.getList().stream().map(x -> {
			UserRoleRespVo resp = new UserRoleRespVo();
			//resp.setId(x.getId());
			//resp.setUserId(x.getUserId());
			//resp.setRoleId(x.getRoleId());
			//resp.setStatusId(x.getStatusId());
			//resp.setSort(x.getSort());
			//resp.setCreateTime(x.getCreateTime());
			//resp.setUpdateTime(x.getUpdateTime());
			return resp;
		}).collect(Collectors.toList());

		return new ResultPage<>(list, pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal());

	}

	/**
	 * 查询用户是否是管理员
	 *
	 * @param userId 用户id
	 * @param roleId 角色id
	 * @return boolean
	 * @author 刘飞华
	 * @date: 2023-09-20 10:44:26
	 */
	@Override
	public boolean queryIsAdmin(int userId, int roleId) {
		UserRoleBean bean = new UserRoleBean();
		bean.setUserId(userId);
		bean.setRoleId(roleId);
		bean.setStatusId(1);
		return userRoleDao.queryUserRole(bean) != null;
	}
}