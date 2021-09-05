
/**
 * Esta clase representa un objeto para los electrodomesticos que
 * son tipo sonido. Hereda de la clase Electrodomestico, por tanto,
 * es una subclase. Dentro de la clase se encuentran los campos específicos
 * correspondientes a un electrodoméstico del tipo Sonido.
 *
 * @author Ubikitina
 * @version 11-abr-2018
 */
public abstract class Sonido extends Electrodomestico implements java.io.Serializable
{
    private int numAltavoces;
    private boolean radio;

    /**
     * Constructor para objetos de la clase Sonido.
     * Los inicializa con campos vacíos.
     */
    public Sonido()
    {
        super();
        this.numAltavoces = 0;
        this.radio = false;
    }
    
    /**
     * Constructor para objetos de la clase Radio.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
    public Sonido(int numAltavoces, boolean radio, String numeroSerie, String marca, String modelo,
                  String color, double precio, String tipo, int stock)
    {
        super(numeroSerie, marca, modelo,color, precio, tipo, stock);
        this.numAltavoces = numAltavoces;
        this.radio = radio;
    }

    /**
     * Método getter que devuelve el número de altavoces.
     *
     * @return    numAltavoces
     */
    public int getNumAltavoces()
    {
        return this.numAltavoces;
    }
    
    /**
     * Método setter que establece el número de altavoces.
     *
     * @param    numAltavoces
     */
    public void setNumAltavoces(int newNumAltavoces)
    {
        this.numAltavoces = newNumAltavoces;
    }
    
    /**
     * Método getter que devuelve radio
     *
     * @return    radio
     */
    public boolean getRadio()
    {
        return this.radio;
    }
    
    /**
     * Método setter que establece radio
     *
     * @param    newRadio
     */
    public void setRadio(boolean newRadio)
    {
        this.radio = newRadio;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo Sonido en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características técnicas: Número de altavoces: " + this.numAltavoces + " y Radio: " + this.radio);
    }
}
