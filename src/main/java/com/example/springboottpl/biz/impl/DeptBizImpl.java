package com.example.springboottpl.biz.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboottpl.biz.DeptBiz;
import com.example.springboottpl.dao.DeptDao;
import com.example.springboottpl.entity.DeptBean;
import com.example.springboottpl.util.Result;
import com.example.springboottpl.vo.req.AddDeptReqVo;
import com.example.springboottpl.vo.req.DeleteDeptReqVo;
import com.example.springboottpl.vo.req.QueryDeptDetailReqVo;
import com.example.springboottpl.vo.req.QueryDeptListReqVo;
import com.example.springboottpl.vo.req.UpdateDeptReqVo;
import com.example.springboottpl.vo.req.UpdateDeptStatusReqVo;
import com.example.springboottpl.vo.resp.QueryDeptDetailRespVo;
import com.example.springboottpl.vo.resp.QueryDeptListRespVo;

/**
 * 描述：部门
 * 作者：刘飞华
 * 日期：2025/01/10 15:34:34
 */
@Service
public class DeptBizImpl implements DeptBiz {

    @Autowired
    private DeptDao deptDao;

    /**
     * 添加部门
     *
     * @param dept 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:34
     */
    @Override
    public Result<Integer> addDept(AddDeptReqVo dept) {

        Long parentId = dept.getParentId();//上级部门id

        DeptBean parentDept = deptDao.queryDeptById(parentId);
        if (parentDept == null) {
            return Result.error("添加部门失败,上级部门不存在");
        }

        if (parentDept.getStatus() == 0) {
            return Result.error("添加部门失败,部门停用，不允许添加");
        }

        DeptBean deptBean = deptDao.queryDeptByName(dept.getDeptName(), parentId);
        if (deptBean != null) {
            return Result.error("添加部门失败,部门名称已存在");
        }

        DeptBean bean = new DeptBean();
        bean.setParentId(parentId); //上级部门id
        bean.setAncestors(parentDept.getAncestors() + "," + parentId); //祖级列表
        bean.setDeptName(dept.getDeptName()); //部门名称
        bean.setSort(dept.getSort()); //显示顺序
        bean.setLeader(dept.getLeader()); //负责人
        bean.setPhone(dept.getPhone()); //联系电话
        bean.setEmail(dept.getEmail()); //邮箱
        bean.setStatus(dept.getStatus()); //部门状态（0：停用，1:正常）

        int i = deptDao.addDept(bean);

        return Result.success(i);
    }

    /**
     * 删除部门
     *
     * @param dept 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:34
     */
    @Override
    public Result<Integer> deleteDept(DeleteDeptReqVo dept) {

        if (dept.getId().equals(1L)) {
            return Result.error("顶级部门,不允许删除");
        }

        int count = deptDao.queryDeptCount(dept.getId());
        if (count > 0) {
            return Result.error("存在下级部门,不允许删除");
        }

        int existUser = deptDao.checkDeptExistUser(dept.getId());
        if (existUser > 0) {
            return Result.error("部门存在用户,不允许删除");
        }

        int i = deptDao.deleteDept(dept.getId());
        return Result.success(i);
    }

    /**
     * 更新部门
     *
     * @param dept 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:34
     */
    @Override
    public Result<Integer> updateDept(UpdateDeptReqVo dept) {

        Long parentId = dept.getParentId();//上级部门id
        Long id = dept.getId();//部门id

        if (Objects.equals(parentId, id)) {
            return Result.error("上级部门不能是自己");
        }

        DeptBean deptBean = deptDao.queryDeptById(id);
        if (deptBean == null) {
            return Result.error("更新失败,部门不存在");
        }

        DeptBean parentDeptBean = deptDao.queryDeptById(parentId);
        if (parentDeptBean == null) {
            return Result.error("更新失败,上级部门不存在");
        }

        String ancestors = parentDeptBean.getAncestors() + "," + parentId;

        DeptBean res = deptDao.queryDeptByName(dept.getDeptName(), parentId);
        if (res != null && !Objects.equals(res.getId(), id)) {
            return Result.error("更新部门失败,部门名称已存在");
        }

        int i = deptDao.queryNormalChildrenDeptById(id);
        if (i > 0 && dept.getStatus() == 0) {
            return Result.error("该部门包含未停用的子部门");
        }

        List<DeptBean> deptBeans = deptDao.queryChildrenDeptById(id);
        deptBeans.forEach(x -> {
            x.setAncestors(StringUtils.replace(x.getAncestors(), deptBean.getAncestors(), ancestors));
            deptDao.updateDept(x);
        });

        DeptBean bean = new DeptBean();
        bean.setId(id);
        bean.setParentId(parentId); //上级部门id
        bean.setAncestors(ancestors); //祖级列表
        bean.setDeptName(dept.getDeptName()); //部门名称
        bean.setSort(dept.getSort()); //显示顺序
        bean.setLeader(dept.getLeader()); //负责人
        bean.setPhone(dept.getPhone()); //联系电话
        bean.setEmail(dept.getEmail()); //邮箱
        bean.setStatus(dept.getStatus()); //部门状态（0：停用，1:正常）

        deptDao.updateDept(bean);

        if (dept.getStatus() == 1) {
            String[] split = ancestors.split(",");
            List<Long> ids = Arrays.stream(split).map(Long::parseLong).toList();

            UpdateDeptStatusReqVo reqVo = new UpdateDeptStatusReqVo();
            reqVo.setIds(ids);
            reqVo.setStatus(dept.getStatus());

            // 如果该部门是启用状态，则启用该部门的所有上级部门
            deptDao.updateDeptStatus(reqVo);
        }

        return Result.success();
    }

