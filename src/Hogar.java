/**
 * Esta clase representa un objeto para los electrodomesticos que
 * son tipo hogar. Hereda de la clase Electrodomestico, por tanto,
 * es una subclase. Dentro de la clase se encuentran los campos específicos
 * correspondientes a un electrodoméstico del tipo Hogar.
 *
 * @author Ubikitina
 * @version 11-abr-2018
 */
public abstract class Hogar extends Electrodomestico implements java.io.Serializable
{
    private boolean controlRemoto;
    private boolean programable;

    /**
     * Constructor para objetos de la clase Hogar.
     * Los inicializa con campos vacíos.
     */
    public Hogar()
    {
        super();
        this.controlRemoto = false;
        this.programable = false;
    }
    
    /**
     * Constructor para objetos de la clase Hogar.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
    public Hogar(boolean controlRemoto, boolean programable, String numeroSerie, String marca, String modelo,
                  String color, double precio, String tipo, int stock)
    {
        super(numeroSerie, marca, modelo,color, precio, tipo, stock);
        this.controlRemoto = controlRemoto;
        this.programable = programable;
    }
    
    /**
     * Método getter que devuelve controlRemoto.
     *
     * @return    controlRemoto
     */
    public boolean getControlRemoto()
    {
        return this.controlRemoto;
    }
    
    /**
     * Método setter que establece controlRemoto.
     *
     * @param    newControlRemoto
     */
    public void setControlRemoto(boolean newControlRemoto)
    {
        this.controlRemoto = newControlRemoto;
    }
    
    /**
     * Método getter que devuelve programable.
     *
     * @return    programable
     */
    public boolean getProgramable()
    {
        return this.programable;
    }
    
    /**
     * Método setter que establece programable.
     *
     * @param    newProgramable
     */
    public void setProgramable(boolean newProgramable)
    {
        this.programable = newProgramable;
    }
    
    /**
     * Método que muestra la información de un electrodomestico tipo Hogar en pantalla
     */
    @Override
    public void generateInfo()
    {
        super.generateInfo();
        System.out.println("Características técnicas: Control remoto: " + this.controlRemoto + " y Programable: " + this.programable);
    }
}
