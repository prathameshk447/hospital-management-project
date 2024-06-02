package org.dnyanyog.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder
        .routes()
        .route(
            "appointment_route", r -> r.path("/api/v1/appointment/add**").uri("http://localhost:8084"))
        .route("patient_route", r -> r.path("/api/v1/patient/add**").uri("http://localhost:8082"))
        .route("case_route", r -> r.path("/api/v1/case/add**").uri("http://localhost:8083"))
        .route("directory_route", r -> r.path("/api/v1/directory/add**").uri("http://localhost:8081"))
        .build();
  }
}
