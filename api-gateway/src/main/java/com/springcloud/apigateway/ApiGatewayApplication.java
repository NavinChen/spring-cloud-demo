package com.springcloud.apigateway;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        // SpringApplication.run(ApiGatewayApplication.class, args);
        new SpringApplicationBuilder(ApiGatewayApplication.class).web(true).run(args);
    }
    
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
    
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)",
                 "${version}/${name})");
    }
    
}