    /**
     * 更新部门状态
     *
     * @param dept 请求参数
     * @return int
     * @author 刘飞华
     * @date: 2025/01/10 15:34:34
     */
    @Override
    public Result<Integer> updateDeptStatus(UpdateDeptStatusReqVo dept) {
        int i = deptDao.updateDeptStatus(dept);
        if (dept.getStatus() == 1) {
            dept.getIds().forEach(id -> {
                String ancestors = deptDao.queryDeptById(id).getAncestors();
                String[] split = ancestors.split(",");
                List<Long> ids = Arrays.stream(split).map(Long::parseLong).toList();

                UpdateDeptStatusReqVo reqVo = new UpdateDeptStatusReqVo();
                reqVo.setIds(ids);
                reqVo.setStatus(dept.getStatus());

                // 如果该部门是启用状态，则启用该部门的所有上级部门
                deptDao.updateDeptStatus(reqVo);
            });
        }

        return Result.success(i);
    }

    /**
     * 查询部门详情
     *
     * @param dept 请求参数
     * @return DeptResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:34
     */
    @Override
    public Result<QueryDeptDetailRespVo> queryDeptDetail(QueryDeptDetailReqVo dept) {

        DeptBean bean = new DeptBean();
        bean.setId(dept.getId());

        DeptBean deptBean = deptDao.queryDeptDetail(bean);
        if (deptBean == null) {
            return Result.error("查询部门详情失败,部门不存在");
        }

        QueryDeptDetailRespVo resp = new QueryDeptDetailRespVo();
        resp.setId(deptBean.getId());//部门id
        resp.setParentId(deptBean.getParentId());//父部门id
        resp.setAncestors(deptBean.getAncestors());//祖级列表
        resp.setDeptName(deptBean.getDeptName());//部门名称
        resp.setSort(deptBean.getSort());//显示顺序
        resp.setLeader(deptBean.getLeader());//负责人
        resp.setPhone(deptBean.getPhone());//联系电话
        resp.setEmail(deptBean.getEmail());//邮箱
        resp.setStatus(deptBean.getStatus());//部门状态（0：停用，1:正常）
        resp.setDelFlag(deptBean.getDelFlag());//删除标志（0代表删除 1代表存在）
        resp.setCreateTime(deptBean.getCreateTime());//创建时间
        resp.setUpdateTime(deptBean.getUpdateTime());//修改时间

        return Result.success(resp);
    }

    /**
     * 查询部门列表
     *
     * @param dept 请求参数
     * @return DeptResp
     * @author 刘飞华
     * @date: 2025/01/10 15:34:34
     */
    @Override
    public Result<List<QueryDeptListRespVo>> queryDeptList(QueryDeptListReqVo dept) {
        DeptBean bean = new DeptBean();
        bean.setDeptName(dept.getDeptName());//部门名称
        bean.setStatus(dept.getStatus());//部门状态（0：停用，1:正常）

        List<DeptBean> query = deptDao.queryDeptList(bean);

        List<QueryDeptListRespVo> list = new ArrayList<>();

        for (DeptBean deptBean : query) {
            QueryDeptListRespVo resp = new QueryDeptListRespVo();
            resp.setId(deptBean.getId());//部门id
            resp.setParentId(deptBean.getParentId());//父部门id
            resp.setAncestors(deptBean.getAncestors());//祖级列表
            resp.setDeptName(deptBean.getDeptName());//部门名称
            resp.setSort(deptBean.getSort());//显示顺序
            resp.setLeader(deptBean.getLeader());//负责人
            resp.setPhone(deptBean.getPhone());//联系电话
            resp.setEmail(deptBean.getEmail());//邮箱
            resp.setStatus(deptBean.getStatus());//部门状态（0：停用，1:正常）
            resp.setDelFlag(deptBean.getDelFlag());//删除标志（0代表删除 1代表存在）
            resp.setCreateTime(deptBean.getCreateTime());//创建时间
            resp.setUpdateTime(deptBean.getUpdateTime());//修改时间

            list.add(resp);
        }

        return Result.success(list);

    }
}