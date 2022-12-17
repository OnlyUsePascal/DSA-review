package data_structure.StackLinkedList;

// Singly Linked List-based implementation of stack
public class StackLinkedList<T> {
  // this class is used as a container of data
  public static class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }
  }

  public int size;
  public Node<T> head;

  public StackLinkedList() {
    size = 0;
    head = null;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean push(T item) {
    // add a new node at the beginning
    Node<T> node = new Node<T>(item);
    if (! isEmpty()) {
      node.next = head;
    }
    head = node;
    size++;
    return true;
  }

  public boolean pop() {
    // remove the first node
    // make sure the stack is not empty
    if (isEmpty()) {
      return false;
    }
    // advance head
    head = head.next;
    size--;
    return true;
  }

  public T peek() {
    // make sure the stack is not empty
    if (isEmpty()) {
      return null;
    }
    return head.data;
  }

  public static void main(String[] args) {
    StackLinkedList<Double> st = new StackLinkedList<Double>();
    st.push(123.45);
    st.push(111.22);
    st.push(444.66);
    st.push(987.65);
    while (!st.isEmpty()) {
      System.out.println(st.peek());
      st.pop();
    }
  }
}
