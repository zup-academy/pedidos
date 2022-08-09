package com.zupfood.pedidos.pedido;

public class PedidoCanceladoEvent {

    private Long id;

    private Long idCliente;

    private Long idRestaurante;


    public PedidoCanceladoEvent(Long id, Long idCliente, Long idRestaurante) {
        this.id = id;
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
    }

    public PedidoCanceladoEvent() {
    }

    @Override
    public String toString() {
        return "PedidoCanceladoEvent{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idRestaurante=" + idRestaurante +
                '}';
    }
}
