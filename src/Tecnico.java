import java.util.ArrayList;
import java.util.Iterator;

/**
 * Esta clase hereda de la clase Empleado, que a su vez hereda de Persona.
 * Exactamente se trata de una subclase Técnico. Dentro de la clase se encuentran
 * los campos y métodos específicos correspondientes.
 *
 * @author Ubikitina
 * @version 06-jun-2018
 */
public class Tecnico extends Empleado implements java.io.Serializable
{
    private ArrayList<FichaReparacion> almacenFichaRep;
    
    /**
     * Constructor for objects of class Tecnico
     */
    public Tecnico(String dni, String nombre, String apellidos, String contrasena)
    {
        super(dni, nombre, apellidos, contrasena, "Tecnico");
        almacenFichaRep = new ArrayList<FichaReparacion>();
    }

    /**
     * Método para añadir una nueva ficha al empleado y obtener el ID de la ficha.
     */
    public int addFichaAlmacen(String dniTecnico, String dniCliente, String refElectrodomestico, String problema){
        FichaReparacion miFicha = new FichaReparacion(dniTecnico, dniCliente, refElectrodomestico, problema);
        almacenFichaRep.add(miFicha);
        return miFicha.getIdFicha();
    }
    
    /**
     * Método para añadir una tarea a una ficha, indicado el ID de la ficha.
     */
    public void addTareaEnFicha(int idFicha, String tarea){
        Iterator it = almacenFichaRep.iterator();
        boolean esIdCorrecto = false;
        
        while(it.hasNext() && !esIdCorrecto){
            FichaReparacion nextFichaExtraida = (FichaReparacion)it.next();
            if(nextFichaExtraida.getIdFicha() == idFicha) {
                nextFichaExtraida.addTarea(tarea);
                esIdCorrecto = true;
            }
        }
        
        if(!esIdCorrecto){
            System.out.println("Error, el ID de ficha introducido no es correcto.");
        }
    }
    
    /**
     * Método para añadir una pieza a una ficha, indicado el ID de la ficha.
     */
    public void addPiezaEnFicha(int idFicha, String pieza){
        Iterator it = almacenFichaRep.iterator();
        boolean esIdCorrecto = false;
        
        while(it.hasNext() && !esIdCorrecto){
            FichaReparacion nextFichaExtraida = (FichaReparacion)it.next();
            if(nextFichaExtraida.getIdFicha() == idFicha) {
                nextFichaExtraida.addPieza(pieza);
                esIdCorrecto = true;
            }
        }
        
        if(!esIdCorrecto){
            System.out.println("Error, el ID de ficha introducido no es correcto.");
        }
    }
    
    /**
     * Método para añadir un nuevo estado a una ficha, indicado el ID de la ficha.
     */
    public void cambiarEstadoFicha(int idFicha, Estado nuevoEstado){
        Iterator it = almacenFichaRep.iterator();
        boolean esIdCorrecto = false;
        
        while(it.hasNext() && !esIdCorrecto){
            FichaReparacion nextFichaExtraida = (FichaReparacion)it.next();
            if(nextFichaExtraida.getIdFicha() == idFicha) {
                nextFichaExtraida.setEstado(nuevoEstado);
                esIdCorrecto = true;
            }
        }
        
        if(!esIdCorrecto){
            System.out.println("Error, el ID de ficha introducido no es correcto.");
        }
    }
    
    /**
     * Método para imprimir una ficha introduciendo el ID.
     */
    public void imprimirFichaDeAlmacen(int idFicha){
        Iterator it = almacenFichaRep.iterator();
        boolean esIdCorrecto = false;
        
        while(it.hasNext() && !esIdCorrecto){
            FichaReparacion nextFichaExtraida = (FichaReparacion)it.next();
            if(nextFichaExtraida.getIdFicha() == idFicha) {
                nextFichaExtraida.generateInfo();
                esIdCorrecto = true;
            }
        }
        
        if(!esIdCorrecto){
            System.out.println("Error, el ID de ficha introducido no es correcto.");
        }
    }
    
    /**
     * Método para imprimir todas las fichas de un empleado.
     */
    public void imprimirAlmacenFichas(){
        Iterator it = almacenFichaRep.iterator();
        
        while(it.hasNext()){
            ((FichaReparacion)it.next()).generateInfo();
        }
    }
    
    /**
     * Método para imprimir las fichas enProceso de un técnico.
     */
    public void imprimirAlmacenFichasEnProceso(){
        Iterator it = almacenFichaRep.iterator();
        FichaReparacion f;
        
        while(it.hasNext()){
            f = (FichaReparacion)it.next();
            if (f.getEstado() == Estado.enProceso){
                f.generateInfo();
            }
        }
    }
    
    /**
     * Método para imprimir todos los electrodomesticos de todas las fichas de un empleado.
     */
    public void imprimirElecDeTodasFichas(){
        Iterator it = almacenFichaRep.iterator();
        
        System.out.println("Los electrodomesticos asignados a este técnico son:");
        
        while(it.hasNext()){
            System.out.println("   - " + ((FichaReparacion)it.next()).getRefElectrodomestico());
        }
    }
    
    /**
     * Método para imprimir todas las piezas de todas las fichas de un empleado.
     */
    public void imprimirPiezasDeTodasFichas(){
        Iterator it = almacenFichaRep.iterator();
        
        System.out.println("Las piezas solicitadas por este técnico son:");
        
        while(it.hasNext()){
            ((FichaReparacion)it.next()).imprimirPiezas();
        }
    }
    
    /**
     * Método para imprimir info empleado en el caso de técnicos. Sobreescribe el método de la clase Empleado.
     */
    public void imprimeInfoEmpleado()
    {
        super.imprimeInfoEmpleado();
        System.out.println("> Este empleado es un TÉCNICO.");
    }
}
