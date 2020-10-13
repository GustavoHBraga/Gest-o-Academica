package gestaoacademica;

import Classes.CentroUniversitario;
import Classes.Estudante;
import java.util.Scanner;
import Classes.Disciplina;
import Classes.Matricula;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author phfar
 */
public class GestaoAcademica {

    public static Scanner entrada;

    public static void main(String[] args) throws IOException {
        entrada = new Scanner(System.in);
        boolean sair = false;

        List<Estudante> estudantes; // = new ArrayList<Estudante>();
        List<Disciplina> disciplinas; // = new ArrayList<Disciplina>();
        List<Matricula> matriculas; // = new ArrayList<Matricula>();
        CentroUniversitario centroUniversitario = new CentroUniversitario("JAVA");
        centroUniversitario.carregarDados("arqDisciplinas.txt", "arqEstudantes.txt", "arqMatriculas.txt");
        System.out.println(centroUniversitario);

        while (!sair) {
            
            System.out.println("Escolha	uma operação: ");
 
            System.out.println("(1) Listar os números e	nomes de todos os estudantes ");
            
            System.out.println("(2) Listar os códigos	de todas as disciplinas ");
            
            System.out.println("(3) Listar todas as informações dos estudantes matriculados "
                    + "em uma determinada disciplina ");
            
            System.out.println("(4) Listar todas as informações das disciplinas em que um "
                    + "determinado estudante está matriculado ");
            
            System.out.println("(5) sair ");
            
            System.out.print("Opção escolhida: ");
            int escolha = entrada.nextInt();
            
            System.out.println("\n");
            switch (escolha) {
                case 1:
                    centroUniversitario.exibirEstundantes();
                    break;
                case 2:
                    System.out.println("COD  | CREDITO");
                    centroUniversitario.exibirDisciplinas();
                    break;
                case 3:
                    
                    System.out.println("Digite o cod da disciplina");
                    long codDisciplina = entrada.nextLong();
                    
                    break;
                case 4:
                    System.out.println("Digite ID do estudante");
                    int ID = entrada.nextInt();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida ");
            }
            System.out.println();
        }
        System.out.println("Fim do programa ");

    }

}
