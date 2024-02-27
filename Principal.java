import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        File inputFile = new File("ejemplo.txt");
        File outputFile = new File("resultado.txt");
        
        try {
            Scanner scanner = new Scanner(inputFile);
            FileWriter writer = new FileWriter(outputFile);
            
            while (scanner.hasNextLine()) {
                String infix = scanner.nextLine();
                String postfix = InfixToPostfix.infixToPostfix(infix);
                writer.write("Entrada: " + infix + "\n");
                writer.write("Salida: " + postfix + "\n");
                writer.write("Resultado: " + "\n\n");
            }
            
            scanner.close();
            writer.close();
            System.out.println("Los resultados se han guardado en el archivo resultado.txt.");
        } catch (IOException e) {
            System.out.println("Error al procesar los archivos: " + e.getMessage());
        }
    }
}