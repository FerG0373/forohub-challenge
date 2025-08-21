# 🚀 ForoHub: API RESTful con Spring Boot
Este proyecto es una API RESTful desarrollada como parte del desafío de Alura Latam, diseñada para la gestión de tópicos en un foro. La API sigue un enfoque modular, implementando buenas prácticas de seguridad y persistencia de datos.

## ✨ Funcionalidades
La API expone los siguientes endpoints para la gestión de tópicos:
- POST /topicos: Permite registrar un nuevo tópico.
  - Validación de campos obligatorios.
  - No permite tópicos duplicados (mismo título y mensaje).
- GET /topicos: Devuelve un listado paginado de todos los tópicos.
  - Permite paginación y ordenación por fecha de creación.
- GET /topicos/{id}: Muestra los detalles de un tópico específico.
  - Devuelve un error 404 si el tópico no existe.
- PUT /topicos/{id}: Actualiza la información de un tópico.
  - El ID del tópico se recibe en la URL.
  - Devuelve un error 404 si el tópico no existe.
- DELETE /topicos/{id}: Realiza una eliminación lógica de un tópico.
  -El tópico se marca como inactivo en la base de datos, no se elimina físicamente.
  - Devuelve un error 404 si el tópico no existe.

 ## 🔐 Autenticación y Seguridad
La API está protegida con Spring Security y un mecanismo de autenticación con JWT (JSON Web Token).
  - POST /login: Permite a los usuarios autenticarse con su login y password para obtener un token JWT.
  - Control de Acceso: Todos los demás endpoints (/topicos) requieren un token JWT válido en el encabezado de la solicitud para ser accedidos.

## 🛠️ Tecnologías Clave
  - Java 17: El lenguaje de programación utilizado.
  - Spring Boot 3: Para el desarrollo rápido de la API.
  - Spring Data JPA: Para la persistencia de datos en la base de datos MySQL.
  - Spring Security: Para la autenticación, autorización y protección de la API.
  - JWT: Para la generación y validación de tokens de seguridad.
  - Flyway: Para la gestión de migraciones de la base de datos.
  - MySQL: Base de datos relacional para el almacenamiento de datos.
  - Lombok: Para reducir la verbosidad del código.

## ⚙️ Cómo ejecutar el proyecto
  - Clonar el repositorio.
  - Configura tus credenciales de base de datos MySQL en el archivo application.properties.
  - Ejecuta la clase ForohubChallengeApplication desde tu IDE.
  - Dado que este proyecto no incluye una interfaz de usuario, se recomienda utilizar una herramienta como Insomnia o Postman para enviar las solicitudes HTTP y probar los endpoints de la API.
