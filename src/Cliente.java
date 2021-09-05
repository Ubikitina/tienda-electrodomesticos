
/**
 * Esta clase representa un objeto que hereda de la clase de persona.
 * Exactamente se trata de una subclase cliente. Dentro de la clase se encuentran
 * los campos específicos correspondientes a los clientes.
 *
 * @author Ubikitina
 * @version 12-abr-2018
 */
public class Cliente extends Persona implements java.io.Serializable
{
    private String domicilio;
    private String telefono; //Declarado como string porque no queremos hacer operaciones matemáticas entre telefonos.
    private int ultNomina;

    /**
     * Constructor para objetos de la clase Cliente.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
    public Cliente(String dni, String nombre, String apellidos, String domicilio, String telefono)
    {
        super(dni, nombre, apellidos);
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.ultNomina = 0; //lo inicializamos a 0 proque no es un dato que se solicitará habitualmente
    }
    
    /**
     * Método getter que devuelve el domicilio.
     *
     * @return    domicilio
     */
    public String getDomicilio()
    {
        return this.domicilio;
    }
    
    /**
     * Método setter que establece el domicilio.
     *
     * @param    newDomicilio
     */
    public void setDomicilio(String newDomicilio)
    {
        this.domicilio = newDomicilio;
    }
    
    /**
     * Método getter que devuelve el telefono.
     *
     * @return    telefono
     */
    public String getTelefono()
    {
        return this.telefono;
    }
    
    /**
     * Método setter que establece el telefono.
     *
     * @param    newTelefono
     */
    public void setTelefono(String newTelefono)
    {
        this.telefono = newTelefono;
    }
    
    /**
     * Método getter que devuelve la última nómina.
     *
     * @return    ultNomina
     */
    public int getUltNomina()
    {
        return this.ultNomina;
    }
    
    /**
     * Método setter que establece el valor de la última nómina.
     *
     * @param    newUltNomina
     */
    public void setUltNomina(int newUltNomina)
    {
        this.ultNomina = newUltNomina;
    }
    
    /**
     * Método que muestra la información de un cliente en pantalla
     */
    public void imprimeInfoCliente()
    {
        System.out.println("DATOS DEL CLIENTE:");
        System.out.println("   - DNI: " + super.getDni());
        System.out.println("   - Nombre y apellidos: " + super.getNombre() + " " + super.getApellidos());
        System.out.println("   - Teléfono: " + this.telefono);
        System.out.println("   - Domicilio: " + this.domicilio);
    }

}
