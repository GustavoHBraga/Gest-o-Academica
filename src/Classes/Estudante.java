/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author phfar
 */
public class Estudante {

    //atributos de classe
    private int id;
    private String nome;
    private String email;
    private ArrayList<Matricula> matriculas;

    //metodo construtor
    public Estudante(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public void addMatricula(Matricula matricula) {
        //a implementar
    }

    public ArrayList<Disciplina> getDisciplinasMatriculadas() {
        //a implementar
        return null;
    }

    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}
