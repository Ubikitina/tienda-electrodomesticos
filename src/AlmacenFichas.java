import java.util.HashMap;
/**
 * Esta clase es para almacenar y gestionar las fichas de compra.
 * Dentro de la clase se encuentran los campos específicos del almacén
 * (principalmente el HashMap para almacenar) y los métodos específicos
 * para gestioanar las fichas dentro del almacén.
 * 
 * Cada ficha se asocia con un cliente.
 * 
 * @author Ubikitina
 * @version 09-jun-2018
 */
public class AlmacenFichas implements java.io.Serializable
{
    private HashMap<String,FichaCompras> fichasCompraHM;

    /**
     * Constructor for objects of class AlmacenFichas
     */
    public AlmacenFichas()
    {
        fichasCompraHM = new HashMap<String,FichaCompras>();
    }
    
    /**
     * Método para añadir una ficha al HashMap.
     */
    public void addFichaCliente(String dniCliente){
        FichaCompras nuevaFicha = new FichaCompras();
        fichasCompraHM.put(dniCliente, nuevaFicha);
    }
    
    /**
     * Método para añadir una factura a una ficha de cliente almacenada dentro del HashMap.
     */
    public void addFacturaEnFichaCliente(String dniCajero, String dniCliente){
       (fichasCompraHM.get(dniCliente)).addFacturaCompraEnFicha(dniCajero, dniCliente);
    }
    
    /**
     * Método para añadir una devolución a una ficha de cliente almacenada dentro del HashMap.
     */
    public void addDevolucionEnFichaCliente(String dniCajero, String dniCliente){
       (fichasCompraHM.get(dniCliente)).addFacturaDevolucionEnFicha(dniCajero, dniCliente);
    }
    
    /**
     * Método para añadir un electrodomestico a una factura dentro de una ficha de cliente almacenada dentro del HashMap.
     */
    public void addElecEnFacturaEnFichaCliente(String dniCliente, int numFactura, String numSerie){
       (fichasCompraHM.get(dniCliente)).addElecEnHMFacturas(numFactura, numSerie);
    }
    
    /**
     * Método para añadir el precio total a una factura dentro de una ficha de cliente almacenada dentro del HashMap.
     */
    public void addPrecioEnFacturaEnFichaCliente(String dniCliente, int numFactura, double precioFactura){
        (fichasCompraHM.get(dniCliente)).addPrecioTotalFactura(numFactura, precioFactura);
    }
    
    /**
     * Método para imprimir toda la lista de facturas.
     */
    public void imprimirFacturasDeListaCliente(String dniCliente) {
        (fichasCompraHM.get(dniCliente)).imprimirTodasFacturas();
    }
}
