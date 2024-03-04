package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" that return "Hello World"

    @GetMapping("/a")
    public String sayHello() {
        return "Hello World!";
    }

    // expose new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a 5km!!";
    }

    //expose new endpoint for "fortune"

    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is lucky day";
    }

}


