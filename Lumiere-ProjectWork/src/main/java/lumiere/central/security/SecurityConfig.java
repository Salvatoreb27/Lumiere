package lumiere.central.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
 * https://docs.spring.io/spring-security/reference/5.8/migration/servlet/config.html
 * https://www.appsdeveloperblog.com/migrating-from-deprecated-websecurityconfigureradapter/
 * https://www.danvega.dev/blog/2022/12/01/spring-security-6/
 * https://reflectoring.io/spring-security
 * https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html#authorize-requests
 * https://www.baeldung.com/spring-security-session
 * https://www.devxperiences.com/pzwp1/2023/01/31/spring-boot-security-configuration-practically-explained-part6-a-deep-intro-to-filter-token-based-security/
 * https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/form.html
 * https://www.codeburps.com/post/spring-boot-form-login
 * https://youtu.be/FLxDnRQonUA
 * https://howtodoinjava.com/spring-security/spring-boot-role-based-authorization/
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	//@Primary
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf((csrf) -> csrf.disable())
		.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/**").permitAll()
				//.requestMatchers("/", "/home", "/images/**", "/css/**").permitAll()
				//.requestMatchers("/error").permitAll()
				//.requestMatchers("/admin/**").hasRole("ADMIN")
				//.requestMatchers("/user/**").hasRole("USER")
				//.anyRequest().authenticated()
				)
		.formLogin(form -> form
				.loginPage("/utenti/login")
				//.defaultSuccessUrl("/home")
				.permitAll()
				)
		.sessionManagement((session) -> session
				.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));
		return http.build();
	}
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
}