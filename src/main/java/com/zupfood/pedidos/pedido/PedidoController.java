package com.zupfood.pedidos.pedido;

import com.zupfood.pedidos.item.ItemRepository;
import com.zupfood.pedidos.item.ItemRequest;
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

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public PedidoResponse novoPedido(@RequestBody PedidoRequest request){
        var pedido = request.getPedido();
        pedido = pedidoRepository.save(pedido);

        var items = ItemRequest.getItems(request.getItems(),pedido);
        items = itemRepository.saveAll(items);

        return PedidoResponse.of(pedido,items);
    }
}
