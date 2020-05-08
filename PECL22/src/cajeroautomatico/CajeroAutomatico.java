package cajeroautomatico;
/**
* Simula un cajero automático.
*/
public class CajeroAutomatico {
 private String _codigo = null;
 /**
 * La cuenta corriente sobre la que se opera en una sesión.
 */
 private String _cuenta;
 public CajeroAutomatico(String codigo){
 _codigo = codigo;
 }
 public void iniciarSesion(String ccc){
 assert(_cuenta == null);
 _cuenta = ccc; //cuenta del cliente
 }

 public void cerrarSesion(){
 assert(_cuenta != null );
 _cuenta = null; //pone a null la cuenta
 }
 public boolean realizarRetirada(double cantidad, PasarelaPago p)
 {
 assert(_cuenta != null );
 if (p.estaBloqueada()) { //Si está bloqueada nada
 return false;
 }
 if (p.tieneSaldo(cantidad)){ //Si está activa y tiene saldo
 p.retirar(cantidad); //llamo al método retirar dinero
 return true;
 }
 return false;
 }
 
 public boolean realizarPrestamoPersonal(double cantidad, int meses, boolean esPrestamoUnico, GestorPrestamosPersonales gestorP)
 {
    assert(_cuenta != null );
    if(!gestorP.comprobarCantidad(cantidad)){ //si la cantidad no es valida no se concede 
        return false;
    }
    if(!gestorP.esPrestamoUnico(esPrestamoUnico)){//si ya se ha pedido un prestamo en los ultimos 12 meses no se concede 
        return false;
    }
    if(!gestorP.mesesValidos(meses)){//si los meses no son validos no se concede 
        return false;
    }
    
    //si no se ha cumplido ninguna condicion anterior se concede el credito
    //se podra haber hecho con un solo if usando los operadores && pero hemos decidido hacerlo asi para que quedase mas claro.
    gestorP.concederPrestamo(cantidad, meses);
    return true;
 }
}