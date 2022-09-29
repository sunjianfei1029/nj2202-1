package com.powernode.security.mapper;

import com.powernode.security.model.SysUser;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);


    /**
     * 根据用户名称查询用户信息
     * @param username
     * @return
     */
    SysUser queryUserByUserName(String username);

    /**
     * 根据userId 查询它的权限列表
     * @param userId
     * @return
     */
    List<String> queryPersessionByUserId(Integer userId);
}