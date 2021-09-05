
/**
 * Esta clase representa el Televisor dentro de los electrodomesticos de tipo
 * Imagen. Hereda directamente de Imagen, e Imagen a su vez hereda de Electrodomestico.
 * Por tanto, Televisor es una subclase de Imagen.
 * Dentro de esta clase se encuentran los campos específicos correspondientes
 * solamente a un Televisor.
 *
 * @author Ubikitina
 * @version 04-may-2018
 */
public class Televisor extends Imagen implements java.io.Serializable
{
    private boolean smartTV;
    
    /**
     * Constructor para objetos de la clase Televisor.
     * Los inicializa con campos vacíos.
     */
    public Televisor()
    {
        super();
        smartTV = false;
    }
    
    /**
     * Constructor para objetos de la clase Televisor.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
     public Televisor(boolean smartTV, int pulgadas, boolean tiene3D, String numeroSerie, String marca,
                   String modelo, String color, double precio, int stock)
    {
        super(pulgadas, tiene3D, numeroSerie, marca, modelo, color, precio, "Televisor", stock);
        this.smartTV = smartTV;
    }
    
    /**
     * Método getter que devuelve smartTV.
     * 
     * @return    smartTV
     */
    public boolean getSmartTV()
    {
        return this.smartTV;
    }
    
    /**
     * Método setter que establece smartTV.
     * 
     * @param    newSmartTV
     */
    public void setTieneSmartTV(boolean newSmartTV)
    {
        this.smartTV = newSmartTV;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo SmartPhone en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características específicas: Tiene smartTV: " + this.smartTV);
        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
    }
}
