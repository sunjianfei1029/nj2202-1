package com.powernode.security.service.impl;

import com.powernode.security.mapper.SysUserMapper;
import com.powernode.security.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-27 10:48
 */

@Component
public class AppUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username:" + username);
        // 根据username 访问数据库 返回SysUser对象
        SysUser sysUser = sysUserMapper.queryUserByUserName(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 根据SysUser对象的id 返回它用于的权限
        List<String> persession = sysUserMapper.queryPersessionByUserId(sysUser.getUserId());
        // 将一个封装到User对象返回
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        for (String per : persession) {
            authorities.add(new SimpleGrantedAuthority(per));
        }

        sysUser.setPersession(authorities);
        //return new User(sysUser.getUsername(),sysUser.getPassword(),authorities);
        return sysUser;
    }
}
