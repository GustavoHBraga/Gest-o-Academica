package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author JPG
 */
public class CentroUniversitario {

    //atributos de classe
    private String nomeFaculdade;
    private ArrayList<Estudante> estudantes;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Matricula> matriculas;

    //metodo construtor
    public CentroUniversitario() {
    }

    public CentroUniversitario(String nome) {
        this.nomeFaculdade = nome;
        this.estudantes = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.matriculas = new ArrayList<>();
    }

    public void carregarDados(String arqDis, String arqEst, String arqMat) {

        try {
            BufferedReader lerEst = new BufferedReader(new FileReader(arqEst));
            BufferedReader lerDis = new BufferedReader(new FileReader(arqDis));
            BufferedReader lerMat = new BufferedReader(new FileReader(arqMat));

            String linha;
            while ((linha = lerEst.readLine()) != null) {

                Estudante estudante = new Estudante();
                String[] dados = linha.split(":");
                
                estudante.setId(Long.parseLong(dados[0]));
                estudante.setNome(dados[1]);
                estudante.setEmail(dados[2]);

                estudantes.add(estudante);

            }

            lerEst.close();

            for (Estudante e : estudantes) {
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

            for (Disciplina e : disciplinas) {
                System.out.println(e.getCodigo());
                System.out.println(e.getCreditos());
            }
            /*disciplina concluido com sucesso*/

            while ((linha = lerMat.readLine()) != null) {

                String[] dados = linha.split(":");

                long codigoAluno = Long.parseLong(dados[0]);

                String codigoDisciplina = dados[1];

                Estudante estudanteRef = FindEstudante(codigoAluno);
                if (estudanteRef != null) {
                    System.out.println("achou" + estudanteRef);
                }

                Disciplina disciplinaRef = FindDisciplina(codigoDisciplina);
                if (disciplinaRef != null) {
                    System.out.println("achou disciplina" + disciplinaRef);
                }

                if (disciplinaRef != null || estudanteRef != null) {
                    System.out.println("Tudo ok");
                    Matricula matricula = new Matricula(estudanteRef, disciplinaRef);
                    //estudanteRef.addMatricula(matricula);// nao esta funcionando 
                    //disciplinaRef.addMatricula(matricula);  nao esta funcionando
                } else {
                    System.out.println("nao ok");
                }
            }
            /*O codigo a cima está com problema, tentar elaborar um FOR interativo para pegar todas as 
            disciplinas e todas os estudantes que sejam igual os parametros do split*/
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    // GETTERS E SETTERS
    
    public String getNomeFaculdade() {
        return nomeFaculdade;
    }

    public void setNomeFaculdade(String nomeFaculdade) {
        this.nomeFaculdade = nomeFaculdade;
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

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }

    // MÉTODOS
    
    public void exibirEstundantes() {
        for (Estudante e : estudantes) {
            System.out.println(e);
        }
    }

    public void exibirDisciplinas() {
        for (Disciplina d : disciplinas) {
            System.out.println(d);
        }
    }

    public void exibirMatriculas() {
        for (Matricula m : matriculas) {
            System.out.println(m);
        }
    }

    public Estudante FindEstudante(long id) {
        for (Estudante e : estudantes) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public Estudante FindEstudanteByTest(long id, String nome, String email) {
        for (Estudante e : estudantes) {
            if (e.getId() == id || e.getNome().equals(nome) || e.getEmail().equals(email)) {
                return e;
            }
        }
        return null;
    }

    public Disciplina FindDisciplina(String cod) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(cod)) {
                return d;
            }
        }
        return null;
    }

    public Disciplina FindDisciplinaByTest(String cod, int cre) {
        for (Disciplina d : disciplinas) {
            if (d.getCodigo().equals(cod) || d.getCreditos() == cre) {
                return d;
            }
        }
        return null;
    }
}