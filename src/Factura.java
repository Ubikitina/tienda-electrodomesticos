import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Esta clase representa un objeto factura. Una factura se emite
 * en cada compra de un cliente. Por tanto, tendrá la información
 * del cliente, el personal de caja que atendió, los electrodomesticos
 * comprados y la fecha de la compra.
 * 
 * NOTA: Una factura puede ser de venta o de devolución.
 *
 * @author Ubikitina
 * @version 09-jun-2018
 */
public class Factura implements java.io.Serializable
{
    private static int contador = 0;
    private int numFactura;
    private String dniCajero;
    private String dniCliente;
    private ArrayList<String> elecsCompradosList; //se introducirá el número de serie de los electrodomesticos
    private LocalDate fechaCompra;
    private Boolean esDevolucion;
    private double precioFactura;
    
    /**
     * Constructor for objects of class Factura
     */
    public Factura(String dniCajero, String dniCliente, Boolean esDevolucion)
    {
       contador++;
       this.numFactura = contador;
       this.dniCajero = dniCajero;
       this.dniCliente = dniCliente;
       this.elecsCompradosList = new ArrayList<String>();
       this.fechaCompra = LocalDate.now();
       this.esDevolucion = esDevolucion;
       this.precioFactura = precioFactura;
    }
    
    /**
    * Método getter que devuelve el contador.
    * Solo se ha hecho getter porque no vamos a modificar nunca.
    *
    * @return    contador
    */
    public static int getContador()
    {
        return contador;
    }
    
    /**
    * Método getter que devuelve el numFactura.
    * Solo se ha hecho getter porque se supone que una factura no la vamos a modificar nunca.
    *
    * @return    numFactura
    */
    public int getNumFactura()
    {
        return this.numFactura;
    }
    
    /**
    * Método getter que devuelve el dniCajero.
    * Solo se ha hecho getter porque se supone que una factura no la vamos a modificar nunca.
    *
    * @return    dniCajero
    */
    public String getDniCajero()
    {
        return this.dniCajero;
    }
    
     /**
     * Método getter que devuelve el dniCliente.
     * Solo se ha hecho getter porque se supone que una factura no la vamos a modificar nunca.
     *
     * @return    dniCliente
     */
    public String getDniCliente()
    {
        return this.dniCliente;
    }
    
     /**
     * Método getter que devuelve el elecsCompradosList.
     * Solo se ha hecho getter porque se supone que una factura no la vamos a modificar nunca.
     *
     * @return    elecsCompradosList
     */
    public ArrayList<String> getElecsCompradosList()
    {
        return this.elecsCompradosList;
    }
    
    /**
     * Método getter que devuelve la fechaCompra.
     * Solo se ha hecho getter porque se supone que una factura no la vamos a modificar nunca.
     *
     * @return    fechaCompra
     */
    public LocalDate getFechaCompra()
    {
        return this.fechaCompra;
    }
    
    /**
     * Método getter que devuelve la esDevolucion.
     *
     * @return    esDevolucion
     */
    public boolean getEsDevolucion()
    {
        return this.esDevolucion;
    }
    
    /**
     * Método setter que establece si esDevolucion.
     *
     * @param    nuevoValor
     */
    public void setEsDevolucion(boolean nuevoValor)
    {
        esDevolucion = nuevoValor;
    }
    
    /**
     * Método getter que devuelve el precio total de la factura.
     *
     * @return    precioFactura
     */
    public double getPrecioFactura()
    {
        return this.precioFactura;
    }
    
    /**
     * Método setter que establece el precio total de la factura.
     * 
     * @param newPrecioFactura
     */
    public void setPrecioFactura(double newPrecioFactura){
        this.precioFactura = newPrecioFactura;
    }
    
    /**
     * Método que añade un número de serie de un electrodomestico a la factura.
     */
    public void addElecEnFactura(String numSerie){
        elecsCompradosList.add(numSerie);
    }

    /**
     * Método que muestra la información de una factura
     */
    public void imprimirFactura()
    {
        System.out.println("==========================================================");
        System.out.println("                  FACTURA nº: " + this.numFactura);
        System.out.println("                           Cliente: " + this.dniCliente);
        System.out.println("                           Le atendio: " + this.dniCajero);
        System.out.println("                           Fecha: " + this.fechaCompra);
        System.out.println("    Productos:");
        for(String e: elecsCompradosList){
            System.out.println("    - " + e);
        }
        System.out.println("  El precio total es: " + this.precioFactura + " €");
        if (this.esDevolucion == true){
            System.out.println("    Esta factura es de DEVOLUCIÓN.");
            System.out.println("      El importe es a devolver");
            System.out.println();
        }
        System.out.println("==========================================================");
        System.out.println();
    }
}
