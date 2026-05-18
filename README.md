# Implementación del Patrón Singleton con Conexión a Base de Datos en Java

En este proyecto se implementó el patrón de diseño Singleton utilizando una conexión a una base de datos MySQL. El objetivo principal fue garantizar que durante toda la ejecución del programa exista una única instancia de conexión a la base de datos, evitando la creación innecesaria de múltiples conexiones.

El patrón Singleton pertenece a los patrones creacionales y se utiliza cuando se necesita controlar que una clase solo pueda tener un objeto instanciado. En aplicaciones reales este patrón es muy utilizado para manejar recursos compartidos como conexiones a bases de datos, configuraciones globales, logs y administradores de servicios.

---

# Clase `ConexionBD`

La clase `ConexionBD` es la encargada de administrar la conexión con MySQL. Esta clase implementa el patrón Singleton y contiene toda la lógica necesaria para crear y retornar la única instancia de conexión.

```java
private static ConexionBD instancia;
```

Esta variable almacena la única instancia de la clase. Al ser `static`, pertenece a la clase y no a un objeto específico.

---

## Constructor privado

```java
private ConexionBD()
```

El constructor se declara privado para impedir que otras clases puedan crear objetos usando `new ConexionBD()`.

Esto es una de las características principales del patrón Singleton, ya que obliga a que la única forma de obtener la instancia sea a través del método `getInstancia()`.

Dentro del constructor se realiza la conexión con la base de datos usando JDBC:

```java
conexion = DriverManager.getConnection(
        URL,
        USUARIO,
        PASSWORD
);
```

Aquí se establece la conexión con MySQL utilizando:

- La URL de conexión
- El usuario
- La contraseña

La URL utilizada fue:

```java
jdbc:mysql://localhost:3310/mi_base
```

Donde:

- `localhost` indica que el servidor está en el mismo equipo.
- `3310` corresponde al puerto configurado en MySQL.
- `mi_base` es la base de datos creada previamente.

---

## Método `getInstancia()`

```java
public static ConexionBD getInstancia()
```

Este método es el núcleo del patrón Singleton. Su función es verificar si la instancia ya existe.

```java
if (instancia == null)
```

Si no existe, se crea una nueva:

```java
instancia = new ConexionBD();
```

Si ya existe, simplemente retorna la misma instancia creada anteriormente.

De esta manera se garantiza que todo el sistema utilice exactamente la misma conexión a la base de datos.

---

# Clase `Tallerpatterns`

La clase `Tallerpatterns` contiene el método `main`, el cual actúa como punto de entrada de la aplicación.

En esta clase se realizan dos solicitudes de instancia:

```java
ConexionBD conexion1 = ConexionBD.getInstancia();

ConexionBD conexion2 = ConexionBD.getInstancia();
```

Aunque parecen dos objetos diferentes, ambos apuntan a la misma instancia creada por Singleton.

Posteriormente se comparan ambas referencias:

```java
if (conexion1 == conexion2)
```

El operador `==` compara si ambos objetos ocupan la misma posición en memoria.

El resultado obtenido fue:

```text
Es la misma instancia de conexión
```

Lo anterior demuestra que Singleton funcionó correctamente y que únicamente se creó un solo objeto de conexión.

---

# Uso de JDBC

Para conectar Java con MySQL se utilizó JDBC (Java Database Connectivity), que es la API estándar de Java para trabajar con bases de datos relacionales.

JDBC permite:

- Abrir conexiones
- Ejecutar consultas SQL
- Obtener resultados
- Manipular datos

Para que JDBC funcione correctamente fue necesario agregar el driver de MySQL mediante Maven en el archivo `pom.xml`.

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>
```

Esta dependencia descarga automáticamente el conector que permite la comunicación entre Java y MySQL.

---

# Ventajas del patrón Singleton en este proyecto

La implementación de Singleton permitió:

- Evitar múltiples conexiones simultáneas a la base de datos.
- Centralizar el acceso a la conexión.
- Reducir consumo de memoria y recursos.
- Facilitar el control de la conexión en toda la aplicación.

Además, este patrón es ampliamente utilizado en sistemas empresariales debido a que las conexiones a bases de datos suelen ser recursos costosos.
Al correr el proyecto en local se obtuvo la siguiente salida :
<img width="2540" height="1090" alt="image" src="https://github.com/user-attachments/assets/bdbed869-2806-422e-a68f-38117c1ba215" />
En donde queda demostrado que efectivamente estamos accediendo a la misma instacia de conexion de la base de datos



# Implementación de los Patrones Adapter y Strategy en Java

En este proyecto que encontraras como adapter_strategy se desarrolló un sistema de exportación de reportes utilizando la combinación de dos patrones de diseño: Adapter y Strategy. El objetivo principal fue construir una solución flexible que permitiera exportar reportes en diferentes formatos sin modificar la lógica principal del sistema.

El patrón Strategy pertenece a los patrones de comportamiento y permite cambiar dinámicamente el algoritmo o comportamiento utilizado por el sistema. En este caso, se utilizó para seleccionar el tipo de exportación del reporte, como PDF, Excel o Word.

Por otro lado, el patrón Adapter pertenece a los patrones estructurales y se utilizó para adaptar librerías externas que poseen métodos incompatibles con la estructura principal del sistema.

---

# Funcionamiento general del sistema

El sistema fue diseñado para generar reportes y exportarlos en diferentes formatos. Para lograr esto, se creó una interfaz común llamada `ExportadorStrategy`, la cual define el método:

```java
void exportar(String contenido);
```

Todas las clases encargadas de exportar reportes deben implementar esta interfaz, garantizando así que el sistema pueda trabajar de manera uniforme sin importar el formato seleccionado.

---

# Patrón Strategy

El patrón Strategy permite seleccionar dinámicamente la forma de exportar el reporte.

Por ejemplo, el sistema puede cambiar entre:

- Exportación PDF
- Exportación Excel
- Exportación Word

sin modificar la clase principal del sistema.

La clase `SistemaReportes` contiene una referencia a la estrategia de exportación:

```java
private ExportadorStrategy estrategia;
```

y mediante el método:

```java
setEstrategia()
```

es posible cambiar el comportamiento del sistema en tiempo de ejecución.

De esta forma, el sistema se vuelve flexible y extensible, ya que nuevos tipos de exportación pueden agregarse fácilmente sin alterar el código existente.

---

# Clase `ExportadorPDF`

La clase `ExportadorPDF` implementa directamente la interfaz `ExportadorStrategy`.

```java
public class ExportadorPDF
        implements ExportadorStrategy
