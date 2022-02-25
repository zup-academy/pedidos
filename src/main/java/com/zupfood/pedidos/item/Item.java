package com.zupfood.pedidos.item;

import com.zupfood.pedidos.pedido.Pedido;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;

    private Long sku;

    private BigDecimal valor;

    private LocalDateTime dataCriado;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    public Item() {
    }

    public Item(int quantidade, Long sku, BigDecimal valor, Pedido pedido) {
        this.quantidade = quantidade;
        this.sku = sku;
        this.valor = valor;
        this.pedido = pedido;
        this.dataCriado= LocalDateTime.now();
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

    public Pedido getPedido() {
        return pedido;
    }
}
