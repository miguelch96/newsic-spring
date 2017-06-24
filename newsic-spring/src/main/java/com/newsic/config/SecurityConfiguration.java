package com.newsic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)//Nos permite escribir anotacion para controlar el acceso a los metodos segun la seguridad
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userService;

	//Servira para añadir el userDetails que se creo con anterioridad
	@Autowired
	public void configureClobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
			.antMatchers("/artistas/registro","/registro","/css/**", "/images/**", "/audio/**","/js/**", "/css/theme/**","/fonts/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").loginProcessingUrl("/logincheck")
			.usernameParameter("username").passwordParameter("password")
			.defaultSuccessUrl("/loginsuccess").permitAll()
			.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
			.permitAll();
		
	}

}