package com.zupfood.pedidos.pedido;

import com.zupfood.pedidos.cliente.ClienteClient;
import com.zupfood.pedidos.cliente.ClienteResponse;
import com.zupfood.pedidos.item.ItemRepository;
import com.zupfood.pedidos.item.ItemRequest;
import com.zupfood.pedidos.restaurante.RestauranteClient;
import com.zupfood.pedidos.restaurante.RestauranteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private RestauranteClient restauranteClient;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public PedidoResponse novoPedido(@RequestBody PedidoRequest request){

        var pedido = request.getPedido();

        ClienteResponse cliente = clienteClient.getCliente(pedido.getIdCliente());
        if(cliente==null){ throw new IllegalArgumentException("Id do cliente inválido");}

        RestauranteResponse restaurante = restauranteClient.getRestaurante(pedido.getIdRestaurante());
        if(restaurante==null){ throw new IllegalArgumentException("Id do cliente inválido");}

        pedido = pedidoRepository.save(pedido);

        logger.info("Pedido de código {} cadastrado com sucesso",pedido.getId());

        return PedidoResponse.of(pedido);
    }
}
