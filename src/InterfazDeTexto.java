import java.util.*;
/**
 * Esta clase representa la consola de interacción con usuario.
 * Dentro de la clase está toda la interfaz textual para la interacción
 * con el usuario.
 *
 * @author Ubikitina
 * @version 11-jul-2018
 */

public class InterfazDeTexto
{
    //Variables internas de la clase InterfazDeTexto
    private static Scanner entrada = new Scanner(System.in);

    AlmacenElectrod miAlmacen;
    AlmacenClientes miAlmacenClientes;
    AlmacenUsuarios miAlmacenUsuarios;
    AlmacenFichas miAlmacenFichas;
    
    private String usuarioActual;
    
    /**
     * Constructor for objects of class Consola
     */
    public InterfazDeTexto(AlmacenElectrod miAlmacen, AlmacenClientes miAlmacenClientes, AlmacenUsuarios miAlmacenUsuarios, AlmacenFichas miAlmacenFichas)
    {
        this.miAlmacen = miAlmacen;
        this.miAlmacenClientes = miAlmacenClientes;
        this.miAlmacenUsuarios = miAlmacenUsuarios;
        this.miAlmacenFichas = miAlmacenFichas;
    }

    /**
     * Menú principal. Este menú principal da la opción de generar el perfil de administrador sino hay usuarios dados de alta.
     * Si existen usuarios previamente dados de alta, la única opción que da es la del inicio de sesión.
     */
    public void menuPrincipal()
    {
        System.out.println("===== MENÚ PRINCIPAL =====");
        int numUsuarios = miAlmacenUsuarios.getNumEmpleados();
        
        if(numUsuarios == 0){
            System.out.println("Bienvenido al programa. Como es la primera vez que accede, por favor, cree un usuario JEFE-ADMINISTRADOR.");
            
            System.out.println("Introduzca los datos del empleado:");
            System.out.println("Introduzca el DNI:");
            String dni = entrada.nextLine();
            System.out.println("Introduzca el nombre:");
            String nombre = entrada.nextLine();
            System.out.println("Introduzca los apellidos:");
            String apellidos = entrada.nextLine();
            System.out.println("Introduzca la contraseña:");
            String contrasena = entrada.nextLine();
            
            miAlmacenUsuarios.addAdmin(dni, nombre, apellidos, contrasena);
                        
            iniciarSesion();
        }else{
            iniciarSesion();
        }
    }
    
    /**
     * Método de inicio de sesión. Incluye un lavado de la información de pantalla mediante la impresión de \u000C. De este modo, un nuevo usuario, al iniciar sesión,
     * no verá la información que ha introducido el usuario anterior.
     */
    private void iniciarSesion(){
        int seleccion;
        do{
            System.out.print("\u000C");
            System.out.println("Bienvenido al Sistema Integrado de Gestión de la Tienda de Electrodomésticos.");
            System.out.println("Seleccione la opción deseada:");
            System.out.println("   1. Iniciar sesión");
            System.out.println("   2. Salir del programa");

            seleccion = entrada.nextInt();
            
            switch(seleccion){
                case 1: 
                    System.out.println("Por favor, inicie sesión.");
                    System.out.println();
                    String dniIntroducido;
                    
                    System.out.println("DNI de usuario:");
                    entrada.nextLine();
                    dniIntroducido = entrada.nextLine();
                    if(!miAlmacenUsuarios.usuarioPreviamenteCreado(dniIntroducido)){
                        System.out.println("DNI de usuario incorrecto. Vuelva a intentarlo.");
                    }else{
                        System.out.println("Contraseña:");
                        String passwordIntroducido = entrada.nextLine();
                        System.out.print("\u000C");
                        if(miAlmacenUsuarios.esPasswordCorrecto(dniIntroducido, passwordIntroducido)){
                            usuarioActual = dniIntroducido;
                            
                            String tipoEmpleado = miAlmacenUsuarios.getTipoEmpleado(usuarioActual);
                    
                            switch (tipoEmpleado){
                                case "jefe": menuAdmin(); break;
                                case "cajero": menuCajero(); break;
                                case "tecnico": menuTecnico(); break;
                                case "financiacion": System.out.println("Esta opción está pendiente de desarrollar."); break; //pendiente de desarrollar
                                case "comercial": System.out.println("Esta opción está pendiente de desarrollar."); break;
                                case "postventa": menuPostventa(); break;
                                case "error": System.out.println("El usuario introducido es incorrecto."); break;
                                default: System.out.println("No existe el usuario introducido. Vuelva a intentarlo."); break;
                            }
                        }else{
                            System.out.println("Contraseña incorrecta. Vuelva a intentarlo.");
                        }
                    }
                    break;
                case 2: System.out.println("¡Hasta la próxima!"); break;
                default: System.out.println("Opción incorrecta. Intente de nuevo."); break;
            }
        
        }while(seleccion != 2);
    }
    
    /**
     * MENÚ PRINCIPAL PARA EL PERFIL JEFE-ADMINISTRADOR.
     * Menú del perfil Jefe-Administrador. Si el usuario que se ha loggeado es un jefe, directamente, saltará este menú.
     */
    private void menuAdmin(){
        int seleccion;
        
        do{
        
            System.out.println("Se encuentra dentro del menú de JEFE-ADMINISTRADOR.");
            System.out.println("Seleccione la opción deseada:");
            System.out.println("   1. Gestión de usuarios");
            System.out.println("   2. Gestión de electrodomesticos");
            System.out.println("   3. Cambiar de usuario/Salir");
            
            seleccion = entrada.nextInt();
            
            switch (seleccion){
                case 1: menuGestionUsuarios(); break;
                case 2: menuGestionElectrodomesticos(); break;
                case 3: break;
                default: System.out.println("Selección incorrecta. Vuelva a intentarlo."); break;
            }
        }while(seleccion != 3);
    }
    
    /**
     * Menú asociado con las tareas del usuario jefe-administrador. Este menú posibilita añadir, editar, borrar, consultar o buscar los usuarios.
     */
    private void menuGestionUsuarios(){
        int seleccion_menu_usuarios;
        String entrada_menu;
        
        do{
            System.out.println("Se encuentra dentro del menú de GESTIÓN DE USUARIOS.");
            System.out.println("Seleccione la opción deseada:");
            System.out.println("   1. Dar de alta a un nuevo usuario");
            System.out.println("   2. Editar la información de un usuario");
            System.out.println("   3. Borrar los datos de un usuario");
            System.out.println("   4. Ver todos los usuarios");
            System.out.println("   5. Buscar un usuario");
            System.out.println("   6. Salir");
            
            seleccion_menu_usuarios = entrada.nextInt();
                  
            switch(seleccion_menu_usuarios){
                case 1: crearUsuario(); break;
                case 2: editarUsuario(); break;
                case 3:
                    System.out.println("Introduzca el DNI del usuario que desea borrar:");
                    entrada.nextLine();
                    entrada_menu = entrada.nextLine();
                    miAlmacenUsuarios.borrarEmpleado(entrada_menu);
                    break;
                case 4: miAlmacenUsuarios.imprimirListaUsuarios(); break;
                case 5:
                    String dniIntroducido;
                    System.out.println("Introduzca el DNI del cliente que desea visualizar:");
                    entrada.nextLine();
                    dniIntroducido = entrada.nextLine();
                    miAlmacenUsuarios.imprimirUnUsuario(dniIntroducido);
                    break;
                case 6: System.out.println("Ha seleccionado salir del menú de GESTIÓN DE USUARIOS. ¡Hasta la próxima!"); break;
                default: System.out.println("La opción no es correcta. Seleccione entre 1, 2, 3, 4, 5 o 6."); break;
            }
        }while(seleccion_menu_usuarios != 6);
        
    }
    
