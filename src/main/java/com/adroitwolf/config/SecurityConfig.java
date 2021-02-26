package com.adroitwolf.config;

import com.adroitwolf.handler.*;
import com.adroitwolf.service.impl.UsrServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created with IntelliJ IDEA.
 * User: ADROITWOLF
 * Time: 2021 2021/2/9 9:00
 * Description: security 配置
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    LoginFailedHandler loginFailedHandler;


    @Autowired
    AuthenticationEntryPoint anonymousAuthenticationEntryPoint;

    @Autowired
    TokenAuthFilter tokenAuthFilter;

    @Autowired
    CustomAccessDeniedHandler customAccessDeniedHandler;


    @Bean
    public UserDetailsService userDetailsService(){
        return new UsrServiceImpl();
    }

//    @Autowired
//    UsernamePasswordAuthenticationFilter customAuthenticationFilter;


    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(loginSuccessHandler);
        filter.setFilterProcessesUrl("/loginUsr");
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationFailureHandler(loginFailedHandler);

        return filter;
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    @Bean
    public BCryptPasswordEncoder getPW(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//       关闭csrf和cors
        http.csrf().and().cors().disable();
//        鉴权
        http
                .authorizeRequests()
                .antMatchers("/authTest").permitAll()
                .antMatchers("/user/**").hasAnyRole("user") //故意写成小写，报403错误
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()

//                走UsernamePasswordAuthenticationHandler
                .and()
                .formLogin()
                .permitAll();

//        异常处理
        http
                .exceptionHandling()
                .authenticationEntryPoint(anonymousAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler);

        http.addFilterAt(customAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(tokenAuthFilter,UsernamePasswordAuthenticationFilter.class);
    }




    @Override
    public void configure(WebSecurity web) throws Exception {
//  这个会在上面的过滤器执行之前执行
        web.ignoring().antMatchers("/loginUsr");
    }


}
