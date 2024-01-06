import queue.PriorityQueue;
public class MyApp {
    public static void main(String[] args) {
        PriorityQueue<String> queue=new PriorityQueue<>();
        queue.insert("Azmir");//insert
        queue.insert("Handren");
        queue.insert("Sleman");
        queue.insert("Aram");
        queue.insert("Sirwan");
        queue.remove();
        System.out.println(queue.printQueue());
    }
}
