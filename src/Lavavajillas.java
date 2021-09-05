/**
 * Esta clase representa el Lavavajillas dentro de los electrodomesticos de tipo
 * Hogar. Hereda directamente de Hogar, y Hogar a su vez hereda de Electrodomestico.
 * Por tanto, Lavavajillas es una subclase de Hogar.
 * Dentro de esta clase se encuentran los campos específicos correspondientes
 * solamente a un lavavajillas.
 *
 * @author Ubikitina
 * @version 18-abr-2018
 */
public class Lavavajillas extends Hogar implements java.io.Serializable
{
    private int consumoAnualAgua;

    /**
     * Constructor para objetos de la clase Lavavajillas.
     * Los inicializa con campos vacíos.
     */
    public Lavavajillas()
    {
        super();
        consumoAnualAgua = 0;
    }
    
    /**
     * Constructor para objetos de la clase Lavavajillas.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
     public Lavavajillas(int consumoAnualAgua, boolean controlRemoto, boolean programable, String numeroSerie, String marca,
                   String modelo, String color, double precio, int stock)
    {
        super(controlRemoto, programable, numeroSerie, marca, modelo, color, precio, "Lavavajillas", stock);
        this.consumoAnualAgua = consumoAnualAgua;
    }
    
    /**
     * Método getter que devuelve consumoAnualAgua.
     * 
     * @return    consumoAnualAgua
     */
    public int getConsumoAnualAgua()
    {
        return this.consumoAnualAgua;
    }
    
    /**
     * Método setter que establece consumoAnualAgua.
     * 
     * @param    newConsumoAnualAgua
     */
    public void setConsumoAnualAgua(int newConsumoAnualAgua)
    {
        this.consumoAnualAgua = newConsumoAnualAgua;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo Hogar en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características específicas: Consumo anual de agua: " + this.consumoAnualAgua + " L.");
        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
    }
}
