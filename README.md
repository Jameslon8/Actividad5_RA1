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
Generar el XML y comprobar que codigoProveedor no aparece en el XML.:
Con el catalogo cargado por el CSV se hará el XML en un nuevo archivo creado automatícenle sin codigoProveedeor y estructurado.
<img width="1811" height="925" alt="image" src="https://github.com/user-attachments/assets/a2edb89f-cdc5-421b-9f5a-3c71119ff5ce" />
<img width="1810" height="926" alt="image" src="https://github.com/user-attachments/assets/49c76a99-44f9-4943-94ce-35f517808306" />
Cargar nuevamente el XML:
Para cargarlo necesitaríamos ya tener el XML de antes y volvemos a iniciar la aplicación para que no tenga nada. A la hora de ver el catalogo mostrara todo menos el codigoProveedor que se muestra en null.
<img width="1816" height="927" alt="image" src="https://github.com/user-attachments/assets/a6ad5bbc-c850-4824-aa38-7f68aa8b99b3" />
<img width="1407" height="447" alt="image" src="https://github.com/user-attachments/assets/3b954810-0932-44fe-b387-d998789f0603" />
Generar un CSV a partir del XML:
Una vez cargados los datos del XML se pueden exportar a un fichero csv que tengamos con esos mismos datos. Eso si, no tendra el codigoProveedor.
<img width="1848" height="1015" alt="image" src="https://github.com/user-attachments/assets/605779e7-3bd1-4c4f-8592-c11823387699" />
<img width="1827" height="847" alt="image" src="https://github.com/user-attachments/assets/48969048-5c11-4939-b895-b9d81a7aadd9" />
Intentar cargar un fichero que no existe:
A la hora de descargar un fichero que no existe saldría, no existe
<img width="1826" height="945" alt="image" src="https://github.com/user-attachments/assets/79d8f87c-9867-45b0-b0e0-de730add9474" />
Introducir un registro CSV incorrecto y comprobar que la aplicación
gestiona el error:
Al poner campos incorrectos en el csv este no lo podrá cargar.
<img width="1835" height="942" alt="image" src="https://github.com/user-attachments/assets/0a0121f3-0bf1-4052-91a0-fb88872a8401" />
