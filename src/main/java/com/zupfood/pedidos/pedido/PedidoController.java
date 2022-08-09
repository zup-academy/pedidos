package com.zupfood.pedidos.pedido;

import com.zupfood.pedidos.item.ItemRepository;
import com.zupfood.pedidos.item.ItemRequest;
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
    private ItemRepository itemRepository;

    @Autowired
    private PedidoNovoProducer pedidoNovoProducer;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public PedidoResponse novoPedido(@RequestBody PedidoRequest request){
        var pedido = request.getPedido();
        pedido = pedidoRepository.save(pedido);

        var itens = request.getItens(pedido);
        itemRepository.saveAll(itens);

        logger.info("Pedido de código {} cadastrado com sucesso",pedido.getId());

        pedidoNovoProducer.enviar(pedido, itens);

        return PedidoResponse.of(pedido, itens);
    }
}
