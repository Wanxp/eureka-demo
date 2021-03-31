package org.example.clientb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ClientBAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientBAApplication.class, args);
    }

    @Value("${spring.application.name}")
    private String applicationName;



    @RequestMapping
    @ResponseBody
    public String getService() {
        return applicationName;
    }



}
