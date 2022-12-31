package com.liviasilvasantos.itau.payment.configuration;

import feign.Logger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.liviasilvasantos.itau.payment.gateway.feign"})
public class FeignConfiguration {

    @Bean
    Logger.Level loggerLevel() {
        return Logger.Level.FULL;
    }
}