    /**
     * Método para dar añadir un usuario. Solicita y recoge la información en pantalla.
     */
    private void crearUsuario(){
        String dni;
        String nombre;
        String apellidos;
        String contrasena;
        int tipoEmpleado;
        
        System.out.println("Ha seleccionado crear un nuevo usuario.");
        
        do{
            System.out.println("Seleccione el tipo de empleado que desea añadir:");
            System.out.println("   1. Técnico");
            System.out.println("   2. Cajero");
            System.out.println("   3. Financiación");
            System.out.println("   4. Postventa");
            System.out.println("   5. Comercial");
            System.out.println("   6. Jefe-Administrador");
            tipoEmpleado = entrada.nextInt();
            if(tipoEmpleado < 1 || tipoEmpleado >= 7){
                System.out.println("Opción incorrecta, vuelva a intentarlo.");
            }
        }while(tipoEmpleado < 1 || tipoEmpleado >= 7);
            
        System.out.println("Introduzca los datos del empleado:");
        System.out.println("Introduzca el DNI:");
        entrada.nextLine();
        dni = entrada.nextLine();
        System.out.println("Introduzca el nombre:");
        nombre = entrada.nextLine();
        System.out.println("Introduzca los apellidos:");
        apellidos = entrada.nextLine();
        System.out.println("Introduzca la contraseña:");
        contrasena = entrada.nextLine();
        
        switch(tipoEmpleado){
            case 1: miAlmacenUsuarios.addTecnico(dni, nombre, apellidos, contrasena); break;
            case 2: miAlmacenUsuarios.addCajero(dni, nombre, apellidos, contrasena); break;
            case 3: miAlmacenUsuarios.addFinanciacion(dni, nombre, apellidos, contrasena); break;
            case 4: miAlmacenUsuarios.addPostventa(dni, nombre, apellidos, contrasena); break;
            case 5: miAlmacenUsuarios.addComercial(dni, nombre, apellidos, contrasena); break;
            case 6: miAlmacenUsuarios.addAdmin(dni, nombre, apellidos, contrasena); break;
        }
        
    }
    
    /**
     * Método para editar un usuario. Interactua con la entrada de datos en pantalla.
     */
    private void editarUsuario(){
        String dniIntroducido;
        int seleccionIntroducida;
        
        System.out.println("Introduzca el DNI del usuario que desea editar:");
        entrada.nextLine();
        dniIntroducido = entrada.nextLine();
        
        if(miAlmacenUsuarios.usuarioPreviamenteCreado(dniIntroducido)) {
            System.out.println("Los datos del usuario son:");
            miAlmacenUsuarios.imprimirUnUsuario(dniIntroducido);
            System.out.println("");
            
            System.out.println("Seleccione el campo que desea editar:");
            System.out.println("   1. Nombre");
            System.out.println("   2. Apellidos");
            System.out.println("   3. Contraseña");
            System.out.println("   4. Si está activo");
            //Suponemos que el DNI no se puede cambiar
            seleccionIntroducida = entrada.nextInt();
            
            String atributo = "";
            switch (seleccionIntroducida){ //se puede plantear esta versión reducida de editar cliente para los electrodomesticos
                case 1: atributo = "nombre"; break;
                case 2: atributo = "apellidos"; break;
                case 3: atributo = "contrasena"; break;
                case 4: atributo = "estaActivo"; break;
                default: System.out.println("No se ha encontrado la selección. Vuelva a intentarlo."); break;
            }
            
            System.out.println("Introduzca el nuevo valor de " + atributo + ":");
            entrada.nextLine();
            String nuevoValor = entrada.nextLine();
            miAlmacenUsuarios.editarAtributo(dniIntroducido, nuevoValor, atributo);
        }else{
            System.out.println("El usuario introducido no existe. Por favor, revise los datos.");
        }
    }
    
