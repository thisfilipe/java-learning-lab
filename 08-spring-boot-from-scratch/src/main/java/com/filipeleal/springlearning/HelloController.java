package com.filipeleal.springlearning;

import java.util.Map;
import java.time.Instant;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HelloController {
    private final Calculator calculator;

    private final ApplicationAvailability availability;

    public HelloController(Calculator calculator, ApplicationAvailability availability) {
        this.calculator = calculator;
        this.availability = availability;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring!";
    }

    @GetMapping("/status")
    public Map<String, String> status() {
        return Map.of("liveness", availability.getLivenessState().toString(), "readiness", availability.getReadinessState().toString(), "timestamp", Instant.now().toString());
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", defaultValue = "visitor") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/sum")
    public String soma(@RequestParam(name = "number1", defaultValue = "0") int a, @RequestParam(name = "number2", defaultValue = "0") int b) {
        return "Result: " + calculator.add(a, b);
    }

    @PostMapping("/echo")
    public Map<String, Object> eco(@RequestBody Map<String, Object> payload) {
        return payload;
    }
}
