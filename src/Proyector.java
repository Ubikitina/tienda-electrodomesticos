
/**
 * Esta clase representa el Proyector dentro de los electrodomesticos de tipo
 * Imagen. Hereda directamente de Imagen, e Imagen a su vez hereda de Electrodomestico.
 * Por tanto, Proyector es una subclase de Imagen.
 * Dentro de esta clase se encuentran los campos específicos correspondientes
 * solamente a un proyector.
 *
 * @author Ubikitina
 * @version 04-may-2018
 */
public class Proyector extends Imagen implements java.io.Serializable
{
    private double distanciaProyeccion; //distancia de proyección en metros
    
    /**
     * Constructor para objetos de la clase Proyector.
     * Los inicializa con campos vacíos.
     */
    public Proyector()
    {
        super();
        distanciaProyeccion = 0.0;
    }
    
    /**
     * Constructor para objetos de la clase Proyector.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
     public Proyector(double distanciaProyeccion, int pulgadas, boolean tiene3D, String numeroSerie, String marca,
                   String modelo, String color, double precio, int stock)
    {
        super(pulgadas, tiene3D, numeroSerie, marca, modelo, color, precio, "Proyector", stock);
        this.distanciaProyeccion = distanciaProyeccion;
    }
    
    /**
     * Método getter que devuelve distanciaProyeccion.
     * 
     * @return    distanciaProyeccion
     */
    public double getDistanciaProyeccion()
    {
        return this.distanciaProyeccion;
    }
    
    /**
     * Método setter que establece distanciaProyeccion.
     * 
     * @param    newDistanciaProyeccion
     */
    public void setDistanciaProyeccion(double newDistanciaProyeccion)
    {
        this.distanciaProyeccion = newDistanciaProyeccion;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo SmartPhone en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características específicas: Distancia proyeccion: " + this.distanciaProyeccion + "m");
        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
    }
}
