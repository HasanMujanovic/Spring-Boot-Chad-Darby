package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class FunRestController {

    // expose "/" that return "Hello World"

    @GetMapping("/a")
    public String sayHello() {
        return "Hello World!";
    }
    @GetMapping("/b")
    public String sayHello2(){
        return "Radil??!";
    }
    @GetMapping("/c")
    public int broj(){
        return 23;
    }

}


