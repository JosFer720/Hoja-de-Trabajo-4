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

            System.out.println("Seleccione la estructura de datos a utilizar:");
            System.out.println("1. Listas");
            System.out.println("2. Array/Vector");

            int opcionEstructura = leerEntero();

            switch (opcionEstructura) {
                case 1:
                    procesarLista(scanner, writer);
                    break;
                case 2:
                    procesarArrayVector(scanner, writer);
                    break;
                default:
                    System.out.println("Opción no válida. Utilizando listas por defecto.");
                    procesarLista(scanner, writer);
            }

            scanner.close();
            writer.close();
            System.out.println("Los resultados se han guardado en el archivo resultado.txt.");
        } catch (IOException e) {
            System.out.println("Error al procesar los archivos: " + e.getMessage());
        }
    }

    private static int leerEntero() {
        Scanner userInputScanner = new Scanner(System.in);
        int opcion = 0;
        try {
            opcion = userInputScanner.nextInt();
        } catch (Exception e) {
            System.out.println("Entrada inválida. Se esperaba un número entero.");
        } finally {
            userInputScanner.close();
        }
        return opcion;
    }

    private static void procesarLista(Scanner scanner, FileWriter writer) throws IOException {
        System.out.println("Seleccione el tipo de lista:");
        System.out.println("1. Lista Simple");
        System.out.println("2. Lista Doble");

        int opcionLista = leerEntero();

        switch (opcionLista) {
            case 1:
                IList<Double> listaSimple = crearListaSimple();
                procesarDatos(scanner, writer, listaSimple);
                break;
            case 2:
                IList<Double> listaDoble = crearListaDoble();
                procesarDatos(scanner, writer, listaDoble);
                break;
            default:
                System.out.println("Opción no válida. Utilizando lista simple por defecto.");
                listaSimple = crearListaSimple();
                procesarDatos(scanner, writer, listaSimple);
        }
    }

    private static void procesarArrayVector(Scanner scanner, FileWriter writer) throws IOException {
        System.out.println("Seleccione la estructura de datos:");
        System.out.println("1. Array");
        System.out.println("2. Vector");

        int opcionEstructura = leerEntero();

        switch (opcionEstructura) {
            case 1:
                IQueue<Double> array = crearArray();
                procesarDatos(scanner, writer, array);
                break;
            case 2:
                IQueue<Double> vector = crearVector();
                procesarDatos(scanner, writer, vector);
                break;
            default:
                System.out.println("Opción no válida. Utilizando array por defecto.");
                array = crearArray();
                procesarDatos(scanner, writer, array);
        }
    }

    private static void procesarDatos(Scanner scanner, FileWriter writer, IList<Double> estructuraDatos) throws IOException {
        while (scanner.hasNextLine()) {
            String infix = scanner.nextLine();
            String postfix = InfixToPostfix.infixToPostfix(infix);
            if (postfix.isEmpty()) {
                continue; 
            }
            double resultado = realizarOperacion(postfix, new Calculadora(), estructuraDatos);
            writer.write("Entrada: " + infix + "\n");
            writer.write("Postfix: " + postfix + "\n");
            writer.write("Resultado: " + resultado + "\n\n");
        }
    }

    private static void procesarDatos(Scanner scanner, FileWriter writer, IQueue<Double> estructuraDatos) throws IOException {
        while (scanner.hasNextLine()) {
            String infix = scanner.nextLine();
            String postfix = InfixToPostfix.infixToPostfix(infix);
            if (postfix.isEmpty()) {
                continue; 
            }
            double resultado = realizarOperacion(postfix, new Calculadora(), estructuraDatos);
            writer.write("Entrada: " + infix + "\n");
            writer.write("Postfix: " + postfix + "\n");
            writer.write("Resultado: " + resultado + "\n\n");
        }
    }

    private static double realizarOperacion(String postfix, ICalculadora calculadora, IList<Double> estructuraDatos) {
        Stack<Double> pila = new Stack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (esNumero(token)) {
                estructuraDatos.addFirst(Double.parseDouble(token));
            } else if (esOperando(token)) {
                double op2 = estructuraDatos.getFirst();
                estructuraDatos.removeFirst();
                double op1 = estructuraDatos.getFirst();
                estructuraDatos.removeFirst();
                double resultado = operar(op1, op2, token, calculadora);
                pila.push(resultado);
            } else {
                System.out.println("Elemento no reconocido: " + token);
            }
        }

        if (!pila.isEmpty()) {
            return pila.pop();
        } else {
            System.out.println("La pila está vacía. No se pudo realizar la operación.");
            return Double.NaN;
        }
    }

    private static double realizarOperacion(String postfix, ICalculadora calculadora, IQueue<Double> estructuraDatos) {
        Stack<Double> pila = new Stack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (esNumero(token)) {
                estructuraDatos.enqueue(Double.parseDouble(token));
            } else if (esOperando(token)) {
                double op2 = estructuraDatos.dequeue();
                double op1 = estructuraDatos.dequeue();
                double resultado = operar(op1, op2, token, calculadora);
                pila.push(resultado);
            } else {
                System.out.println("Elemento no reconocido: " + token);
            }
        }

        if (!pila.isEmpty()) {
            return pila.pop();
        } else {
            System.out.println("La pila está vacía. No se pudo realizar la operación.");
            return Double.NaN;
        }
    }


    private static boolean esNumero(String elemento) {
        try {
            Double.parseDouble(elemento);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean esOperando(String elemento) {
        return elemento.matches("[+\\-*/^%]");
    }

    private static double operar(double op1, double op2, String operando, ICalculadora calculadora) {
        switch (operando) {
            case "+":
                return calculadora.sumar(op1, op2);
            case "-":
                return calculadora.restar(op1, op2);
            case "*":
                return calculadora.multiplicar(op1, op2);
            case "/":
                return calculadora.dividir(op1, op2);
            default:
                System.out.println("Operando no reconocido: " + operando);
                return Double.NaN;
        }
    }


    private static IList<Double> crearListaSimple() {
        System.out.println("Utilizando lista simple...");
        FactoryLista<Double> factoryLista = new FactoryLista<>();
        return factoryLista.crearLista("simple");
    }

    private static IList<Double> crearListaDoble() {
        System.out.println("Utilizando lista doble...");
        FactoryLista<Double> factoryLista = new FactoryLista<>();
        return factoryLista.crearLista("doble");
    }

    private static IQueue<Double> crearArray() {
        System.out.println("Utilizando array...");
        FactoryArray<Double> factoryArray = new FactoryArray<>();
        return factoryArray.createStructure("array");
    }

    private static IQueue<Double> crearVector() {
        System.out.println("Utilizando vector...");
        FactoryArray<Double> factoryArray = new FactoryArray<>();
        return factoryArray.createStructure("vector");
    }
}
