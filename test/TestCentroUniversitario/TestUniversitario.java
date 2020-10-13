package TestCentroUniversitario;

import Classes.CentroUniversitario;
import Classes.Disciplina;
import Classes.Estudante;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JPG
 */

public class TestUniversitario {
    
    @Test
    public void testNomeCentro_Universitario() {
        CentroUniversitario facul = new CentroUniversitario("Senac");
        String nomeObtido = facul.getNome();
        assertEquals("Senac",nomeObtido);
    }
    
    @Test
    public void testDisciplinas() throws IOException {
        CentroUniversitario facul = new CentroUniversitario("Senac");
        facul.carregarDados("arqDisciplinas.txt","arqEstudantes.txt","arqMatriculas.txt");
        
        Disciplina disciplinas;
        ArrayList<Disciplina> disciplinasArray = new ArrayList<>(); 
        
        int numeroObtido = facul.getDisciplinas().size();
        
        assertEquals(5, numeroObtido);//primeira linha do arquivo. credito esperado = 1; 
        
        for (Disciplina d : disciplinasArray ) {
            
            String codigo = d.getCodigo();
            int creditos = d.getCreditos();
            Disciplina disciplinaEncontrada = facul.FindDisciplinaByTest(codigo,creditos);
            assertNotNull(disciplinaEncontrada);
            assertEquals(codigo, disciplinaEncontrada.getCodigo());
            assertEquals(creditos, disciplinaEncontrada.getCreditos());
            
        }
    }
    
    @Test
    public void testEstudantes() throws IOException {
        
        CentroUniversitario facul = new CentroUniversitario("Senac");
        facul.carregarDados("arqDisciplinas.txt","arqEstudantes.txt","arqMatriculas.txt");
        
        Estudante estudantes ;
        ArrayList<Estudante> estudantesArray = new ArrayList<>(); 
        int numeroesperado = 5;
        int numeroObtido = facul.getEstudantes().size();
        
        assertEquals(numeroesperado, numeroObtido);//primeira linha do arquivo. credito esperado = 1; 
        
        for (Estudante e : estudantesArray ) {
            
            long idEsperado = e.getId();
            String nomeEsperado = e.getNome();
            String emailEsperado = e.getEmail();
            Estudante estudanteEncontrado = facul.FindEstudanteByTest(idEsperado,nomeEsperado,emailEsperado);
            assertNotNull(estudanteEncontrado);
            assertEquals(idEsperado, estudanteEncontrado.getId());
            assertEquals(nomeEsperado, estudanteEncontrado.getNome());
            assertEquals(emailEsperado, estudanteEncontrado.getEmail());
        }
    }
     @Test
    public void testMatriculas() throws IOException {
        
        CentroUniversitario facul = new CentroUniversitario("Senac");
        facul.carregarDados("arqDisciplinas.txt","arqEstudantes.txt","arqMatriculas.txt");
        
        ArrayList<Estudante> estudantesArray = new ArrayList<>();
        int numeroObtido = facul.getEstudantes().size();
        
        /*for (int i=0; i<estudantesArray.size(); i++) {
            Estudante estudanteArray = estudantesArray.get(i);
            int id = Integer.parseInt(estudanteArray[0]);
            Estudante estudante = findEstudanteById(id, estudantes);
            assertEquals(matriculasPorEstudante[i], estudante.getMatriculas().size());,
        }
        
        /*for (int i=0; i<disciplinasArray.length; i++) {
            String[] disciplinaArray = disciplinasArray[i];
            String codigo = disciplinaArray[0];
            Disciplina disciplina = findDisciplinaByCodigo(codigo, disciplinas);
            assertEquals(matriculasPorDisciplina[i], disciplina.getMatriculas().size());
        }
        
        for (String[] matriculaArray : matriculasArray) {
            int idEstudante = Integer.parseInt(matriculaArray[0]);
            String codigoDisciplina = matriculaArray[1];
            Estudante estudante = findEstudanteById(idEstudante, estudantes);
            Disciplina disciplina = findDisciplinaByCodigo(codigoDisciplina, disciplinas);
            
            Matricula matriculaEncontradaInEstudante = null;
            matriculas = estudante.getMatriculas();
            for (Matricula matricula : matriculas) {
                if (codigoDisciplina.equals(matricula.getDisciplina().getCodigo()) 
                        && idEstudante == matricula.getEstudante().getId()) {
                    matriculaEncontradaInEstudante = matricula;
                    break;
                }
            }
            assertNotNull(matriculaEncontradaInEstudante);
            
            Matricula matriculaEncontradaInDisciplina = null;
            matriculas = disciplina.getMatriculas();
            for (Matricula matricula : matriculas) {
                if (codigoDisciplina.equals(matricula.getDisciplina().getCodigo()) 
                           && idEstudante == matricula.getEstudante().getId()) {
                    matriculaEncontradaInDisciplina = matricula;
                    break;
                }
            }
            assertNotNull(matriculaEncontradaInDisciplina);
        }*/
    }
    
    
}
