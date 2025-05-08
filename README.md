# 🏛️ App Municipal – Backend

Este es el backend de la aplicación mobile dedicada a municipios. Fue desarrollado con **Spring Boot** y utiliza **SQL Server** como sistema de base de datos. Este backend provee las APIs necesarias para gestionar publicaciones, servicios, denuncias e inspecciones relacionadas con la comunidad del municipio.

## ⚙️ Funcionalidades principales

- 📢 Gestión de **publicaciones comerciales** locales
- 🛠️ Registro y visualización de **servicios/oficios** ofrecidos por los ciudadanos
- 🚨 **Denuncias** con seguimiento por parte de inspectores
- 🔄 Cambio de **estado de denuncia** durante el proceso de inspección
- 🛠️ Registro e inicio de sesión de usuarios dependiendo a que pertenece: Un usuario con cuenta corriente o un usuario nivel inspector
- 🔐 Autenticación y autorización con JWT

## 🛠️ Tecnologías utilizadas

- **Framework:** Spring Boot
- **Base de datos:** SQL Server
- **Seguridad:** Spring Security + JWT
- **ORM:** Spring Data JPA (Hibernate)

## 🚀 Instalación

1. Cloná el repositorio:

```bash
git clone https://github.com/tuusuario/app-municipal-backend.git
cd app-municipal-backend
```

2. Configurá la base de datos en el archivo `application.properties`:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=municipal_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=tu_clave_secreta
```

3. Ejecutá el proyecto con Maven:

```bash
./mvnw spring-boot:run
```

## 🔗 Frontend del proyecto

El frontend de esta aplicación se encuentra disponible en el siguiente repositorio:  
👉 [Ver repositorio frontend](https://github.com/MontiNahuel/TPO-DA1-Front-End/)
