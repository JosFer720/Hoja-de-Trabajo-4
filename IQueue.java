public interface IQueue<T> {

    public void enqueue(T value);

    public T dequeue();

    public boolean isEmpty();

    public T first();
}
