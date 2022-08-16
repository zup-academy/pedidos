package com.zupfood.pedidos.restaurante;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "restaurante", url = "${endpoint.restaurante}", configuration = ClientConfiguration.class)
public interface RestauranteClient {

    @GetMapping(value = "/{id}", produces = "application/json")
    public RestauranteResponse getRestaurante(@PathVariable("id") Long id);


}
