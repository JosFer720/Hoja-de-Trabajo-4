/**
 * Implementación de una lista simple que implementa la interfaz IList.
 * @param <T> Tipo de elementos almacenados en la lista.
 */
public class ListaSimple<T> implements IList<T> {
    /**
     * Referencia al primer nodo de la lista.
     */
    public Node<T> head = null;

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false de lo contrario.
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Obtiene el primer elemento de la lista.
     * @return El primer elemento de la lista, null si la lista está vacía.
     */
    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.getValue();
    }

    /**
     * Remueve el primer elemento de la lista.
     */
    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
        }
    }

    /**
     * Agrega un nuevo elemento al principio de la lista.
     * @param value El valor a agregar a la lista.
     */
    public void addFirst(T value) {
        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }
}
