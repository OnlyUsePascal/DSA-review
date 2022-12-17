package data_structure.QueueArray;

//operations
//enqueue
//dequeue
//peek - ez
//isfull - ez
//isempty - ez


public class QueueArray <T>{
    T[] arr;
    int left, right;
    int size;

    QueueArray(int _size){
        System.out.println("=== Queue initiated ===");
        this.left = 0;
        this.right = -1;
        this.size = 0;
        this.arr = (T[]) new Object[_size];
    }


    void enQueue(T _data){
        System.out.println("=== Enqueue ===");
        if (this.size == this.arr.length){
            System.out.println("Queue is full");
            return;
        }

        this.right = (this.right + 1) % this.arr.length;
        this.arr[this.right] = _data;

        this.size++;
        System.out.println("Added value: " + _data);
    }


    void deQueue(){
        System.out.println("=== Dequeue ===");
        if (this.size == 0){
            System.out.println("Queue is empty");
            return;
        }

        this.left = (this.left + 1) % this.arr.length;

        this.size--;
        System.out.println("Deleted");
    }


    void printAll(){
        System.out.println("=== Print all ===");
        if (this.size == 0){
            System.out.println("Queue is empty");
            return;
        }

        int idx = this.left;
        for (int i = 0; i < this.size; i++){
            System.out.println(this.arr[idx] + " ");
            idx = (idx + 1) % this.arr.length;
        }

        System.out.println("");
    }


    public static void main(String[] args) {
        QueueArray<Integer> s = new QueueArray<Integer>(3);
        s.enQueue(2);
        s.enQueue(5);
        s.enQueue(6);
        s.enQueue(66);

        s.deQueue();
        s.deQueue();
        s.enQueue(66);
        s.printAll();
    }


}
