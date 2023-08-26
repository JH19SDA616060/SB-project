package com.example.Minor_Project2.configs;


import com.example.Minor_Project2.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // authentication + authorization + PE

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Value("${users.admin.authority}")
    String adminAuthority;


    @Value("${users.student.authority}")
    String studentAuthority;


    // Spring security configs
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/student_for_admin/**").hasAuthority(adminAuthority)
                .antMatchers(HttpMethod.POST, "/student/**").permitAll()
                .antMatchers("/student/**", "/transaction/**").hasAuthority(studentAuthority)
                .antMatchers("/book/search/**").hasAnyAuthority(studentAuthority, adminAuthority)
                .antMatchers("/book/**").hasAuthority(adminAuthority)
                .antMatchers("/**").permitAll()
                .and()
                .formLogin();

    }




}
