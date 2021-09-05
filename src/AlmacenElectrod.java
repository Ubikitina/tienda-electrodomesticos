import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
/**
 * Esta clase representa un objeto para almacenar los electrodomesticos.
 * Dentro de la clase se encuentran los campos específicos de almacén
 * (principalmente el HashMap para almacenar) y los métodos específicos
 * para gestioanar este almacén.
 *
 * @author Ubikitina
 * @version 14-abr-2018
 */
public class AlmacenElectrod implements java.io.Serializable
{
    private HashMap <String, Electrodomestico> elecHM;
    private int contador;

    /**
     * Constructor para objetos de la clase AlmacenElectrod
     */
    public AlmacenElectrod()
    {
        elecHM = new HashMap<String, Electrodomestico>();
        contador = 0;
    }
    
    /**
     * Metodo para editar la lista de electrodomesticos
     */
    public void editarElec(Electrodomestico elec1){
        if ((elecHM.containsKey(elec1.getNumeroSerie())) == true){
            elecHM.put(elec1.getNumeroSerie(), elec1);
        }
    }
    
    /**
     * Metodo que elimina un electrodomestico, pasandole el numero de serie.
     */
    public void borrarElec (String numeroSerie)
    {
        elecHM.remove(numeroSerie);
    }
    
    /**
     * Método para hacer búsquedas dentro de una lista de electrodomesticos. Busca por número de serie.
     * 
     * @return Electrodomestico
     */
    public Electrodomestico busquedaPorNumSerie(String numeroSerie){
        return elecHM.get(numeroSerie);
    }
    
    /**
     * Método para imprimir toda la lista de electrodomesticos y sus datos.
     */
    public void imprimirAlmacen() {
        Set <String> setDeNombres = new HashSet<String>();
             
        setDeNombres = elecHM.keySet();
                
        for(Iterator<String> it = setDeNombres.iterator(); it.hasNext(); ) { 
            elecHM.get(it.next()).generateInfo(); //asi consigo sacar info tipo electrodomestico todos los objetos, pero no consigo sacar la referencia
            System.out.println();
        }
    } 
    
    /**
     * Método para imprimir un único electrodomestico, introduciendo su referencia.
     */
    public void imprimirUnElec(String referencia){
        busquedaPorNumSerie(referencia).generateInfo();
    }
    
    /**
     * Método para añadir un electrodomestico del tipo TelefonoDomestico y sus datos.
     */
    public void addTelefonoDomestico(int unidades, int horasAutonomia, boolean tieneManosLibres, String numeroSerie, String marca, String modelo, String color, double precio, int stock) {
        Electrodomestico telefonoDomestico = new TelefonoDomestico(unidades, horasAutonomia, tieneManosLibres, numeroSerie, marca, modelo, color, precio, stock);
        elecHM.put(telefonoDomestico.getNumeroSerie(), telefonoDomestico);
        contador++;
    }
    
    /**
     * Método para añadir un electrodomestico del tipo SmartPhone y sus datos.
     */
    public void addSmartPhone(boolean tiene4G, int horasAutonomia, boolean tieneManosLibres, String numeroSerie, String marca, String modelo, String color, double precio, int stock) {
        Electrodomestico smartPhone = new SmartPhone(tiene4G, horasAutonomia, tieneManosLibres, numeroSerie, marca, modelo, color, precio, stock);
        elecHM.put(smartPhone.getNumeroSerie(), smartPhone);
        contador++;
    }
    
    /**
     * Método para añadir un electrodomestico del tipo PCSobremesa y sus datos.
     */
    public void addPCSobremesa(boolean incluyeTeclado, int capacidadDisco, String tipoDisco, String numeroSerie, String marca, String modelo, String color, double precio, int stock) {
        Electrodomestico pcSobremesa = new PCSobremesa(incluyeTeclado, capacidadDisco, tipoDisco, numeroSerie, marca, modelo, color, precio, stock);
        elecHM.put(pcSobremesa.getNumeroSerie(), pcSobremesa);
        contador++;
    }
    
    /**
     * Método para añadir un electrodomestico del tipo Portatil y sus datos.
     */
    public void addPortatil(int horasAutonomia, int capacidadDisco, String tipoDisco, String numeroSerie, String marca, String modelo, String color, double precio, int stock) {
        Electrodomestico portatil = new Portatil(horasAutonomia, capacidadDisco, tipoDisco, numeroSerie, marca, modelo, color, precio, stock);
        elecHM.put(portatil.getNumeroSerie(), portatil);
        contador++;
    }
    
    /**
     * Método para añadir un electrodomestico del tipo Frigorifico y sus datos.
     */
    public void addFrigorifico(boolean incluyeBotellero, boolean controlRemoto, boolean programable, String numeroSerie, String marca, String modelo, String color, double precio, int stock) {
        Electrodomestico frigorifico = new Frigorifico(incluyeBotellero, controlRemoto, programable, numeroSerie, marca, modelo, color, precio, stock);
        elecHM.put(frigorifico.getNumeroSerie(), frigorifico);
        contador++;
    }
    
