import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManejadorArchivo {

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
                // System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        }
    }

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