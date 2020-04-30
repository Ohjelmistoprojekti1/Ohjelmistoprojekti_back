package com.team5.projekti.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.team5.projekti.domain.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				//.antMatchers("/deleteradio/**", "/add", "/answers").hasAuthority("ADMIN")//Tarvitsee adminin kyseisiin URL:hin hasRole
				.antMatchers(HttpMethod.POST, "/vastaus").permitAll()
				.antMatchers("/deleteradio/**", "/add", "/answers", "/kysymys/**", "/vastaus").permitAll()
				.anyRequest().authenticated()
				.and()			
				// .antMatchers("//**", "/deleteradio/**", "/add", "/answers").hasRole("ADMIN") //Tarvitsee adminin kyseisiin URL:hin hasRole
				// .antMatchers("/").permitAll() //Kuka vain pääsee, koska permitAll() 
				// .anyRequest().authenticated()
				// .and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/index")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
	
}
