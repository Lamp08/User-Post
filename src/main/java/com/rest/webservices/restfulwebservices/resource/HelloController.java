package com.rest.webservices.restfulwebservices.resource;

import com.rest.webservices.restfulwebservices.data.HelloBean;
import org.apache.tomcat.util.http.parser.AcceptLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloController {

    @Autowired
    private MessageSource messageSource ;

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

    @GetMapping(path = "/hello-world-bean-int")
    public String HelloBeanInternationalize(
            @RequestHeader(name = "Accept-Language",required = false) Locale locale
            ){
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }
}