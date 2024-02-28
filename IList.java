/**
 * Interfaz que define el comportamiento de una lista.
 * @param <T> El tipo de elementos que contendrá la lista.
 */
public interface IList<T> {
    
    /**
     * Elimina el primer elemento de la lista.
     */
    public void removeFirst();

    /**
     * Obtiene el primer elemento de la lista.
     * @return El primer elemento de la lista.
     */
    public T getFirst();

    /**
     * Agrega un elemento al principio de la lista.
     * @param value El elemento a agregar.
     */
    public void addFirst(T value);

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false de lo contrario.
     */
    public boolean isEmpty();
}