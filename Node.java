/**
 * Clase que representa un nodo genérico utilizado en una estructura de datos.
 * @param <T> El tipo de elemento almacenado en el nodo.
 */
public class Node<T> {
    T value;
    Node<T> next;
    Node<T> prev;

    /**
     * Obtiene el valor almacenado en el nodo.
     * @return El valor almacenado en el nodo.
     */
    public T getValue() {
        return value;
    }

    /**
     * Obtiene el siguiente nodo en la secuencia.
     * @return El siguiente nodo en la secuencia.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Establece el valor del nodo.
     * @param newValue El nuevo valor a establecer en el nodo.
     */
    public void setValue(T newValue) {
        value = newValue;
    }

    /**
     * Establece el siguiente nodo en la secuencia.
     * @param n El siguiente nodo en la secuencia.
     */
    public void setNext(Node<T> n) {
        next = n;
    }

    /**
     * Constructor que inicializa un nuevo nodo con un valor específico.
     * @param val El valor a almacenar en el nodo.
     */
    public Node(T val) {
        value = val;
        next = null;
    }
}