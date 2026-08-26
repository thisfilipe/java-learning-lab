package com.filipeleal.springbootaprendizado;

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
    private final Calculadora calculadora;

    private final ApplicationAvailability availability;

    public HelloController(Calculadora calculadora, ApplicationAvailability availability) {
        this.calculadora = calculadora;
        this.availability = availability;
    }

    @GetMapping("/ola")
    public String ola() {
        return "Olá, Spring!";
    }

    @GetMapping("/status")
    public Map<String, String> status() {
        return Map.of("liveness", availability.getLivenessState().toString(), "readiness", availability.getReadinessState().toString(), "timestamp", Instant.now().toString());
    }

    @GetMapping("/saudacao")
    public String saudacao(@RequestParam(name = "nome", defaultValue = "visitante") String nome) {
        return "Olá, " + nome + "!";
    }

    @GetMapping("/soma")
    public String soma(@RequestParam(name = "numero1", defaultValue = "0") int a, @RequestParam(name = "numero2", defaultValue = "0") int b) {
        return "Resultado: " + calculadora.somar(a, b);
    }

    @PostMapping("/eco")
    public Map<String, Object> eco(@RequestBody Map<String, Object> payload) {
        return payload;
    }
}
