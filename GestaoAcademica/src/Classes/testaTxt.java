/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.FileNotFoundException;

/**
 *
 * @author phfar
 */
public class testaTxt {
    public static void main(String[] args) throws FileNotFoundException {
        CentroUniversitario centroUniversitario = new CentroUniversitario("JAVA");
        centroUniversitario.carregarDados("disciplinas.txt", "estudantes.txt", "matriculas.txt");
        //System.out.println(centroUniversitario);
        centroUniversitario.getNome();
        centroUniversitario.getEstudantes();
        centroUniversitario.getDisciplinas();
    }
}
