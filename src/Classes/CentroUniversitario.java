package Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JPG
 */

public class CentroUniversitario {

<<<<<<< HEAD
    private String nome;
    private List<Disciplina> disciplinas;
    private List<Estudante> estudantes;
    private List<Matricula> matriculas;

=======
    //atributos de classe
    private String nomeFaculdade;
    private List<Estudante> estudantes;
    private List<Disciplina> disciplinas;
    private final List<Matricula> matriculas;

    //metodo construtor
>>>>>>> 4114ff583d7590efa736373a7c65c9489736d5c3
    public CentroUniversitario(String nome) {
        this.nome = nome;
        this.estudantes = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
    }

<<<<<<< HEAD
    public void carregarDados(String arqDisciplinas, String arqEstudantes, String arqMatriculas) throws FileNotFoundException, IOException {
        try {
            BufferedReader lerEstudantes = new BufferedReader(new FileReader(arqEstudantes));
            BufferedReader lerDisciplinas = new BufferedReader(new FileReader(arqDisciplinas));
            BufferedReader lerMatriculas = new BufferedReader(new FileReader(arqMatriculas));

            String linha = "";
            while ((linha = lerEstudantes.readLine()) != null) {
                String[] dadosAlunos = linha.split(":");
                long id = Long.parseLong(dadosAlunos[0]);
                String nome = dadosAlunos[1];
                String email = dadosAlunos[2];
                Estudante estudante = new Estudante(id, nome, email);
                estudantes.add(estudante);
            }
            while ((linha = lerDisciplinas.readLine()) != null) {
                String[] dadosDisciplinas = linha.split(":");
                String codigo = dadosDisciplinas[0];
                int creditos = Integer.parseInt(dadosDisciplinas[1]);
                Disciplina disciplina = new Disciplina(codigo, creditos);
                disciplinas.add(disciplina);
            }
            while ((linha = lerMatriculas.readLine()) != null) {
                String[] dadosDisciplinas = linha.split(":");
                long codigoAluno = Long.parseLong(dadosDisciplinas[0]);
                String codigoDisciplina = dadosDisciplinas[1];

                Estudante estudanteRef = null;

                for (Estudante estudante : estudantes) {
                    if (estudante.getId() == codigoAluno) {
                        estudanteRef = estudante;
                    }
                }

                Disciplina disciplinaRef = null;

                for (Disciplina disciplina : disciplinas) {
                    if (disciplina.getCodigo().equals(codigoDisciplina)) {
                        disciplinaRef = disciplina;
                    }
                }

                if (disciplinaRef == null || estudanteRef == null) {
                    System.out.println("Aluno ou disciplina não encontrados");
                } else {
                    Matricula matricula = new Matricula(estudanteRef, disciplinaRef);
                    estudanteRef.addMatricula(matricula);
                    disciplinaRef.addMatricula(matricula);
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Estudante> getEstudantes() {
        return estudantes;
=======
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
>>>>>>> 4114ff583d7590efa736373a7c65c9489736d5c3
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public String toString() {
        return "CentroUniversitario{" + "nome=" + nome + ", disciplinas=" + disciplinas + ", estudantes=" + estudantes + ", matriculas=" + matriculas + '}';
    }

<<<<<<< HEAD
=======
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
>>>>>>> 4114ff583d7590efa736373a7c65c9489736d5c3
}
