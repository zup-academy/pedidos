package com.zupfood.pedidos.item;

import com.zupfood.pedidos.pedido.Pedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ItemRequest {

    private int quantidade;

    private Long sku;

    private BigDecimal valor;

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Item getItem(Pedido pedido){
        return new Item(this.quantidade, this.sku, this.valor, pedido);
    }

    public static List<Item> getItems(List<ItemRequest> items, Pedido pedido){
        return items.stream().map(i -> i.getItem(pedido)).collect(Collectors.toList());
    }
}
