package com.codeup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

//    @RequestMapping(path = "/hello")
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        return "<h1>Hello from Spring!" + name + "</h1>";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "<h1>Hello from Spring!</h1>";
    }

    @GetMapping("/increment/{number}")
    @ResponseBody
    public String increment(@PathVariable int number) {
        return number+ " plus one is " + (number + 1);
    }

}
