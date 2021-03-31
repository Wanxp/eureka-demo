package org.example.servera;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class ServerAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerAApplication.class, args);
    }

    @EventListener
    public void processEurekaRegistryAvailableEvent(EurekaRegistryAvailableEvent event) {
        log.warn("====================================");
        log.warn("eureka服务上线:{},{}", event.getTimestamp(), event.getSource());
        log.warn("====================================");
    }

    @EventListener
    public void processEurekaServerStartedEvent(EurekaServerStartedEvent event) {
        log.warn("====================================");
        log.warn("eureka服务启动完成:{},{}", event.getTimestamp(), event.getSource());
        log.warn("====================================");
    }

}
