## GraphQL

###  1. Listar países

Consulta que obtiene un listado general de países con información básica como código, nombre y emoji.
<img width="1641" height="1316" alt="image" src="https://github.com/user-attachments/assets/5cb1d165-4f49-422c-98d3-46c30fadca22" />

---

###  2. País por código (filtro)

Consulta que obtiene la información de un país específico utilizando un argumento (code), en este caso Colombia (CO).
<img width="1761" height="1233" alt="image" src="https://github.com/user-attachments/assets/6c637e12-80f3-445b-a170-e12c5b0f5b47" />

---

###  3. Listar continentes

Consulta que retorna todos los continentes disponibles junto con su código y nombre.
<img width="1633" height="1221" alt="image" src="https://github.com/user-attachments/assets/4fa5439b-1618-49e0-9fa7-c80e385d1ffb" />

---

###  4. Listar idiomas

Consulta que obtiene los idiomas disponibles en la API, incluyendo su código, nombre y nombre nativo.
<img width="1850" height="1268" alt="image" src="https://github.com/user-attachments/assets/addd5de3-076f-416b-9acc-46bb48a00196" />

---

###  5. Continente con países (query anidada)

Consulta que obtiene un continente específico y, de forma anidada, la lista de países que pertenecen a dicho continente.  
Esta request permite evidenciar el uso de relaciones entre datos en GraphQL.
<img width="1845" height="1300" alt="image" src="https://github.com/user-attachments/assets/92b65cb6-9b11-4b8d-8d19-b40c4c69e76a" />

---

###  ¿Qué diferencia encontraste vs REST?

La principal diferencia entre GraphQL y REST es la forma en la que se obtienen los datos.

En REST, se utilizan múltiples endpoints y diferentes métodos HTTP (GET, POST, PUT, DELETE) para acceder a los recursos. En cambio, GraphQL utiliza un único endpoint y todas las solicitudes se realizan mediante el método POST.

Además, en GraphQL el cliente puede especificar exactamente qué datos necesita, evitando recibir información innecesaria, lo que mejora la eficiencia de las consultas.

---

###  ¿Cuántos requests REST necesitarías para reemplazar tu query más compleja?

Para la query más compleja (consulta anidada de continente con países), en REST se necesitarían al menos 2 o más requests:

- Un request para obtener el continente  
- Otro request para obtener los países relacionados  

En GraphQL, esta información se obtiene en una sola consulta, lo que reduce la cantidad de solicitudes al servidor.

---

### ¿En qué proyecto real usarías GraphQL?

GraphQL sería especialmente útil en proyectos donde se requiere optimizar el consumo de datos, como por ejemplo:

- Aplicaciones móviles, donde es importante reducir el uso de datos y llamadas al servidor  
- Aplicaciones con interfaces complejas que requieren múltiples recursos relacionados  
- Sistemas donde diferentes clientes (web, móvil) necesitan distintos tipos de información  

En estos casos, GraphQL permite mayor flexibilidad y eficiencia en la obtención de datos.

###  Limitaciones de la API utilizada

Es importante destacar que la API utilizada (**Countries GraphQL**) es de solo lectura, por lo cual no soporta operaciones de modificación de datos como crear, actualizar o eliminar registros.

Esto significa que no es posible utilizar **mutations**, limitándose únicamente al uso de **queries** para la consulta de información.
