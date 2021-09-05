/**
 * Esta clase representa el Portatil dentro de los electrodomesticos de tipo
 * Informatica. Hereda directamente de Informatica, e Informatica a su vez hereda de Electrodomestico.
 * Por tanto, Portatil es una subclase de Informatica.
 * Dentro de esta clase se encuentran los campos específicos correspondientes
 * solamente a un portatil.
 *
 * @author Ubikitina
 * @version 18-abr-2018
 */
public class Portatil extends Informatica implements java.io.Serializable
{
    private int horasAutonomia;

    /**
     * Constructor para objetos de la clase Portatil.
     * Los inicializa con campos vacíos.
     */
    public Portatil()
    {
        super();
        horasAutonomia = 0;
    }
    
    /**
     * Constructor para objetos de la clase Portatil.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
     public Portatil(int horasAutonomia, int capacidadDisco, String tipoDisco, String numeroSerie, String marca, String modelo,
                  String color, double precio, int stock)
    {
        super(capacidadDisco, tipoDisco, numeroSerie, marca, modelo, color, precio, "Portatil", stock);
        this.horasAutonomia = horasAutonomia;
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
     * Método que muestra la información de un electrodomestico tipo Informatica en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características especificas: Horas autonomía: " + this.horasAutonomia + "h.");
        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
    }
}
