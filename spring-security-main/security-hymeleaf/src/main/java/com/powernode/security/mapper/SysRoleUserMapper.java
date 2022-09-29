package com.powernode.security.mapper;

import com.powernode.security.model.SysRoleUserKey;

public interface SysRoleUserMapper {
    int deleteByPrimaryKey(SysRoleUserKey key);

    int insert(SysRoleUserKey record);

    int insertSelective(SysRoleUserKey record);
}