package com.zupfood.pedidos.restaurante;

import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestauranteClientConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public Feign clientRestaurante() {
        return Feign.builder().logLevel(feignLoggerLevel()).build();
    }

}
