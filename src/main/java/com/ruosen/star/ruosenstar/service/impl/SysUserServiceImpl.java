package com.ruosen.star.ruosenstar.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruosen.star.ruosenstar.dao.SysUserMappper;
import com.ruosen.star.ruosenstar.exception.CustomException;
import com.ruosen.star.ruosenstar.module.Enums.ResultInfoEnum;
import com.ruosen.star.ruosenstar.module.base.ResponseData;
import com.ruosen.star.ruosenstar.module.po.SysUser;
import com.ruosen.star.ruosenstar.module.vo.SysUserRq;
import com.ruosen.star.ruosenstar.module.vo.SysUserVo;
import com.ruosen.star.ruosenstar.service.SysUserService;
import com.ruosen.star.ruosenstar.utils.PageInfo;
import com.ruosen.star.ruosenstar.utils.RequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMappper, SysUser> implements SysUserService {

    /**
     * 新增系统用户
     *
     * @param sysUserRq
     */
    @Override
    @CachePut(value = "user", key = "#result", unless = "#result <= 0")
    @Transactional(rollbackFor = Exception.class)
    public SysUserVo addUser(SysUserRq sysUserRq) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserRq, sysUser);
        sysUser.setCreateDate(new Date());
        sysUser.setCreateBy(RequestHandler.getDefaultUserName());
        int insert = this.baseMapper.insert(sysUser);
        SysUserVo sysUserVo = new SysUserVo();
        if (insert > 0) {
            BeanUtils.copyProperties(sysUser, sysUserVo);
        }
        return sysUserVo;
    }

    @Override
    @CachePut(value = "user", key = "#result", unless = "#result <= 0")
    @Transactional(rollbackFor = Exception.class)
    public SysUserVo updateUser(SysUserRq sysUserRq) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserRq, sysUser);
        sysUser.setUpdateDate(new Date());
        sysUser.setUpdateBy(RequestHandler.getDefaultUserName());
        int i = this.baseMapper.updateById(sysUser);
        SysUserVo sysUserVo = new SysUserVo();
        if (i > 0) {
            BeanUtils.copyProperties(sysUser, sysUserVo);
        }
        return sysUserVo;
    }

    /**
     * 删除用户
     *
     * @param ids
     */
    @Override
    @CacheEvict(value = "user", key = "#ids")
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
    @Cacheable(value = "user", key = "#id")
    @Transactional(readOnly = true)
    public SysUserVo detail(Long id) {
        SysUser sysUser = this.baseMapper.selectById(id);
        if (null == sysUser) {
            throw new CustomException(ResultInfoEnum.USER_IS_NOT_EXIST);
        }
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

    @Override
    @Cacheable(value = "userList")
    @Transactional(readOnly = true)
    public List<SysUserVo> selectUserList(SysUserRq sysUserRq) {
        List<SysUserVo> sysUserVoList = this.baseMapper.selectUserPage(sysUserRq);
        return sysUserVoList;
    }

    /**
     * 清空缓存
     *
     * @return
     */
    @Override
    @CacheEvict(value = {"user", "userList"}, allEntries = true)
    public ResponseData cacheEvict() {
        return new ResponseData().ok();
    }
}
