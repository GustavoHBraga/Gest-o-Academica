package gestaoacademica;

import Classes.CentroUniversitario;
import Classes.Estudante;
import java.util.Scanner;
import Classes.Disciplina;
import Classes.Matricula;

/**
 *
 * @author phfar
 */
public class GestaoAcademica {

    public static Scanner entrada;

    public static void main(String[] args) {
        entrada = new Scanner(System.in);
        boolean sair = false;

        Estudante[] estudantes = new Estudante[5];
        Disciplina[] disciplinas = new Disciplina[5];
        Matricula[] matriculas = new Matricula[5];
        CentroUniversitario centroUniversitario = new CentroUniversitario("JAVA");

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
            System.out.println();
            switch (escolha) {
                case 1:
                    mostrarInfoEstudantes(estudantes);
                    break;
                case 2:
                    mostrarInfoDisciplinas(disciplinas);
                    break;
                case 3:
                    //a implementar
                    break;
                case 4:
                    //a implementar
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

    public static void mostrarInfoEstudantes(Estudante[] estudantes) {
        System.out.println("Números e nomes de todos os alunos cadastrados ");
        for (int i = 0; i < estudantes.length; i++) {
            System.out.println("[" + i + "]" + estudantes[i]);
        }

    }

    public static void mostrarInfoDisciplinas(Disciplina[] disciplinas) {
        System.out.println("Códigos de todas as disciplinas ");
        for (int i = 0; i < disciplinas.length; i++) {
            System.out.println("[" + i + "]" + disciplinas[i]);
        }
    }
    
    

}
