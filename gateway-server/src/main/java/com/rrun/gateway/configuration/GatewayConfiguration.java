package com.rrun.gateway.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rrun.gateway.filter.AuthFilter;
import com.rrun.gateway.filter.AuthFilterConfig;

@Configuration
public class GatewayConfiguration {

	@Autowired
	private AuthFilter authenticationFilter;

	@Bean
	public RouteLocator gateWayRoutes(RouteLocatorBuilder builder) {
		return builder.routes().route("guest-service", r -> r.path("/v1/api/users/**")
				.filters(f -> f.filter(authenticationFilter.apply(new AuthFilterConfig()))).uri("lb://guest-service"))
				.route("book-service",
						r -> r.path("/v1/api/books/**")
								.filters(f -> f.filter(authenticationFilter.apply(new AuthFilterConfig())))
								.uri("lb://book-service"))
				.route("payment-service",
						r -> r.path("/v1/api/payments/**")
								.filters(f -> f.filter(authenticationFilter.apply(new AuthFilterConfig())))
								.uri("lb://payment-service"))
				.route("reservation-service",
						r -> r.path("/v1/api/reservations/**")
								.filters(f -> f.filter(authenticationFilter.apply(new AuthFilterConfig())))
								.uri("lb://reservation-service"))
				.build();

	}
}
