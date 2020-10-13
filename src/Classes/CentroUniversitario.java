package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

        String linha;

        try {
            //LEITURA ESTUDANTES
            try ( BufferedReader lerEst = new BufferedReader(new FileReader(arqEst))) {

                while ((linha = lerEst.readLine()) != null) {

                    Estudante estudante = new Estudante();
                    String[] dados = linha.split(":");

                    estudante.setId(Long.parseLong(dados[0]));
                    estudante.setNome(dados[1]);
                    estudante.setEmail(dados[2]);

                    estudantes.add(estudante);

                    /*estudante concluido com sucesso*/
                }
            }
        } catch (IOException | NumberFormatException e) {
            throw new Error(e);
        }

        //LEITURA DISCIPLINAS
        try ( BufferedReader lerDis = new BufferedReader(new FileReader(arqDis))) {
            while ((linha = lerDis.readLine()) != null) {

                Disciplina disciplina = new Disciplina();

                String[] dados = linha.split(":");

                disciplina.setCodigo(dados[0]);
                disciplina.setCreditos(Integer.parseInt(dados[1]));

                disciplinas.add(disciplina);

                /*disciplina concluido com sucesso*/
            }
        } catch (IOException | NumberFormatException e) {
            throw new Error(e);
        }

        //LEITURA MATRICULAS
        try ( BufferedReader lerMat = new BufferedReader(new FileReader(arqMat))) {
            //Lê o arquivo
            while ((linha = lerMat.readLine()) != null) {
                //Separa o arquivo em array String
                String[] dados = linha.split(":");
                long codEstudante = Long.parseLong(dados[0]);
                String codDisciplina = dados[1];

                //Verifica se o estudante existe
                Estudante eRef = FindEstudante(codEstudante);
                if (eRef == null) {
                    System.out.println("Não achou nenhum estudante com o código: "
                            + codEstudante + "\n");
                }

                //Verifica se a disciplica existe
                Disciplina dRef = FindDisciplina(codDisciplina);
                if (dRef == null) {
                    System.out.println("Não achou nenhuma disciplina com o código: "
                            + codDisciplina + "\n");
                }

                if (dRef != null || eRef != null) {
                    //System.out.println("Tudo ok \n");
                    Matricula matricula = new Matricula(eRef, dRef);
                    System.out.println(matricula);
                    this.matriculas.add(matricula);
                    //disciplinaRef.addMatricula(matricula);
                } else {
                    System.out.println("nao ok");
                }
            }
        } catch (IOException | NumberFormatException e) {
            throw new Error(e);
        }
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
}
