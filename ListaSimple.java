public class ListaSimple<T> implements IList<T> {
    public Node<T> head= null;

    public boolean isEmpty() {
        return (head == null);
    }

    public T getFirst(){
        if (head == null){
            return null;
        }
        return head.getValue();
    }

    public void removeFirst() {
        if (head == null){
            head = head.getNext();
        }
    }

    public void addFirst(T value){
        Node<T> newNode = new Node<T>(value);
        if (head == null){
            head = newNode;
        }else{
            newNode.setNext(head);
            head = newNode;
        }
    }
}
