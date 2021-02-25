package com.adroitwolf.config;

import com.adroitwolf.handler.CustomAuthenticationFilter;
import com.adroitwolf.handler.LoginFailedHandler;
import com.adroitwolf.handler.LoginSuccessHandler;
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
 * Description: ://TODO ${END}
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    LoginFailedHandler loginFailedHandler;


    @Autowired
    AuthenticationEntryPoint anonymousAuthenticationEntryPoint;


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
        http.csrf().and().cors().disable();
        http
                .authorizeRequests()
                .antMatchers("/authTest").permitAll()
                .anyRequest().authenticated()


                .and()
//                .exceptionHandling()
//                .authenticationEntryPoint(anonymousAuthenticationEntryPoint)
//                .and()
                .formLogin()
//                .loginPage("/login")
                .loginProcessingUrl("/loginUsr")
//                .successHandler(loginSuccessHandler)
                .permitAll();

        http.exceptionHandling().authenticationEntryPoint(anonymousAuthenticationEntryPoint);

        http.addFilterAt(customAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class);
    }




    @Override
    public void configure(WebSecurity web) throws Exception {
//  这个会在上面的过滤器执行之前执行
        web.ignoring().antMatchers("/loginUsr");
    }


}
