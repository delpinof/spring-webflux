package com.example.springwebflux.functionalendpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        Optional<String> optionalName = request.queryParam("name");
        String name = "world";
        if (!name.isEmpty())
            name = optionalName.get();
        log.info("name={}", name);
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue(String.format("Hello, %s! from spring-webflux", name)));
    }
}
