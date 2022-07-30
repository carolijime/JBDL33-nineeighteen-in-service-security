package com.example.JBDL33eighteensecurity;

import org.springframework.web.bind.annotation.GetMapping;
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
    public String developeCode(){
        return "Developing the code...";
    }

    @GetMapping("/accessserver")
    public String accessServer(){
        return "Accessing the server...";
    }

    @GetMapping("/home")
    public String home(){
        return "Welcome to the home page...";
    }

    @GetMapping("/home/all")
    public String homeAll(){
        return "Welcome to the home page all...";
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
