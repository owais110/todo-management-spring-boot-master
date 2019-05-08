package net.guides.springboot.todomanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {        auth.inMemoryAuthentication()
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
        		.withUser("admin").password("admin")
                .roles("USER", "ADMIN");
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		 http
         .csrf().disable()
         .authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/login").permitAll()
        .antMatchers("/welcome").permitAll()
        .antMatchers("/list-todos").permitAll()
        .antMatchers("/add-todo").permitAll();
       // .anyRequest().authenticated();
		}   
}