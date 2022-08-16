package com.zupfood.pedidos.pedido;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private PedidoService pedidoService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public PedidoResponse novoPedido(@RequestBody PedidoRequest request){

        Pedido pedido = request.getPedido();

        pedido = pedidoService.incluir(pedido);

        logger.info("Pedido de código {} cadastrado com sucesso",pedido.getId());

        return PedidoResponse.of(pedido);
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizaStatus(@PathVariable Long id,@RequestBody StatusRequest request){

        pedidoService.atualizarStatus(id, request.getStatus());

        logger.info("Pedido de código {} atualizado status com sucesso",id);
    }

    @GetMapping("/{id}")
    public PedidoResponse buscar(@PathVariable Long id){

        Pedido pedido = pedidoService.buscar(id);

        return PedidoResponse.of(pedido);
    }

}
