package Classes;

import java.io.IOException;

/**
 *
 * @author Gustavo
 */
public class main {
    public static void main(String[] args) throws IOException {
        CentroUniversitario facul = new CentroUniversitario("Senac");
        facul.carregarDados("arqDisciplinas.txt","arqEstudantes.txt","arqMatriculas.txt");
        
        facul.exibirEstundantes();//exibir todos os estudantes 
        System.out.println("\n");
        facul.exibirDisciplinas();//exibir todos os Disciplinas
        System.out.println("\n");
        facul.exibirMatriculas();
        System.out.println("\n");
        
        System.out.println("-------> "+facul.FindDisciplina("COD01"));
        System.out.println("-------> "+facul.FindEstudante(1));
        
        
        
//        Estudante a1 = facul.FindEstudante(1);//aux para fazer matricula manual 
//        Disciplina a2 = facul.FindDisciplina("COD01");//aux disciplina para fazer matricula manual
//        Matricula ma = new Matricula(a1,a2);// tentar automatizar na classe centroUniversitario
//        
//        System.out.println(ma);// to string da matricula depois de adicionar os valores acima
//        //System.out.println("--> estudante"+a1);
        
       
    }
}
