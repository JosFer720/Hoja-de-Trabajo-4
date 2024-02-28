public class ListaDoble<T> implements IList<T>{
    public Node<T> head =null;
    public Node<T> tail =null;

    public void removeFirst(){
        if (head !=null){
            if (head == tail){
                head=tail= null;
            }else{
                head = head.next;
        }
    }
    }

    public T getFirst() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<T>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
}
