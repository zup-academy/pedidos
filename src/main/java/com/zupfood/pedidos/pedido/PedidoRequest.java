package com.zupfood.pedidos.pedido;

import com.zupfood.pedidos.item.ItemRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class PedidoRequest {

    @NotNull
    private Long idCliente;

    @NotNull
    private Long idRestaurante;

    @NotEmpty
    private List<ItemRequest> items;

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public void setItems(List<ItemRequest> items) {
        this.items = items;
    }

    public List<ItemRequest> getItems() {
        return items;
    }

    public Pedido getPedido() {
        var items = ItemRequest.getItems(this.getItems());

        return new Pedido(this.idCliente, this.idRestaurante, items);
    }
}
