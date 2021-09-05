
/**
 * Esta clase representa un objeto para los electrodomesticos que
 * son tipo imágen. Hereda de la clase Electrodomestico, por tanto,
 * es una subclase. Dentro de la clase se encuentran los campos específicos
 * correspondientes a un electrodoméstico del tipo Imágen.
 *
 * @author Ubikitina
 * @version 11-abr-2018
 */
public abstract class Imagen extends Electrodomestico implements java.io.Serializable
{
    private int pulgadas;
    private boolean tiene3D;

    /**
     * Constructor para objetos de la clase Imagen.
     * Los inicializa con campos vacíos.
     */
    public Imagen()
    {
        super();
        this.pulgadas = 0;
        this.tiene3D = false;
    }
    
    /**
     * Constructor para objetos de la clase Imagen.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
    public Imagen(int pulgadas, boolean tiene3D, String numeroSerie, String marca, String modelo,
                  String color, double precio, String tipo, int stock)
    {
        super(numeroSerie, marca, modelo,color, precio, tipo, stock);
        this.pulgadas = pulgadas;
        this.tiene3D = tiene3D;
    }

    /**
     * Método getter que devuelve las pulgadas
     *
     * @return    pulgadas
     */
    public int getPulgadas()
    {
        return this.pulgadas;
    }
    
    /**
     * Método setter que establece las pulgadas
     *
     * @param    pulgadas
     */
    public void setPulgadas(int newPulgadas)
    {
        this.pulgadas = newPulgadas;
    }
    
    /**
     * Método getter que devuelve tiene3D
     *
     * @return    tiene3D
     */
    public boolean getTiene3D()
    {
        return this.tiene3D;
    }
    
    /**
     * Método setter que establece tiene3D
     *
     * @param    newTiene3D
     */
    public void setTiene3D(boolean newTiene3D)
    {
        this.tiene3D = newTiene3D;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo imágen en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características técnicas: Pulgadas: " + this.pulgadas + " y 3D: " + this.tiene3D);
    }
}
