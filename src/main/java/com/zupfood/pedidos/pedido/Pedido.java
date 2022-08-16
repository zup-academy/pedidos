package com.zupfood.pedidos.pedido;

import com.zupfood.pedidos.item.Item;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCliente;

    private Long idRestaurante;

    private LocalDateTime dataCriado;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private List<Item> items;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Pedido() {
    }

    public Pedido(Long idCliente, Long idRestaurante,List<Item> items) {
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
        this.dataCriado = LocalDateTime.now();
        this.items = items;
        this.status = Status.PENDENTE;
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

    public List<Item> getItems() {
        return items;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idRestaurante=" + idRestaurante +
                ", dataCriado=" + dataCriado +
                ", items=" + items +
                '}';
    }

    public void atualizaStatus(Status status) {
        this.status = status;
    }
}
