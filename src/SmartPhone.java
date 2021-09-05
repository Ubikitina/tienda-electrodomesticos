/**
 * Esta clase representa el Smart Phone dentro de los electrodomesticos de tipo
 * Telefonia. Hereda directamente de Telefonia, y Telefonia a su vez hereda de Electrodomestico.
 * Por tanto, SmartPhone es una subclase de Telefonia.
 * Dentro de esta clase se encuentran los campos específicos correspondientes
 * solamente a un SmartPhone.
 *
 * @author Ubikitina
 * @version 04-may-2018
 */
public class SmartPhone extends Telefonia implements java.io.Serializable
{
    private boolean tiene4G;

    /**
     * Constructor para objetos de la clase SmartPhone.
     * Los inicializa con campos vacíos.
     */
    public SmartPhone()
    {
        super();
        tiene4G = false;
    }
    
    /**
     * Constructor para objetos de la clase SmartPhone.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
     public SmartPhone(boolean tiene4G, int horasAutonomia, boolean tieneManosLibres, String numeroSerie, String marca,
                   String modelo, String color, double precio, int stock)
    {
        super(horasAutonomia, tieneManosLibres, numeroSerie, marca, modelo, color, precio, "SmartPhone", stock);
        this.tiene4G = tiene4G;
    }
    
    /**
     * Método getter que devuelve tiene4G.
     * 
     * @return    tiene4G
     */
    public boolean getTiene4G()
    {
        return this.tiene4G;
    }
    
    /**
     * Método setter que establece tiene4G.
     * 
     * @param    newTiene4G
     */
    public void setTiene4G(boolean newTiene4G)
    {
        this.tiene4G = newTiene4G;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo SmartPhone en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características específicas: Tiene 4G: " + this.tiene4G);
        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
    }
}
