package dnasequence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author HP
 */
public class DNASequenceTest { 
private DNASequence secuencia;
    public DNASequenceTest() {
    }
    
    @Before
    public void setUp() {
        secuencia = new DNASequence("AGTICASDC");//Creo la secuencia, a la vista está que mal
        
    }
    
    @After
    public void tearDown() {
        secuencia = null;
    }

    @Test
    public void testIsValid() {//Comprueba si es válida, debe de salir falsa
        System.out.println("isValid");
        boolean expResult = false;
        boolean result = secuencia.isValid();
        assertEquals(expResult, result);
    }

    @Test
    public void testCountADENINE() {//Cuenta las A de la cadena, en este caso hay 2
        System.out.println("count");
        char nucleotide = 'A';
        int expResult = 2;
        int result = secuencia.count(nucleotide);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCountCYTOSINE() {//Cuenta las C de la cadena, en este caso hay 2
        System.out.println("count1");
        char nucleotide = 'C';
        int expResult = 2;
        int result = secuencia.count(nucleotide);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCountTHYMINE() {////Cuenta las T de la cadena, en este caso hay 1
        System.out.println("count2");
        char nucleotide = 'T';
        int expResult = 1;
        int result = secuencia.count(nucleotide);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCountGUANINE() {//Cuenta las G de la cadena, en este caso hay 1
        System.out.println("count3");
        char nucleotide = 'G';
        int expResult = 1;
        int result = secuencia.count(nucleotide);
        assertEquals(expResult, result);
    }
}