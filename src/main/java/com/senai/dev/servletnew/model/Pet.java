package com.senai.dev.servletnew.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@ToString
public class Pet {
    private static int id = 0;
    private String nome;
    private String raca;

    public Pet(String nome, String raca) {
        this.id = generatedId();
        this.nome = nome;
        this.raca = raca;
    }

    private int generatedId() {

        return ++this.id;
    }

    public int getId() {
        return this.id;
    }
}
