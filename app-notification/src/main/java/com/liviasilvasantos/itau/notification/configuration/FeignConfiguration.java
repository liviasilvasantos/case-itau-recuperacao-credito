package com.liviasilvasantos.itau.notification.configuration;

import feign.Logger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.liviasilvasantos.itau.notification.gateway.feign"})
public class FeignConfiguration {

    @Bean
    Logger.Level loggerLevel() {
        return Logger.Level.FULL;
    }
}
