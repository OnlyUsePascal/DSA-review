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
            this.data = _data;
            this.next = null;
            this.prev = null;
        }
    }

    Node left, right;
    int size, max;


    QueueLinkedList(){
        System.out.printf("=== Queue initiated ===");
        this.left = null; this.right = null;
        this.size = 0;
        this.max = 5;
    }


    void enQueue(T _data){
        System.out.println("=== Enqueue ===");

        if (size >= max){
            System.out.println("Queue is full");
            return;
        }

        Node newNode = new Node(_data);
        if (this.left == null) { //queue is empty
            this.left = newNode;
            this.right = this.left;
        }
        else{
            newNode.next = this.left;
            this.left.prev = newNode;
            this.left = newNode;
        }
        this.size++;
        System.out.println("Added");
    }


    void deQueue(){
        System.out.println("=== Dequeue ===");

        if (this.left == null){
            System.out.println("Queue is empty");
            return;
        }

        if (this.size == 1){ //reset both ends
            this.left = null;
            this.right = null;
        }
        else{   //step back right node
            this.right = this.right.prev;
            this.right.next = null;
        }

        this.size--;
        System.out.println("Deleted");
    }


    void printAll(){
        System.out.println("=== Print queue ===");
        if (this.size == 0){
            System.out.println("queue is empty");
        }
        else{
            Node cur = this.left;
            while (cur != null){
                System.out.print(cur.data + " ");
                cur = cur.next;
            }
            System.out.printf("");
        }
    }


    public static void main(String[] args) {
        QueueLinkedList<Integer> ex = new QueueLinkedList<Integer>();
        ex.enQueue(10);
        ex.enQueue(13);
//        ex.enQueue(14);
//        ex.enQueue(16);
//        ex.enQueue(19);
//        ex.enQueue(15);

        ex.deQueue();
        ex.deQueue();
        ex.deQueue();
        ex.printAll();
//        ex.
    }

}
