package com.blumbit.web.api.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class TesterController {

    @GetMapping("/hello-1")
    public String helloAdmin() {
        return "Hola admin desde Spring boot Keycloak";
    }
    @GetMapping("/hello-2")
    public String helloUser() {
        return "Hola user desde Spring boot Keycloak";
    }
}
