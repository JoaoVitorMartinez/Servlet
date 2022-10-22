package com.senai.dev.servletnew.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@ToString
public class Tutor {
    private static int id = 0;
    private String nome;
    private Integer idade;


    public Tutor(String nome, Integer idade) {
        this.id = this.generatedId();
        this.nome = nome;
        this.idade = idade;
    }

    private int generatedId() {

        return ++this.id;
    }

    public int getId() {
        return id;
    }
}
