package com.senai.dev.servletnew.model;

public class Pessoa {
    private static Integer SEQUENCE = 0;
    private Integer id;
    private String nome;
    private Integer idade;

    public Pessoa() {
        this.id = proximoId();
    }

    public Pessoa(String nome, Integer idade) {
        this.id = proximoId();
        this.nome = nome;
        this.idade = idade;
    }

    private Integer proximoId() {
        return ++SEQUENCE;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getidade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
