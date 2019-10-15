package br.com.angular.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.com.angular.controller.TokenFilter;

@SpringBootApplication
public class ApiwebApplication {

	@Bean
	public FilterRegistrationBean FiltroJwt() {
		FilterRegistrationBean frb = new FilterRegistrationBean();
		frb.setFilter(new TokenFilter());
		frb.addUrlPatterns("/admin/*");
		return frb;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiwebApplication.class, args);
	}

}
