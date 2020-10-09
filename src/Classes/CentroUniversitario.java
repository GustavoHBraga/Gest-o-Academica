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
    public  ArrayList<Estudante>estudantes;
    private ArrayList<Disciplina>disciplinas;

    //metodo construtor
    public CentroUniversitario(String nome) {
        this.nome = nome;
        this.estudantes = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }

    public void carregarDados(String arqDisciplinas, String filename /*, String arqMatriculas*/) {
        /*try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filename)))) {
            String linha = bufferedReader.readLine();*/
        try{
            BufferedReader lerEst = new BufferedReader(new FileReader(filename));
            BufferedReader lerDis = new BufferedReader(new FileReader(arqDisciplinas));
            /*BufferedReader lerMat = new BufferedReader(new FileReader(arqMatriculas));*/
            
           
            String linha = "";
            while((linha = lerEst.readLine()) != null){
                
                Estudante estudante = new Estudante();
                String[] dados = linha.split(":");
                
                /*long id = Long.parseLong(dados[0]);
                String name = dados[1];
                String Email = dados[2];
                
                Estudante estudante = new Estudante(id,name,Email);*/
             
                estudante.setId(Long.parseLong(dados[0]));
                estudante.setNome(dados[1]);
                estudante.setEmail(dados[2]);
                
                estudantes.add(estudante);
                
            }
            lerEst.close();
            for (Estudante e : estudantes ) {
                System.out.println(e.getId());
                System.out.println(e.getNome());
                System.out.println(e.getEmail());
            }
            /*estudante concluido com sucesso*/
            
            while ((linha = lerDis.readLine()) != null) {
                
                Disciplina disciplina = new Disciplina();
                
                String[] dados = linha.split(":");
                
                disciplina.setCodigo(dados[0]);
                disciplina.setCreditos(Integer.parseInt(dados[1]));
                
                disciplinas.add(disciplina);
            }
            for (Disciplina e : disciplinas ) {
                System.out.println(e.getCodigo());
                System.out.println(e.getCreditos());
            }
            
          
        } catch(Exception e){
            throw new Error(e);
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
