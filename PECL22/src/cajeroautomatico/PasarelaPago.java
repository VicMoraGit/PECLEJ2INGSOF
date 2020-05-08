package cajeroautomatico;
/**
* Simula la interfaz de una entidad bancaria
*/
public interface PasarelaPago {
 /**
 * Comprueba si la cuenta tiene saldo suficiente para la retirada
 * @param cantidad
 * @return
 */
 public boolean tieneSaldo(double cantidad);
 /**
 * Una cuenta se bloquea si se ha intentado realizar una retirada de dinero
 * sin saldo suficiente de manera previa.
 * @return
 */
 public boolean estaBloqueada();
 /**
 * Retira dinero de la cuenta.
 * Precondición: la cuenta debe tener saldo suficiente.
 * @param cantidad a retirar
 */
 public void retirar(double cantidad);
}