    /**
     * Método para añadir un electrodomestico del tipo Lavavajillas y sus datos.
     */
    public void addLavavajillas(int consumoAnualAgua, boolean controlRemoto, boolean programable, String numeroSerie, String marca, String modelo, String color, double precio, int stock) {
        Electrodomestico lavavajillas = new Lavavajillas(consumoAnualAgua, controlRemoto, programable, numeroSerie, marca, modelo, color, precio, stock);
        elecHM.put(lavavajillas.getNumeroSerie(), lavavajillas);
        contador++;
    }
    
    /**
     * Método para añadir un electrodomestico del tipo BarraDeSonido y sus datos.
     */
    public void addBarraDeSonido(String tipoConexion, int numAltavoces, boolean radio, String numeroSerie, String marca, String modelo, String color, double precio, int stock) {
        Electrodomestico barraDeSonido = new BarraDeSonido(tipoConexion, numAltavoces, radio, numeroSerie, marca, modelo, color, precio, stock);
        elecHM.put(barraDeSonido.getNumeroSerie(), barraDeSonido);
        contador++;
    }
    
    /**
     * Método para añadir un electrodomestico del tipo Minicadena y sus datos.
     */
    public void addMinicadena(boolean grabaVoz, int numAltavoces, boolean radio, String numeroSerie, String marca, String modelo, String color, double precio, int stock) {
        Electrodomestico minicadena = new Minicadena(grabaVoz, numAltavoces, radio, numeroSerie, marca, modelo, color, precio, stock);
        elecHM.put(minicadena.getNumeroSerie(), minicadena);
        contador++;
    }
    
    /**
     * Método para añadir un electrodomestico del tipo Proyector y sus datos.
     */
    public void addProyector(double distanciaProyeccion, int pulgadas, boolean tiene3D, String numeroSerie, String marca, String modelo, String color, double precio, int stock) {
        Electrodomestico proyector = new Proyector(distanciaProyeccion, pulgadas, tiene3D, numeroSerie, marca, modelo, color, precio, stock);
        elecHM.put(proyector.getNumeroSerie(), proyector);
        contador++;
    }
    
    /**
     * Método para añadir un electrodomestico del tipo Televisor y sus datos.
     */
    public void addTelevisor(boolean smartTV, int pulgadas, boolean tiene3D, String numeroSerie, String marca, String modelo, String color, double precio, int stock) {
        Electrodomestico televisor = new Televisor(smartTV, pulgadas, tiene3D, numeroSerie, marca, modelo, color, precio, stock);
        elecHM.put(televisor.getNumeroSerie(), televisor);
        contador++;
    }

