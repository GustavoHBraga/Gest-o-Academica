package Classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JPG
 */

public class CentroUniversitario {

    //atributos de classe
    private String nomeFaculdade;
    private List<Estudante> estudantes;
    private List<Disciplina> disciplinas;
    private final List<Matricula> matriculas;

    //metodo construtor
    public CentroUniversitario(String nome) {
        this.nomeFaculdade = nome;
        this.estudantes = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.matriculas = new ArrayList<>();
    }

    public void carregarDados(String arqDis, String arqEst, String arqMat) {

        String linha;

        //LEITURA ESTUDANTES
        try ( BufferedReader lerEst = new BufferedReader(new FileReader(arqEst))) {

            while ((linha = lerEst.readLine()) != null) {
                String[] dados = linha.split(":");
                Estudante est = new Estudante(Long.parseLong(dados[0]), dados[1], dados[2]);
                estudantes.add(est);

                /*estudante concluido com sucesso*/
            }
        } catch (IOException | NumberFormatException e) {
            throw new Error(e);
        }

        //LEITURA DISCIPLINAS
        try ( BufferedReader lerDis = new BufferedReader(new FileReader(arqDis))) {
            while ((linha = lerDis.readLine()) != null) {

                String[] dados = linha.split(":");
                Disciplina dis = new Disciplina(dados[0], Integer.parseInt(dados[1]));
                disciplinas.add(dis);

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
                long codEst = Long.parseLong(dados[0]);
                String codDis = dados[1];

                //Verifica se o estudante existe
                Estudante estudante = null;
                for (Estudante est : estudantes){
                    if(est.getId() == codEst){
                        estudante = est;
                    }
                }

                //Verifica se a disciplica existe
                Disciplina disciplina = null;
                for (Disciplina dis : disciplinas){
                    if(dis.getCodigo().equals(codDis)){
                        disciplina = dis;
                    }
                }
                
                //Verifica se nenhum é null
                if (disciplina == null || estudante == null) {
                    System.out.println("Estudante ou matrícula não encontrado");
                    
                } else {
                    Matricula matricula = new Matricula(estudante, disciplina);
                    
                    estudante.addMatricula(matricula);
                    disciplina.addMatricula(matricula);
                }
            }
        } catch (IOException | NumberFormatException e) {
            throw new Error(e);
        }
    }

    // MÉTODOS
    public void exibirEstundantes() {
        estudantes.forEach(e -> {
            System.out.println(e);
        });
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

    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setEstudantes(ArrayList<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }
}
