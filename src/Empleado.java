import java.time.LocalDate;
/**
 * Esta clase representa un objeto para que hereda de la clase de persona.
 * Exactamente se trata de una subclase empleado. Dentro de la clase se encuentran
 * los campos específicos correspondientes a los empleados.
 *
 * @author Ubikitina
 * @version 06-jun-2018
 */
public abstract class Empleado extends Persona implements java.io.Serializable
{
    private String contrasena;
    private LocalDate antiguedad;
    private String tipoEmpleado;
    private boolean estaActivo;

    /**
     * Constructor para objetos de la clase Empleado.
     * Los inicializa con campos vacíos.
     */
    public Empleado()
    {
        super("", "", "");
        contrasena = "";
        antiguedad = LocalDate.now();
        tipoEmpleado = "";
        estaActivo = false;
    }

    /**
     * Constructor para objetos de la clase Empleado.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
    public Empleado(String dni, String nombre, String apellidos, String contrasena, String tipoEmpleado)
    {
        super(dni, nombre, apellidos);
        this.contrasena = contrasena;
        this.antiguedad = LocalDate.now();
        this.tipoEmpleado = tipoEmpleado;
        this.estaActivo = true;
    }
    
    /**
     * Método getter que devuelve la contraseña.
     *
     * @return    contrasena
     */
    public String getContrasena()
    {
        return this.contrasena;
    }
    
    /**
     * Método setter que establece la contraseña.
     *
     * @param    newContrasena
     */
    public void setContrasena(String newContrasena)
    {
        this.contrasena = newContrasena;
    }
    
    /**
     * Método getter que devuelve la fechaAlta.
     *
     * @return    fechaAlta
     */
    public LocalDate getAntiguedad()
    {
        return this.antiguedad;
    }
    
    /**
     * Método getter que devuelve el tipoEmpleado.
     *
     * @return    tipoEmpleado
     */
    public String getTipoEmpleado()
    {
        return this.tipoEmpleado;
    }
    
    /**
     * Método setter que establece el tipoEmpleado.
     *
     * @param    newTipoEmpleado
     */
    public void setTipoEmpleado(String newTipoEmpleado)
    {
        this.tipoEmpleado = newTipoEmpleado;
    }
    
    /**
     * Método getter que devuelve estaActivo.
     *
     * @return    estaActivo
     */
    public boolean getEstaActivo()
    {
        return this.estaActivo;
    }
    
    /**
     * Método setter que establece estaActivo.
     *
     * @param    newEstaActivo
     */
    public void setEstaActivo(boolean newEstaActivo)
    {
        this.estaActivo = newEstaActivo;
    }
    
    /**
     * Método que muestra la información de un empleado en pantalla
     */
    public void imprimeInfoEmpleado()
    {
        System.out.println("DATOS DEL EMPLEADO:");
        System.out.println("   - DNI: " + super.getDni());
        System.out.println("   - Nombre y apellidos: " + super.getNombre() + " " + super.getApellidos());
        System.out.println("   - Contraseña: " + this.contrasena);
        System.out.println("   - Fecha de alta: " + this.antiguedad);
        System.out.println("   - Está activo: " + this.estaActivo);
    }
}
