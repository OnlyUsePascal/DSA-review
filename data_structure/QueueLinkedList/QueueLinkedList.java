package data_structure.QueueLinkedList;


//operations
//enqueue
//dequeue
//peek - ez
//isfull - ez
//isempty - ez


public class QueueLinkedList <T>{
    class Node{
        T data;
        Node next, prev;

        Node(T _data){
            data = _data;
            next = null;
            prev = null;
        }
    }

    Node left, right;
    int size;


    QueueLinkedList(){
        System.out.printf("=== Queue initiated ===");
        left = null; right = null;
        size = 0;
    }


    boolean isEmpty(){
        return size == 0;
    }


    void enQueue(T _data){
        System.out.println("=== Enqueue ===");

        Node newNode = new Node(_data);
        if (isEmpty()) { //queue is empty
            left = newNode;
            right = left;
        }
        else{
            newNode.next = left;
            left.prev = newNode;
            left = newNode;
        }
        size++;
        System.out.println("Added");
    }


    void deQueue(){
        System.out.println("=== Dequeue ===");

        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        if (size == 1){ //reset both ends
            left = null;
            right = null;
        }
        else{   //step back 1 node
            right = right.prev;
            right.next = null;
        }

        size--;
        System.out.println("Deleted");
    }


    T peekFront(){
        if (isEmpty()) return null;
        return right.data;
    }


    T peekBack(){
        if (isEmpty()) return null;
        return left.data;
    }


    void printAll(){
        System.out.println("=== Print queue ===");
        if (isEmpty()){
            System.out.println("queue is empty");
            return;
        }

        Node cur = left;
        while (cur != null){
            System.out.println(cur.data);
            cur = cur.next;
        }
    }


    public static void main(String[] args) {
        QueueLinkedList<Integer> ex = new QueueLinkedList<Integer>();
        ex.enQueue(10);
        ex.enQueue(13);
        ex.enQueue(14);

        ex.printAll();

        ex.deQueue();
        ex.printAll();
    }

}
