package com.example.springwebflux.annotatedcontroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class GreetingController {

    @GetMapping("/spring-webflux/annotated-controller/hello")
    public Mono<String> getHello(@RequestParam(name = "name", defaultValue = "world") String name) {
        log.info("name={}", name);
        return Mono.just(String.format("Hello, %s! from webflux", name));
    }
}
