package org.example.clienta;

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
public class ClientAAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientAAApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return  restTemplateBuilder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping
    @ResponseBody
    public String getService() {
        String result = restTemplate.getForObject("http://client-b-a", String.class);
        return applicationName + "->" + result;
    }

}
