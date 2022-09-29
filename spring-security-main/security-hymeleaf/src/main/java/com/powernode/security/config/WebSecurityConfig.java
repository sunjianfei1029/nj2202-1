package com.powernode.security.config;

;
import com.powernode.security.filter.ValidateCodeFilter;
import com.powernode.security.service.impl.AppUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-26 10:34
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 开启方法级别的权限检查
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private ValidateCodeFilter validateCodeFilter;



    @Autowired
    private AppUserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // super.configure(auth);
        // 使用数据库中的用户名密码登录
        auth.userDetailsService(userDetailsService);
    }

   @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 设置登录之前的校验验证码的过滤器
       http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class);
       http.formLogin()
               .usernameParameter("uname")  // 设置登录页的用户名输入框的name
               .passwordParameter("pwd")  // 设置登录页密码输入框的name值
               .loginPage("/index/toLogin") // 设置自定义的登录页面
               .loginProcessingUrl("/login/doLogin")  // 修改登录表单的提交地址
               .successForwardUrl("/index/toIndex")  // 登录成功后请求的路径
               .failureForwardUrl("/index/toLogin")  // 登录失败后跳转到登录页
               .permitAll();
       // 配置退出之后的处理器
       http.logout()
               .logoutUrl("/logout")
               .logoutSuccessUrl("/index/toLogin");

       // 对某一些路径进行拦截，要求用户必须拥有某一些权限才能访问
        http.authorizeRequests()
                .mvcMatchers("/index/toIndex","/index/toLogin","/code/image").permitAll()
                .anyRequest().authenticated();

       // 禁用csrf跨站请求攻击  后面可以使用postman工具测试
       http.csrf().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }




}
