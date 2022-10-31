package com.example.healthcareapi.securityconfigs;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.healthcareapi.service.AppUserService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfigs {

	private final static String [] exceptionalEndpoints= {"/signin","/register"};
	private final DaoAuthenticationProvider authprovider = new DaoAuthenticationProvider();
	
	@Bean 
	AuthenticationManager authManager(AppUserService userdetailsservice) {
		authprovider.setUserDetailsService(userdetailsservice);
		authprovider.setPasswordEncoder(encoder());
		return new ProviderManager(authprovider);
	}
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.cors().configurationSource(configSource());
		http.csrf().disable().authorizeRequests(request ->{
			try {
				request.antMatchers(exceptionalEndpoints).permitAll()
				.anyRequest().authenticated()
				.and().exceptionHandling()
				.and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}).oauth2ResourceServer(OAuth2ResourceServerConfigurer :: jwt)
		.logout().logoutUrl("/logout").permitAll().logoutSuccessUrl("/default");
		
		return http.build();
	}
	
	
	@Bean
	public WebSecurityCustomizer customizer() {
		return web->web.ignoring().antMatchers("/h2-console/**");
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	CorsConfigurationSource configSource() {
	CorsConfiguration corsConfiguration = new CorsConfiguration();
	corsConfiguration.setAllowCredentials(true);
	corsConfiguration.setAllowedOrigins (Arrays.asList("http://localhost:6500"));
	corsConfiguration.setAllowedHeaders (Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
	"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
	"Access-Control-Request-Method", "Access-Control-Request-Headers")); 
	corsConfiguration.setExposedHeaders (Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
	"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")); 
	corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	corsConfiguration.addExposedHeader("Authorization");
	UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
	urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
	return urlBasedCorsConfigurationSource;
}
}
