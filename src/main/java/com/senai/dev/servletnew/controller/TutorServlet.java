package com.senai.dev.servletnew.controller;

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

@WebServlet(name = "Tutor", value = "/tutores")
public class TutorServlet extends HttpServlet {

    private List<Tutor> tutores = new ArrayList<>();

    //  Visualiza objetos da lista
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //Resposta do servidor
        PrintWriter out = response.getWriter();

        for (int i = 0; i < tutores.size(); i++) {
            out.println(tutores.get(i));

        }


    }

    @Override // Adiciona objeto na lista
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Coletando passagem de parâmetros
        String nome = req.getParameter("nome");
        Integer idade = Integer.parseInt(req.getParameter("idade"));


        //Usando builder para construir o objeto - Lombok
        Tutor tutor = Tutor.builder()
                .nome(nome)
                .idade(idade)
                .build();

        //Resposta do servidor
        PrintWriter out = resp.getWriter();
        out.println(tutor.getId() + " "+ tutor.toString());

        //Adiciona na lista
        tutores.add(tutor);

    }

    @Override // Edita objeto da lista
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        Integer idade = Integer.parseInt(req.getParameter("idade"));

        for (int i = 0; i < tutores.size(); i++) {
            if (tutores.get(i).getId() == id) {
                tutores.get(i).setNome(nome);
                tutores.get(i).setIdade(idade);

            }

        }

    }

    @Override // Deleta objeto da lista
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        for (int i = 0; i < tutores.size(); i++) {
            if (tutores.get(i).getId() == id) {
                tutores.remove(i);
                resp.setStatus(200);

            }

        }


    }
}
