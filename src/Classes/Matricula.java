package Classes;

/**
 *
 * @author JPG
 */
public class Matricula {

    private Estudante estudante;
    private Disciplina disciplina;

<<<<<<< HEAD
=======
    //metodo construtor  
>>>>>>> 4114ff583d7590efa736373a7c65c9489736d5c3
    public Matricula(Estudante estudante, Disciplina disciplina) {
        this.estudante = estudante;
        this.disciplina = disciplina;
    }

<<<<<<< HEAD
=======
    // OVERRIDE
    @Override
    public String toString() {
        return "Matrícula ->" + this.estudante + "\n"
                + "          ->" + this.disciplina + "\n";
    }
    
    // GETTERS E SETTERS
>>>>>>> 4114ff583d7590efa736373a7c65c9489736d5c3
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
<<<<<<< HEAD

    @Override
    public String toString() {
        return "Matricula{" + "estudante=" + estudante.toString() + ", disciplina=" + disciplina.toString() + '}';
    }

}
=======
}
>>>>>>> 4114ff583d7590efa736373a7c65c9489736d5c3
