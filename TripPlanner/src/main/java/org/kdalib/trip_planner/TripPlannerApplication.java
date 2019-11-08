package org.kdalib.trip_planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TripPlannerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TripPlannerApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").
                        allowedOrigins("http://localhost:3000").
                        allowedMethods("POST", "GET", "HEAD");
            }
        };
    }
}
