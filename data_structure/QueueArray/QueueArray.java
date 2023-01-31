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
        left = 0;
        right = -1;
        size = 0;
        arr = (T[]) new Object[_size];
    }


    boolean isEmpty(){
        return size == 0;
    }


    void enQueue(T _data){
        System.out.println("=== Enqueue ===");
        if (size == arr.length){
            System.out.println("Queue is full");
            return;
        }

        right = (right + 1) % arr.length;
        arr[right] = _data;

        size++;
        System.out.println("Added value: " + _data);
    }


    void deQueue(){
        System.out.println("=== Dequeue ===");
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        left = (left + 1) % arr.length;

        size--;
        System.out.println("Deleted");
    }


    T peekFront(){
        if (isEmpty()) return null;
        return arr[left];
    }


    T peekBack(){
        if (isEmpty()) return null;
        return arr[right];
    }


    void printAll(){
        System.out.println("=== Print all ===");
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        int idx = left;
        for (int i = 0; i < size; i++){
            System.out.println(arr[idx]);
            idx = (idx + 1) % arr.length;
        }
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
