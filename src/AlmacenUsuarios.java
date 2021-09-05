import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
/**
 * Esta clase es para almacenar y gestionar los usuarios del programa.
 * Dentro de la clase se encuentran los campos específicos de almacén
 * (principalmente el HashMap para almacenar) y los métodos específicos
 * para gestioanar los usuarios dentro del almacén.
 *
 * @author Ubikitina
 * @version 06-jun-2018
 */
public class AlmacenUsuarios implements java.io.Serializable
{
    private HashMap <String, Empleado> empleadoHM;
    private int contador;

    /**
     * Constructor for objects of class AlmacenUsuarios
     */
    public AlmacenUsuarios()
    {
        empleadoHM = new HashMap<String, Empleado>();
        contador = 0;
    }

    /**
     * Método para añadir un empleado del tipo Tecnico y sus datos al HashMap.
     */
    public void addTecnico(String dni, String nombre, String apellidos, String contrasena) {
        Tecnico nuevoTecnico = new Tecnico(dni, nombre, apellidos, contrasena);
        empleadoHM.put(nuevoTecnico.getDni(), nuevoTecnico);
        contador++;
    }
    
    /**
     * Método para añadir un empleado del tipo Cajero y sus datos al HashMap.
     */
    public void addCajero(String dni, String nombre, String apellidos, String contrasena) {
        Empleado nuevoCajero = new Cajero(dni, nombre, apellidos, contrasena);
        empleadoHM.put(nuevoCajero.getDni(), nuevoCajero);
        contador++;
    }
    
    /**
     * Método para añadir un empleado del tipo Financiacion y sus datos al HashMap.
     */
    public void addFinanciacion(String dni, String nombre, String apellidos, String contrasena) {
        Empleado nuevoFinanciacion = new Financiacion(dni, nombre, apellidos, contrasena);
        empleadoHM.put(nuevoFinanciacion.getDni(), nuevoFinanciacion);
        contador++;
    }
    
    /**
     * Método para añadir un empleado del tipo Postventa y sus datos al HashMap.
     */
    public void addPostventa(String dni, String nombre, String apellidos, String contrasena) {
        Empleado nuevoPostventa = new Postventa(dni, nombre, apellidos, contrasena);
        empleadoHM.put(nuevoPostventa.getDni(), nuevoPostventa);
        contador++;
    }
    
    /**
     * Método para añadir un empleado del tipo Postventa y sus datos al HashMap.
     */
    public void addComercial(String dni, String nombre, String apellidos, String contrasena) {
        Empleado nuevoComercial = new Comercial(dni, nombre, apellidos, contrasena);
        empleadoHM.put(nuevoComercial.getDni(), nuevoComercial);
        contador++;
    }
    
    /**
     * Método para añadir un empleado del tipo Jefe-administrador y sus datos al HashMap.
     */
    public void addAdmin(String dni, String nombre, String apellidos, String contrasena) {
        Empleado nuevoAdmin = new JefeAdmin(dni, nombre, apellidos, contrasena);
        empleadoHM.put(nuevoAdmin.getDni(), nuevoAdmin);
        contador++;
    }
    
    /**
     * Metodo que elimina un empleado, pasandole el DNI.
     */
    public void borrarEmpleado(String dni)
    {
        empleadoHM.remove(dni);
    }
    
    /**
     * Método para imprimir un único empleado, introduciendo su DNI.
     */
    public void imprimirUnUsuario(String dni){
        (empleadoHM.get(dni)).imprimeInfoEmpleado();
    }
    
    /**
     * Método para imprimir toda la lista de usuarios y sus datos.
     */
    public void imprimirListaUsuarios() {
        Set <String> setDeDNIs = new HashSet<String>();
             
        setDeDNIs = empleadoHM.keySet();
                
        for(Iterator<String> it = setDeDNIs.iterator(); it.hasNext(); ) { 
            empleadoHM.get(it.next()).imprimeInfoEmpleado(); 
            System.out.println();
        }
    }
    
    /**
     * Método para imprimir toda la lista de usuarios del tipo tecnico y sus datos.
     */
    public void imprimirListaUsuariosTecnico() {
        Set <String> setDeDNIs = new HashSet<String>();
             
        setDeDNIs = empleadoHM.keySet();
                
        for(Iterator<String> it = setDeDNIs.iterator(); it.hasNext(); ) { 
            Empleado e = empleadoHM.get(it.next());
            if (getTipoEmpleado(e.getDni()).equals("tecnico")){
                e.imprimeInfoEmpleado(); 
                System.out.println();
            }
        }
    }
    
