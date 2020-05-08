/*
* Prueba con EasyMock de la interacción entre CajeroAutomatico
* y GestorPrestamosPersonales
*/
package cajeroautomatico;
import static org.easymock.EasyMock.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class CajeroAutomaticoTest {

    private CajeroAutomatico classUnderTest;
    private GestorPrestamosPersonales mock;
    
    public CajeroAutomaticoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    @Before
    public void setUp() {
        classUnderTest = new CajeroAutomatico("1111111111");
        classUnderTest.iniciarSesion("1234");
        /* (1) Crea un mock para la clase colaboradora*/
        mock = createMock(GestorPrestamosPersonales.class);
    }
    @After
        public void tearDown() {
        classUnderTest.cerrarSesion();
        reset(mock);
    }
    /**
    * Test of realizarRetirada method, of class CajeroAutomatico.
    * @throws java.lang.Exception
    */

    @Test
    public void testRealizarPrestamoCantidad() throws Exception {
        System.out.println("solicitarPrestamo");
        
        expect(mock.comprobarCantidad(500)).andReturn(false);
   
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(500, 8, true, mock);
        assertFalse(result);
        
        verify(mock);
    }
    /**
    * Test of realizarRetirada method, of class CajeroAutomatico.
    * @throws java.lang.Exception
    */

    @Test
    public void testRealizarPrestamoUnico() throws Exception {
        System.out.println("solicitarPrestamo");

 
        expect(mock.comprobarCantidad(1890)).andReturn(true);
        expect(mock.esPrestamoUnico(false)).andReturn(false);
            
       
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(1890, 9, false, mock);
        assertFalse(result);
        
        verify(mock);
    }/**
    * Test of realizarRetirada method, of class CajeroAutomatico.
    * @throws java.lang.Exception
    */
/**
    * Test of realizarRetirada method, of class CajeroAutomatico.
    * @throws java.lang.Exception
    */

    @Test
    public void testRealizarPrestamoMeses() throws Exception {
        System.out.println("solicitarPrestamo");

        expect(mock.comprobarCantidad(1500)).andReturn(true);
        expect(mock.esPrestamoUnico(true)).andReturn(true);
        expect(mock.mesesValidos(15)).andReturn(false);

        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(1500, 15, true, mock);

        assertFalse(result);

        verify(mock);
    }
    @Test
    public void testRealizarPrestamoCorrecto() throws Exception {
        System.out.println("solicitarPrestamo");

        
        expect(mock.comprobarCantidad(2400)).andReturn(true);
        expect(mock.esPrestamoUnico(true)).andReturn(true);
        expect(mock.mesesValidos(7)).andReturn(true);
        
        mock.concederPrestamo(2400, 7);
        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(2400, 7, true, mock);
        assertTrue(result);
        
        verify(mock);
    }
    
}