import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Clase principal que interactúa con el usuario y realiza operaciones utilizando un archivo de entrada.
 */
public class Principal {

    /**
     * Método principal que inicia la ejecución del programa.
     * 
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String archivo = "ejemplo.txt";
        Stack<Double> pila = new Stack<>();

        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Realizar operaciones desde archivo");
            System.out.println("2. Salir");
            System.out.print("Ingrese su opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarOperacionesDesdeArchivo(archivo, pila);
                    mostrarResultadoActual(pila);
                    break;
                case 2:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    /**
     * Realiza operaciones utilizando los datos contenidos en un archivo.
     * 
     * @param archivo El nombre del archivo que contiene los datos para las operaciones.
     * @param pila    La pila utilizada para realizar las operaciones.
     */
    private static void realizarOperacionesDesdeArchivo(String archivo, Stack<Double> pila) {
        try {
            ArrayList<ArrayList<String>> elementos = ManejadorArchivo.abrirArchivo(archivo);

            for (ArrayList<String> lineaElementos : elementos) {
                for (String elemento : lineaElementos) {
                    if (esNumero(elemento)) {
                        pila.push(Double.parseDouble(elemento));
                    } else if (esOperando(elemento)) {
                        double op2 = pila.pop();
                        double op1 = pila.pop();
                        double resultado = operar(op1, op2, elemento);
                        pila.push(resultado);
                    } else {
                        System.out.println("Elemento no reconocido: " + elemento);
                    }
                }
            }

            System.out.println("Operaciones realizadas desde el archivo.");

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo" + e.getMessage());
        }
    }

    /**
     * Muestra el resultado actual en la pila.
     * 
     * @param pila La pila utilizada para almacenar resultados.
     */
    private static void mostrarResultadoActual(Stack<Double> pila) {
        if (!pila.isEmpty()) {
            System.out.println("Resultados actuales en la pila:");
    
            // Mientras la pila no esté vacía, imprimir resultados
            while (!pila.isEmpty()) {
                System.out.println(pila.pop());
            }
    
        } else {
            System.out.println("La pila está vacía. Realice operaciones primero.");
        }
    }    

    /**
     * Verifica si un elemento es un número.
     * 
     * @param elemento El elemento a verificar.
     * @return true si el elemento es un número, false de lo contrario.
     */
    private static boolean esNumero(String elemento) {
        try {
            Double.parseDouble(elemento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Verifica si un elemento es un operando válido.
     * 
     * @param elemento El elemento a verificar.
     * @return true si el elemento es un operando válido, false de lo contrario.
     */
    private static boolean esOperando(String elemento) {
        return elemento.matches("[+\\-*/]");
    }
    
    /**
     * Realiza una operación aritmética específica.
     * 
     * @param op1      El primer operando.
     * @param op2      El segundo operando.
     * @param operando El operando que indica la operación a realizar.
     * @return El resultado de la operación.
     */
    private static double operar(double op1, double op2, String operando) {
        switch (operando) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                if (op2 != 0) {
                    return op1 / op2;
                } else {
                    System.out.println("Error: División por cero");
                    return 0;
                }
            default:
                System.out.println("Operando no reconocido: " + operando);
                return 0;
        }
    }
}