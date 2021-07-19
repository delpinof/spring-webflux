package com.example.springweb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    HelloService service;

    @GetMapping("/spring-mvc/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "world") String name) {
        log.info("name={}", name);
        return service.hello(name);
    }
}
