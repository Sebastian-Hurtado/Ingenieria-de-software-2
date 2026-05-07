#  Implementación de API Node.js en Máquina Virtual con Acceso Remoto

##  Descripción

Esta Tarea consiste en la creación y despliegue de una API REST básica utilizando Node.js, ejecutada dentro de una máquina virtual con Ubuntu. Se configuró el entorno para permitir el acceso remoto desde el equipo host mediante red local y túnel SSH.



##  Objetivo

Implementar una API funcional y exponerla fuera de la máquina virtual, permitiendo su consumo desde otro equipo, simulando un entorno real de backend.



##  Creación del entorno

Se utilizó VirtualBox para crear una máquina virtual con Ubuntu 24.04 LTS.

A la máquina virtual se le asignaron recursos adecuados para desarrollo, incluyendo memoria RAM, procesador y espacio en disco suficiente para ejecutar servicios de backend.



##  Configuración de red

Inicialmente la máquina virtual estaba configurada en modo NAT, lo que impedía el acceso desde el host.

Se cambió la configuración a modo "Adaptador Puente (Bridged)", lo que permitió que la máquina virtual obtuviera una dirección IP dentro de la red local.

Esto permitió que el servidor pudiera ser accedido desde el equipo host mediante dicha IP.

<img width="1299" height="1134" alt="image" src="https://github.com/user-attachments/assets/f13589bc-b738-458d-b281-d1fac726f3c3" />




##  Instalación del entorno de ejecución

Dentro de la máquina virtual se instaló Node.js y npm, lo que permitió ejecutar aplicaciones JavaScript del lado del servidor.



##  Ejecución del servidor

Se ejecutó una API REST construida con el módulo HTTP nativo de Node.js.

Se configuró el servidor para escuchar en todas las interfaces de red, lo cual es fundamental para permitir el acceso externo para esto se modifico un poco el archivo de server.js 

<img width="321" height="66" alt="image" src="https://github.com/user-attachments/assets/f9141586-e633-4713-9dab-bbc0180ead16" />



##  Verificación de funcionamiento

Se verificó que la API estuviera funcionando correctamente accediendo desde el navegador del host a través de la IP de la máquina virtual.

La respuesta obtenida confirmó que el servidor estaba activo y atendiendo solicitudes.



##  Configuración de acceso remoto

Se instaló y configuró el servicio SSH dentro de la máquina virtual, lo que permitió conectarse desde el host mediante terminal.

Se verificó que el servicio estuviera activo y escuchando en el puerto correspondiente.



##  Implementación de túnel SSH

Se configuró un túnel SSH que permite redirigir el tráfico desde el puerto local del host hacia el puerto del servidor en la máquina virtual.

Esto permite acceder a la API utilizando localhost en el equipo host, simulando un entorno local aunque el servidor se encuentre en otra máquina.

<img width="921" height="416" alt="image" src="https://github.com/user-attachments/assets/c847162f-b89b-4467-8abe-1cfce1b4e4ab" />

<img width="921" height="500" alt="image" src="https://github.com/user-attachments/assets/e92838bb-5a68-425a-bef5-0916d2bd774d" />







##  Pruebas de la API

Se realizaron pruebas de los endpoints de la API utilizando PowerShell.

Se validaron las operaciones principales:

- Registro de usuarios
  
  <img width="921" height="227" alt="image" src="https://github.com/user-attachments/assets/4892e882-85d5-4e80-84aa-cd9dfa3b0cd8" />

- Autenticación mediante login y obtencion de tareas

  <img width="921" height="512" alt="image" src="https://github.com/user-attachments/assets/d78f89ab-3130-4192-9a83-c5c950a0604b" />

- Creación de tareas

  <img width="921" height="259" alt="image" src="https://github.com/user-attachments/assets/73623eb0-939d-473d-8661-944ef39195c9" />

- Actualización de tareas
  
<img width="921" height="238" alt="image" src="https://github.com/user-attachments/assets/626a6bb8-d8a4-4b20-b0a5-89898e555338" />

- Eliminación de tareas

  <img width="921" height="521" alt="image" src="https://github.com/user-attachments/assets/3262a176-1aab-48aa-9672-f760bee16c07" />


Durante las pruebas se identificaron y solucionaron errores relacionados con el envío de datos en formato JSON.








##  Problemas encontrados

Durante el desarrollo se presentaron varios inconvenientes:

- La API no era accesible externamente debido a la configuración de red
- El servidor inicialmente escuchaba solo en localhost
- El servicio SSH no estaba instalado ni activo
- Problemas al enviar datos correctamente desde PowerShell

Todos estos problemas fueron solucionados mediante ajustes en configuración de red, servidor y comandos utilizados.


