package Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phfar
 */
public class CentroUniversitario {

    //atributos de classe
    private String nome;
    private ArrayList<Estudante>estudantes;
    private ArrayList<Disciplina>disciplinas;
    private ArrayList<Matricula>matriculas;
    //metodo construtor
    public CentroUniversitario(String nome) {
        this.nome = nome;
        this.estudantes = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.matriculas = new ArrayList<>();
    }


    public void carregarDados(String arqDisciplinas, String filename , String arqMatriculas) {
        /*try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filename)))) {
            String linha = bufferedReader.readLine();*/
        try{
            BufferedReader lerEst = new BufferedReader(new FileReader(filename));
            BufferedReader lerDis = new BufferedReader(new FileReader(arqDisciplinas));
            BufferedReader lerMat = new BufferedReader(new FileReader(arqMatriculas));
            
           
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
            /*disciplina concluido com sucesso*/
            
            
            while ((linha = lerMat.readLine()) != null) {
                
                
                String[] dados = linha.split(":");
                
                long codigoAluno = Long.parseLong(dados[0]);
                
                String codigoDisciplina = dados[1];
                
                 
                Estudante estudanteRef = FindEstudante(codigoAluno);
                if(estudanteRef != null){
                    System.out.println("achou"+estudanteRef);
                } 
                
                Disciplina disciplinaRef = FindDisciplina(codigoDisciplina);
                if(disciplinaRef != null){
                    System.out.println("achou disciplina"+disciplinaRef);
                }
                
                if (disciplinaRef != null || estudanteRef != null) {
                    System.out.println("Tudo ok");
                    Matricula matricula = new Matricula(estudanteRef,disciplinaRef);
                    //estudanteRef.addMatricula(matricula);
                    //disciplinaRef.addMatricula(matricula);
                } else {
                    System.out.println("nao ok");
                }
            }
            /*O codigo a cima está com problema, tentar elaborar um FOR interativo para pegar todas as 
            disciplinas e todas os estudantes que sejam igual os parametros do split*/
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
    
    public void exibirEstundantes(){
        for (Estudante e : estudantes) {
            System.out.println(e);
        }
    }
    
    public void exibirDisciplinas(){
        for (Disciplina d : disciplinas) {
            System.out.println(d);
        }
    }
    public void exibirMatriculas(){
        for (Matricula m : matriculas) {
            System.out.println(m);
        }
    }
    
    public Estudante FindEstudante(long id){
        for (Estudante e : estudantes) {
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }
    
    public Disciplina FindDisciplina(String cod){
        for (Disciplina d: disciplinas) {
            if(d.getCodigo().equals(cod)){
                return d;
            }
        }
        return null;
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }
    
}
