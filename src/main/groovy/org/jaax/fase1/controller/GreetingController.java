package org.jaax.fase1.controller;

import org.jaax.fase1.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting/{name}")
    public Greeting helloWorld(@RequestParam(value="name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
}
