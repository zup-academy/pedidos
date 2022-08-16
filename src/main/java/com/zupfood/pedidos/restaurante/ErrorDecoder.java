package com.zupfood.pedidos.restaurante;

import feign.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorDecoder implements feign.codec.ErrorDecoder {

    private final feign.codec.ErrorDecoder defaultErrorDecoder = new Default();
    Logger logger = LoggerFactory.getLogger(ErrorDecoder.class);

    @Override
    public Exception decode(String s, Response response) {
        if (400 == response.status()) {
           logger.info(" Erro : {} ", response.body());
        }
        logger.info(" Entrou no decoder ");
        return defaultErrorDecoder.decode(s, response);
    }
}
