package com.senai.dev.servletnew.controller;

import com.senai.dev.servletnew.model.Pet;
import com.senai.dev.servletnew.model.Tutor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Pet", value = "/pets")
public class PetServlet extends HttpServlet {

    private List<Pet> pets = new ArrayList<>();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        for (int i = 0; i < pets.size(); i++) {
            out.println(pets.get(i));

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String raca = req.getParameter("raca");

        Pet pet = Pet.builder()
                .raca(raca)
                .nome(nome)
                .build();

        PrintWriter out = resp.getWriter();
        out.println(pet.toString());

        pets.add(pet);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        String raca = req.getParameter("raca");

        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == id) {
                pets.get(i).setNome(nome);
                pets.get(i).setRaca(raca);

            }

        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getId() == id) {
                pets.remove(i);

            }

        }


    }
}
