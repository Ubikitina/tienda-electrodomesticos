import java.util.*;
/**
 * Esta clase representa un objeto para almacenar los clientes.
 * Dentro de la clase se encuentran los campos específicos de almacén
 * (principalmente el HashMap para almacenar) y los métodos específicos
 * para gestioanar este almacén.
 *
 * @author Ubikitina
 * @version 04-may-2018
 */
public class AlmacenClientes implements java.io.Serializable
{
    private HashMap <String, Cliente> clienteHM;
    private int contadorClientes;

    /**
     * Constructor para objetos de la clase AlmacenClientes
     */
    public AlmacenClientes()
    {
        clienteHM = new HashMap<String, Cliente>();
        contadorClientes = 0;
    }
    
    /**
     * Método para añadir un cliente al HashMap pasandole todos los datos de cliente.
     */
    public void addCliente(String dni, String nombre, String apellidos, String domicilio, String telefono) {
        Cliente nuevoCliente = new Cliente(dni, nombre, apellidos, domicilio, telefono);
        clienteHM.put(nuevoCliente.getDni(), nuevoCliente);
        contadorClientes++;
    }
    
    /**
     * Metodo para editar la lista de clientes
     */
    public void editarCliente(Cliente cli1){
        if ((clienteHM.containsKey(cli1.getDni())) == true){
            clienteHM.put(cli1.getDni(), cli1);
        }
    }
    
    /**
     * Metodo que elimina un cliente, pasandole el DNI.
     */
    public void borrarCliente(String dni)
    {
        clienteHM.remove(dni);
    }
    
    /**
     * Método para hacer búsquedas dentro de una lista de clientes. Busca por DNI.
     */
    public Cliente busquedaPorDNI(String dni){
        return clienteHM.get(dni);
    }
    
    /**
     * Método para imprimir toda la lista de clientes y sus datos.
     */
    public void imprimirListaClientes() {
        Set <String> setDeDNIs = new HashSet<String>();
             
        setDeDNIs = clienteHM.keySet();
                
        for(Iterator<String> it = setDeDNIs.iterator(); it.hasNext(); ) { 
            clienteHM.get(it.next()).imprimeInfoCliente(); //asi consigo sacar info de todos los objetos tipo cliente
            System.out.println();
        }
    }
    
    /**
     * Método para imprimir un único cliente y sus datos, introduciendo su DNI.
     */
    public void imprimirClienteDeHM(String dni){
        if(clienteHM.get(dni) != null){
            (clienteHM.get(dni)).imprimeInfoCliente();
            System.out.println("   - Última nómina: " + (clienteHM.get(dni)).getUltNomina() + " €");
        }else{
            System.out.println("No se ha encontrado ningún cliente que corresponda al DNI introducido.");
        }
    }
    
    /**
     * Método para editar un atributo de un cliente dentro del HashMap.
     */
    public void editarAtributo(String dni, String nuevoValor, String atributo){
        if (atributo.equals("nombre")){
            (clienteHM.get(dni)).setNombre(nuevoValor);
        }else if (atributo.equals("apellidos")){
            (clienteHM.get(dni)).setApellidos(nuevoValor);
        } else if (atributo.equals("domicilio")){
            (clienteHM.get(dni)).setDomicilio(nuevoValor);
        } else if (atributo.equals("telefono")){
            (clienteHM.get(dni)).setTelefono(nuevoValor);
        } else if (atributo.equals("nomina")){
            int nuevaNomina = Integer.parseInt(nuevoValor);
            (clienteHM.get(dni)).setUltNomina(nuevaNomina);
        }
    }
    
    /**
     * Método para saber si existe cliente.
     */
    public boolean clientePreviamenteCreado(String dni){
        return clienteHM.containsKey(dni);
    }
}
