package org.sid.auth_security;

import org.sid.auth_security.Entity.AppUser;
import org.sid.auth_security.Filter.JwtAuthenticationFilter;
import org.sid.auth_security.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 @Autowired
 private AccountService accountService;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                AppUser appUser=accountService.loadUserByUsername(username);
                Collection<GrantedAuthority> authorities=new ArrayList<>();
                appUser.getAppRoles().forEach(r->{
                    authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
                });
                return new User(appUser.getUsername(),appUser.getPassword(),authorities);
            }
        });
    }

    @Override
     protected void configure(HttpSecurity http) throws Exception{
          http.csrf().disable();
          http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
          http.headers().frameOptions().disable();
          //http.formLogin();
        http.authorizeRequests().antMatchers("h2-console/**").permitAll();
          http.authorizeHttpRequests().anyRequest().authenticated();
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
     }
@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}