/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author phfar
 */
public class CentroUniversitario {

    //atributos de classe
    private String nome;
    private ArrayList<Estudante> estudantes;
    private ArrayList<Disciplina> disciplinas;

    //metodo construtor
    public CentroUniversitario(String nome) {
        this.nome = nome;
    }

    public void carregarDados(String arqDisciplinas, String arqEstudantes, String arqMatriculas) {
        try {
            BufferedReader lerEstudantes = new BufferedReader(new FileReader(arqEstudantes));
            BufferedReader lerDisciplinas = new BufferedReader(new FileReader(arqDisciplinas));
            BufferedReader lerMatriculas = new BufferedReader(new FileReader(arqMatriculas));

            String linha = "";
            while ((linha = lerEstudantes.readLine()) != null) {
                String[] dadosEstudantes = linha.split(":");
                int id = Integer.parseInt(dadosEstudantes[0]);
                String nome = dadosEstudantes[1];
                String email = dadosEstudantes[2];
                Estudante estudante = new Estudante(id, nome, email);
                estudantes.add(estudante);
            }
            while ((linha = lerDisciplinas.readLine()) != null) {
                String[] dadosDisciplinas = linha.split(":");
                String codigo = dadosDisciplinas[0];
                int creditos = Integer.parseInt(dadosDisciplinas[1]);
                Disciplina disciplina = new Disciplina(codigo, creditos);
                disciplinas.add(disciplina);
            }
            while ((linha = lerMatriculas.readLine()) != null) {
                String[] dadosDisciplinas = linha.split(":");
                long codigoAluno = Long.parseLong(dadosDisciplinas[0]);
                String codigoDisciplina = dadosDisciplinas[1];
                Estudante estudanteRef = null;
                for (Estudante estudante : estudantes) {
                    if (estudante.getId() == codigoAluno) {
                        estudanteRef = estudante;
                    }
                }
                Disciplina disciplinaRef = null;
                for (Disciplina disciplina : disciplinas) {
                    if (disciplina.getCodigo().equals(codigoDisciplina)) {
                        {
                            disciplinaRef = disciplina;
                        }
                    }
                    if (disciplinaRef == null || estudanteRef == null) {
                        System.out.println("Aluno ou disciplina não encontrada");
                    } else {
                        Matricula matricula = new Matricula(estudanteRef, disciplinaRef);
                        estudanteRef.addMatricula(matricula);
                        disciplinaRef.addMatricula(matricula);
                    }
                }
            }
        } catch (Exception e) {
            System.exit(-1);
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(ArrayList<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
