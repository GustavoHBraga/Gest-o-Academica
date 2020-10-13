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

        CentroUniversitario centroUniversitario = new CentroUniversitario("Senac");
        centroUniversitario.carregarDados("arqDisciplinas.txt", "arqEstudantes.txt", "arqMatriculas.txt");
        System.out.println(centroUniversitario);

        System.out.println("");
        
        while (!sair) {

            System.out.print("|===============>> ESCOLHA UMA OPÇÃO <<================|\n"
                    + "|------------------------------------------------------|\n"
                    + "| (1) Listar os números e nomes de todos os estudantes |\n"
                    + "|------------------------------------------------------|\n"
                    + "| (2) Listar os códigos de todas as disciplinas        |\n"
                    + "|------------------------------------------------------|\n"
                    + "| (3) Listar todas as informações dos estudantes       |\n"
                    + "|     matriculados em uma determinada disciplina       |\n"
                    + "|------------------------------------------------------|\n"
                    + "| (4) Listar todas as informações das disciplinas em   |\n"
                    + "|     que um determinado estudante está matriculado    |\n"
                    + "|------------------------------------------------------|\n"
                    + "| (5) Sair                                             |\n"
                    + "|======================================================|\n"
                    + "\n"
                    + "Digite uma opção: ");

            int opt = entrada.nextInt();
            System.out.println("");
            
            switch (opt) {
                case 1:
                    System.out.println("COD | NOMES");
                    centroUniversitario.exibirEstundantes();
                    break;
                case 2:
                    System.out.println("COD  | CREDITO");
                    centroUniversitario.exibirDisciplinas();
                    break;
                case 3:

                    System.out.print("Digite o cod da disciplina");
                    long codDisciplina = entrada.nextLong();

                    break;
                case 4:
                    System.out.print("Digite ID do estudante");
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