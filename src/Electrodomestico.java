
/**
 * Esta clase representa un objeto estándar válido para todos los
 * electrodomesticos. Por tanto, es una superclase.
 * Se utiliza para generar los campos estándares para todas las 
 * clases que heredan de esta superclase.
 *
 * @author Ubikitina
 * @version 10-abr-2018
 */
public abstract class Electrodomestico implements java.io.Serializable
{
    private String numeroSerie;
    private String marca;
    private String modelo;
    private String color;
    private double precio; 
    private String tipoElec; 
    private int stock;

    /**
     * Constructor para objetos de la clase Electrodomestico.
     * Los inicializa con campos vacíos.
     */
    public Electrodomestico()
    {
        this.numeroSerie = "";
        this.marca = "";
        this.modelo = "";
        this.color = "";
        this.precio = 0.00;
        this.tipoElec = "";
        this.stock = 0;
    }
    
    /**
     * Constructor para objetos de la clase Electrodomestico.
     * Se encarga de pasar a la clase lo que recibe como parámetro.
     */
    public Electrodomestico(String numeroSerie, String marca, String modelo,
                            String color, double precio, String tipoElec, int stock)
    {
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.tipoElec = tipoElec;
        this.stock = stock;
    }


    /**
     * Método getter que devuelve el numeroSerie
     *
     * @return    numeroSerie
     */
    public String getNumeroSerie()
    {
        return this.numeroSerie;
    }
    
    /**
     * Método setter que establece el numeroSerie
     *
     * @param    newNumeroSerie
     */
    public void setNumeroSerie(String newNumeroSerie)
    {
        this.numeroSerie = newNumeroSerie;
    }
    
    /**
     * Método getter que devuelve la marca
     *
     * @return    marca
     */
    public String getMarca()
    {
        return this.marca;
    }
    
    /**
     * Método setter que establece la marca
     *
     * @param    newMarca
     */
    public void setMarca(String newMarca)
    {
        this.marca = newMarca;
    }
    
    /**
     * Método getter que devuelve el modelo
     *
     * @return    modelo
     */
    public String getModelo()
    {
        return this.modelo;
    }
    
    /**
     * Método setter que establece el modelo
     *
     * @param    newModelo
     */
    public void setModelo(String newModelo)
    {
        this.modelo = newModelo;
    }
    
    /**
     * Método getter que devuelve el color
     *
     * @return    color
     */
    public String getColor()
    {
        return this.color;
    }
    
    /**
     * Método setter que establece el color
     *
     * @param    newColor
     */
    public void setColor(String newColor)
    {
        this.color = newColor;
    }
    
    /**
     * Método getter que devuelve el precio
     *
     * @return    precio
     */
    public double getPrecio()
    {
        return this.precio;
    }
    
    /**
     * Método setter que establece el precio
     *
     * @param    newPrecio
     */
    public void setPrecio(double newPrecio)
    {
        this.precio = newPrecio;
    }
    
    /**
     * Método getter que devuelve el tipoElec
     *
     * @return    tipoElec
     */
    public String getTipoElec()
    {
        return this.tipoElec;
    }
    
    /**
     * Método setter que establece el tipoElec
     *
     * @param    tipoElec
     */
    public void setTipoElec(String newTipoElec)
    {
        this.tipoElec = newTipoElec;
    }
    
    /**
     * Método getter que devuelve el stock
     
     * @return    stock
     */
    public int getStock()
    {
        return this.stock;
    }
    
    /**
     * Método setter que establece el stock
     *
     * @param    stock
     */
    public void setStock(int newStock)
    {
        this.stock = newStock;
    }
    
    /**
     * Método que descuenta el stock en una unidad.
     */
    public void descuentaUnaUdStock(){
        this.stock--;
    }
    
    /**
     * Método que incrementa el stock en una unidad.
     */
    public void incrementaUnaUdStock(){
        this.stock++;
    }
    
    /**
     * Método que muestra la información de un electrodomestico en pantalla
     */
    public void generateInfo()
    {     
        System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
        System.out.println("Electrodomestico tipo: " + this.tipoElec + " con numero de serie: " + this.numeroSerie);
        System.out.println("Marca y modelo: " + this.marca + " - " + this.modelo);
        System.out.println("Color: " + this.color + " - Precio: " + this.precio + " €");
        System.out.println("STOCK = " + this.stock);
    }
}
