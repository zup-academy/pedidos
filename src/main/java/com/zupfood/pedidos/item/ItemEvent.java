package com.zupfood.pedidos.item;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemEvent {

    private Long id;

    private int quantidade;

    private Long sku;

    private BigDecimal valor;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataCriado;

    public ItemEvent() {
    }

    public ItemEvent(Long id, int quantidade, Long sku, BigDecimal valor, LocalDateTime dataCriado) {
        this.id = id;
        this.quantidade = quantidade;
        this.sku = sku;
        this.valor = valor;
        this.dataCriado = dataCriado;
    }

    public Long getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Long getSku() {
        return sku;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getDataCriado() {
        return dataCriado;
    }
}
