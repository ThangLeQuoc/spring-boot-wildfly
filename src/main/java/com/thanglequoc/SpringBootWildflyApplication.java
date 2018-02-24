package com.thanglequoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootWildflyApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
	SpringApplication.run(SpringBootWildflyApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(SpringBootWildflyApplication.class);
    }
}

@RestController
class GreetingController {
    @RequestMapping("/")
    String home() {
	return "Now you see me !";
    }

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable String name) {
	return "";
    }
}
