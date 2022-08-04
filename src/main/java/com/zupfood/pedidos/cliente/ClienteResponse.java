package com.zupfood.pedidos.cliente;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClienteResponse {

    private Long id;

    private String nome;

    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate nascimento;

    @JsonFormat(pattern = "dd-MM-yyyy HH:MM:ss")
    private LocalDateTime incluidoEm;

    @JsonFormat(pattern = "dd-MM-yyyy HH:MM:ss")
    private LocalDateTime atualizadoEm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public LocalDateTime getIncluidoEm() {
        return incluidoEm;
    }

    public void setIncluidoEm(LocalDateTime incluidoEm) {
        this.incluidoEm = incluidoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
