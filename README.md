# Api Rick and Morty

## Descripción
Breve proyecto demo, dónde a través de un microservicio se obtiene unos datos de una API externa con REST Template, y se devuelve en la petición.

## Tecnologías Utilizadas
- Java 17
- Spring Boot 2.6.0
- Gradle

## Estructura del Proyecto
Se ha planteado el uso de una arquitectura hexagonal basada en componentes, pero por la simplicidad del proyecto se ha terminado desarrollando con las capas mínimas indispensables para su funcionamiento.

El proyecto está estructurado en las siguientes capas:

- **Controller**: Contiene las clases que manejan las solicitudes HTTP y gestionan las respuestas.

- **Service**: Contiene las clases de servicio que implementan la lógica de negocio de la aplicación.

- **Repository**: Contiene las clases que se encargan de la interacción con la base de datos. Las clases en esta capa se anotan con `@Repository`.

- **Model**: Define las entidades de datos y los objetos de transferencia de datos (DTO) utilizados en la aplicación.

- **Configuration**: Contiene configuraciones personalizadas de Spring, como configuraciones de bases de datos y configuraciones de seguridad.

- **Exception**: Contiene clases personalizadas de excepciones para manejar errores específicos de la aplicación.


## Uso del Proyecto
A continuación se describen las principales características y cómo utilizarlas.

### Endpoint
Se define un endpoint tipo GET, que devuelve unos determinados datos a través de un parámetro aportado en la cabecera.

### Seguridad
No se ha implementado ningún tipo de Bearer Token, CORS o protocolo OAUTH2 por la simplicidad de la demo.

## Documentación
No se ha implementado contrato SWAGGER (OpenAPI) ni plugin para documentación por la simplicidad de la demo.

## Plugins
Se ha añadido Lombok para reducir el código redundante (BoilerPlate), pero para que quede más legible el código se ha sustituido por los getters, setters, etc..., convencionales.

## Secrets
Se añade una única variable de entorno (url de API de Rick y Morty) como parámetro en el application.yml, por la simplicidad de la demo no se añade en ninguna plataforma de Secrets.

## Ejecución
Para levantar el servicio habrá que importar el proyecto en un editor (IntellIJ o STS) como proyecto GRADLE, construir el proyecto y ejecutarlo como aplicación Spring Boot.

Para levantarlo mediante comando, ya que está construido con Gradle, sustituiremos el "mvn spring-boot:run" por un "gradlew bootRun".

Si se quisiera levantar en un contenedor, sería tan sencillo como construir la imagen y correrla via consola o con cualquier editor gráfico (Podman Desktop, Docker Compose, Rancher, etc).
