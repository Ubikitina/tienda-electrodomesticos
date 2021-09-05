/**
 * Esta clase representa las Minicadenas dentro de los electrodomesticos de tipo
 * sonido. Hereda directamente de Sonido, y Sonido a su vez hereda de Electrodomestico.
 * Por tanto, Minicadena es una subclase de Sonido.
 * Dentro de esta clase se encuentran los campos específicos correspondientes
 * solamente a una minicadena.
 *
 * @author Ubikitina
 * @version 18-abr-2018
 */
public class Minicadena extends Sonido implements java.io.Serializable
{
    private boolean grabaVoz;
    
    /**
     * Constructor para objetos de la clase Minicadena.
     * Los inicializa con campos vacíos.
     */
    public Minicadena()
    {
        super();
        grabaVoz = false;
    }

    /**
     * Constructor para objetos de la clase Minicadena.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
     public Minicadena(boolean grabaVoz, int numAltavoces, boolean radio, String numeroSerie, String marca, String modelo,
                  String color, double precio, int stock)
    {
        super(numAltavoces, radio, numeroSerie, marca, modelo,color, precio, "Minicadena", stock);
        this.grabaVoz = grabaVoz;
    }
    
    /**
     * Método getter que devuelve grabaVoz
     *
     * @return    grabaVoz
     */
    public boolean getGrabaVoz()
    {
        return this.grabaVoz;
    }
    
    /**
     * Método setter que establece grabaVoz
     *
     * @param    newGrabaVoz
     */
    public void setGrabaVoz(boolean newGrabaVoz)
    {
        this.grabaVoz = newGrabaVoz;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo Sonido en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características específicas: Posibilidad de grabar voz: " + this.grabaVoz);
        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
    }
}
