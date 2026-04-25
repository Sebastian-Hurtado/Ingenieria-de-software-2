## 🧪 Taller de APIs – Postman

### 1. ¿Qué API elegiste y por qué?

Se eligió la API de **SuperHero API**  
<img width="477" height="157" alt="image" src="https://github.com/user-attachments/assets/7e95cfba-e9e5-43bf-b4dd-592b8686e1dc" />

debido a que resulta interesante trabajar con información de superhéroes, lo cual hace más dinámico y atractivo el proceso de aprendizaje al interactuar con datos conocidos y relevantes.

Sin embargo, esta API solo permite realizar consultas de tipo GET, por lo cual no es posible implementar otras operaciones como POST, PUT, PATCH o DELETE.

Para cumplir con el requerimiento de uso de **query parameters**, se utilizó la siguiente API:

**Random User API**  
<img width="445" height="181" alt="image" src="https://github.com/user-attachments/assets/9676f85f-7805-4b9b-8018-ebe3f1717ae3" />

Esta API permite obtener usuarios aleatorios y aplicar filtros mediante parámetros en la URL, como la cantidad de resultados y la nacionalidad.

Adicionalmente, para implementar las operaciones CRUD (POST, PUT, PATCH y DELETE), se utilizó la API:

**DummyJSON API**

Esta API proporciona datos simulados y permite realizar operaciones de creación, actualización y eliminación de recursos, siendo ideal para pruebas en Postman.


Se utilizaron múltiples APIs con diferentes características:

- **SuperHero API** → consultas GET con autenticación mediante token en la URL  
- **Random User API** → uso de query parameters  
- **DummyJSON API** → implementación de operaciones CRUD  


---

### 2. ¿Qué datos devuelve?

#### SuperHero API

La API devuelve información detallada sobre los superhéroes, incluyendo:

- Nombre  
- Identidad  
- Poderes (powerstats)  
- Apariencia (altura, peso, etc.)  
- Biografía  
- Imagen del personaje  

En las consultas realizadas, se obtuvieron listas de superhéroes y sus características en formato JSON.



#### Random User API

La API Random User devuelve información de usuarios generados aleatoriamente en formato JSON.  

Entre los datos obtenidos se encuentran:

- Nombre completo  
- Género  
- Ubicación (ciudad y país)  
- Correo electrónico  
- Usuario y contraseña  
- Edad  
- Teléfono  
- Imagen del usuario  

Mediante el uso de parámetros en la URL (query params), es posible controlar la cantidad de resultados y filtrar por nacionalidad.



####  DummyJSON API

La API DummyJSON proporciona datos simulados en formato JSON para diferentes entidades como usuarios, productos y publicaciones.

En este caso, se trabajó con el endpoint de usuarios, el cual devuelve información como:

- Identificador del usuario  
- Nombre y apellido  
- Edad  
- Género  
- Correo electrónico  
- Teléfono  
- Nombre de usuario  
- Fecha de nacimiento  
- Imagen del usuario  

Adicionalmente, la API incluye metadatos como el total de registros, el límite de resultados y el desplazamiento, lo cual permite implementar paginación en las consultas.

Esta API también permite simular operaciones CRUD (crear, actualizar y eliminar), siendo útil para pruebas y aprendizaje.


---

### 3. ¿Usa token o no? ¿Qué tipo?

####  SuperHero API

Sí, la API utiliza un **token de acceso**.

Este token se incluye directamente en la URL de la siguiente manera:  
https://superheroapi.com/api/{token}/endpoint  

El tipo de autenticación es mediante **API Key**, donde el token funciona como una clave única que permite acceder a los recursos de la API.

A diferencia de otros tipos de autenticación como Bearer Token, en este caso no se envía en los headers, sino como parte de la ruta de la URL.



####  Random User API

No, la API **no utiliza ningún tipo de autenticación**.

Es una API completamente pública que permite realizar consultas sin necesidad de token o credenciales.  
Los datos se obtienen directamente mediante peticiones GET, incluyendo el uso de parámetros en la URL (query params).



####  DummyJSON API

Depende del endpoint utilizado:

- Para los endpoints públicos (como `/users`, `/products`, etc.), **no se requiere autenticación**.  
- Para los endpoints protegidos (como `/auth/me`), se utiliza autenticación mediante **Bearer Token (JWT)**.

En este caso, el token se obtiene a través de un proceso de login y se envía en los headers de la siguiente forma:

---

### 4. ¿Qué código de estado recibiste en cada request?
En la primera request llamada con_id obtuve codigo de estado 200 lo cual fue exitoso en esta obtuvimos el super heroe batman ya que es mi favorito
<img width="1444" height="948" alt="image" src="https://github.com/user-attachments/assets/91243684-2282-4992-b3a5-e1b2c670104c" />
sin embargo al no tener la api el poder listar todos los usuarios pero si tener una busqueda por nombre decidi buscar la letra a para que me listara todos los super heroes que tuvieran la letra a en su nombre esto se realizo en la request de tipo get llamda busca_a
<img width="1405" height="811" alt="image" src="https://github.com/user-attachments/assets/8a5edfec-9acc-48c0-b411-28af902c3890" />
Se realizo tambien la request params para practicar las request de esa forma 
<img width="1609" height="433" alt="image" src="https://github.com/user-attachments/assets/66dc524a-771d-4e22-a66a-712ec880de6a" />
se destaca que la url cambia un poco al poder meter como parametros en ella.  
Se realizo la request llamada agregar usuario con la api de dummy para poder practicar el metodo post en este cambio que si lleva body 
<img width="1525" height="568" alt="image" src="https://github.com/user-attachments/assets/f80fdeaf-5288-4cc6-8327-67503c467c47" />
tambien se realizo el metodo put y patch donde estos se parecen mucho con la diferencia de que put puedes actualizar todo el registro mientras que patch solo und ato en especifico, aca cambio que lleva headers la peticion 
<img width="1581" height="396" alt="image" src="https://github.com/user-attachments/assets/d3be672e-027d-4ab4-9a46-45bc8ff9de26" />
y por el ultimo el metodo delete que no lleva ni headers ni body 
<img width="1576" height="810" alt="image" src="https://github.com/user-attachments/assets/589f0d04-53d6-438f-9ab8-245fc1bf0109" />




---

### 5. ¿Qué aprendiste diferente a JSONPlaceholder?

A diferencia de JSONPlaceholder, se aprendió que:

- No todas las APIs permiten realizar operaciones CRUD completas (POST, PUT, DELETE).  
- Algunas APIs solo permiten consultas de tipo GET.  
- Existen diferentes formas de autenticación, como el uso de tokens en la URL.  
- Es importante validar la estructura de la respuesta, ya que puede variar entre APIs.  
- El uso de tests en Postman permite verificar automáticamente el correcto funcionamiento de cada request.
- Todos los metodos llevan sus pruebas en el apartado de scripts
