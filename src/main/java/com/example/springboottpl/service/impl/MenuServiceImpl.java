package com.example.springboottpl.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.entity.Menu;
import com.example.springboottpl.util.ResultPage;
import com.example.springboottpl.vo.req.MenuReq;
import com.example.springboottpl.vo.req.MenuListReq;
import com.example.springboottpl.vo.req.MenuAddReq;
import com.example.springboottpl.vo.req.MenuUpdateReq;
import com.example.springboottpl.vo.resp.MenuResp;
import com.example.springboottpl.dao.MenuDao;
import com.example.springboottpl.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 描述：菜单信息
 * 作者：刘飞华
 * 日期：2023/02/23 13:42:32
 */
@Service
public class MenuServiceImpl implements MenuService {

   @Autowired
   private MenuDao menuDao;
   /**
    * 查询菜单信息
    *
    * @param menu 请求参数
    * @return MenuResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   @Override
   public MenuResp query(MenuReq menu){

       Menu query = menuDao.query(Menu.builder().build());

       return MenuResp.builder().build();
   }
   /**
    * 查询菜单信息列表
    *
    * @param menu 请求参数
    * @return MenuResp
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   @Override
   public ResultPage<MenuResp> queryMenuList(MenuListReq menu){

       PageHelper.startPage(menu.getCurrent(), menu.getPageSize());
	   List<Menu> query = menuDao.queryMenuList(Menu.builder().build());
       PageInfo<Menu> pageInfo = new PageInfo<>(query);

	   List<MenuResp> list = pageInfo.getList().stream().map(x -> {
		   MenuResp resp = new MenuResp();
		   BeanUtils.copyProperties(x, resp);
		   return resp;
	   }).collect(Collectors.toList());

        return new ResultPage<>(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());

   }
   /**
    * 添加菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   @Override
   public int insert(MenuAddReq menu){

        return menuDao.insert(Menu.builder().build());
   }
   /**
    * 删除菜单信息
    *
    * @param ids 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   @Override
   public int delete(String ids){
		return menuDao.delete(Arrays.stream(ids.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
   }
   /**
    * 更新菜单信息
    *
    * @param menu 请求参数
    * @return int
    * @author 刘飞华
    * @date: 2023/02/23 13:42:32
    */
   @Override
   public int update(MenuUpdateReq menu){

        return menuDao.update(Menu.builder().build());
   }

}