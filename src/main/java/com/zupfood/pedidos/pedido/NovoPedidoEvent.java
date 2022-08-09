package com.zupfood.pedidos.pedido;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zupfood.pedidos.item.ItemEvent;

import java.time.LocalDateTime;
import java.util.List;

public class NovoPedidoEvent {

    private Long id;

    private Long idCliente;

    private Long idRestaurante;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataCriado;

    private List<ItemEvent> itens;

    public NovoPedidoEvent(Long id, Long idCliente, Long idRestaurante, LocalDateTime dataCriado, List<ItemEvent> itens) {
        this.id = id;
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
        this.dataCriado = dataCriado;
        this.itens = itens;
    }

    public NovoPedidoEvent() {
    }

    public Long getId() {
        return id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public LocalDateTime getDataCriado() {
        return dataCriado;
    }

    public List<ItemEvent> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "NovoPedidoEvent{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idRestaurante=" + idRestaurante +
                ", dataCriado=" + dataCriado +
                '}';
    }
}
