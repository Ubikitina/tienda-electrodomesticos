/**
 * Esta clase representa un objeto para los electrodomesticos que
 * son tipo informatica. Hereda de la clase Electrodomestico, por tanto,
 * es una subclase. Dentro de la clase se encuentran los campos específicos
 * correspondientes a un electrodoméstico del tipo informatica.
 *
 * @author Ubikitina
 * @version 11-abr-2018
 */
public abstract class Informatica extends Electrodomestico implements java.io.Serializable
{
    private int capacidadDisco;
    private String tipoDisco;

    /**
     * Constructor para objetos de la clase Informatica.
     * Los inicializa con campos vacíos.
     */
    public Informatica()
    {
        super();
        this.capacidadDisco = 0;
        this.tipoDisco = "";
    }
    
    /**
     * Constructor para objetos de la clase Informatica.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
    public Informatica(int capacidadDisco, String tipoDisco, String numeroSerie, String marca, String modelo,
                  String color, double precio, String tipo, int stock)
    {
        super(numeroSerie, marca, modelo,color, precio, tipo, stock);
        this.capacidadDisco = capacidadDisco;
        this.tipoDisco = tipoDisco;
    }

    
    /**
     * Método getter que devuelve capacidadDisco.
     *
     * @return    capacidadDisco
     */
    public int getCapacidadDisco()
    {
        return this.capacidadDisco;
    }
    
    /**
     * Método setter que establece capacidadDisco.
     *
     * @param    newCapacidadDisco
     */
    public void setCapacidadDisco(int newCapacidadDisco)
    {
        this.capacidadDisco = newCapacidadDisco;
    }
    
    /**
     * Método getter que devuelve tipoDisco.
     * 
     * @return    tipoDisco
     */
    public String getTipoDisco()
    {
        return this.tipoDisco;
    }
    
    /**
     * Método setter que establece tipoDisco.
     * 
     * @param    newtipoDisco
     */
    public void setTipoDisco(String newTipoDisco)
    {
        this.tipoDisco = newTipoDisco;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo Informatica en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características técnicas: Tipo disco: " + this.tipoDisco + " y Capacidad Disco: " + this.capacidadDisco);
    }
}
