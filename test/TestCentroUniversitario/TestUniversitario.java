package TestCentroUniversitario;

import Classes.CentroUniversitario;
import Classes.Disciplina;
import Classes.Estudante;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author JPG
 */

public class TestUniversitario {
    
    @Test
    public void testNomeCentro_Universitario() {
        CentroUniversitario facul = new CentroUniversitario("Senac");
        String nomeObtido = facul.getNomeFaculdade();
        assertEquals("Senac",nomeObtido);
    }
    
    @Test
    public void testDisciplinas() {
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
    public void testEstudantes() {
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
    
}
