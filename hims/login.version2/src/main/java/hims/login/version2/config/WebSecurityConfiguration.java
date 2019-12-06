package hims.login.version2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.SessionManagementFilter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
				addFilterBefore(corsFilter(), SessionManagementFilter.class)
				.exceptionHandling()
				.authenticationEntryPoint((request, response, authException) -> response.sendError(response.SC_UNAUTHORIZED,authException.getMessage()))
				.and()
				.csrf().disable()
				.anonymous().disable()
				.authorizeRequests()
				.antMatchers("/authentication").permitAll()
				.antMatchers("/oauth/token").permitAll()
				.antMatchers("/**").authenticated()
				.and()
				.httpBasic();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	CustomCorsFilter corsFilter(){

		CustomCorsFilter corsFilter = new CustomCorsFilter();

		return corsFilter;

	}

}
