package com.powernode.springboot.config;

import com.powernode.springboot.handler.AppAccessDeniedHandler;
import com.powernode.springboot.handler.AppAuthenticationFailureHandler;
import com.powernode.springboot.handler.AppAuthenticationSuccessHandler;
import com.powernode.springboot.handler.AppLogoutSuccessHandler;
import com.powernode.springboot.service.impl.AppUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author laolu
 * @version 1.0
 * @date:2022-09-26 10:34
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 开启方法级别的权限检查
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppAuthenticationSuccessHandler appAuthenticationSuccessHandler;

    @Autowired
    private AppAuthenticationFailureHandler appAuthenticationFailureHandler;

    @Autowired
    private AppAccessDeniedHandler appAccessDeniedHandler;

    @Autowired
    private AppLogoutSuccessHandler appLogoutSuccessHandler;

    @Autowired
    private AppUserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // super.configure(auth);
        // 使用数据库中的用户名密码登录
        auth.userDetailsService(userDetailsService);
        // 使用内存中的用户名和密码
//        auth.inMemoryAuthentication()
//                        .withUser("admin")
//                        .password("$2a$10$q3nm5xf0hwF/ltlpJqt0eOqY7rgs0hFYMy1ekLZXysFvmqxfqqLJ.")
//                        .roles("user:add","user:delete","user:update","user:query")
//                        .authorities("user:add","user:delete","user:query","user:update")
//                        .and()
//                        .withUser("zhangsan")
//                        .password("$2a$10$KmEUCDsb78.expvhnA7HK.NkICqk2cbzdfs2q1V8lZgym/edO2aru")
//                        .roles("user:query","user:add")
//                        .authorities("user:add","user:delete")
//                        .and()
//                        .withUser("lisi")
//                        .password("$2a$10$BfOs5JwblS8sYSslLcqUVOFpPhoQh7RcMezc.CIq7BiCjEi6qoRua")
//                        .roles("EMP");
    }

   @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
       //配置没有权限的处理器
       http.exceptionHandling().accessDeniedHandler(appAccessDeniedHandler);

       // 使用用户名密码进行登录,并且设置登录成功或失败后的访问路径
       http.formLogin()
               //.successForwardUrl("/welcome").failureForwardUrl("/fail");
               .successHandler(appAuthenticationSuccessHandler)
               .failureHandler(appAuthenticationFailureHandler);

       // 配置退出之后的处理器
       http.logout()
               .logoutSuccessHandler(appLogoutSuccessHandler);
       // 对某一些路径进行拦截，要求用户必须拥有某一些权限才能访问
        http.authorizeRequests()
                /*.antMatchers("/user/addUser").hasAuthority("user:add")
                .antMatchers("/user/deleteUser").hasAuthority("user:delete")
                .antMatchers("/user/updateUser").hasAuthority("user:update")
                .antMatchers("/user/queryUser").hasAuthority("user:query")
                .antMatchers("/user/export").hasAuthority("user:export")
                .antMatchers("/user/queryAll").hasRole("EMP")*/
                // 所有的请求都必须认证(登录)才能访问
                .anyRequest().authenticated();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode1 = encoder.encode("1234");
        String encode2 = encoder.encode("1234");
        String encode3 = encoder.encode("1234");
        System.out.println("encode1=" + encode1);
        System.out.println("encode2=" + encode2);
        System.out.println("encode3=" + encode3);
    }


}
