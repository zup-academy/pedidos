package com.zupfood.pedidos.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cliente", url = "${endpoint.cliente}")
public interface ClienteClient {

    @GetMapping(value = "/{id}", produces = "application/json")
    public ClienteResponse getCliente(@PathVariable("id") Long id);

}
