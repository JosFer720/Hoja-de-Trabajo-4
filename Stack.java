/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 * Clase que representa una pila genérica.
 * @param <T> El tipo de elementos que se almacenarán en la pila.
 */
public class Stack<T> {
    private Node<T> lastNode;
    private Node<T> firstNode;

    /**
     * Agrega un elemento a la pila.
     * @param value El valor del elemento a agregar.
     */
    public void push(T value) {
        if (lastNode == null) {
            lastNode = new Node<T>(value);
            firstNode = lastNode;
        } else {
            Node<T> current = new Node<T>(value);
            current.setNext(firstNode);
            firstNode = current;
        }
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     * @return El elemento eliminado, o null si la pila está vacía.
     */
    public T pop() {
        if (firstNode != null) {
            T value = firstNode.getValue();
            firstNode = firstNode.getNext();
            return value;
        }
        return null;
    }

    /**
     * Muestra el elemento en la cima de la pila sin eliminarlo.
     * @return El elemento en la cima de la pila, o null si la pila está vacía.
     */
    public T peek() {
        if (firstNode != null) {
            return firstNode.getValue();
        }
        return null;
    }

    /**
     * Verifica si la pila está vacía.
     * @return true si la pila está vacía, false de lo contrario.
     */
    public boolean isEmpty() {
        return firstNode == null;
    }
}