package com.example.springwebflux.functionalendpoint;

import com.example.springwebflux.functionalendpoint.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GreetingRouter {
    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        RequestPredicate requestPredicate = RequestPredicates
                .GET("/spring-webflux/functional-endpoint/hello")
                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN));
        return RouterFunctions.route(requestPredicate, greetingHandler::hello);
    }
}
