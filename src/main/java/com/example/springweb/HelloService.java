package com.example.springweb;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

    public String hello(String name) {
        return String.format("Hello, %s! from spring-mvc", name);
    }

}
