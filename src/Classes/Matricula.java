package Classes;

/**
 *
 * @author JPG
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

    // OVERRIDE
    @Override
    public String toString() {
        return "Matrícula ->" + this.estudante + "\n"
                + "          ->" + this.disciplina + "\n";
    }
    
    // GETTERS E SETTERS
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
}