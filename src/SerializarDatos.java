import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
/**
 * Esta clase es para la serialización de datos.
 * Los datos que se necesitan guardar son los datos de todos los almacenes (electrodomesticos, clientes, usuarios y fichas de compra).
 *
 * @author Ubikitina
 * @version 11-jul-2018
 */

public class SerializarDatos
{
    private String ruta;
    private File datosDeAlmacenes;
    
    AlmacenElectrod miAlmacen;
    AlmacenClientes miAlmacenClientes;
    AlmacenUsuarios miAlmacenUsuarios;
    AlmacenFichas miAlmacenFichas;

    /**
     * Constructor para objetos de la clase SerializarDatos
     */
    public SerializarDatos(){
        ruta = System.getProperty("user.dir");
        ruta = ruta + File.separatorChar;
        
        datosDeAlmacenes = new File(ruta + "misdatos.dat");
        
        miAlmacen = new AlmacenElectrod();
        miAlmacenClientes = new AlmacenClientes();
        miAlmacenUsuarios = new AlmacenUsuarios();
        miAlmacenFichas = new AlmacenFichas();
    }
    
    /**
     * Método para enviar toda la información del archivo .dad (desde el ordenador) 
     * a los cuatro almacenes (al programa).
     */
    public boolean importarDatos(){
        try{
            FileInputStream origen = new FileInputStream(datosDeAlmacenes);
            ObjectInputStream entrada = new ObjectInputStream(origen);
            miAlmacen = (AlmacenElectrod)entrada.readObject();
            miAlmacenClientes = (AlmacenClientes)entrada.readObject();
            miAlmacenUsuarios = (AlmacenUsuarios)entrada.readObject();
            miAlmacenFichas = (AlmacenFichas)entrada.readObject();
            entrada.close();
            origen.close();
        }catch(FileNotFoundException exc){
           
        }catch(ClassNotFoundException exc){
            exc.printStackTrace();
            return false;
        }catch(IOException ioe){
            ioe.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * Método para guardar toda la información almacenada en los gestores (desde el prgorama)
     * en el archivo .dat para el uso posterior (al ordenador).
     */
    public boolean exportarDatos(){
        try{
            FileOutputStream destino = new FileOutputStream(datosDeAlmacenes);
            ObjectOutputStream salida = new ObjectOutputStream(destino);
            salida.writeObject(miAlmacen);
            salida.writeObject(miAlmacenClientes);
            salida.writeObject(miAlmacenUsuarios);
            salida.writeObject(miAlmacenFichas);
            salida.close();
            destino.close();
        }catch(IOException ioe) {
            ioe.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * Método getter que devuelve el almacen de electrodomesticos.
     *
     * @return    miAlmacen
     */
    public AlmacenElectrod getAlmacenElectrod(){
        return this.miAlmacen;
    }
    
    /**
     * Método getter que devuelve el almacen de clientes.
     *
     * @return    miAlmacenClientes
     */
    public AlmacenClientes getAlmacenClientes(){
        return this.miAlmacenClientes;
    }
    
    /**
     * Método getter que devuelve el almacen de usuarios.
     *
     * @return    miAlmacenUsuarios
     */
    public AlmacenUsuarios getAlmacenUsuarios(){
        return this.miAlmacenUsuarios;
    }
    
    /**
     * Método getter que devuelve el almacen de fichas.
     *
     * @return    miAlmacenFichas
     */
    public AlmacenFichas getAlmacenFichas(){
        return this.miAlmacenFichas;
    }
}
