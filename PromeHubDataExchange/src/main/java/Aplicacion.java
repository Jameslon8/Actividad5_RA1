import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Videojuego> catalogo = new ArrayList<>();
        int opcion = 1;

        do{
            System.out.println("========================================");
            System.out.println("PROMEHUB DATA EXCHANGE");
            System.out.println("========================================");
            System.out.println("1. Cargar catálogo desde CSV\n" +
                    "2. Mostrar catálogo\n" +
                    "3. Exportar catálogo a XML\n" +
                    "4. Cargar catálogo desde XML\n" +
                    "5. Exportar catálogo a CSV\n" +
                    "6. Buscar videojuego\n" +
                    "7. Información de ficheros\n" +
                    "0. Salir\n");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    catalogo = Gestor.carga("videojuegos.csv");
                    break;
                case 2:
                    for (int i = 0; i < catalogo.size(); i++) {
                        System.out.println(catalogo.get(i));
                    }
                    break;
                case 3:
                    GestorXML.exportarXML(catalogo);
                    break;
                case 4:
                    ArrayList<Videojuego> listaXML = GestorXML.cargarXML();

                    if (listaXML != null) {
                        catalogo = listaXML;
                    }
                    break;
                case 5:
                    Gestor.exportarCSV(catalogo);
                    break;
                case 6:
                    if (catalogo.isEmpty()) {
                        System.out.println("No existen videojuegos.");
                    } else {
                        System.out.print("Introduce el ID del videojuego: ");
                        int busqueda = sc.nextInt();

                        boolean encontrado = false;

                        for (int i = 0; i < catalogo.size(); i++) {

                            Videojuego juego = catalogo.get(i);

                            if (juego.getId() == busqueda) {

                                System.out.println(juego);
                                encontrado = true;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("No se ha encontrado ningún videojuego.");
                        }
                    }

                    break;
                case 7:
                    String[] nombres = {
                            "videojuegos.csv",
                            "catalogo.xml",
                            "videojuegos_exportados.csv"
                    };

                    for (int i = 0; i < nombres.length; i++) {

                        File fichero = new File(nombres[i]);

                        System.out.println("\nArchivo: " + fichero.getName());
                        System.out.println("Ruta: " + fichero.getAbsolutePath());

                        if (fichero.exists()) {
                            System.out.println("Existe: sí");
                            System.out.println("Tamaño: " + fichero.length() + " bytes");
                        } else {
                            System.out.println("Existe: no");
                            System.out.println("Tamaño: no disponible");
                        }
                    }

                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        }while(opcion != 0);
    }
}
