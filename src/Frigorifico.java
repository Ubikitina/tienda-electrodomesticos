/**
 * Esta clase representa el Frigorifico dentro de los electrodomesticos de tipo
 * Hogar. Hereda directamente de Hogar, y Hogar a su vez hereda de Electrodomestico.
 * Por tanto, Frigorifico es una subclase de Hogar.
 * Dentro de esta clase se encuentran los campos específicos correspondientes
 * solamente a un frigorifico.
 *
 * @author Ubikitina
 * @version 18-abr-2018
 */
public class Frigorifico extends Hogar implements java.io.Serializable
{
    private boolean incluyeBotellero;

    /**
     * Constructor para objetos de la clase Frigorifico.
     * Los inicializa con campos vacíos.
     */
    public Frigorifico()
    {
        super();
        incluyeBotellero = false;
    }
    
    /**
     * Constructor para objetos de la clase Frigorifico.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
     public Frigorifico(boolean incluyeBotellero, boolean controlRemoto, boolean programable, String numeroSerie, String marca,
                   String modelo, String color, double precio, int stock)
    {
        super(controlRemoto, programable, numeroSerie, marca, modelo, color, precio, "Frigorifico", stock);
        this.incluyeBotellero = incluyeBotellero;
    }
    
    /**
     * Método getter que devuelve incluyeBotellero.
     * 
     * @return    incluyeBotellero
     */
    public boolean getIncluyeBotellero()
    {
        return this.incluyeBotellero;
    }
    
    /**
     * Método setter que establece incluyeBotellero.
     * 
     * @param    newIncluyeBotellero
     */
    public void setIncluyeBotellero(boolean newIncluyeBotellero)
    {
        this.incluyeBotellero = newIncluyeBotellero;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo Frigorifico en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características específicas: Incluye botellero: " + this.incluyeBotellero);
        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
    }
}
