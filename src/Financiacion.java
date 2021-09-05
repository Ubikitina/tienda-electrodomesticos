
/**
 * Esta clase hereda de la clase Empleado, que a su vez hereda de Persona.
 * Exactamente se trata de una subclase Financiacion. Dentro de la clase se encuentran
 * los campos y métodos específicos correspondientes.
 *
 * @author Ubikitina
 * @version 06-jun-2018
 */
public class Financiacion extends Empleado implements java.io.Serializable
{
    
    /**
     * Constructor for objects of class Financiacion
     */
    public Financiacion(String dni, String nombre, String apellidos, String contrasena)
    {
        super(dni,nombre, apellidos, contrasena, "Financiacion");
    }
    
    /**
     * Método para imprimir info empleado en el caso de financiación. Sobreescribe el método de la clase Empleado.
     */
    public void imprimeInfoEmpleado()
    {
        super.imprimeInfoEmpleado();
        System.out.println("> Este empleado es FINANCIACIÓN.");
    }
}
