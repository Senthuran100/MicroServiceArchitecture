package com.senthuran.Client;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class HelloResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/rest/client")
    public String hello(){
        String url="http://SERVER/rest/server";
        return restTemplate.getForObject(url,String.class) + "  client8";
    }

}
