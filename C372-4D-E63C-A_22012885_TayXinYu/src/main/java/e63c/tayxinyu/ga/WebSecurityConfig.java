package e63c.tayxinyu.ga;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public MemberDetailsService memberDetailsService() {
		return new MemberDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(memberDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
	        .requestMatchers("/items/add", "/items/edit/*", "/items/save", "/items/delete/*").hasRole("ADMIN")
	        .requestMatchers("/members/add", "/members/edit/*", "/members/save", "/members/delete/*").hasRole("ADMIN")
        	.requestMatchers("/", "/items", "/items/*", "/members", "/aboutus", "/cart").permitAll() //Page are visible without logging in
        	.requestMatchers("/bootstrap/*/*").permitAll() //for static resources, visible to all
        	.requestMatchers("/img/*").permitAll() //for static resources, visible to all
            .anyRequest().authenticated()//Other requests such as to view an item with id 1: /items/1            
			) //end of authorizeHttpRequests 
		.formLogin((login) -> login.loginPage("/login").permitAll().defaultSuccessUrl("/")) //Goes to homepage upon login
		.logout((logout) -> logout.logoutSuccessUrl("/")) //Goes to homepage upon logout					        
		.exceptionHandling((exceptionHandling) -> exceptionHandling.accessDeniedPage("/403"));

		return http.build();
	}

}
