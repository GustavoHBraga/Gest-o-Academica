/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phfar
 */
public class Estudante {

    //atributos de classe
    private long id;
    private String nome;
    private String email;
    //private List<Matricula> matriculas;

    //metodo construtor
    public Estudante(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    public Estudante() {
        
    }

    public void addMatricula(Matricula matricula) {
        matricula.setEstudante(this);
    }

    /*public ArrayList<Disciplina> getDisciplinasMatriculadas() {
        return null;
    }*/

    //getters e setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
