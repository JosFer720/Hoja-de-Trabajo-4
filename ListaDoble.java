/**
 * Implementación de una lista doble que cumple con la interfaz de una lista.
 * @param <T> El tipo de elementos que contendrá la lista.
 */
public class ListaDoble<T> implements IList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;

    /**
     * Remueve el primer nodo de la lista.
     */
    public void removeFirst() {
        if (head != null) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
        }
    }

    /**
     * Obtiene el primer elemento de la lista.
     * @return El primer elemento de la lista, o null si la lista está vacía.
     */
    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    /**
     * Agrega un nuevo elemento al inicio de la lista.
     * @param value El valor del elemento a agregar.
     */
    public void addFirst(T value) {
        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false de lo contrario.
     */
    public boolean isEmpty() {
        return (head == null);
    }
}
