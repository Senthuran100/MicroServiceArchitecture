package com.senthuran.Server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

   @GetMapping("/rest/server")
    public String hello(){
       return "Hello Server";
   }
}
