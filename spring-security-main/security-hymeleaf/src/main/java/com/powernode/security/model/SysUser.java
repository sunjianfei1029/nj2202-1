package com.powernode.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SysUser implements UserDetails {
    private Integer userId;

    private String username;

    private String password;

    private String sex;

    private String address;

    private Integer enabled;

    private Integer accountNoExpired;

    private Integer credentialsNoExpired;

    private Integer accountNoLocked;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNoExpired.equals(1);
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNoLocked.equals(1);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNoExpired.equals(1);
    }

    @Override
    public boolean isEnabled() {
        return enabled.equals(1);
    }

    // 声明一个存放权限的集合
    private List<SimpleGrantedAuthority> persession = new ArrayList<SimpleGrantedAuthority>();



    // 用于保存权限的集合
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return persession;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }



    public void setAccountNoExpired(Integer accountNoExpired) {
        this.accountNoExpired = accountNoExpired;
    }



    public void setCredentialsNoExpired(Integer credentialsNoExpired) {
        this.credentialsNoExpired = credentialsNoExpired;
    }



    public void setAccountNoLocked(Integer accountNoLocked) {
        this.accountNoLocked = accountNoLocked;
    }

    public List<SimpleGrantedAuthority> getPersession() {
        return persession;
    }

    public void setPersession(List<SimpleGrantedAuthority> persession) {
        this.persession = persession;
    }
}