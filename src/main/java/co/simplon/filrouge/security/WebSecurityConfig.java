package co.simplon.filrouge.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import co.simplon.filrouge.security.JWTRoleAuthenticationFilter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		  http.csrf().disable()
		  	.authorizeRequests().antMatchers("/api1").permitAll()
		  		.and()
		  		.addFilterBefore(new JWTRoleAuthenticationFilter("role1"),  UsernamePasswordAuthenticationFilter.class)
		  	.authorizeRequests().antMatchers("/api2").permitAll()
		  		.and()
		  		.addFilterBefore(new JWTRoleAuthenticationFilter("role2"),  UsernamePasswordAuthenticationFilter.class);
	  }
}
