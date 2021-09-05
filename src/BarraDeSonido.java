/**
 * Esta clase representa las Barras de Sonido dentro de los electrodomesticos de tipo
 * sonido. Hereda directamente de Sonido, y Sonido a su vez hereda de Electrodomestico.
 * Por tanto, BarraDeSonido es una subclase de Sonido.
 * Dentro de esta clase se encuentran los campos específicos correspondientes
 * solamente a una barra de sonido.
 *
 * @author Ubikitina
 * @version 18-abr-2018
 */
public class BarraDeSonido extends Sonido implements java.io.Serializable
{
    private String tipoConexion;

    /**
     * Constructor para objetos de la clase BarraDeSonido.
     * Los inicializa con campos vacíos.
     */
    public BarraDeSonido()
    {
        super();
        tipoConexion = "";
    }
    
    /**
     * Constructor para objetos de la clase BarraDeSonido.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
     public BarraDeSonido(String tipoConexion, int numAltavoces, boolean radio, String numeroSerie, String marca, String modelo,
                  String color, double precio, int stock)
    {
        super(numAltavoces, radio, numeroSerie, marca, modelo,color, precio, "BarraDeSonido", stock);
        this.tipoConexion = tipoConexion;
    }
    
    /**
     * Método getter que devuelve tipoConexion.
     * 
     * @return    tipoConexion
     */
    public String getTipoConexion()
    {
        return this.tipoConexion;
    }
    
    /**
     * Método setter que establece tipoConexion.
     * 
     * @param    newTipoConexion
     */
    public void setTipoConexion(String newTipoConexion)
    {
        this.tipoConexion = newTipoConexion;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo Sonido en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características específicas: Tipo conexion " + this.tipoConexion);
        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
    }
}
