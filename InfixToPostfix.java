/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 */

import java.util.Stack;

/**
 * Clase para convertir una expresión en notación infija a notación posfija (postfija).
 */
public class InfixToPostfix {
    
    /**
     * Convierte una expresión en notación infija a notación posfija.
     * @param infix Expresión en notación infija.
     * @return Expresión en notación posfija.
     */
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        stack.push('#');
        
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == '^') {
                stack.push(ch);
            } else if (ch == ')') {
                while (stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        
        while (stack.peek() != '#') {
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
    }
    
    /**
     * Devuelve la precedencia de un operador.
     * @param operator El operador.
     * @return La precedencia del operador.
     */
    private static int precedence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }
}
