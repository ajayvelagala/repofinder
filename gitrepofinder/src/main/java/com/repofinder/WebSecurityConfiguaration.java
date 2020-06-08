/**
 * 
 */
package com.repofinder;

/**
 * @author anupb
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;



/*@Configuration
@EnableWebSecurity
public class WebSecurityConfiguaration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/h2**").permitAll();
		http.authorizeRequests().antMatchers("/hello").access("hasRole('ROLE_ADMIN')").and().formLogin();
		
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).
		withUser("ajay").password("ajay").roles("ADMIN");
	}*/
//}
