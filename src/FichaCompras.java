import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
/**
 * Esta clase representa un objeto ficha de compras. Una ficha de compras
 * se crea para ir guardando las compras (en factura) de un cliente específico.
 * Por tanto, cada cliente tendrá su ficha de compras.
 *
 * @author Ubikitina
 * @version 09-jun-2018
 */
public class FichaCompras implements java.io.Serializable
{
    private HashMap <Integer, Factura> facturasHM;

    /**
     * Constructor for objects of class FichaCompras
     */
    public FichaCompras()
    {
        facturasHM = new HashMap<Integer, Factura>();
    }

    /**
     * Método para añadir una factura de Compra y sus datos.
     */
    public void addFacturaCompraEnFicha(String dniCajero, String dniCliente) {
        Factura nuevaFactura = new Factura(dniCajero, dniCliente, false);
        facturasHM.put(nuevaFactura.getNumFactura(), nuevaFactura);
    }
    
    /**
     * Método para añadir una factura de Devolución y sus datos.
     */
    public void addFacturaDevolucionEnFicha(String dniCajero, String dniCliente) {
        Factura nuevaFactura = new Factura(dniCajero, dniCliente, true);
        facturasHM.put(nuevaFactura.getNumFactura(), nuevaFactura);
    }
    
    /**
     * Método para añadir un electrodomestico en una factura ya existente.
     */
    public void addElecEnHMFacturas(int numFactura, String numSerie){
        facturasHM.get(numFactura).addElecEnFactura(numSerie);
    }
    
    /**
     * Método para añadir el precio total en una factura.
     */
    public void addPrecioTotalFactura(int numFactura, double precioFactura){
        facturasHM.get(numFactura).setPrecioFactura(precioFactura);
    }
    
    /**
     * Método para imprimir una factura introduciendo el número de factura.
     */
    public void imprimirUnaFactura(int numFactura){
        (facturasHM.get(numFactura)).imprimirFactura();
    }
    
    /**
     * Método para imprimir toda la lista de facturas.
     */
    public void imprimirTodasFacturas() {
        Set <Integer> setDeNumsFactura = new HashSet<Integer>();
             
        setDeNumsFactura = facturasHM.keySet();
                
        for(Iterator<Integer> it = setDeNumsFactura.iterator(); it.hasNext(); ) { 
            facturasHM.get(it.next()).imprimirFactura(); 
            System.out.println();
        }
    }
}
