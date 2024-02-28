/**
 * Implementación de la interfaz {@code IQueue} utilizando un vector de la API de Java.
 *
 * @param <T> el tipo de elementos almacenados en la cola
 */
public class Vector<T> implements IQueue<T> {
    private java.util.Vector<T> value;

    /**
     * Crea una nueva instancia de la clase {@code Vector}.
     */
    public Vector() {
        value = new java.util.Vector<T>();
    }

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param value el elemento a agregar
     */
    public void enqueue(T value) {
        this.value.add(value);
    }

    /**
     * Elimina y devuelve el primer elemento de la cola.
     *
     * @return el primer elemento de la cola, o {@code null} si la cola está vacía
     */
    public T dequeue() {
        if (!isEmpty()) {
            return value.remove(0);
        }
        return null;
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return {@code true} si la cola está vacía, {@code false} de lo contrario
     */
    public boolean isEmpty() {
        return value.isEmpty();
    }

    /**
     * Obtiene el primer elemento de la cola sin eliminarlo.
     *
     * @return el primer elemento de la cola, o {@code null} si la cola está vacía
     */
    public T first() {
        if (!isEmpty()) {
            return value.elementAt(0);
        }
        return null;
    }
}