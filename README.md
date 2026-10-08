# Actividad5_RA1
## Descripción:
Aplicación Java para intercambiar un catálogo de videojuegos entre CSV y XML.
## Autor:
Tu nombre y que el trabajo se realiza individualmente.
## Requisitos:
Java con Maven, XML y JAXB.
Para poder usar JAXB haría falta meter estas dependencias en el pom.xml

<dependencies>
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
</dependencies>
    
## Estructura:
Qué hace cada clase: Videojuego, GestorCSV, Main…
## Cómo ejecutarlo:
Dónde colocar el CSV y cómo iniciar el programa.
## Funcionalidades:
Qué opciones están implementadas y cuáles están pendientes.
## Decisiones técnicas:
Cómo lees el CSV, qué anotaciones JAXB utilizas y por qué excluyes codigoProveedor del XML.
## Errores gestionados:
Qué ocurre si falta un archivo o hay datos incorrectos.
## Pruebas:
Qué has probado, qué esperabas y qué ocurrió realmente.
