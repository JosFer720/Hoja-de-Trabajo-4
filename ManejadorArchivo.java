/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que maneja la lectura de un archivo de texto y procesa sus líneas.
 */
public class ManejadorArchivo {

    /**
     * Método principal que lee un archivo de texto y muestra sus líneas en la consola.
     *
     * @param args argumentos de la línea de comandos (no utilizado)
     */
    public static void main(String[] args) {
        String archivo = "ejemplo.txt";
        try {
            ArrayList<ArrayList<String>> elementos = abrirArchivo(archivo);
            for (int i = 0; i < elementos.size(); i++) {
                System.out.println("Linea " + (i + 1));
                ArrayList<String> lineaElementos = elementos.get(i);
                for (String elemento : lineaElementos) {
                    System.out.print(elemento + " - ");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        }
    }

    /**
     * Abre un archivo de texto y procesa sus líneas en una lista de listas de cadenas.
     *
     * @param archivo el nombre del archivo a abrir
     * @return una lista de listas de cadenas que representan los elementos de cada línea del archivo
     * @throws IOException si ocurre un error al abrir o leer el archivo
     */
    public static ArrayList<ArrayList<String>> abrirArchivo(String archivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String linea;
        ArrayList<ArrayList<String>> elementos = new ArrayList<>();
        while ((linea = reader.readLine()) != null) {
            ArrayList<String> lineaElementos = new ArrayList<>();
            String[] partes = linea.split(" ");
            for (String parte : partes) {
                if (!parte.isEmpty()) {
                    lineaElementos.add(parte);
                }
            }
            elementos.add(lineaElementos);
        }
        reader.close();
        return elementos;
    }
}