package com.example.hanium.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean // 비밀번호 암호화 등록
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().frameOptions().disable();

        http.authorizeRequests()
                //회원가입 페이지 허용
                .antMatchers("/user/**").permitAll()
                //h2-console페이지 허용
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated() // anyRequest: 어떤 요청이 오든지 로그인 과정이 없으면 로그인
                .and()
                .formLogin()
                .loginPage("/user/login") // 로그인이 필요할 떄 필요한 페이지의 위치 지정
                .failureUrl("/user/login/error") // 로그인 실패했을 때 해당되는 url로 위치 지정
                .defaultSuccessUrl("/") // 로그인이 완료되었을 때 이동할 위치 (home)
                .permitAll() //로그인 페이지에 대해서는 허용
                .and()
                .logout()
                .logoutUrl("/user/logout") // Controller 없이 security가 알아서 요청이 들어오면 logout
                .permitAll(); // 로그아웃 기능도 허용
    }
}
