package com.powernode.springboot.service.impl;

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
 * @date:2022-09-27 09:08
 */
@Component
public class AppUserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //UserDetails userDetails = // 根据当前的用户名和从数据库中获取用户信息
        // 模拟访问数据库
//        UserDetails userDetails = null;
//
//        if (userDetails == null) {
//            throw new UsernameNotFoundException("用户没有找到");
//        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("user:add"));
//        authorities.add(new SimpleGrantedAuthority("user:query"));
//        authorities.add(new SimpleGrantedAuthority("user:delete"));
//        authorities.add(new SimpleGrantedAuthority("user:update"));
        return new User("admin","$2a$10$q3nm5xf0hwF/ltlpJqt0eOqY7rgs0hFYMy1ekLZXysFvmqxfqqLJ.",authorities);
    }
}
