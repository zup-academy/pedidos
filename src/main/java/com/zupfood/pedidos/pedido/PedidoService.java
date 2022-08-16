package com.zupfood.pedidos.pedido;

import com.zupfood.pedidos.cliente.ClienteClient;
import com.zupfood.pedidos.cliente.ClienteResponse;
import com.zupfood.pedidos.restaurante.RestauranteClient;
import com.zupfood.pedidos.restaurante.RestauranteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    Logger logger = LoggerFactory.getLogger(PedidoService.class);

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteClient clienteClient;

    @Autowired
    private RestauranteClient restauranteClient;

    public Pedido incluir(Pedido pedido){
        ClienteResponse cliente = clienteClient.getCliente(pedido.getIdCliente());
        if(cliente==null){ throw new IllegalArgumentException("Id do cliente inválido");}

        RestauranteResponse restaurante = restauranteClient.getRestaurante(pedido.getIdRestaurante());
        if(restaurante==null){ throw new IllegalArgumentException("Id do cliente inválido");}

        logger.info("Recebendo o email do cliente " + cliente.getEmail());

        return pedidoRepository.save(pedido);
    }

    public void atualizarStatus(Long id, Status status){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        pedido.atualizaStatus(status);

        pedidoRepository.save(pedido);
    }

    public Pedido buscar(Long id){
        return pedidoRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

    }
}
