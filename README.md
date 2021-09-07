# Objetivo tienda-electrodomesticos
Trabajo desarrollado dentro de la asignatura Programación Orientada a Objetos en el Grado de Ingeniería Informática de la UNED. Consiste en el diseño e implementación de un Sistema Integrado de Gestión de una tienda de electrodomésticos.

Los objetivos de la realización de esta práctica han sido los siguientes:
- Familiarización con la Programación Orientada a Objetos (POO): definición de clases e instancias, uso de la herencia, definición/uso de métodos estáticos y abstractos.
- Realización del diseño orientado a objetos en el Sistema Integrado de Gestión de una tienda de electrodomésticos.
- Implementación de un programa sencillo donde se manejen conceptos relacionados con POO.

La práctica ha consistido en diseñar e implementar un Sistema Integrado de Gestión de una tienda de electrodomésticos. El diseño y desarrollo de este programa se ha basado en que el programa debe incluir varias características como: la capacidad de gestionar varios tipos de electrodomésticos diferentes en la tienda, diferentes perfiles de empleados (técnicos, cajeros, financiación y postventa), perfiles de clientes con un historial de compras, facturas de las compras realizadas, etc.

Los requisitos mínimos del programa y las especificaciones están descritos en el enunciado de la práctica provisto por el equipo docente.

# Arquitectura del sistema y jerarquía de clases
![alt text](https://github.com/Ubikitina/tienda-electrodomesticos/blob/main/Diagrama%20de%20clases.png)
La arquitectura del sistema diseñada muestra con claridad la separación por bloques de la lógica del programa. La estructuración de las clases está dividida en los siguientes bloques:
- **Clase `Tienda`**: Esta clase es la clase principal que abre la aplicación. Contiene el método main.
- **Clase `InterfazDeTexto`**: Esta clase se encarga de comunicar con el usuario del programa. En el caso de esta práctica, es una interfaz de texto que sirve como consola. Provee la información necesaria para que el usuario del programa sepa las opciones que puede realizar, mostradas en pantalla mediante la clase System, el atributo out, y su método println() (System.out.println();). De esa interacción con el usuario, también recupera la información introducida mediante la clase Scanner, y transmite la información recopilada a las clases pertinentes.
- **Clases denominadas como `Almacen…`**: `AlmacenUsuarios`, `AlmacenClientes`, `AlmacenFichas` y `AlmacenElectrod`. Son los gestores de datos. Todas estas clases contienen HashMap-s para representar una estructura de datos donde se almacena pares de "clave/valor". Estas clases también son los receptores de datos recopilados en la clase `InterfazDeTexto`, y contienen métodos de consulta, escritura, búsquedas, etc. en los HashMap, para poder realizar las acciones solicitadas por el usuario con los datos facilitados. Por tanto, la `InterfazDeTexto` llama a las clases denominadas `Almacen…` para utilizar los métodos necesarios.
- **Clases de datos básicos**: Se trata de todas las demás clases, como `Electrodomestico`, `Empleado`, `FichaDeCompras`, … Estas clases definen las estructuras de los datos básicos. El uso de la herencia y de los métodos abstractos es notable entre estas clases.
- **Clase SerializarDatos**: La serialización consiste en codificar objetos a una serie de bites en un medio de almacenamiento. En esta práctica se ha utilizado la serialización, con el fin de transportar la información introducida en el programa al PC, para después poder cargar los datos al volver a iniciar el programa, y de esta manera, conseguir la persistencia de datos. Para ello, se ha utilizado la clase SerializarDatos.

El diseño de las clases tiene como objetivo el separar la interacción con el usuario (clase `InterfazDeTexto`) de la gestión de datos o gestores (clases `Almacen…`), y a su vez, separar los gestores de las clases básicas de definición de objetos simples. Por tanto, la lógica del programa se centra en los gestores, donde se manipulan los datos. La interfaz de texto se limita a mostrar información en pantalla y recopilar información introducida, pero realiza operaciones de lógica.

Se ha optado por desarrollar cuatro gestores diferentes, cada uno especializado en un subconjunto de clases básicas a gestionar, en vez de un único gestor que gestione todas las clases básicas. El objetivo de crear cuatro gestores ha sido facilitar la comprensión de la arquitectura del programa y aclarar el funcionamiento a simple vista. No obstante, la interfaz de texto de interacción con el usuario es una única para todo el programa.

# Bibliografía
- Barnes, D., Díaz Fondón, M., Kölling, M., Luengo Díez, M., & Read, T. _Programación orientada a objetos con Java usando BlueJ_. Pearson.

