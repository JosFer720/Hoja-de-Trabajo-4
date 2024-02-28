import java.util.ArrayList;
public class ArrayListQueue<T> implements IQueue<T> {
    ArrayList<T> info=null;

    public ArrayListQueue(){
        info=new ArrayList<T>();
    }

    public T first(){
        if (info.size()>0){
        return info.get(0);
        }
        return null;
    }

    public void enqueue(T value){
        info.add(value);
    }

    public T dequeue(){
        return info.remove(info.size() - 1);
    }

    public boolean isEmpty(){
        return (info.size() == 0);
    }

}
