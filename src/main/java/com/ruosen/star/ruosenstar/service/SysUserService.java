package com.ruosen.star.ruosenstar.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruosen.star.ruosenstar.module.base.ResponseData;
import com.ruosen.star.ruosenstar.module.po.SysUser;
import com.ruosen.star.ruosenstar.module.vo.SysUserRq;
import com.ruosen.star.ruosenstar.module.vo.SysUserVo;
import com.ruosen.star.ruosenstar.utils.PageInfo;

import java.util.List;

/**
 *  系统用户 服务接口
 *  * @projectName ruosen-star
 *  * @title     SysUserService   
 *  * @package    com.ruosen.star.ruosenstar.service  
 *  * @author Administrator     
 *  * @date   2019/9/28 0028 星期六
 *  * @version V1.0.0
 *  
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 新增系统用户
     *
     * @param sysUserRq
     */
    SysUserVo addUser(SysUserRq sysUserRq);

    /**
     * 修改系统用户
     *
     * @param sysUserRq
     */
    SysUserVo updateUser(SysUserRq sysUserRq);

    /**
     * 删除用户
     *
     * @param ids
     */
    void deleteUser(List<Long> ids);

    /**
     * 获取用户详情
     *
     * @param id
     * @return
     */
    SysUserVo detail(Long id);

    /**
     * 查询用户分页
     *
     * @param sysUserRq
     * @param pageInfo
     * @return
     */
    Page<SysUserVo> selectUserPage(SysUserRq sysUserRq, PageInfo pageInfo);

    List<SysUserVo> selectUserList(SysUserRq sysUserRq);

    /**
     * 清空缓存
     *
     * @return
     */
    ResponseData cacheEvict();
}
