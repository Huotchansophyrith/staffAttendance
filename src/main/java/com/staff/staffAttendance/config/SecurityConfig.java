package com.staff.staffAttendance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

        @Override
        protected void configure(HttpSecurity http) throws Exception {

//            String[] permitAllUrl = {"/plugins/**", "/js/**", "/css/**", "/img/**", "/login/**", "/js/**", "/dist/**", "/index","/api/v1/**"
//            };

//            String[] permitAllUrl = {"/", "/login/**", "/login-error", "/plugins/**",
//                    "/js/**", "/dist/**", "/index","/api/v1/**"
//            };


            String[] permitAllUrl = {"/login/**", "/login-error", "/plugins/**",
                    "/js/**", "/dist/**", "/index","/api/v1/**"
            };

            http.authorizeRequests(authorizeRequests -> authorizeRequests
                    .antMatchers(permitAllUrl)
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            ).formLogin(formLogin -> formLogin
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .failureUrl("/login-error")
            ).logout(logout -> logout
                    .logoutUrl("/logout")
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/login")
            ).csrf().disable();
        }

        /**
         * Configure global.
         *
         * @param auth the auth
         * @throws Exception the exception
         */

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) {
            auth.authenticationProvider(customAuthenticationProvider);
        }





}
