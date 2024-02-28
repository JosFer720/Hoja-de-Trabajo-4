/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 * Implementación de una lista que cumple con la interfaz de una cola.
 * @param <T> El tipo de elementos que contendrá la lista.
 */
public class Lista<T> implements IQueue<T> {
    IList<T> list = null;

    /**
     * Constructor de la lista.
     * @param tipo El tipo de lista a crear.
     */
    public Lista(String tipo) {
        FactoryLista<T> lst = new FactoryLista<>();
        list = lst.crearLista(tipo);
    }

    /**
     * Obtiene el primer elemento de la lista.
     * @return El primer elemento de la lista.
     */
    public T first() {
        if (isEmpty()) {
            System.out.println("La lista está vacía");
        }
        return list.getFirst();
    }

    /**
     * Agrega un elemento al final de la lista (enqueue).
     * @param value El valor del elemento a agregar.
     */
    public void enqueue(T value) {
        list.addFirst(value);
    }

    /**
     * Elimina y devuelve el primer elemento de la lista (dequeue).
     * @return El primer elemento de la lista.
     */
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("La lista está vacía");
        }
        T result = list.getFirst();
        list.removeFirst();
        return result;
    }

    /**
     * Verifica si la lista está vacía.
     * @return true si la lista está vacía, false de lo contrario.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
}