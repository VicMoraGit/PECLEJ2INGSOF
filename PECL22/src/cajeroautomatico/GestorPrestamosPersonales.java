
package cajeroautomatico;

/**
 *
 * @author Victor
 */
public interface GestorPrestamosPersonales {
    
    /**
     * Si la cantidad es menor a 3000€ y mayor a 1000€ devuelve true. En caso
     * contrario, devuelve false.
     * 
     * @param cantidad
     * @return
     */
    public boolean comprobarCantidad(double cantidad);
        
    /**
     * Si meses se encuentra entre 6 y 12 ambos inclusive, se devuelve true.
     * En caso contrario se devuelve false.
     * 
     * @param meses
     * @return
     */
    public boolean mesesValidos(int meses);
    
    /**
     * Si la respuesta del cliente a la pregunta de si no ha pedido algun 
     * prestamo en los ultimos 12 meses es true devuelve true. En caso
     * contrario devuelve false.
     * 
     * @param respuestaCliente
     * @return
     */
    public boolean esPrestamoUnico(boolean respuestaCliente);
    
    /**
     * Se concede un prestamo de la cantidad solicitada al numero de meses señalado. 
     * 
     * @param cantidad
     * @param meses
     * @return
     */
    public void concederPrestamo(double cantidad, int meses);
}
