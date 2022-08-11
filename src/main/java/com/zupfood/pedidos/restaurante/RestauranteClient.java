package com.zupfood.pedidos.restaurante;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "restaurante", url = "http://localhost:8082/", configuration = RestauranteClientConfiguration.class)
public interface RestauranteClient {

    @GetMapping(value = "restaurantes/{id}", produces = "application/json")
    public RestauranteResponse getRestaurante(@PathVariable("id") Long id);

}
