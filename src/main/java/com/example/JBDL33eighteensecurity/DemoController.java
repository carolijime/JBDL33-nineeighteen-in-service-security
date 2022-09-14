package com.example.JBDL33eighteensecurity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String greet(){
        return "Hello World!";
    }

    @GetMapping("/demo2")
    public String greet2(){
        return "Hello World2!";
    }

    @GetMapping("/testcode")
    public String testCode(){
        return "Testing the code...";
    }

    @GetMapping("/developcode")
    public String developCode(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUser myUser = (MyUser) authentication.getPrincipal();
        return myUser.getName() + " is Developing the code...";
    }

    @GetMapping("/accessserver")
    public String accessServer(){
        return "Accessing the server...";
    }

    @PostMapping("/home")
    public String home(){
        return "Welcome to the home page...";
    }

    @GetMapping("/home/all")
    public String homeAll(){
        return "Welcome to the home page all...";
    }

    // sign up API to create user
    // POST method is consired a non-safe method. Non-safe methods can not be permitted all with csrf enabled (by default is enabled)
    // We have disabled csrf in DemoConfig so we can use POST method (line .csrf().disable())
    @PostMapping("/signup")
    public void signup(@RequestParam("name") String name,
                       @RequestParam("email") String email,
                       @RequestParam("password") String password, //encrypted pwd : algorithm
                       @RequestParam("authority") String authority){

    }



}

/*
    Request comes to the BE
    1. JSESSIONID sent is of authenticated session / user
            BE work : verify the session id, return of the request resource
    2. JSESSIONID sent is of unauthenticated session / user
            BE work: verify the session id, redirect to /login API
            End user: pass the credentials
            FE: makes a call to /login API with unauthenticated JSESSION ID + payload (username + password)
            BE: verify on basis of username and pwd and generate a new authenticated session and return the id of that as a set-cookie in the response header


 */
