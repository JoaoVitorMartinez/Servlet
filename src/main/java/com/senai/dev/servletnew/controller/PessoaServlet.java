package com.senai.dev.servletnew.controller;

import com.senai.dev.servletnew.model.Pessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "pessoa", value = "/pessoa")
public class PessoaServlet  extends HttpServlet {

    private List<Pessoa> pessoas = new ArrayList<>();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        for (int i = 0; i < pessoas.size(); i++) {
            out.println(pessoas.get(i));

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        Integer idade = Integer.parseInt(req.getParameter("idade")) ;

        System.out.println("Nome: " + nome + " Idade:" +idade);

        Pessoa pessoa = new Pessoa(nome, idade);

        PrintWriter out = resp.getWriter();
        out.println(pessoa.getNome() + " " + pessoa.getidade());

        pessoas.add(pessoa);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String nome = req.getParameter("nome");
        Integer idade = Integer.parseInt(req.getParameter("idade"));

        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == id){
                pessoas.get(i).setNome(nome);
                pessoas.get(i).setIdade(idade);

            }

        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == id){
                pessoas.remove(i);

            }

        }




    }
}
