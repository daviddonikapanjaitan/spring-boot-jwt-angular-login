package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
      .route("api_auth", r -> r.path("/api/auth/**")
        .uri("http://localhost:8080"))
      .route("api_auth", r -> r.path("/api/test/**")
        .uri("http://localhost:8080"))
      .route("path_route", r -> r.path("/**")
        .uri("http://localhost:4200"))
      .build();
  }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