```

Esta clase representa una exportación simple y compatible con la estructura principal del sistema.

Su función es mostrar un mensaje indicando que el reporte fue exportado en formato PDF.

---

# Patrón Adapter

El patrón Adapter se utilizó para integrar librerías externas incompatibles con la interfaz del sistema.

En el proyecto se simuló el uso de librerías externas para Excel y Word.

Por ejemplo, la librería de Excel contiene el método:

```java
crearArchivoExcel()
```

mientras que la librería de Word utiliza:

```java
generarWord()
```

El problema es que el sistema principal espera trabajar con el método:

```java
exportar()
```

Debido a esta incompatibilidad, fue necesario implementar adapters.

---

# Clase `ExportadorExcelAdapter`

La clase `ExportadorExcelAdapter` implementa la interfaz `ExportadorStrategy` y actúa como intermediario entre el sistema y la librería externa de Excel.

Internamente contiene un objeto de tipo `LibreriaExcel`:

```java
private LibreriaExcel excel;
```

Cuando el sistema llama al método:

```java
exportar(contenido)
```

el adapter traduce esta llamada al método real de la librería:

```java
excel.crearArchivoExcel(contenido);
```

De esta manera, el sistema puede utilizar la librería externa sin necesidad de modificar su estructura original.

---

# Clase `ExportadorWordAdapter`

La clase `ExportadorWordAdapter` cumple la misma función, pero para la librería de Word.

El adapter transforma la llamada:

```java
exportar(contenido)
```

en:

```java
word.generarWord(contenido);
```

permitiendo que la librería externa sea compatible con el sistema principal.

---

# Clase `SistemaReportes`

La clase `SistemaReportes` representa el núcleo del sistema.

Su responsabilidad es generar reportes utilizando cualquier estrategia de exportación configurada.

Gracias al patrón Strategy, esta clase no necesita conocer detalles internos de PDF, Excel o Word, ya que únicamente trabaja con la interfaz `ExportadorStrategy`.

Esto reduce el acoplamiento y mejora la mantenibilidad del sistema.

---

# Clase `Main`

La clase `Main` contiene el punto de entrada del programa y demuestra el funcionamiento combinado de ambos patrones.

Durante la ejecución se cambia dinámicamente la estrategia de exportación:

```java
sistema.setEstrategia(new ExportadorPDF());
```

posteriormente:

```java
sistema.setEstrategia(new ExportadorExcelAdapter());
```

y finalmente:

```java
sistema.setEstrategia(new ExportadorWordAdapter());
```

Esto demuestra cómo el sistema puede modificar su comportamiento sin alterar su estructura principal.

---

# Ventajas de la implementación

La combinación de Adapter y Strategy permitió:

- Separar responsabilidades.
- Reducir el acoplamiento.
- Facilitar la integración de librerías externas.
- Permitir agregar nuevos formatos de exportación fácilmente.
- Mejorar la flexibilidad y mantenibilidad del sistema.

---
  
Al correr en proyecto en forma local se obtuvo la siguiente salida 
<img width="1873" height="1465" alt="image" src="https://github.com/user-attachments/assets/ed760b8c-1426-45a7-a6c1-84c416c545d0" />
La implementación realizada permitió comprender cómo combinar patrones estructurales y de comportamiento dentro de un mismo proyecto. El patrón Strategy aportó flexibilidad al permitir cambiar dinámicamente el tipo de exportación, mientras que Adapter permitió integrar librerías externas incompatibles sin modificar la lógica principal del sistema.

Gracias a esta combinación, el sistema quedó preparado para crecer y adaptarse fácilmente a nuevos requerimientos futuros.



