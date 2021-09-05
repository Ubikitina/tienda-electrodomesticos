
/**
 * Esta clase representa un objeto válido para todas las personas, por tanto,
 * se trata de la superclase de las clases cliente y empleado.
 * Tiene una característica especial, que es una clase abstracta. Al ser
 * una clase abstracta, contiene también un método abstracto.
 * Se utiliza para generar todos los campos estándares para las clases
 * que heredan de esta superclase.
 *
 * @author Ubikitina
 * @version 12-abr-2018
 */
public abstract class Persona implements java.io.Serializable
{
    private String dni;
    private String nombre;
    private String apellidos;
    
    /**
     * Constructor para objetos de la clase Persona.
     * Los inicializa con campos vacíos.
     */
    public Persona()
    {
        this.dni = "";
        this.nombre = "";
        this.apellidos = "";
    }
    
    /**
     * Constructor para objetos de la clase Persona.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
    public Persona(String dni, String nombre, String apellidos)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    
    /**
     * Método getter que devuelve el dni.
     *
     * @return    dni
     */
    public String getDni()
    {
        return this.dni;
    }
    
    /**
     * Método setter que establece el dni.
     *
     * @param    newDni
     */
    public void setDni(String newDni)
    {
        this.dni = newDni;
    }
    
    /**
     * Método getter que devuelve el nombre.
     *
     * @return    nombre
     */
    public String getNombre()
    {
        return this.nombre;
    }
    
    /**
     * Método setter que establece el nombre.
     *
     * @param    newNombre
     */
    public void setNombre(String newNombre)
    {
        this.nombre = newNombre;
    }
    
    /**
     * Método getter que devuelve los apellidos.
     *
     * @return    apellidos
     */
    public String getApellidos()
    {
        return this.apellidos;
    }
    
    /**
     * Método setter que establece los apellidos.
     *
     * @param    newApellidos
     */
    public void setApellidos(String newApellidos)
    {
        this.apellidos = newApellidos;
    }
}
