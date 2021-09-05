/**
 * Esta clase representa el PC de Sobremesa dentro de los electrodomesticos de tipo
 * Informatica. Hereda directamente de Informatica, e Informatica a su vez hereda de Electrodomestico.
 * Por tanto, PCSobremesa es una subclase de Informatica.
 * Dentro de esta clase se encuentran los campos específicos correspondientes
 * solamente a un PC de sobremesa.
 *
 * @author Ubikitina
 * @version 18-abr-2018
 */
public class PCSobremesa extends Informatica implements java.io.Serializable
{
    private boolean incluyeTeclado;

    /**
     * Constructor para objetos de la clase PCSobremesa.
     * Los inicializa con campos vacíos.
     */
    public PCSobremesa()
    {
        super();
        incluyeTeclado = false;
    }
    
    /**
     * Constructor para objetos de la clase PCSobremesa.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
     public PCSobremesa(boolean incluyeTeclado, int capacidadDisco, String tipoDisco, String numeroSerie, String marca, String modelo,
                  String color, double precio, int stock)
    {
        super(capacidadDisco, tipoDisco, numeroSerie, marca, modelo, color, precio, "PCSobremesa", stock);
        this.incluyeTeclado = incluyeTeclado;
    }
    
    /**
     * Método getter que devuelve incluyeTeclado.
     * 
     * @return    incluyeTeclado
     */
    public boolean getIncluyeTeclado()
    {
        return this.incluyeTeclado;
    }
    
    /**
     * Método setter que establece incluyeTeclado.
     * 
     * @param    newIncluyeTeclado
     */
    public void setIncluyeTeclado(boolean newIncluyeTeclado)
    {
        this.incluyeTeclado = newIncluyeTeclado;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo Informatica en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características especificas: Incluye teclado: " + this.incluyeTeclado);
        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
    }
}
