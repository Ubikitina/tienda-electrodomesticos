/**
 * Esta clase representa un objeto para los electrodomesticos que
 * son tipo telefonía. Hereda de la clase Electrodomestico, por tanto,
 * es una subclase. Dentro de la clase se encuentran los campos específicos
 * correspondientes a un electrodoméstico del tipo telefonía
 *
 * @author Ubikitina
 * @version 11-abr-2018
 */
public abstract class Telefonia extends Electrodomestico implements java.io.Serializable
{
    private int horasAutonomia;
    private boolean tieneManosLibres;

    /**
     * Constructor para objetos de la clase Telefonia.
     * Los inicializa con campos vacíos.
     */
    public Telefonia()
    {
        super();
        this.horasAutonomia = 0;
        this.tieneManosLibres = false;
    }
    
    /**
     * Constructor para objetos de la clase Telefonia.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
    public Telefonia(int horasAutonomia, boolean tieneManosLibres, String numeroSerie, String marca, String modelo,
                  String color, double precio, String tipo, int stock)
    {
        super(numeroSerie, marca, modelo,color, precio, tipo, stock);
        this.horasAutonomia = horasAutonomia;
        this.tieneManosLibres = tieneManosLibres;
    }
    
    /**
     * Método getter que devuelve horasAutonomia.
     * 
     * @return    horasAutonomia
     */
    public int getHorasAutonomia()
    {
        return this.horasAutonomia;
    }
    
    /**
     * Método setter que establece horasAutonomia.
     * 
     * @param    newHorasAutonomia
     */
    public void setHorasAutonomia(int newHorasAutonomia)
    {
        this.horasAutonomia = newHorasAutonomia;
    }
    
    /**
     * Método getter que devuelve tieneManosLibres.
     * 
     * @return    tieneManosLibres
     */
    public boolean getTieneManosLibres()
    {
        return this.tieneManosLibres;
    }
    
    /**
     * Método setter que establece tieneManosLibres.
     * 
     * @param    newTieneManosLibres
     */
    public void setTieneManosLibres(boolean newTieneManosLibres)
    {
        this.tieneManosLibres = newTieneManosLibres;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo Telefonia en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características técnicas: Tiempo de autonomía: " + this.horasAutonomia + "h, y tiene manos libres: " + this.tieneManosLibres);
    }
}
