
/**
 * Esta clase representa el Telefono Domestico dentro de los electrodomesticos de tipo
 * Telefonia. Hereda directamente de Telefonia, y Telefonia a su vez hereda de Electrodomestico.
 * Por tanto, TelefonoDomestico es una subclase de Imagen.
 * Dentro de esta clase se encuentran los campos específicos correspondientes
 * solamente a un telefono domestico.
 *
 * @author Ubikitina
 * @version 04-may-2018
 */
public class TelefonoDomestico extends Telefonia implements java.io.Serializable
{
    private int unidades;

    /**
     * Constructor para objetos de la clase TelefonoDomestico.
     * Los inicializa con campos vacíos.
     */
    public TelefonoDomestico()
    {
        super();
        unidades = 0;
    }
    
    /**
     * Constructor para objetos de la clase TelefonoDomestico.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
     public TelefonoDomestico(int unidades, int horasAutonomia, boolean tieneManosLibres, String numeroSerie, String marca,
                   String modelo, String color, double precio, int stock)
    {
        super(horasAutonomia, tieneManosLibres, numeroSerie, marca, modelo, color, precio, "TelefonoDomestico", stock);
        this.unidades = unidades;
    }
    
    /**
     * Método getter que devuelve unidades.
     * 
     * @return    unidades
     */
    public int getUnidades()
    {
        return this.unidades;
    }
    
    /**
     * Método setter que establece unidades.
     * 
     * @param    newUnidades
     */
    public void setUnidades(int newUnidades)
    {
        this.unidades = newUnidades;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo SmartPhone en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características específicas: Unidades: " + this.unidades);
        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
    }
}
