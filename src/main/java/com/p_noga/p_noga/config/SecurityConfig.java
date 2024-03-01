package com.p_noga.p_noga.config;

import com.p_noga.p_noga.dto.security.UserDetailImpl;
import com.p_noga.p_noga.service.UsersService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// enable은 spring에 이미 있기 때문에 사용하지 않아도 된다.
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf().disable() // api 사용시 필요한 옵션
            .authorizeRequests(auth -> auth
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .mvcMatchers(
                    HttpMethod.GET,
                    "/"
                ).permitAll()
                .mvcMatchers(
                    HttpMethod.POST,
                    "/users/signup"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin()
                .defaultSuccessUrl("/users/login/result")
                .permitAll()
            .and()
            .logout()
                .logoutSuccessUrl("/login")
                .and()
            .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UsersService usersService){
        return username -> usersService
            .searchUser(username)
            .map(UserDetailImpl::from)
            .orElseThrow(() -> new UsernameNotFoundException("유저를 찾을 수 없습니다 - username: " + username));
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
