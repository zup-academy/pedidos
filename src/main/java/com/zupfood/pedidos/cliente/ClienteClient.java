package com.zupfood.pedidos.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cliente", url = "http://localhost:8081/")
public interface ClienteClient {

    @GetMapping(value = "clientes/{id}", produces = "application/json")
    public ClienteResponse getCliente(@PathVariable("id") Long id);

}
