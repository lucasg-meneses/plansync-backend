package br.com.lucasgmeneses.plansync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class PlanSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanSyncApplication.class, args);
	}

}
