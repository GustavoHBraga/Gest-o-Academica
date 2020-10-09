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
public class Disciplina {

    //atributos de classe
    private String codigo;
    private int creditos;
    private ArrayList<Matricula> matriculas;

    //metodo construtor
    public Disciplina(String codigo, int creditos) {
        this.codigo = codigo;
        this.creditos = creditos;
    }

    public void addMatricula(Matricula matricula) {
        //a implementar
    }

    public ArrayList<Estudante> getEstudantesMatriculados() {
        return null;
    }

    //getters e setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

}
