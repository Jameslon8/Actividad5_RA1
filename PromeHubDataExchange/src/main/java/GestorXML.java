import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;

public class GestorXML {
    public static void exportarXML(ArrayList<Videojuego> videojuegos) {

        try {
            Catalogo catalogoXML = new Catalogo(videojuegos);

            // le damos el contexto de todas los atributos
            JAXBContext contexto = JAXBContext.newInstance(Catalogo.class);

            // convierte de java a xml
            Marshaller exportador = contexto.createMarshaller();

            // permite que se vea ordenado y limpio el xml
            exportador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // exporta todo lo de catalogo a catalogo.xml
            exportador.marshal(catalogoXML, new File("catalogo.xml"));

            System.out.println("Catálogo exportado a catalogo.xml.");

        }catch (JAXBException e){
        System.out.println("No se ha podido exportar el XML: " + e.getMessage());
    }
    }

    public static ArrayList<Videojuego> cargarXML() {

        File fichero = new File("catalogo.xml");

        if (!fichero.exists()) {
            System.out.println("No existe el archivo catalogo.xml");
            return null;
        }

        try {
            JAXBContext contexto = JAXBContext.newInstance(Catalogo.class);

            // convierte de xml a java
            Unmarshaller importador = contexto.createUnmarshaller();

            // importa todo lo del xml al arraylist
            Catalogo catalogoXML = (Catalogo) importador.unmarshal(fichero);

            System.out.println("Videojuegos cargados desde XML: " + catalogoXML.getVideojuegos().size());

            return catalogoXML.getVideojuegos();

        } catch (JAXBException e) {
            System.out.println("No se ha podido cargar el XML: " + e.getMessage());
            return null;
        }
    }
}