    /**
     * Método para editar un atributo de un usuario dentro del HashMap.
     */
    public void editarAtributo(String dni, String nuevoValor, String atributo){ //fechaAlta no se puede modificar porque no tiene sentido modificar la fecha de alta.
        if (atributo.equals("nombre")){
            (empleadoHM.get(dni)).setNombre(nuevoValor);
        }else if (atributo.equals("apellidos")){
            (empleadoHM.get(dni)).setApellidos(nuevoValor);
        } else if (atributo.equals("contrasena")){
            (empleadoHM.get(dni)).setContrasena(nuevoValor);
        } else if (atributo.equals("estaActivo")){
            boolean nuevoEstaActivo = Boolean.parseBoolean(nuevoValor);
            (empleadoHM.get(dni)).setEstaActivo(nuevoEstaActivo);
        }
    }
    
    /**
     * Método para saber si existe usuario.
     */
    public boolean usuarioPreviamenteCreado(String dni){
        return empleadoHM.containsKey(dni);
    }
    
    /**
     * Método para comprobar que la contraseña de un empleado es correcta.
     */
    public boolean esPasswordCorrecto(String dniEmpleado, String passwordPorComprobar){
        if ((empleadoHM.get(dniEmpleado)).getContrasena().equals(passwordPorComprobar)){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Método para añadir una ficha de reparación a un técnico concreto que está dentro del HM de empleados.
     */
    public void agregarFichaRep(String dniTecnico, String dniCliente, String refElectrodomestico, String problema){
        ((Tecnico)(empleadoHM.get(dniTecnico))).addFichaAlmacen(dniTecnico, dniCliente, refElectrodomestico, problema);
    }
    
    /**
     * Método para añadir una tarea en una ficha de reparación de un técnico concreto que está dentro del HM de empleados.
     */
    public void agregarTareaEnFicha(String dniTecnico,int idFicha, String tarea){
        ((Tecnico)(empleadoHM.get(dniTecnico))).addTareaEnFicha(idFicha, tarea);
    }
    
    /**
     * Método para añadir una pieza en una ficha de reparación de un técnico concreto que está dentro del HM de empleados.
     */
    public void agregarPiezaEnFicha(String dniTecnico,int idFicha, String pieza){
        ((Tecnico)(empleadoHM.get(dniTecnico))).addPiezaEnFicha(idFicha, pieza);
    }
    
    /**
     * Método para cambiar el estado a una ficha de reparación de un técnico concreto que está dentro del HM de empleados.
     */
    public void cambiarEstadoEnFichaTecnico(String dniTecnico, int idFicha, Estado nuevoEstado){
        ((Tecnico)(empleadoHM.get(dniTecnico))).cambiarEstadoFicha(idFicha, nuevoEstado);
    }
    
    /**
     * Método para imprimir una ficha de reparación de un técnico concreto que está dentro del HM de empleados.
     */
    public void imprimirUnaFichaTecnico(String dniTecnico, int idFicha){
        ((Tecnico)(empleadoHM.get(dniTecnico))).imprimirFichaDeAlmacen(idFicha);
    }
    
    /**
     * Método para imprimir todas las fichas de reparación de un técnico concreto que está dentro del HM de empleados.
     */
    public void imprimirTodasFichasTecnico(String dniTecnico){
        ((Tecnico)(empleadoHM.get(dniTecnico))).imprimirAlmacenFichas();
    }
    
    /**
     * Método para imprimir todos los electrodomesticos de todas las fichas de un técnico concreto que está dentro del HM de empleados.
     */
    public void imprimirTodosElecTecnico(String dniTecnico){
        ((Tecnico)(empleadoHM.get(dniTecnico))).imprimirElecDeTodasFichas(); 
    }
    
    /**
     * Método para imprimir todas las piezas de todas las fichas de un técnico concreto que está dentro del HM de empleados.
     */
    public void imprimirTodasPiezasTecnico(String dniTecnico){
        ((Tecnico)(empleadoHM.get(dniTecnico))).imprimirPiezasDeTodasFichas(); 
    }
    
    /**
     * Método para imprimir todas las fichas de reparación de estado En Proceso de un técnico concreto que está dentro del HM de empleados.
     */
    public void imprimirTodasFichasTecnicoEnProceso(String dniTecnico){
        ((Tecnico)(empleadoHM.get(dniTecnico))).imprimirAlmacenFichasEnProceso();
    }
    
    /**
     * Método para saber qué tipo de empleado es un empleado concreto que está dentro del HM, ppasandole el DNI.
     */
    public String getTipoEmpleado(String dniEmpleado){
        if(empleadoHM.get(dniEmpleado) instanceof JefeAdmin){
            return "jefe";
        }else if(empleadoHM.get(dniEmpleado) instanceof Cajero){
            return "cajero";
        }else if(empleadoHM.get(dniEmpleado) instanceof Tecnico){
            return "tecnico";
        }else if(empleadoHM.get(dniEmpleado) instanceof Financiacion){
            return "financiacion";
        }else if(empleadoHM.get(dniEmpleado) instanceof Comercial){
            return "comercial";
        }else if(empleadoHM.get(dniEmpleado) instanceof Postventa){
            return "postventa";
        }else{
            return "error";
        }
    }
    
    /**
     * Método para saber el número de usuarios que están almacenados.
     */
    public int getNumEmpleados(){
        return empleadoHM.size();
    }
}
