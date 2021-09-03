package com.rest.webservices.restfulwebservices.controller;

import com.rest.webservices.restfulwebservices.data.HelloBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(method= RequestMethod.GET,path = "/hello-world")
    public String Hello(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloBean HelloBean(){
        return new HelloBean("Hello World from Bean");
    }

    @GetMapping(path = "/hello-world-variable/{name}")
    public HelloBean HelloBean(@PathVariable String name){
        return new HelloBean(String.format("Hello World from Bean, %s",name));
    }




}