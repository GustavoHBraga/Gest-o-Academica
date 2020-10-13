package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JPG
 */
public class Estudante {

    //atributos de classe
    private long id;
    private String nome;
    private String email;
    private List<Matricula> matriculas;

    //metodo construtor
    public Estudante(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.matriculas = new ArrayList<>();
    }

    // MÉTODOS
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

    // OVERRIDE
    @Override
    public String toString() {
        return "Estudante[" + "Id:" + id + " |Nome:" + nome + " |Email:"
                + email + " |Matrículas (" + matriculas + ")]";
    }
    
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
    
    public List<Matricula> getMatriculas() {
        return matriculas;
    }
    
    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}