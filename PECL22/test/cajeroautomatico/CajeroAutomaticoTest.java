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
    public void test1() throws Exception {
        System.out.println("Test1");
        
        expect(mock.comprobarCantidad(2400)).andReturn(true);
        expect(mock.esPrestamoUnico(true)).andReturn(true);
        expect(mock.mesesValidos(8)).andReturn(true);
        
        mock.concederPrestamo(2400, 8);
        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(2400, 8, true, mock);
        assertTrue(result);
        
        verify(mock);
    }
    @Test
    public void test2() throws Exception {
        System.out.println("Test2");
        
        expect(mock.comprobarCantidad(1400)).andReturn(true);
        expect(mock.esPrestamoUnico(true)).andReturn(true);
        expect(mock.mesesValidos(5)).andReturn(false);
        
        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(1400, 5, true, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test3() throws Exception {
        System.out.println("Test3");
        
        expect(mock.comprobarCantidad(1400)).andReturn(true);
        expect(mock.esPrestamoUnico(true)).andReturn(true);
        expect(mock.mesesValidos(15)).andReturn(false);
        
        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(1400, 15, true, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test4() throws Exception {
        System.out.println("Test4");
        
        expect(mock.comprobarCantidad(1400)).andReturn(true);
        expect(mock.esPrestamoUnico(false)).andReturn(false);

        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(1400, 11, false, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test5() throws Exception {
        System.out.println("Test5");
        
        expect(mock.comprobarCantidad(1400)).andReturn(true);
        expect(mock.esPrestamoUnico(false)).andReturn(false);
        
        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(1400, 5, false, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test6() throws Exception {
        System.out.println("Test6");
        
        expect(mock.comprobarCantidad(1400)).andReturn(true);
        expect(mock.esPrestamoUnico(false)).andReturn(false);
        
        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(1400, 14, false, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test7() throws Exception {
        System.out.println("Test7");
        
        expect(mock.comprobarCantidad(800)).andReturn(false);
        

        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(800, 7, true, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test8() throws Exception {
        System.out.println("Test8");
        
        
        expect(mock.comprobarCantidad(800)).andReturn(false);
      
        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(800, 4, true, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test9() throws Exception {
        System.out.println("Test9");
        
        expect(mock.comprobarCantidad(800)).andReturn(false);

        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(800, 13, true, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test10() throws Exception {
        System.out.println("Test10");
        
        expect(mock.comprobarCantidad(700)).andReturn(false);

        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(700, 7, false, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test11() throws Exception {
        System.out.println("Test1");
        
        expect(mock.comprobarCantidad(700)).andReturn(false);        

        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(700, 5, false, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test12() throws Exception {
        System.out.println("Test12");
        
        expect(mock.comprobarCantidad(700)).andReturn(false);

        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(700, 16, false, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test13() throws Exception {
        System.out.println("Test13");
        
        expect(mock.comprobarCantidad(5000)).andReturn(false);

        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(5000, 9, true, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test14() throws Exception {
        System.out.println("Test14");
        
        expect(mock.comprobarCantidad(5000)).andReturn(false);
        
        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(5000, 5, true, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test15() throws Exception {
        System.out.println("Test15");
        
        expect(mock.comprobarCantidad(5000)).andReturn(false);
       
        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(5000, 18, true, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test16() throws Exception {
        System.out.println("Test16");
        
        expect(mock.comprobarCantidad(5000)).andReturn(false);

        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(5000, 7, false, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test17() throws Exception {
        System.out.println("Test17");
        
        expect(mock.comprobarCantidad(5000)).andReturn(false);
        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(5000, 1, false, mock);
        assertFalse(result);
        
        verify(mock);
    }
    @Test
    public void test18() throws Exception {
        System.out.println("Test18");
        
        expect(mock.comprobarCantidad(5000)).andReturn(false);
        
        replay(mock);

        boolean result = classUnderTest.realizarPrestamoPersonal(5000, 13, false, mock);
        assertFalse(result);
        
        verify(mock);
    }
    
}