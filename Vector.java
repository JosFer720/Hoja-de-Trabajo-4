public class Vector<T> implements IQueue<T> {
    private java.util.Vector<T> value;

    public Vector() {
        value = new java.util.Vector<T>();
    }

    public void enqueue(T value) {
        this.value.add(value);
    }

    public T dequeue() {
        if (!isEmpty()) {
            return value.remove(0);
        }
        return null;
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }

    public T first() {
        if (!isEmpty()) {
            return value.elementAt(0);
        }
        return null;
    }
}