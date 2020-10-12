package Classes;

import java.util.ArrayList;

/**
 *
 * @author JPG
 */

public class Estudante {

    //atributos de classe
    private long id;
    private String nome;
    private String email;
    private Matricula matricula;
    private ArrayList<Matricula> matriculas;

    //metodo construtor
    public Estudante() {
    }
    
    public Estudante(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
    
    // MÉTODOS
    
    public void addMatricula(Matricula a){
        this.matriculas.add(a);
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(ArrayList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public ArrayList<Disciplina> getDisciplinasMatriculadas() {
        return null;
    }
   
    //this.matriculas.add(matricula);
    
    /*public List<Disciplina> getDisciplinasMatriculadas() {
        
        List<Disciplina> disciplinas = new ArrayList<>();
        for (Matricula matricula : matriculas) {
            disciplinas.add(matricula.getDisciplina());
        }
        return disciplinas;
    }*/

    // GETTERS E SETTERS
    
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

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
   
    // OVERRIDE
    
    @Override
    public String toString() {
        return "Estudante{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", matriculas=" + matriculas + '}';
    }
}