    /**
     * Método para editar un atributo de un electrodomestico dentro del HashMap.
     */
    public void editarAtributo(String referencia, String nuevoValor, String atributo){
        if (atributo.equals("marca")){
            busquedaPorNumSerie(referencia).setMarca(nuevoValor);
        }else if (atributo.equals("modelo")){
            busquedaPorNumSerie(referencia).setModelo(nuevoValor);
        }else if (atributo.equals("color")){
            busquedaPorNumSerie(referencia).setColor(nuevoValor);
        }else if (atributo.equals("precio")){
            double nuevoPrecio = Double.parseDouble(nuevoValor);
            busquedaPorNumSerie(referencia).setPrecio(nuevoPrecio);
        }else if (atributo.equals("stock")){
            int nuevoStock = Integer.parseInt(nuevoValor);
            busquedaPorNumSerie(referencia).setStock(nuevoStock);
        }else if (atributo.equals("pulgadas")){
            int nuevasPulgadas = Integer.parseInt(nuevoValor);
            ((Imagen)busquedaPorNumSerie(referencia)).setPulgadas(nuevasPulgadas);
        }else if (atributo.equals("3D")){
            boolean nuevoTiene3D = Boolean.parseBoolean(nuevoValor);
            ((Imagen)busquedaPorNumSerie(referencia)).setTiene3D(nuevoTiene3D);
        }else if (atributo.equals("smartTV")){
            boolean nuevoTieneSmartTV = Boolean.parseBoolean(nuevoValor);
            ((Televisor)busquedaPorNumSerie(referencia)).setTieneSmartTV(nuevoTieneSmartTV);
        }else if (atributo.equals("distanciaProyeccion")){
            double nuevaDistancia = Double.parseDouble(nuevoValor);
            ((Proyector)busquedaPorNumSerie(referencia)).setDistanciaProyeccion(nuevaDistancia);
        }else if (atributo.equals("numAltavoces")){
            int nuevoNumAltavoces = Integer.parseInt(nuevoValor);
            ((Sonido)busquedaPorNumSerie(referencia)).setNumAltavoces(nuevoNumAltavoces);
        }else if (atributo.equals("radio")){
            boolean nuevoTieneRadio = Boolean.parseBoolean(nuevoValor);
            ((Sonido)busquedaPorNumSerie(referencia)).setRadio(nuevoTieneRadio);
        }else if (atributo.equals("grabaVoz")){
            boolean nuevoGrabaVoz = Boolean.parseBoolean(nuevoValor);
            ((Minicadena)busquedaPorNumSerie(referencia)).setGrabaVoz(nuevoGrabaVoz);
        }else if (atributo.equals("tipoConexion")){
            ((BarraDeSonido)busquedaPorNumSerie(referencia)).setTipoConexion(nuevoValor);
        }else if (atributo.equals("controlRemoto")){
            boolean nuevoTieneRemoto = Boolean.parseBoolean(nuevoValor);
            ((Hogar)busquedaPorNumSerie(referencia)).setControlRemoto(nuevoTieneRemoto);
        }else if (atributo.equals("programable")){
            boolean nuevoEsProgramable = Boolean.parseBoolean(nuevoValor);
            ((Hogar)busquedaPorNumSerie(referencia)).setProgramable(nuevoEsProgramable);
        }else if (atributo.equals("consumoAnualAgua")){
            int nuevoConsumo = Integer.parseInt(nuevoValor);
            ((Lavavajillas)busquedaPorNumSerie(referencia)).setConsumoAnualAgua(nuevoConsumo);
        }else if (atributo.equals("incluyeBotellero")){
            boolean nuevoIncluyeBot = Boolean.parseBoolean(nuevoValor);
            ((Frigorifico)busquedaPorNumSerie(referencia)).setIncluyeBotellero(nuevoIncluyeBot);
        }else if (atributo.equals("capacidadDisco")){
            int nuevaCapacidad = Integer.parseInt(nuevoValor);
            ((Informatica)busquedaPorNumSerie(referencia)).setCapacidadDisco(nuevaCapacidad);
        }else if (atributo.equals("tipoDisco")){
            ((Informatica)busquedaPorNumSerie(referencia)).setTipoDisco(nuevoValor);
        }else if (atributo.equals("horasAutonomiaPortatil")){
            int nuevasHoras = Integer.parseInt(nuevoValor);
            ((Portatil)busquedaPorNumSerie(referencia)).setHorasAutonomia(nuevasHoras);
        }else if (atributo.equals("incluyeTeclado")){
            boolean nuevoIncluyeTeclado = Boolean.parseBoolean(nuevoValor);
            ((PCSobremesa)busquedaPorNumSerie(referencia)).setIncluyeTeclado(nuevoIncluyeTeclado);
        }else if (atributo.equals("horasAutonomiaTelefonia")){
            int nuevasHoras = Integer.parseInt(nuevoValor);
            ((Telefonia)busquedaPorNumSerie(referencia)).setHorasAutonomia(nuevasHoras);
        }else if (atributo.equals("manosLibres")){
            boolean nuevoTieneManos = Boolean.parseBoolean(nuevoValor);
            ((Telefonia)busquedaPorNumSerie(referencia)).setTieneManosLibres(nuevoTieneManos);
        }else if (atributo.equals("4G")){
            boolean nuevoTiene4G = Boolean.parseBoolean(nuevoValor);
            ((SmartPhone)busquedaPorNumSerie(referencia)).setTiene4G(nuevoTiene4G);
        }else if (atributo.equals("unidades")){
            int nuevasUnidades = Integer.parseInt(nuevoValor);
            ((TelefonoDomestico)busquedaPorNumSerie(referencia)).setUnidades(nuevasUnidades);
        }
    }
    
    /**
     * Método que devuelve el tipo de electrodomestico en un string.
     */
    public String tipoElecEnHM(String refIntroducido){
        return busquedaPorNumSerie(refIntroducido).getTipoElec();
    }
    
    /**
     * Método que devuelve el stock de un electrodomestico en concreto.
     */
    public int stockElecEnHM(String refIntroducido){
        return busquedaPorNumSerie(refIntroducido).getStock();
    }
    
    /**
     * Método que devuelve el precio de un electrodomestico en concreto.
     */
    public double precioElecEnHM(String refIntroducido){
        return busquedaPorNumSerie(refIntroducido).getPrecio();
    }
    
    /**
     * Método que descuenta una unidad de stock de un electrodomestico dentro del HashMap.
     */
    public void descuentaStockElecEnHM(String refIntroducido){
        busquedaPorNumSerie(refIntroducido).descuentaUnaUdStock();
    }
    
    /**
     * Método que incrementa una unidad de stock de un electrodomestico dentro del HashMap.
     */
    public void incrementaStockElecEnHM(String refIntroducido){
        busquedaPorNumSerie(refIntroducido).incrementaUnaUdStock();
    }
    
    /**
     * Método para saber si existe electrodomestico.
     */
    public boolean elecPreviamenteCreado(String numSerie){
        return elecHM.containsKey(numSerie);
    }
}
