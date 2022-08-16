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

    private Long idProduto;

    private BigDecimal valor;

    private LocalDateTime dataCriado;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    public Item() {
    }

    public Item(int quantidade, Long idProduto, BigDecimal valor) {
        this.quantidade = quantidade;
        this.idProduto = idProduto;
        this.valor = valor;
        this.dataCriado= LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Long getIdProduto() {
        return idProduto;
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

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
