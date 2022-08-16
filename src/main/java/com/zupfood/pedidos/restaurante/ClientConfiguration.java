package com.zupfood.pedidos.restaurante;

import feign.Feign;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoderGenerico(){
        return new ErrorDecoder();
    }

    @Bean
    public Feign clientRestaurante() {
        return Feign.builder()
                .logLevel(feignLoggerLevel())
                .errorDecoder(errorDecoderGenerico())
                .build();
    }


}