    /**
     * Menú asociado con las tareas del jefe-administrador. Este menú posibilita añadir, editar, borrar, buscar los electrodomesticos o consultar el inventario.
     */
    private void menuGestionElectrodomesticos(){
        int seleccion_menu;
        String entrada_usuario;
        
        do{
            System.out.println("Se encuentra dentro del menú de GESTIÓN DE ELECTRODOMÉSTICOS.");
            System.out.println("Seleccione la opción deseada:");
            System.out.println("   1. Añadir un electrodoméstico");
            System.out.println("   2. Editar un electrodoméstico");
            System.out.println("   3. Borrar un electrodoméstico");
            System.out.println("   4. Ver todos los electrodomesticos (Inventario)");
            System.out.println("   5. Buscar un electrodoméstico");
            System.out.println("   6. Salir");
            
            seleccion_menu = entrada.nextInt();
                  
            switch(seleccion_menu){
                case 1: crearElectrodomestico(); break;
                case 2: editarElectrodomestico(); break;
                case 3:
                    System.out.println("Introduzca el número de serie del electrodomestico que desea borrar:");
                    entrada.nextLine();
                    entrada_usuario = entrada.nextLine();
                    miAlmacen.borrarElec(entrada_usuario);
                    break;
                case 4: miAlmacen.imprimirAlmacen(); break;
                case 5:
                    String refIntroducido;
                    
                    System.out.println("Introduzca el nº de serie del electrodomestico que desea visualizar:");
                    entrada.nextLine();
                    refIntroducido = entrada.nextLine();
                    
                    if((miAlmacen.busquedaPorNumSerie(refIntroducido)) != null){
                        miAlmacen.imprimirUnElec(refIntroducido);
                    }else{
                        System.out.println("No se ha encontrado ningún electrodomestico que corresponda al nº de serie introducido.");
                    }
                    break;
                case 6:
                    System.out.println("Ha seleccionado salir del menú de GESTIÓN DE ELECTRODOMÉSTICOS. ¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("La opción no es correcta. Seleccione entre 1, 2, 3, 4, 5 o 6.");
                    break;
            }
        }while(seleccion_menu != 6);
        
    }
    
    /**
     * Método para dar de alta a un electrodoméstico. Solicita la información al usuario, y recoge las entradas en pantalla para crear un nuevo electrodoméstico.
     */
    private void crearElectrodomestico(){
        
        int seleccion_tipo;
        int seleccion_elec;
        
        //campos genericos de electrodomesticos
        String numeroSerie;
        String marca;
        String modelo;
        String color;
        double precio;
        int stock;
           
                
        do{
            System.out.println();
            System.out.println("Seleccione el tipo de electrodoméstico deseado:");
            System.out.println("   1. Imagen");
            System.out.println("   2. Sonido");
            System.out.println("   3. Hogar");
            System.out.println("   4. Informática");
            System.out.println("   5. Telefonía");
            System.out.println("Si desea cancelar la operación y volver al menú anterior, pulse 6");
        
            seleccion_tipo = entrada.nextInt();
            
            switch(seleccion_tipo){
                case 1:
                    //campos específicos de imagen
                    int pulgadas;
                    boolean tiene3D;  
                    
                    System.out.println("Ha seleccionado IMAGEN. Selecciona entre:");
                    System.out.println("   1. Televisor");
                    System.out.println("   2. Proyector");
                    seleccion_elec = entrada.nextInt();
                    
                    switch(seleccion_elec){
                        case 1:
                            boolean smartTV; //solo para Televisor
                            System.out.println("Introduzca los datos de TELEVISOR.");
                            System.out.println("Introduzca el número de serie:");
                            entrada.nextLine();
                            numeroSerie = entrada.nextLine();
                            System.out.println("Introduzca la marca:");
                            marca = entrada.nextLine();
                            System.out.println("Introduzca el modelo:");
                            modelo = entrada.nextLine();
                            System.out.println("Introduzca el color:");
                            color = entrada.nextLine();
                            System.out.println("Introduzca el precio:");
                            precio = entrada.nextDouble();
                            System.out.println("Introduzca el número de pulgadas:");
                            pulgadas = entrada.nextInt();
                            System.out.println("Introduzca si tiene 3D (true/false):");
                            tiene3D = entrada.nextBoolean();
                            System.out.println("Introduzca si tiene smart TV (true/false):"); //específico
                            smartTV = entrada.nextBoolean();
                            System.out.println("Introduzca el stock actual:");
                            stock = entrada.nextInt();
                            miAlmacen.addTelevisor(smartTV, pulgadas, tiene3D, numeroSerie, marca, modelo, color, precio, stock);
                            break;
                        case 2:
                            double distanciaProyeccion; //solo para Proyector
                            System.out.println("Introduzca los datos de PROYECTOR");
                            System.out.println("Introduzca el número de serie:");
                            entrada.nextLine();
                            numeroSerie = entrada.nextLine();
                            System.out.println("Introduzca la marca:");
                            marca = entrada.nextLine();
                            System.out.println("Introduzca el modelo:");
                            modelo = entrada.nextLine();
                            System.out.println("Introduzca el color:");
                            color = entrada.nextLine();
                            System.out.println("Introduzca el precio:");
                            precio = entrada.nextDouble();
                            System.out.println("Introduzca el número de pulgadas:");
                            pulgadas = entrada.nextInt();
                            System.out.println("Introduzca si tiene 3D (true/false):");
                            tiene3D = entrada.nextBoolean();
                            System.out.println("Introduzca la distancia máxima de proyección en metros:"); //específico
                            distanciaProyeccion = entrada.nextDouble();
                            System.out.println("Introduzca el stock actual:");
                            stock = entrada.nextInt();
                            miAlmacen.addProyector(distanciaProyeccion, pulgadas, tiene3D, numeroSerie, marca, modelo, color, precio, stock); 
                            break;
                    }
                    
                    break;
                case 2:
                    //campos específicos de Sonido
                    int numAltavoces;
                    boolean radio;
                    
                    System.out.println("Ha seleccionado SONIDO. Selecciona entre:");
                    System.out.println("   1. Minicadena");
                    System.out.println("   2. Barra de sonido");
                    seleccion_elec = entrada.nextInt();
                    
                    switch(seleccion_elec){
                        case 1:
                            boolean grabaVoz; //solo para MiniCadena
                            System.out.println("Introduzca los datos de MINICADENA");
                            System.out.println("Introduzca el número de serie:");
                            entrada.nextLine();
                            numeroSerie = entrada.nextLine();
                            System.out.println("Introduzca la marca:");
                            marca = entrada.nextLine();
                            System.out.println("Introduzca el modelo:");
                            modelo = entrada.nextLine();
                            System.out.println("Introduzca el color:");
                            color = entrada.nextLine();
                            System.out.println("Introduzca el precio:");
                            precio = entrada.nextDouble();
                            System.out.println("Introduzca el número de altavoces:");
                            numAltavoces = entrada.nextInt();
                            System.out.println("Introduzca si tiene radio (true/false):");
                            radio = entrada.nextBoolean();
                            System.out.println("Introduzca si tiene grabadora (true/false):"); //específico
                            grabaVoz = entrada.nextBoolean();
                            System.out.println("Introduzca el stock actual:");
                            stock = entrada.nextInt();
                            miAlmacen.addMinicadena(grabaVoz, numAltavoces, radio, numeroSerie, marca, modelo, color, precio, stock);
                            break;
                        case 2:
                            String tipoConexion; //solo para BarraDeSonido
                            System.out.println("Introduzca los datos de BARRA DE SONIDO");
                            System.out.println("Introduzca el número de serie:");
                            entrada.nextLine();
                            numeroSerie = entrada.nextLine();
                            System.out.println("Introduzca la marca:");
                            marca = entrada.nextLine();
                            System.out.println("Introduzca el modelo:");
                            modelo = entrada.nextLine();
                            System.out.println("Introduzca el color:");
                            color = entrada.nextLine();
                            System.out.println("Introduzca el precio:");
                            precio = entrada.nextDouble();
                            System.out.println("Introduzca el número de altavoces:");
                            numAltavoces = entrada.nextInt();
                            System.out.println("Introduzca si tiene radio (true/false):");
                            radio = entrada.nextBoolean();
                            System.out.println("Introduzca el tipo de conexión:"); //específico
                            entrada.nextLine();
                            tipoConexion = entrada.nextLine();
                            System.out.println("Introduzca el stock actual:");
                            stock = entrada.nextInt();
                            miAlmacen.addBarraDeSonido(tipoConexion, numAltavoces, radio, numeroSerie, marca, modelo, color, precio, stock);
                            break;                                        
                    }
                    break;
                case 3:
                    //campos específicos de Hogar
                    boolean controlRemoto;
                    boolean programable;
                    
                    System.out.println("Ha seleccionado HOGAR. Selecciona entre:");
                    System.out.println("   1. Lavavajillas");
                    System.out.println("   2. Frigorifico");
                    seleccion_elec = entrada.nextInt();
                    
                    switch(seleccion_elec){
                        case 1:
                            int consumoAnualAgua; //solo para Lavavajillas
                            System.out.println("Introduzca los datos de LAVAVAJILLAS");
                            System.out.println("Introduzca el número de serie:");
                            entrada.nextLine();
                            numeroSerie = entrada.nextLine();
                            System.out.println("Introduzca la marca:");
                            marca = entrada.nextLine();
                            System.out.println("Introduzca el modelo:");
                            modelo = entrada.nextLine();
                            System.out.println("Introduzca el color:");
                            color = entrada.nextLine();
                            System.out.println("Introduzca el precio:");
                            precio = entrada.nextDouble();
                            System.out.println("Introduzca si tiene control remoto (true/false):");
                            controlRemoto = entrada.nextBoolean();
                            System.out.println("Introduzca si es programable (true/false):");
                            programable = entrada.nextBoolean();
                            System.out.println("Introduzca el consumo de agua anual en litros:"); //específico
                            consumoAnualAgua = entrada.nextInt();
                            System.out.println("Introduzca el stock actual:");
                            stock = entrada.nextInt();
                            miAlmacen.addLavavajillas(consumoAnualAgua, controlRemoto, programable, numeroSerie, marca, modelo, color, precio, stock); 
                            break;                                        
                        case 2:
                            boolean incluyeBotellero; //solo para Frigorifico
                            System.out.println("Introduzca los datos de FRIGORIFICO");
                            System.out.println("Introduzca el número de serie:");
                            entrada.nextLine();
                            numeroSerie = entrada.nextLine();
                            System.out.println("Introduzca la marca:");
                            marca = entrada.nextLine();
                            System.out.println("Introduzca el modelo:");
                            modelo = entrada.nextLine();
                            System.out.println("Introduzca el color:");
                            color = entrada.nextLine();
                            System.out.println("Introduzca el precio:");
                            precio = entrada.nextDouble();
                            System.out.println("Introduzca si tiene control remoto (true/false):");
                            controlRemoto = entrada.nextBoolean();
                            System.out.println("Introduzca si es programable (true/false):");
                            programable = entrada.nextBoolean();
                            System.out.println("Introduzca si incluye botellero (true/false):"); //específico
                            incluyeBotellero = entrada.nextBoolean();
                            System.out.println("Introduzca el stock actual:");
                            stock = entrada.nextInt();
                            miAlmacen.addFrigorifico(incluyeBotellero, controlRemoto, programable, numeroSerie, marca,  modelo, color, precio, stock);
                            break;                                       
                    }
                    break;
                case 4:
                    //campos específicos de Informática
                    int capacidadDisco;
                    String tipoDisco;
                    
                    System.out.println("Ha seleccionado INFORMÁTICA. Selecciona entre:");
                    System.out.println("   1. Portatil");
                    System.out.println("   2. PC de sobremesa");
                    seleccion_elec = entrada.nextInt();
                    
                    switch(seleccion_elec){
                        case 1:
                            int horasAutonomiaInfor; //solo para Portatil
                            System.out.println("Introduzca los datos de PORTATIL");
                            System.out.println("Introduzca el número de serie:");
                            entrada.nextLine();
                            numeroSerie = entrada.nextLine();
                            System.out.println("Introduzca la marca:");
                            marca = entrada.nextLine();
                            System.out.println("Introduzca el modelo:");
                            modelo = entrada.nextLine();
                            System.out.println("Introduzca el color:");
                            color = entrada.nextLine();
                            System.out.println("Introduzca el precio:");
                            precio = entrada.nextDouble();
                            System.out.println("Introduzca la capacidad de disco en mb:");
                            capacidadDisco = entrada.nextInt();
                            System.out.println("Introduzca el tipo de disco que contiene:");
                            entrada.nextLine();
                            tipoDisco = entrada.nextLine();
                            System.out.println("Introduzca el número de horas de autonomía:"); //específico
                            horasAutonomiaInfor = entrada.nextInt();
                            System.out.println("Introduzca el stock actual:");
                            stock = entrada.nextInt();
                            miAlmacen.addPortatil(horasAutonomiaInfor, capacidadDisco, tipoDisco, numeroSerie, marca, modelo, color, precio, stock);
                            break;                                        
                        case 2:
                            boolean incluyeTeclado; //solo para PCSobremesa
                            System.out.println("Introduzca los datos de PC SOBREMESA");
                            System.out.println("Introduzca el número de serie:");
                            entrada.nextLine();
                            numeroSerie = entrada.nextLine();
                            System.out.println("Introduzca la marca:");
                            marca = entrada.nextLine();
                            System.out.println("Introduzca el modelo:");
                            modelo = entrada.nextLine();
                            System.out.println("Introduzca el color:");
                            color = entrada.nextLine();
                            System.out.println("Introduzca el precio:");
                            precio = entrada.nextDouble();
                            System.out.println("Introduzca la capacidad de disco en mb:");
                            capacidadDisco = entrada.nextInt();
                            System.out.println("Introduzca el tipo de disco que contiene:");
                            entrada.nextLine();
                            tipoDisco = entrada.nextLine();
                            System.out.println("Introduzca si incluye teclado (true/false):"); //específico
                            incluyeTeclado = entrada.nextBoolean();
                            System.out.println("Introduzca el stock actual:");
                            stock = entrada.nextInt();
                            miAlmacen.addPCSobremesa(incluyeTeclado, capacidadDisco, tipoDisco, numeroSerie, marca, modelo, color, precio, stock); 
                            break;                                        
                    }
                    break;
                case 5:
                    //campos específicos de Telefonia
                    int horasAutonomiaTelef;
                    boolean tieneManosLibres;
                    
                    System.out.println("Ha seleccionado TELEFONÍA. Selecciona entre:");
                    System.out.println("   1. Smartphone");
                    System.out.println("   2. Teléfono domestico");
                    seleccion_elec = entrada.nextInt();
                    
                    switch(seleccion_elec){
                        case 1:
                            boolean tiene4G; //solo para SmartPhone
                            System.out.println("Introduzca los datos de SMARTPHONE");
                            System.out.println("Introduzca el número de serie:");
                            entrada.nextLine();
                            numeroSerie = entrada.nextLine();
                            System.out.println("Introduzca la marca:");
                            marca = entrada.nextLine();
                            System.out.println("Introduzca el modelo:");
                            modelo = entrada.nextLine();
                            System.out.println("Introduzca el color:");
                            color = entrada.nextLine();
                            System.out.println("Introduzca el precio:");
                            precio = entrada.nextDouble();
                            System.out.println("Introduzca el número de horas de autonomía:");
                            horasAutonomiaTelef = entrada.nextInt();
                            System.out.println("Introduzca si tiene manos libres (true/false):");
                            tieneManosLibres = entrada.nextBoolean();
                            System.out.println("Introduzca si tiene 4G (true/false):"); //específico
                            tiene4G = entrada.nextBoolean();
                            System.out.println("Introduzca el stock actual:");
                            stock = entrada.nextInt();
                            miAlmacen.addSmartPhone(tiene4G, horasAutonomiaTelef, tieneManosLibres, numeroSerie, marca, modelo, color, precio, stock); 
                            break;                                       
                        case 2:
                            int unidades; //solo para TelefonoDomestico
                            System.out.println("Introduzca los datos de TELEFONO DOMESTICO");
                            System.out.println("Introduzca el número de serie:");
                            entrada.nextLine();
                            numeroSerie = entrada.nextLine();
                            System.out.println("Introduzca la marca:");
                            marca = entrada.nextLine();
                            System.out.println("Introduzca el modelo:");
                            modelo = entrada.nextLine();
                            System.out.println("Introduzca el color:");
                            color = entrada.nextLine();
                            System.out.println("Introduzca el precio:");
                            precio = entrada.nextDouble();
                            System.out.println("Introduzca el número de horas de autonomía:");
                            horasAutonomiaTelef = entrada.nextInt();
                            System.out.println("Introduzca si tiene manos libres (true/false):");
                            tieneManosLibres = entrada.nextBoolean();
                            System.out.println("Introduzca el número de unidades de telefonos que contiene:"); //específico
                            unidades = entrada.nextInt();
                            System.out.println("Introduzca el stock actual:");
                            stock = entrada.nextInt();
                            miAlmacen.addTelefonoDomestico(unidades, horasAutonomiaTelef, tieneManosLibres, numeroSerie, marca, modelo, color, precio, stock);
                            break;                                        
                    }
                    break;
                default:
                    System.out.println("Por favor, seleccione la opción desada.");
                    break;
             }
        }while(seleccion_tipo != 6);
    }
    
    /**
     * Método para editar un electrodomestico, introduciendo el número de serie del electrodoméstico que se quiera editar.
     */
    private void editarElectrodomestico(){
        String refIntroducido;
        int seleccionIntroducida;
        
        System.out.println("Introduzca el nº de serie del electrodomestico que desea editar:");
        entrada.nextLine();
        refIntroducido = entrada.nextLine();
        
        if (miAlmacen.busquedaPorNumSerie(refIntroducido) != null){
            System.out.println("El electrodomestico introducido es:");
            miAlmacen.imprimirUnElec(refIntroducido);
        }else{
            System.out.println("La referencia es errónea. No se ha encontrado ningún resultado.");
        }
        
        
        if ((miAlmacen.tipoElecEnHM(refIntroducido)).equals("Televisor")) {
            System.out.println("\nEsta referencia corresponde a un TELEVISOR.");
            imprimirCamposElectrodomestico();
            System.out.println("   6. Número de pulgadas");
            System.out.println("   7. Si tiene 3D (true/false)");
            System.out.println("   8. Si tiene Smart TV (true/false)");
            seleccionIntroducida = entrada.nextInt();
            switch (seleccionIntroducida){
                case 1: cambiarMarcaElec(refIntroducido); break;
                case 2: cambiarModeloElec(refIntroducido); break;
                case 3: cambiarColorElec(refIntroducido); break;
                case 4: cambiarPrecioElec(refIntroducido); break;
                case 5: cambiarStockElec(refIntroducido); break;
                case 6: cambiarPulgadasImagen(refIntroducido); break;
                case 7: cambiar3DImagen(refIntroducido); break;
                case 8:
                    System.out.println("Introduzca la nueva configuración (true/false):");
                    entrada.nextLine();
                    String nuevoTieneSmartTV = entrada.nextLine();
                    miAlmacen.editarAtributo(refIntroducido, nuevoTieneSmartTV, "smartTV");
                    break;
                default: System.out.println("No se ha encontrado la selección, vuelva a intentarlo."); break;
            }
        } else if ((miAlmacen.tipoElecEnHM(refIntroducido)).equals("Proyector")){
            System.out.println("\nEsta referencia corresponde a un PROYECTOR.");
            imprimirCamposElectrodomestico();
            System.out.println("   6. Número de pulgadas");
            System.out.println("   7. Si tiene 3D (true/false)");
            System.out.println("   8. Distancia de proyección");
            seleccionIntroducida = entrada.nextInt();
            switch (seleccionIntroducida){
                case 1: cambiarMarcaElec(refIntroducido); break;
                case 2: cambiarModeloElec(refIntroducido); break;
                case 3: cambiarColorElec(refIntroducido); break;
                case 4: cambiarPrecioElec(refIntroducido); break;
                case 5: cambiarStockElec(refIntroducido); break;
                case 6: cambiarPulgadasImagen(refIntroducido); break;
                case 7: cambiar3DImagen(refIntroducido); break;
                case 8:
                    System.out.println("Introduzca la nueva distancia de proyección (m):");
                    entrada.nextLine();
                    String nuevaDistancia = entrada.nextLine();
                    miAlmacen.editarAtributo(refIntroducido, nuevaDistancia, "distanciaProyeccion");
                    break;
                default: System.out.println("No se ha encontrado la selección, vuelva a intentarlo."); break;
            }
        } else if ((miAlmacen.tipoElecEnHM(refIntroducido)).equals("Minicadena")){
            System.out.println("\nEsta referencia corresponde a una MINICADENA.");
            imprimirCamposElectrodomestico();
            System.out.println("   6. Número de altavoces");
            System.out.println("   7. Si tiene radio (true/false)");
            System.out.println("   8. Si graba voz (true/false)");
            seleccionIntroducida = entrada.nextInt();
            switch (seleccionIntroducida){
                case 1: cambiarMarcaElec(refIntroducido); break;
                case 2: cambiarModeloElec(refIntroducido); break;
                case 3: cambiarColorElec(refIntroducido); break;
                case 4: cambiarPrecioElec(refIntroducido); break;
                case 5: cambiarStockElec(refIntroducido); break;
                case 6: cambiarAltavocesSonido(refIntroducido); break;
                case 7: cambiarRadioSonido(refIntroducido); break;
                case 8:
                    System.out.println("Introduzca la nueva configuración (true/false):");
                    entrada.nextLine();
                    String nuevoGrabaVoz = entrada.nextLine();
                    miAlmacen.editarAtributo(refIntroducido, nuevoGrabaVoz, "grabaVoz");
                    break;
                default: System.out.println("No se ha encontrado la selección, vuelva a intentarlo."); break;
            }
        } else if ((miAlmacen.tipoElecEnHM(refIntroducido)).equals("BarraDeSonido")){
            System.out.println("\nEsta referencia corresponde a una BARRA DE SONIDO.");
            imprimirCamposElectrodomestico();
            System.out.println("   6. Número de altavoces");
            System.out.println("   7. Si tiene radio (true/false)");
            System.out.println("   8. Tipo de conexión");
            seleccionIntroducida = entrada.nextInt();
            switch (seleccionIntroducida){
                case 1: cambiarMarcaElec(refIntroducido); break;
                case 2: cambiarModeloElec(refIntroducido); break;
                case 3: cambiarColorElec(refIntroducido); break;
                case 4: cambiarPrecioElec(refIntroducido); break;
                case 5: cambiarStockElec(refIntroducido); break;
                case 6: cambiarAltavocesSonido(refIntroducido); break;
                case 7: cambiarRadioSonido(refIntroducido); break;
                case 8:
                    System.out.println("Introduzca el nuevo tipo de conexión:");
                    entrada.nextLine();
                    String nuevaConexion = entrada.nextLine();
                    miAlmacen.editarAtributo(refIntroducido, nuevaConexion, "tipoConexion");
                    break;
                default: System.out.println("No se ha encontrado la selección, vuelva a intentarlo."); break;
            }
        } else if ((miAlmacen.tipoElecEnHM(refIntroducido)).equals("Lavavajillas")){
            System.out.println("\nEsta referencia corresponde a un LAVAVAJILLAS.");
            imprimirCamposElectrodomestico();
            System.out.println("   6. Si tiene control remoto (true/false)");
            System.out.println("   7. Si es programable (true/false)");
            System.out.println("   8. Consumo anual de agua (L/año)");
            seleccionIntroducida = entrada.nextInt();
            switch (seleccionIntroducida){
                case 1: cambiarMarcaElec(refIntroducido); break;
                case 2: cambiarModeloElec(refIntroducido); break;
                case 3: cambiarColorElec(refIntroducido); break;
                case 4: cambiarPrecioElec(refIntroducido); break;
                case 5: cambiarStockElec(refIntroducido); break;
                case 6: cambiarRemotoHogar(refIntroducido); break;
                case 7: cambiarProgramableHogar(refIntroducido); break;
                case 8:
                    System.out.println("Introduzca el nuevo consumo (L/año):");
                    entrada.nextLine();
                    String nuevoConsumo = entrada.nextLine();
                    miAlmacen.editarAtributo(refIntroducido, nuevoConsumo, "consumoAnualAgua");
                    break;
                default: System.out.println("No se ha encontrado la selección, vuelva a intentarlo."); break;
            }
        } else if ((miAlmacen.tipoElecEnHM(refIntroducido)).equals("Frigorifico")){
            System.out.println("\nEsta referencia corresponde a un FRIGORIFICO.");
            imprimirCamposElectrodomestico();
            System.out.println("   6. Si tiene control remoto (true/false)");
            System.out.println("   7. Si es programable (true/false)");
            System.out.println("   8. Si incluye botellero (true/false)");
            seleccionIntroducida = entrada.nextInt();
            switch (seleccionIntroducida){
                case 1: cambiarMarcaElec(refIntroducido); break;
                case 2: cambiarModeloElec(refIntroducido); break;
                case 3: cambiarColorElec(refIntroducido); break;
                case 4: cambiarPrecioElec(refIntroducido); break;
                case 5: cambiarStockElec(refIntroducido); break;
                case 6: cambiarRemotoHogar(refIntroducido); break;
                case 7: cambiarProgramableHogar(refIntroducido); break;
                case 8:
                    System.out.println("Introduzca la nueva configuración (true/false):");
                    entrada.nextLine();
                    String nuevoIncluyeBot = entrada.nextLine();
                    miAlmacen.editarAtributo(refIntroducido, nuevoIncluyeBot, "incluyeBotellero");
                    break;
                default: System.out.println("No se ha encontrado la selección, vuelva a intentarlo."); break;
            }
        } else if ((miAlmacen.tipoElecEnHM(refIntroducido)).equals("Portatil")){
            System.out.println("\nEsta referencia corresponde a un PORTATIL.");
            imprimirCamposElectrodomestico();
            System.out.println("   6. Capacidad de disco (Gb)");
            System.out.println("   7. Tipo de disco duro");
            System.out.println("   8. Horas de autonomía");
            seleccionIntroducida = entrada.nextInt();
            switch (seleccionIntroducida){
                case 1: cambiarMarcaElec(refIntroducido); break;
                case 2: cambiarModeloElec(refIntroducido); break;
                case 3: cambiarColorElec(refIntroducido); break;
                case 4: cambiarPrecioElec(refIntroducido); break;
                case 5: cambiarStockElec(refIntroducido); break;
                case 6: cambiarCapacidadInformatica(refIntroducido); break;
                case 7: cambiarTipoDiscoInformatica(refIntroducido); break;
                case 8:
                    System.out.println("Introduzca el nuevo valor (h):");
                    entrada.nextLine();
                    String nuevasHoras = entrada.nextLine();
                    miAlmacen.editarAtributo(refIntroducido, nuevasHoras, "horasAutonomiaPortatil");
                    break;
                default: System.out.println("No se ha encontrado la selección, vuelva a intentarlo."); break;
            }
        } else if ((miAlmacen.tipoElecEnHM(refIntroducido)).equals("PCSobremesa")){
            System.out.println("\nEsta referencia corresponde a un PC DE SOBREMESA.");
            imprimirCamposElectrodomestico();
            System.out.println("   6. Capacidad de disco (Gb)");
            System.out.println("   7. Tipo de disco duro");
            System.out.println("   8. Si incluye teclado (true/false)");
            seleccionIntroducida = entrada.nextInt();
            switch (seleccionIntroducida){
                case 1: cambiarMarcaElec(refIntroducido); break;
                case 2: cambiarModeloElec(refIntroducido); break;
                case 3: cambiarColorElec(refIntroducido); break;
                case 4: cambiarPrecioElec(refIntroducido); break;
                case 5: cambiarStockElec(refIntroducido); break;
                case 6: cambiarCapacidadInformatica(refIntroducido); break;
                case 7: cambiarTipoDiscoInformatica(refIntroducido); break;
                case 8:
                    System.out.println("Introduzca la nueva configuración (true/false):");
                    entrada.nextLine();
                    String nuevoIncluyeTeclado = entrada.nextLine();
                    miAlmacen.editarAtributo(refIntroducido, nuevoIncluyeTeclado, "incluyeTeclado");
                    break;
                default: System.out.println("No se ha encontrado la selección, vuelva a intentarlo."); break;
            }
        } else if ((miAlmacen.tipoElecEnHM(refIntroducido)).equals("SmartPhone")){
            System.out.println("\nEsta referencia corresponde a un SMARTPHONE.");
            imprimirCamposElectrodomestico();
            System.out.println("   6. Horas de autonomía");
            System.out.println("   7. Si tiene manos libres (true/false)");
            System.out.println("   8. Si tiene 4G (true/false)");
            seleccionIntroducida = entrada.nextInt();
            switch (seleccionIntroducida){
                case 1: cambiarMarcaElec(refIntroducido); break;
                case 2: cambiarModeloElec(refIntroducido); break;
                case 3: cambiarColorElec(refIntroducido); break;
                case 4: cambiarPrecioElec(refIntroducido); break;
                case 5: cambiarStockElec(refIntroducido); break;
                case 6: cambiarHorasTelefonia(refIntroducido); break;
                case 7: cambiarManosLibresTelefonia(refIntroducido); break;
                case 8:
                    System.out.println("Introduzca la nueva configuración (true/false):");
                    entrada.nextLine();
                    String nuevoTiene4G = entrada.nextLine();
                    miAlmacen.editarAtributo(refIntroducido, nuevoTiene4G, "4G");
                    break;
                default: System.out.println("No se ha encontrado la selección, vuelva a intentarlo."); break;
            }
        }else if ((miAlmacen.tipoElecEnHM(refIntroducido)).equals("TelefonoDomestico")){
            System.out.println("\nEsta referencia corresponde a un TELEFONO DOMESTICO.");
            imprimirCamposElectrodomestico();
            System.out.println("   6. Horas de autonomía");
            System.out.println("   7. Si tiene manos libres (true/false)");
            System.out.println("   8. Unidades por caja");
            seleccionIntroducida = entrada.nextInt();
            switch (seleccionIntroducida){
                case 1: cambiarMarcaElec(refIntroducido); break;
                case 2: cambiarModeloElec(refIntroducido); break;
                case 3: cambiarColorElec(refIntroducido); break;
                case 4: cambiarPrecioElec(refIntroducido); break;
                case 5: cambiarStockElec(refIntroducido); break;
                case 6: cambiarHorasTelefonia(refIntroducido); break;
                case 7: cambiarManosLibresTelefonia(refIntroducido); break;
                case 8:
                    System.out.println("Introduzca el nuevo valor de unidades:");
                    entrada.nextLine();
                    String nuevasUnidades = entrada.nextLine();
                    miAlmacen.editarAtributo(refIntroducido, nuevasUnidades, "unidades");
                    break;
                default: System.out.println("No se ha encontrado la selección, vuelva a intentarlo."); break;
            }
        
        }
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Simplemente, imprime los campos de un electrodomestico a editar.
     */
    private void imprimirCamposElectrodomestico(){
        System.out.println("Seleccione el campo que desea editar:");
        System.out.println("   1. Marca");
        System.out.println("   2. Modelo");
        System.out.println("   3. Color");
        System.out.println("   4. Precio");
        System.out.println("   5. Stock");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar de marca.
     */
    private void cambiarMarcaElec(String refIntroducido){
        System.out.println("Introduzca la nueva marca:");
        entrada.nextLine();
        String nuevaMarca = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevaMarca, "marca");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar de modelo.
     */
    private void cambiarModeloElec(String refIntroducido){
        System.out.println("Introduzca el nuevo modelo:");
        entrada.nextLine();
        String nuevoModelo = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevoModelo, "modelo");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar el color.
     */
    private void cambiarColorElec(String refIntroducido){
        System.out.println("Introduzca el nuevo color:");
        entrada.nextLine();
        String nuevoColor = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevoColor, "color");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar el precio.
     */
    private void cambiarPrecioElec(String refIntroducido){
        System.out.println("Introduzca el nuevo precio:");
        entrada.nextLine();
        String nuevoPrecio = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevoPrecio, "precio");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar el stock.
     */
    private void cambiarStockElec(String refIntroducido){
        System.out.println("Introduzca el nuevo stock:");
        entrada.nextLine();
        String nuevoStock = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevoStock, "stock");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar las pulgadas.
     */
    private void cambiarPulgadasImagen(String refIntroducido){
        System.out.println("Introduzca el nuevo numero de pulgadas:");
        entrada.nextLine();
        String nuevasPulgadas = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevasPulgadas, "pulgadas");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar si tiene 3D.
     */
    private void cambiar3DImagen(String refIntroducido){
        System.out.println("Introduzca la nueva configuración (true/false):");
        entrada.nextLine();
        String nuevoTiene3D = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevoTiene3D, "3D");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar el número de altavoces.
     */
    private void cambiarAltavocesSonido(String refIntroducido){
        System.out.println("Introduzca el nuevo numero de altavoces:");
        entrada.nextLine();
        String nuevoNumAltavoces = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevoNumAltavoces, "numAltavoces");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar si tiene radio.
     */
    private void cambiarRadioSonido(String refIntroducido){
        System.out.println("Introduzca la nueva configuración (true/false):");
        entrada.nextLine();
        String nuevoTieneRadio = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevoTieneRadio, "radio");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar si tiene control remoto.
     */
    private void cambiarRemotoHogar(String refIntroducido){
        System.out.println("Introduzca la nueva configuración (true/false):");
        entrada.nextLine();
        String nuevoTieneRemoto = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevoTieneRemoto, "controlRemoto");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar si es programalble.
     */
    private void cambiarProgramableHogar(String refIntroducido){
        System.out.println("Introduzca la nueva configuración (true/false):");
        entrada.nextLine();
        String nuevoEsProgramable = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevoEsProgramable, "programable");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar la capacidad de disco en Gb.
     */
    private void cambiarCapacidadInformatica(String refIntroducido){
        System.out.println("Introduzca la nueva capacidad de disco (Gb):");
        entrada.nextLine();
        String nuevaCapacidad = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevaCapacidad, "capacidadDisco");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar el tipo de disco.
     */
    private void cambiarTipoDiscoInformatica(String refIntroducido){
        System.out.println("Introduzca el nuevo tipo de disco:");
        entrada.nextLine();
        String nuevoTipoDisco = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevoTipoDisco, "tipoDisco");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar las horas de autonomía.
     */
    private void cambiarHorasTelefonia(String refIntroducido){
        System.out.println("Introduzca el nuevo valor (h):");
        entrada.nextLine();
        String nuevasHoras = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevasHoras, "horasAutonomiaTelefonia");
    }
    
    /**
     * Método auxiliar para el anterior (editarElectrodomestico). Sirve para cambiar si tiene manos libres.
     */
    private void cambiarManosLibresTelefonia(String refIntroducido){
        System.out.println("Introduzca la nueva configuración (true/false):");
        entrada.nextLine();
        String nuevoTieneManos = entrada.nextLine();
        miAlmacen.editarAtributo(refIntroducido, nuevoTieneManos, "manosLibres");
    }
    
    /**
     * MENÚ PRINCIPAL PARA EL PERFIL CAJERO.
     * Menú del perfil Cajero. Si el usuario que se ha loggeado es un cajero, directamente, saltará este menú.
     */
    private void menuCajero(){
        int seleccion_menu;
        
        do{
        
            System.out.println("Se encuentra dentro del menú de CAJERO.");
            System.out.println("Seleccione la opción deseada:");
            System.out.println("   1. Tramitar una venta");
            System.out.println("   2. Visualizar las compras de un cliente");
            System.out.println("   3. Gestionar clientes");
            System.out.println("   4. Cambiar de usuario/Salir");
            
            seleccion_menu = entrada.nextInt();
            
            switch(seleccion_menu){
                case 1: menuVenta(); break;
                case 2: 
                    System.out.println("Introduzca el DNI del cliente que contiene las facturas que desea visualizar:");
                    entrada.nextLine();
                    String dniCliente = entrada.nextLine();
                    if (miAlmacenClientes.clientePreviamenteCreado(dniCliente)){
                        miAlmacenFichas.imprimirFacturasDeListaCliente(dniCliente);
                    }else{
                        System.out.println("El cliente introducido no existe. Vuelva a intentarlo.");
                    }
                    break;
                case 3: menuGestionClientes(); break;
                case 4: break;
                default: System.out.println("Selección incorrecta. Vuelva a intentarlo."); break;
            }
        }while(seleccion_menu != 4);
    }
    
    /**
     * Menú asociado con las tareas del usuario Cajero. Este menú posibilita realizar una venta.
     */
    private void menuVenta(){
        String dniCliente;
        double precioTotal = 0;
        
        System.out.println("Introduzca el DNI del cliente:");
        entrada.nextLine();
        dniCliente = entrada.nextLine();
        
        if (miAlmacenClientes.clientePreviamenteCreado(dniCliente)){
            miAlmacenFichas.addFacturaEnFichaCliente(usuarioActual, dniCliente);
            int numFactura = Factura.getContador();
            String seleccion = "";
            
            do{
                System.out.println("Introduzca el número de serie del electrodomestico que desea comprar:");
                String serieElectrodomestico = entrada.nextLine();
                if (miAlmacen.elecPreviamenteCreado(serieElectrodomestico) && miAlmacen.stockElecEnHM(serieElectrodomestico) > 0){
                    miAlmacenFichas.addElecEnFacturaEnFichaCliente(dniCliente, numFactura, serieElectrodomestico);
                    miAlmacen.descuentaStockElecEnHM(serieElectrodomestico);
                    precioTotal = precioTotal + miAlmacen.precioElecEnHM(serieElectrodomestico);
                    miAlmacenFichas.addPrecioEnFacturaEnFichaCliente(dniCliente, numFactura, precioTotal);
                }else{
                    System.out.println("No se ha podido añadir a la factura, este electrodomestico no existe o no hay stock suficiente. Por favor, da de alta al cliente en el menú GESTIÓN DE ELECTRODOMESTICOS");
                }
                System.out.println("¿Desea incluir más electrodomésticos en esta factura? (S/N)");
                seleccion = entrada.nextLine();
            }while(seleccion.equalsIgnoreCase("S"));
        }else{
            System.out.println("Este cliente no existe. Por favor, da de alta al cliente en el menú GESTIÓN DE CLIENTES");
        }
    }
    
    /**
     * Menú asociado con las tareas del usuario Cajero. Este menú posibilita dar de alta, editar, dar de baja, buscar los clientes o consultar todos los clientes.
     */
    private void menuGestionClientes(){
        int seleccion_menu_cliente;
        String entrada_menucliente;
        
        do{
            System.out.println("Se encuentra dentro del menú de GESTIÓN DE CLIENTES.");
            System.out.println("Seleccione la opción deseada:");
            System.out.println("   1. Dar de alta a un nuevo cliente");
            System.out.println("   2. Editar la información de un cliente");
            System.out.println("   3. Dar de baja a un cliente");
            System.out.println("   4. Ver todos los Clientes");
            System.out.println("   5. Buscar un cliente");
            System.out.println("   6. Salir");
            
            seleccion_menu_cliente = entrada.nextInt();
                  
            switch(seleccion_menu_cliente){
                case 1: crearCliente(); break;
                case 2: editarCliente(); break;
                case 3:
                    System.out.println("Introduzca el DNI del cliente que desea borrar:");
                    entrada.nextLine();
                    entrada_menucliente = entrada.nextLine();
                    miAlmacenClientes.borrarCliente(entrada_menucliente);
                    break;
                case 4: miAlmacenClientes.imprimirListaClientes(); break;
                case 5:
                    String dniIntroducido;
                    System.out.println("Introduzca el DNI del cliente que desea visualizar:");
                    entrada.nextLine();
                    dniIntroducido = entrada.nextLine();
                    miAlmacenClientes.imprimirClienteDeHM(dniIntroducido);
                    break;
                case 6: System.out.println("Ha seleccionado salir del menú de GESTIÓN DE CLIENTES. ¡Hasta la próxima!"); break;
                default: System.out.println("La opción no es correcta. Seleccione entre 1, 2, 3, 4, 5 o 6."); break;
            }
        }while(seleccion_menu_cliente != 6);
        
    }
    
    /**
     * Método para crear un cliente. Solicita la información en pantalla.
     */
    private void crearCliente(){
        String dni;
        String nombre;
        String apellidos;
        String domicilio;
        String telefono;
        
        System.out.println("Ha seleccionado crear un nuevo cliente.");
        System.out.println("Introduzca el DNI:");
        entrada.nextLine();
        dni = entrada.nextLine();
        System.out.println("Introduzca el nombre:");
        nombre = entrada.nextLine();
        System.out.println("Introduzca los apellidos:");
        apellidos = entrada.nextLine();
        System.out.println("Introduzca el teléfono:");
        telefono = entrada.nextLine();
        System.out.println("Introduzca el domicilio:");
        domicilio = entrada.nextLine();
        
        miAlmacenClientes.addCliente(dni, nombre, apellidos, domicilio, telefono);
        miAlmacenFichas.addFichaCliente(dni);
    }
    
    /**
     * Método para editar un cliente. Solicita la información en pantalla.
     */
    private void editarCliente(){
        String dniIntroducido;
        int seleccionIntroducida;
        
        System.out.println("Introduzca el DNI del cliente que desea editar:");
        entrada.nextLine();
        dniIntroducido = entrada.nextLine();
        
        System.out.println("Los datos del cliente son:");
        miAlmacenClientes.imprimirClienteDeHM(dniIntroducido);
        System.out.println("");
        
        System.out.println("Seleccione el campo que desea editar:");
        System.out.println("   1. Nombre");
        System.out.println("   2. Apellidos");
        System.out.println("   3. Telefono");
        System.out.println("   4. Domicilio");
        System.out.println("   5. Valor de la última nómina");
        //Suponemos que el DNI no se puede cambiar
        seleccionIntroducida = entrada.nextInt();
        
        String atributo = "";
        switch (seleccionIntroducida){ //se puede plantear esta versión reducida de editar cliente para los electrodomesticos
            case 1: atributo = "nombre"; break;
            case 2: atributo = "apellidos"; break;
            case 3: atributo = "telefono"; break;
            case 4: atributo = "domicilio"; break;
            case 5: atributo = "nomina"; break;
            default: System.out.println("No se ha encontrado la selección. Vuelva a intentarlo."); break;
        }
        
        System.out.println("Introduzca el nuevo valor de " + atributo + ":");
        entrada.nextLine();
        String nuevoValor = entrada.nextLine();
        miAlmacenClientes.editarAtributo(dniIntroducido, nuevoValor, atributo);
    }
    
    /**
     * MENÚ PRINCIPAL PARA EL PERFIL POSTVENTA.
     * Menú del perfil Postventa. Si el usuario que se ha loggeado es un postventa, directamente, saltará este menú.
     */
    private void menuPostventa(){
        int seleccion_menu;
        
        do{
            System.out.println("Se encuentra dentro del menú de POSTVENTA.");
            System.out.println("Seleccione la opción deseada:");
            System.out.println("   1. Tramitar una devolución");
            System.out.println("   2. Reparar un electrodoméstico");
            System.out.println("   3. Cambiar de usuario/Salir");
            
            seleccion_menu = entrada.nextInt();
            
            switch(seleccion_menu){
                case 1: menuDevolucion(); break;
                case 2: menuAsignarReparacion(); break;
                case 3: break;
                default: System.out.println("Selección incorrecta. Vuelva a intentarlo."); break;
            }
        }while(seleccion_menu != 3);
    }
    
    /**
     * Menú asociado con las tareas del usuario Postventa. Este menú posibilita realizar una devolución.
     */
    private void menuDevolucion(){
        String dniCliente;
        double precioTotal = 0;
        
        System.out.println("Introduzca el DNI del cliente:");
        entrada.nextLine();
        dniCliente = entrada.nextLine();
        
        if (miAlmacenClientes.clientePreviamenteCreado(dniCliente)){
            miAlmacenFichas.addDevolucionEnFichaCliente(usuarioActual, dniCliente);
            int numFactura = Factura.getContador();
            String seleccion = "";
            
            do{
                System.out.println("Introduzca el número de serie del electrodomestico que desea devolver:");
                String serieElectrodomestico = entrada.nextLine();
                if (miAlmacen.elecPreviamenteCreado(serieElectrodomestico)){
                    miAlmacenFichas.addElecEnFacturaEnFichaCliente(dniCliente, numFactura, serieElectrodomestico);
                    miAlmacen.incrementaStockElecEnHM(serieElectrodomestico);
                    precioTotal = precioTotal + miAlmacen.precioElecEnHM(serieElectrodomestico);
                    miAlmacenFichas.addPrecioEnFacturaEnFichaCliente(dniCliente, numFactura, precioTotal);
                }else{
                    System.out.println("No se ha podido añadir a la devolución, este electrodomestico no existe.");
                }
                System.out.println("¿Desea devolver más electrodomésticos? (S/N)");
                seleccion = entrada.nextLine();
            }while(seleccion.equalsIgnoreCase("S"));
        }else{
            System.out.println("Este cliente no existe. Por favor, da de alta al cliente en el menú GESTIÓN DE CLIENTES.");
        }
    }
    
    
    /**
     * Menú asociado con las tareas del usuario Postventa. Este menú posibilita asignar una reparación a un técnico.
     */
    private void menuAsignarReparacion(){
        String dniCliente;
        String refElectrodomestico;
        String problema;
        String tecnico_selec;
        
        System.out.println("Introduzca el DNI del cliente solicitante:");
        entrada.nextLine();
        dniCliente = entrada.nextLine();
        
        if (miAlmacenClientes.clientePreviamenteCreado(dniCliente)){
        
            System.out.println("Introduzca la referencia del electrodomestico que desea reparar:");
            refElectrodomestico = entrada.nextLine();
            
            if (miAlmacen.elecPreviamenteCreado(refElectrodomestico)){
                System.out.println("Introduzca una breve descripción del problema según el cliente:");
                problema = entrada.nextLine();
                
                System.out.println("Seleccione el técnico al que desea asignar la reparación de la siguiente lista de usuarios:");
                miAlmacenUsuarios.imprimirListaUsuariosTecnico();
                System.out.println("Introduzca el DNI del técnico seleccionado:");
                tecnico_selec = entrada.nextLine();
                
                miAlmacenUsuarios.agregarFichaRep(tecnico_selec, dniCliente, refElectrodomestico, problema);
                
                System.out.println("La reparación ha sido asignada.");
            }else{
                System.out.println("Este electrodoméstico no existe. Por favor, revise el dato introducido y vuelva a comenzar.");
            }
        }else{
            System.out.println("Este cliente no existe. Por favor, revise el dato introducido y vuelva a comenzar.");
        }
    }
    
    /**
     * MENÚ PRINCIPAL PARA EL PERFIL TECNICO.
     * Menú del perfil Técnico. Si el usuario que se ha loggeado es un técnico, directamente, saltará este menú.
     */
    private void menuTecnico(){
        int seleccion;
        
        do{
        
            System.out.println("Se encuentra dentro del menú de TÉCNICO.");
            System.out.println("Seleccione la opción deseada:");
            System.out.println("   1. Ver todas las fichas de reparación (historial de técnico)");
            System.out.println("   2. Ver fichas de reparación EN PROCESO asignadas");
            System.out.println();
            System.out.println("   3. Añadir tarea en una ficha de reparación");
            System.out.println("   4. Añadir pieza en una ficha de reparación");
            System.out.println();
            System.out.println("   5. Cambiar el estado de una ficha de reparación");
            System.out.println();
            System.out.println("   6. Ver todos los electrodomésticos pendientes de reparar para el usuario actual");
            System.out.println("   7. Ver todas las piezas solicitadas del usuario actual");
            System.out.println();
            System.out.println("   8. Cambiar de usuario/Salir");
            
            seleccion = entrada.nextInt();
            
            switch (seleccion){
                case 1: miAlmacenUsuarios.imprimirTodasFichasTecnico(usuarioActual); break;
                case 2: miAlmacenUsuarios.imprimirTodasFichasTecnicoEnProceso(usuarioActual); break;
                case 3: menuAgregarTarea(); break;
                case 4: menuAgregarPieza(); break;
                case 5: menuCambiarEstadoFicha(); break;
                case 6: miAlmacenUsuarios.imprimirTodosElecTecnico(usuarioActual); break;
                case 7: miAlmacenUsuarios.imprimirTodasPiezasTecnico(usuarioActual); break;
                case 8: break;
                default: System.out.println("Selección incorrecta. Vuelva a intentarlo."); break;
            }
        }while(seleccion != 8);
    }
    
    /**
     * Menú asociado con las tareas del usuario Técnico. Este menú posibilita agregar una tarea.
     */
    private void menuAgregarTarea(){
        int idFicha;
        String tarea;
        
        System.out.println("Escoja el ID de la ficha donde desea añadir la tarea:");
        miAlmacenUsuarios.imprimirTodasFichasTecnicoEnProceso(usuarioActual);
        System.out.println("ID de la ficha seleccionada:");
        idFicha = entrada.nextInt();
        
        System.out.println("Introduzca la tarea que desea añadir:");
        entrada.nextLine();
        tarea = entrada.nextLine();
        
        miAlmacenUsuarios.agregarTareaEnFicha(usuarioActual, idFicha, tarea);
    }
    
    /**
     * Menú asociado con las tareas del usuario Técnico. Este menú posibilita agregar una pieza.
     */
    private void menuAgregarPieza(){
        int idFicha;
        String pieza;
        
        System.out.println("Escoja el ID de la ficha donde desea añadir la pieza:");
        miAlmacenUsuarios.imprimirTodasFichasTecnicoEnProceso(usuarioActual);
        System.out.println("ID de la ficha seleccionada:");
        idFicha = entrada.nextInt();
        
        System.out.println("Introduzca la pieza que desea añadir:");
        entrada.nextLine();
        pieza = entrada.nextLine();
        
        miAlmacenUsuarios.agregarPiezaEnFicha(usuarioActual, idFicha, pieza);
    }
    
    /**
     *  Menú asociado con las tareas del usuario Técnico. Este menú posibilita cambiar el estado de una ficha.
     */
    private void menuCambiarEstadoFicha(){
        int idFicha;
        int estadoSelec;
        
        System.out.println("Escoja el ID de la ficha a cambiar de estado:");
        miAlmacenUsuarios.imprimirTodasFichasTecnico(usuarioActual);
        System.out.println("ID de la ficha seleccionada:");
        idFicha = entrada.nextInt();
        
        System.out.println("Seleccione el estado que desea establecer:");
        System.out.println("   1. Pendiente");
        System.out.println("   2. En proceso");
        System.out.println("   3. Parado");
        System.out.println("   4. Fase de prueba");
        System.out.println("   5. Terminado");
        
        estadoSelec = entrada.nextInt();
        
        switch(estadoSelec){
            case 1: miAlmacenUsuarios.cambiarEstadoEnFichaTecnico(usuarioActual, idFicha, Estado.pendiente); break;
            case 2: miAlmacenUsuarios.cambiarEstadoEnFichaTecnico(usuarioActual, idFicha, Estado.enProceso); break;
            case 3: miAlmacenUsuarios.cambiarEstadoEnFichaTecnico(usuarioActual, idFicha, Estado.parado); break;
            case 4: miAlmacenUsuarios.cambiarEstadoEnFichaTecnico(usuarioActual, idFicha, Estado.faseDePrueba); break;
            case 5: miAlmacenUsuarios.cambiarEstadoEnFichaTecnico(usuarioActual, idFicha, Estado.terminado); break;
            default: System.out.println("Selección incorrecta. Vuelva a intentarlo."); break;
        }
    }
}
