package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JPG
 */
public class Disciplina {

    private String codigo;
    private int creditos;
    private List<Matricula> matriculas;

<<<<<<< HEAD
=======
    //metodo construtor
    
>>>>>>> 4114ff583d7590efa736373a7c65c9489736d5c3
    public Disciplina(String codigo, int creditos) {
        this.codigo = codigo;
        this.creditos = creditos;
        this.matriculas = new ArrayList<>();
    }

    public void addMatricula(Matricula matricula) {
        this.matriculas.add(matricula);
    }

    public List<Estudante> getEstudantesMatriculados() {
        List<Estudante> estudantes = new ArrayList<>();
        for (Matricula matricula : matriculas) {
            estudantes.add(matricula.getEstudante());
        }
        return estudantes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return "Disciplina{" + "codigo=" + codigo + ", creditos=" + creditos + '}';
=======
        return "Disciplina[" + "Código:" + codigo + " |Créditos:"
                + creditos + " |Matrículas (" + matriculas + ")]";
>>>>>>> 4114ff583d7590efa736373a7c65c9489736d5c3
    }

    
}
