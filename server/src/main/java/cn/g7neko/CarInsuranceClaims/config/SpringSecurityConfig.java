package cn.g7neko.CarInsuranceClaims.config;

import cn.g7neko.CarInsuranceClaims.service.impl.UserServiceimpl;
import cn.g7neko.CarInsuranceClaims.springSecurity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * springSecurityConfig配置类
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationEnryPoint authenticationEnryPoint; //未登录
    @Autowired
    AuthenticationSuccess authenticationSuccess;    //登陆成功
    @Autowired
    AuthenticationLogout authenticationLogout;      //注销成功
    @Autowired
    AuthenticationFailure authenticationFailure;    //登陆失败
    @Autowired
    AccessDeny accessDeny;      //无权访问
    @Autowired
    SelfAuthenticationProvider selfAuthenticationProvider; //自定义认证逻辑处理

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserServiceimpl();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


    //用于认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(selfAuthenticationProvider);
    }


    //用于授权作用
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();//cors()解决跨域问题,csrf()会与restful风格冲突
        http
                .authorizeRequests()
                .antMatchers("/goods/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()

                .and()
                .formLogin()//开启登陆
                .permitAll() //允许所有人访问
                .successHandler(authenticationSuccess)//登陆成功后逻辑处理
                .failureHandler(authenticationFailure)//登陆失败逻辑处理

                .and()
                .logout()//开启注销
                .permitAll() //允许所有人访问
                .logoutSuccessHandler(authenticationLogout) //注销逻辑处理
                .deleteCookies("JSESSLONID")//删除cookie

                .and().exceptionHandling()
                .accessDeniedHandler(accessDeny)//权限不足的时候逻辑处理
                .authenticationEntryPoint(authenticationEnryPoint) //未登录时的逻辑处理

                .and()
                .httpBasic();
    }




}
