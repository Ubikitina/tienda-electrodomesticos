import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Esta clase representa un objeto ficha de reparación. Una ficha de reparación
 * se crea para asignar a un trabajador del perfil Técnico la reparación de un 
 * electrodoméstico. En ella, se van registrando las tareas realizadas, y la información
 * de producto, cliente y técnico.
 *
 * @author Ubikitina
 * @version 17-jun-2018
 */
public class FichaReparacion implements java.io.Serializable
{
    private static int contador = 0;
    private int idFicha;
    private LocalDate fechaCreacion;
    private String dniTecnico;
    private String dniCliente;
    private String refElectrodomestico;
    private String problema;
    private ArrayList<String> tareas;
    private Estado estado;
    private ArrayList<String> piezasQueFaltan;

    /**
     * Constructor para objetos de la clase FichaReparacion
     */
    public FichaReparacion(String dniTecnico, String dniCliente, String refElectrodomestico, String problema)
    {
        this.idFicha = contador;
        fechaCreacion = LocalDate.now();
        this.dniTecnico = dniTecnico;
        this.dniCliente = dniCliente;
        this.refElectrodomestico = refElectrodomestico;
        this.problema = problema;
        this.tareas = new ArrayList<String>();
        this.estado = Estado.pendiente;
        this.piezasQueFaltan = new ArrayList<String>();
        contador++;
    }
    
    /**
     * Método getter que devuelve el ID de la ficha.
     */
    public int getIdFicha(){
        return this.idFicha;
    }
    
    /**
     * Método getter que devuelve la fecha de creación de la ficha.
     * 
     * @return fechaCreacion
     */
    public LocalDate getFechaCreacion(){
        return this.fechaCreacion;
    }
    
    /**
     * Método getter que devuelve el dni del técnico.
     * 
     * @return dniTecnico
     */
    public String getDniTecnico(){
        return this.dniTecnico;
    }
    
    /**
     * Método getter que devuelve el dni del cliente.
     * 
     * @return dniCliente
     */
    public String getDniCliente(){
        return this.dniCliente;
    }
    
    /**
     * Método getter que devuelve la referencia del electrodomestico.
     * 
     * @return refElectrodomestico
     */
    public String getRefElectrodomestico(){
        return this.refElectrodomestico;
    }
    
    /**
     * Método getter que devuelve la descripción del problema.
     * 
     * @return problema
     */
    public String getProblema(){
        return this.problema;
    }
    
    /**
     * Método getter que devuelve el listado de tareas.
     * 
     * @return tareas
     */
    public ArrayList<String> getTareas(){
        return this.tareas;
    }
    
    /**
     * Método getter que devuelve el estado.
     * 
     * @return estado
     */
    public Estado getEstado(){
        return this.estado;
    }
    
    /**
     * Método getter que devuelve el listado de piezas que faltan.
     * 
     * @return piezasQueFaltan
     */
    public ArrayList<String> getPiezasQueFaltan(){
        return this.piezasQueFaltan;
    }
    
    /**
     * Método que añade una tarea al listado de tareas.
     */
    public void addTarea(String nuevaTarea){
        tareas.add(nuevaTarea);
    }
    
    /**
     * Método que añade una nueva pieza al listado de piezas que faltan.
     */
    public void addPieza(String nuevaPieza){
        piezasQueFaltan.add(nuevaPieza);
    }
    
    /**
     * Método setter que establece un nuevo estado a la ficha.
     */
    public void setEstado(Estado nuevoEstado){
        this.estado = nuevoEstado;
    }
    
    /**
     * Método para imprimir la ficha.
     */
    public void generateInfo(){
        System.out.println(" + + + FICHA Nº " + idFicha + " + + +");
        System.out.println("ID ficha: " + idFicha + " // Fecha: " + fechaCreacion + " // Técnico: " + dniTecnico + " // Cliente: " + dniCliente + " // Ref. Electrodomestico: " + refElectrodomestico);
        System.out.println("Problema: " + problema);
        switch (this.estado){
            case pendiente: System.out.println("Estado: Pendiente"); break;
            case enProceso: System.out.println("Estado: En proceso"); break;
            case parado: System.out.println("Estado: Parado"); break;
            case faseDePrueba: System.out.println("Estado: Fase de Prueba"); break;
            case terminado: System.out.println("Estado: Terminado"); break;
        }
        
        System.out.println("Tareas:");
        Iterator it = tareas.iterator();        
        while(it.hasNext()){
            System.out.println("  - "+ it.next());
        }
        
        System.out.println("Piezas que faltan:");
        Iterator it2 = piezasQueFaltan.iterator();        
        while(it2.hasNext()){
            System.out.println("  - "+ it2.next());
        }
        
        System.out.println("+   +   +   +   +   +   +   +   +   +   +");
    }
    
    /**
     * Método para imprimir tareas de la ficha.
     */
    public void imprimirPiezas(){
        Iterator it = piezasQueFaltan.iterator();        
        while(it.hasNext()){
            System.out.println("  - "+ it.next());
        }
    }

}

enum Estado{ pendiente,enProceso,parado,faseDePrueba,terminado }
