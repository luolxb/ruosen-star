package com.ruosen.star.ruosenstar.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ruosen.star.ruosenstar.dao.SysUserMappper;
import com.ruosen.star.ruosenstar.module.base.PageInfo;
import com.ruosen.star.ruosenstar.module.po.SysUser;
import com.ruosen.star.ruosenstar.module.vo.SysUserRq;
import com.ruosen.star.ruosenstar.module.vo.SysUserVo;
import com.ruosen.star.ruosenstar.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 *  系统用户 服务接口实现类
 *  * @projectName ruosen-star
 *  * @title     SysUserServiceImpl   
 *  * @package    com.ruosen.star.ruosenstar.service  
 *  * @author Administrator     
 *  * @date   2019/9/28 0028 星期六
 *  * @version V1.0.0
 *  
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMappper, SysUser> implements SysUserService {

    /**
     * 新增系统用户
     *
     * @param sysUserRq
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(SysUserRq sysUserRq) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserRq, sysUser);
        sysUser.setCreateDate(new Date());
        sysUser.setCreateBy("todo");
        this.baseMapper.insert(sysUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(SysUserRq sysUserRq) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserRq, sysUser);
        sysUser.setUpdateDate(new Date());
        sysUser.setUpdateBy("todo");
        this.baseMapper.updateById(sysUser);
    }

    /**
     * 删除用户
     *
     * @param ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(List<Long> ids) {
        this.baseMapper.deleteBatchIds(ids);
    }

    /**
     * 获取用户详情
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public SysUserVo detail(Long id) {
        SysUser sysUser = this.baseMapper.selectById(id);
        SysUserVo sysUserVo = new SysUserVo();
        BeanUtils.copyProperties(sysUser, sysUserVo);
        return sysUserVo;
    }

    /**
     * 获取系统用户分页
     *
     * @param sysUserRq
     * @param pageInfo
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SysUserVo> selectUserPage(SysUserRq sysUserRq, PageInfo pageInfo) {
        Page<SysUserVo> page = new Page<>(pageInfo.getCurrent(), pageInfo.getSize());
        List<SysUserVo> sysUserVoList = this.baseMapper.selectUserPage(sysUserRq, page);
        return page.setRecords(sysUserVoList);
    }
}
