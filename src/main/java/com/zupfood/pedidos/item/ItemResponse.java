package com.zupfood.pedidos.item;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemResponse {

    private Long id;

    private int quantidade;

    private Long sku;

    private BigDecimal valor;

    private LocalDateTime dataCriado;

    public ItemResponse(Long id, int quantidade, Long sku,
                        BigDecimal valor, LocalDateTime dataCriado) {
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

    public  static ItemResponse of(Item item){
        return new ItemResponse(item.getId(), item.getQuantidade(),
                item.getSku(), item.getValor(), item.getDataCriado());
    }
}
