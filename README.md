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

