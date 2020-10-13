package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JPG
 */

public class Estudante {

    private long id;
    private String nome;
    private String email;
    private List<Matricula> matriculas;

    public Estudante(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matriculas = new ArrayList<>();
    }

    public void addMatricula(Matricula matricula) {
        this.matriculas.add(matricula);
    }

    public List<Disciplina> getDisciplinasMatriculadas() {
        List<Disciplina> disciplinas = new ArrayList<>();
        for (Matricula matricula : matriculas) {
            disciplinas.add(matricula.getDisciplina());
        }
        return disciplinas;
    }
    
    

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
    
    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public String toString() {
        return "\n\nId:" + id + " | Nome: " + nome + " | Email: " + email + "\nMatrícula(s): " + matriculas;
    }
}