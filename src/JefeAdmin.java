
/**
 * Esta clase hereda de la clase Empleado, que a su vez hereda de Persona.
 * Exactamente se trata de una subclase Jefe-Administrador. Dentro de la clase se encuentran
 * los campos y métodos específicos correspondientes.
 *
 * @author Ubikitina
 * @version 06-jun-2018
 */
public class JefeAdmin extends Empleado implements java.io.Serializable
{
    
    /**
     * Constructor for objects of class JefeAdmin
     */
    public JefeAdmin(String dni, String nombre, String apellidos, String contrasena)
    {
        super(dni,nombre, apellidos, contrasena, "Jefe");
    }

    /**
     * Método para imprimir info empleado en el caso del jefe. Sobreescribe el método de la clase Empleado.
     */
    public void imprimeInfoEmpleado()
    {
        super.imprimeInfoEmpleado();
        System.out.println("> Este empleado es un JEFE-ADMINISTRADOR.");
    }
}
