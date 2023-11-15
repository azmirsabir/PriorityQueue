package queue;
public class PriorityQueue<T>{
    private Node<T> head;
    private Node<T> end;

    //the method for inserting and order the elements
    public void insert(T value){
        Node<T> newNode = new Node<>(value);
        if (isEmpty() || compare(value, head.getValue()) <= 0) {
            newNode.setNext(head);
            head = newNode;
            if (isEmpty()) {
                end = newNode;
            }
        } else {
            Node<T> current = head;
            while (current.next() != null && compare(value, current.next().getValue()) > 0) {
                current = current.next();
            }
            newNode.setNext(current.next());
            current.setNext(newNode);
            if (newNode.next() == null) {
                end = newNode;
            }
        }
    }
    //remove first element
    public void remove() {
        if(head==end) {
            end=null;
        }else{
            head=this.head.next();
        }
    }

    //size of queue
    public int size(){
        int counter=0;
        for (Node<T>cur=head;cur!=null;cur=cur.next()){
            counter++;
        }
        return counter;
    }

    //it returns the head element
    public T head(){
        return head.getValue();
    }

    //it returns the last element
    public T end(){
        return end.getValue();
    }

    //it clears the queue
    public void clear(){
        head=null;
        end=null;
    }

    //checks either the queue is empty or not
    public boolean isEmpty(){
        return head==null;
    }

    //it prints the whole queue
    public String printQueue() {

        StringBuilder res = new StringBuilder();

        for (Node<T> cur=head;cur!=null;cur=cur.next()){
            res.append(cur.getValue());
            res.append("\n");
        }
        return res.toString();
    }

    //the method for comparing the elements
    private int compare(T value1, T value2) {
        if (value1 instanceof Comparable && value2 instanceof Comparable) {
            return ((Comparable<T>) value1).compareTo(value2);
        } else {
            throw new IllegalArgumentException("Elements are not comparable");
        }
    }
}
