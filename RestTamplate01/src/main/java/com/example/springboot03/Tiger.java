package com.example.springboot03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.*;
@RestController
@RequestMapping("/app1")
class AppController {

    @Autowired
    RestTemplate rt;

    @GetMapping("")
    @HystrixCommand(fallbackMethod = "tiger")
    String f1() {
        System.out.println("app1");
        String result = rt.getForObject(
                "http://localhost:8082/bpp1"
                , String.class
        );
        return "app 1 : " + result;
    }
    public String tiger(){
        return "기본 광고를 시작합니다.";
    }
}}