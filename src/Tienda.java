
/**
 * Esta clase es la clase exigida en el enunciado de la práctica.
 * Contiene el método main.
 *
 * @author Ubikitina
 * @version 27-may-2018
 */

public class Tienda
{
    /**
     * Constructor for objects of class Tienda
     */
    public Tienda()
    {
        
    }

    /**
     * Método main
     */
    public static void main(String[] args)
    {
        SerializarDatos d = new SerializarDatos();
        
        d.importarDatos();
        
        AlmacenElectrod miAlmacen = d.getAlmacenElectrod();
        AlmacenClientes miAlmacenClientes = d.getAlmacenClientes();
        AlmacenUsuarios miAlmacenUsuarios = d.getAlmacenUsuarios();
        AlmacenFichas miAlmacenFichas = d.getAlmacenFichas();
        
        InterfazDeTexto miInterfaz = new InterfazDeTexto(miAlmacen, miAlmacenClientes, miAlmacenUsuarios, miAlmacenFichas);
        miInterfaz.menuPrincipal();
        
        d.exportarDatos();
    }
}
