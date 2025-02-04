package com.example.demo.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunController {

    @GetMapping("/run")
    String home() {
        return "Hello, runnerz!";
    }

}
