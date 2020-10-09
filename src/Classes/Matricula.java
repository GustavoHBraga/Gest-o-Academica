package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author phfar
 */
public class Matricula {

    //atributos de classe
    private Estudante estudante;
    private Disciplina disciplina;

    //metodo construtor
    public Matricula(Estudante estudante, Disciplina disciplina) {
        this.estudante = estudante;
        this.disciplina = disciplina;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }


    @Override
    public String toString() {
        return "Matricula{" + "estudante=" + estudante + ", disciplina=" + disciplina + '}';
    }
    
    

}
