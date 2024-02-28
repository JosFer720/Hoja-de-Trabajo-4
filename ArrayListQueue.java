import java.util.ArrayList;

/**
 * Implementación de la interfaz {@code IQueue} utilizando un ArrayList de la API de Java.
 *
 * @param <T> el tipo de elementos almacenados en la cola
 */
public class ArrayListQueue<T> implements IQueue<T> {
    ArrayList<T> info=null;

    /**
     * Crea una nueva instancia de la clase {@code ArrayListQueue}.
     */
    public ArrayListQueue(){
        info=new ArrayList<T>();
    }

    /**
     * Obtiene el primer elemento de la cola sin eliminarlo.
     *
     * @return el primer elemento de la cola, o {@code null} si la cola está vacía
     */
    public T first(){
        if (info.size()>0){
        return info.get(0);
        }
        return null;
    }

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param value el elemento a agregar
     */
    public void enqueue(T value){
        info.add(value);
    }

    /**
     * Elimina y devuelve el primer elemento de la cola.
     *
     * @return el primer elemento de la cola, o {@code null} si la cola está vacía
     */
    public T dequeue(){
        return info.remove(info.size() - 1);
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return {@code true} si la cola está vacía, {@code false} de lo contrario
     */
    public boolean isEmpty(){
        return (info.size() == 0);
    }

}