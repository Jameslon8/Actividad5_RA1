# Actividad5_RA1
## Descripción:
Aplicación Java para intercambiar un catálogo de videojuegos entre CSV y XML.
## Autor:
Tu nombre y que el trabajo se realiza individualmente.
## Requisitos:
Java con Maven, XML y JAXB.
Para poder usar JAXB haría falta meter estas dependencias en el pom.xml

/*<dependencies>
        <dependency>
            <groupId>jakarta.xml.bind</groupId>
            <artifactId>jakarta.xml.bind-api</artifactId>
            <version>4.0.2</version>
        </dependency>
        <dependency>
            <groupId>com.sun.xml.bind</groupId>
            <artifactId>jaxb-impl</artifactId>
            <version>4.0.5</version>
            <scope>runtime</scope>
        </dependency>
</dependencies>*/
    
## Estructura:
SRC:
- Aplicación: Menú principal donde se llevaran acabo todas las funciones del programa
        1. Cargar catálogo desde CSV
        2. Mostrar catálogo
        3. Exportar catálogo a XML
        4. Cargar catálogo desde XML
        5. Exportar catálogo a CSV
        6. Buscar videojuego
        7. Información de ficheros
- Catalogo: El elemento principal a la hora de hacer el XML. Catalogo englobara todo los atributos de videojuego.
- Gestor: Para cargar y exportar los archivos csv
- GestorXML: Para cargar y exportar los archivos xml
- Videojuego: Los atributos de la clase videojuego
## Cómo ejecutarlo:
Para ejecutarlo seria en Aplicación con cualquiera de las opciones:
1. Cargar catálogo desde CSV.
   
## Funcionalidades:
Qué opciones están implementadas y cuáles están pendientes.
## Decisiones técnicas:
Cómo lees el CSV, qué anotaciones JAXB utilizas y por qué excluyes codigoProveedor del XML.
## Errores gestionados:
Qué ocurre si falta un archivo o hay datos incorrectos.
## Pruebas:
Cargar correctamente el CSV y mostrar catalogo:
Aquí se puede ver como al cargar el CSV, se cargan todos bien, pudiendolos ver en el catálogo a continuación:
<img width="1797" height="873" alt="image" src="https://github.com/user-attachments/assets/7f080433-aa3a-4c77-b130-f5ddba2cd76a" />
<img width="1821" height="908" alt="image" src="https://github.com/user-attachments/assets/4ae88140-5894-4787-8c16-bd8fbf2a2955" />
