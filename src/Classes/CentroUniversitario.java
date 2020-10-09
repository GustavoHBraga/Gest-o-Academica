/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
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
        //a implementar
    }

    public void carregarDadosMatriculas(String arqMatriculas) {
        try {
            // abre arquivo para leitura
            BufferedReader r = new BufferedReader(new FileReader(arquivoMatricula));

            String linha = r.readLine(); // quantidade de dados a serem lidos
            int q = Integer.parseInt(linha);
            String linhas[] = new String[q];

            for (int i = 0; i < q; i++) {
                linha = r.readLine();
                linhas = linha.split("[]:");
                Disciplina dis = new Disciplina(linhas[0], Integer.parseInt(linhas[1]));
                Estudante est = new Estudante(
                        Integer.parseInt(linhas[0]),
                        linhas[1],
                        linhas[2]);
                Matricula mat = new Matricula(dis, est);
            }
            r.close();   // fecha arquivo de entrada

        } catch (Exception e) {
            System.exit(-1);
        }

    }

    public void carregarDadosDisciplinas(String arqDisciplinas) {
        disciplinas = new ArrayList<>();
        try {
            // abre arquivo para leitura
            BufferedReader r = new BufferedReader(new FileReader(arqDisciplinas));

            String linha = r.readLine(); // quantidade de dados a serem lidos
            int q = Integer.parseInt(linha);
            String linhas[] = new String[q];
            for (int i = 0; i < q; i++) {
                linha = r.readLine();
                linhas = linha.split("[]:");

                Disciplina dis = new Disciplina(linhas[0], Integer.parseInt(linhas[1]));
            }
            r.close();   // fecha arquivo de entrada

        } catch (Exception e) {
            System.exit(-1);
        }
    }

    public void carregarDadosEstudantes(String arqEstudantes) {
        estudantes = new ArrayList<>();
        try {
            // abre arquivo para leitura
            BufferedReader r = new BufferedReader(new FileReader(arqEstudantes));

            String linha = r.readLine(); // quantidade de dados a serem lidos
            int q = Integer.parseInt(linha);
            String linhas[] = new String[q];
            for (int i = 0; i < q; i++) {
                linha = r.readLine();
                linhas = linha.split("[]:");

                Estudante est = new Estudante(
                        Integer.parseInt(linhas[0]),
                        linhas[1],
                        linhas[2]);
            }
            r.close();   // fecha arquivo de entrada

        } catch (Exception e) {
            System.exit(-1);
        }
    }

}
