# Proyecto Spring Boot con Hibernate y Oracle

## Descripción
Este proyecto es una aplicación basada en Spring Boot que utiliza Hibernate como proveedor de JPA y se conecta a una base de datos Oracle. 

## Requisitos
- Java 11 o superior
- Maven 3.6.0 o superior
- Oracle Database (opcional para pruebas iniciales)

## Configuración del Proyecto

### Archivo `pom.xml`
Asegúrate de tener las siguientes dependencias en tu archivo `pom.xml`:

```xml
<dependencies>
    <!-- Dependencias de Spring Boot -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Driver JDBC para Oracle -->
    <dependency>
        <groupId>com.oracle.database.jdbc</groupId>
        <artifactId>ojdbc8</artifactId>
        <scope>runtime</scope>
    </dependency>

    <!-- Hibernate -->
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.5.2.Final</version>
    </dependency>

    <!-- Otros -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```
