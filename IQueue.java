/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 * Interfaz que define las operaciones básicas de una cola.
 * @param <T> El tipo de elementos que contendrá la cola.
 */
public interface IQueue<T> {

    /**
     * Agrega un elemento al final de la cola.
     * @param value El elemento a agregar.
     */
    public void enqueue(T value);

    /**
     * Elimina y devuelve el elemento del frente de la cola.
     * @return El elemento del frente de la cola, o null si la cola está vacía.
     */
    public T dequeue();

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola está vacía, false de lo contrario.
     */
    public boolean isEmpty();

    /**
     * Devuelve el elemento del frente de la cola sin eliminarlo.
     * @return El elemento del frente de la cola, o null si la cola está vacía.
     */
    public T first();
}
