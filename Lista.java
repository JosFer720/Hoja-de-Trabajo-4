public class Lista<T> implements IQueue<T>{
    IList<T> list=null;

    public Lista(String tipo){
        FactoryLista<T> lst = new FactoryLista<>();
        list=lst.crearLista(tipo);
    }

    public T first(){
        if (isEmpty()){
            System.out.println("Esta vacio");
        }
        return list.getFirst();
    }

    public void enqueue(T value){
        list.addFirst(value);

    }

    public T dequeue(){
        if (isEmpty()){
            System.out.println("Esta vacio");
        }
        T result = list.getFirst();
        list.removeFirst();
        return result;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }
}