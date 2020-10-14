package TestCentroUniversitario;

import Classes.CentroUniversitario;
import Classes.Disciplina;
import Classes.Estudante;
import Classes.Matricula;
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
        
        for (int i=0; i<facul.getEstudantes().size(); i++) {
            
            long id = facul.getEstudantes().get(i).getId();
            int tamEsperado = facul.FindEstudanteByTest(id);
            assertEquals(tamEsperado,facul.getEstudantes().get(i).getDisciplinasMatriculadas().size());
        }
        
        for (int i=0; i<facul.getDisciplinas().size(); i++) {
            String cod = facul.getDisciplinas().get(i).getCodigo();
            int tamEsperado = facul.FindDisciplinaByTest(cod);
            assertEquals(tamEsperado,facul.getDisciplinas().get(i).getEstudantesMatriculados().size() );
        }
        Matricula matriculaResult = null;
        for (int i=0; i<facul.getMatriculas().size(); i++) {
            
            long id = facul.getEstudantes().get(i).getId();
            String cod = facul.getDisciplinas().get(i).getCodigo();
            
            if(facul.getMatriculas().get(i).getDisciplina().getCodigo().equals(cod)
                && facul.getMatriculas().get(i).getEstudante().getId() == id){
                
                matriculaResult = facul.getMatriculas().get(i);
            }
            assertEquals(id,matriculaResult.getEstudante().getId());
            assertEquals(cod,matriculaResult.getDisciplina().getCodigo());
            assertNotNull(matriculaResult);
        }
    }
}
