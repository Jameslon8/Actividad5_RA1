import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Gestor {

    public static ArrayList<Videojuego> carga(String ruta) {

        //Se mete el array de la clase Videojuego para que vaya recoga todos los datos
        ArrayList<Videojuego> videojuegos = new ArrayList<>();
        Path fichero = Path.of(ruta);

        // Se comprueba si el fichero existe
        if (!Files.exists(fichero)) {
            System.out.println("No existe");
            return videojuegos;
        }

        //Se abre el buffered reader
        try (BufferedReader lector = Files.newBufferedReader(fichero, StandardCharsets.UTF_8)) {

            //lee linea del archivo
            lector.readLine();

            String linea;
            int numeroLinea = 1;
            int incorrectos = 0;

            // se lee cada linea del archivo hasta que no queden mas
            while ((linea = lector.readLine()) != null) {
                numeroLinea++;

                // Se divide la linea en ,
                String[] datos = linea.split(",", -1);

                // detecta si la linea contiene los 7 campos
                if (datos.length != 7) {
                    System.out.println(numeroLinea + " de 7 campos");
                    incorrectos++;
                    continue;
                }

                // se carga el array con los datos de los campos
                try {
                    int id = Integer.parseInt(datos[0].trim());
                    String titulo = datos[1].trim();
                    String plataforma = datos[2].trim();
                    String genero = datos[3].trim();
                    double precio = Double.parseDouble(datos[4].trim());
                    int stock = Integer.parseInt(datos[5].trim());
                    String codigoProveedor = datos[6].trim();

                    Videojuego juego = new Videojuego(
                            id,
                            titulo,
                            plataforma,
                            genero,
                            precio,
                            stock,
                            codigoProveedor
                    );

                    videojuegos.add(juego);
                } catch (NumberFormatException e) {
                    System.out.println("Línea " + numeroLinea + ": el id, precio o stock no es un número válido.");
                    incorrectos++;
                }
            }
            System.out.println("Videojuegos cargados: " + videojuegos.size());
            System.out.println("Registros incorrectos: " + incorrectos);

        } catch (IOException e) {
            System.out.println("No se ha podido completar la lectura: " + e.getMessage());
        }
        return videojuegos;
    }

    public static void exportarCSV(ArrayList<Videojuego> videojuegos) {

        Path fichero = Path.of("videojuegos_exportados.csv");

        // abrimos el Buffered
        try (BufferedWriter escritor = Files.newBufferedWriter(fichero, StandardCharsets.UTF_8)) {

            // se escribe la primera linea de los campos
            escritor.write("id,titulo,plataforma,genero,precio,stock,codigoProveedor");
            escritor.newLine();

            // bucle para ir metiendo los datos de cada juego linea por linea
            for (int i = 0; i < videojuegos.size(); i++) {

                Videojuego juego = videojuegos.get(i);

                String proveedor = juego.getCodigoProveedor();

                if (proveedor == null) {
                    proveedor = "";
                }

                escritor.write(juego.getId() + ","
                                + juego.getTitulo() + ","
                                + juego.getPlataforma() + ","
                                + juego.getGenero() + ","
                                + juego.getPrecio() + ","
                                + juego.getStock() + ","
                                + proveedor);

                escritor.newLine();
            }

            System.out.println("Catálogo exportado a videojuegos_exportados.csv");

        } catch (IOException e) {
            System.out.println("No se ha podido exportar el CSV: " + e.getMessage());
        }
    }
}