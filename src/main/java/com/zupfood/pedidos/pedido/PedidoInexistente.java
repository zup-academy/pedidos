package com.zupfood.pedidos.pedido;

public class PedidoInexistente extends RuntimeException{

    public PedidoInexistente() {
        super("Não foi possível encontrar o pedido com esse código em nossa base de dados");
    }
}
