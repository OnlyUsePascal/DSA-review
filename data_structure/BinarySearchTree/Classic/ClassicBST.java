package data_structure.BinarySearchTree.Classic;
//import javafx.util.*;

import java.util.LinkedList;
import java.util.Queue;

public class ClassicBST {
    public class Node{
        public int data;
        public Node left, right, parent;

        Node (int _data){
            this.data = _data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    public Node head;
    public int size;

    public ClassicBST(){
        this.size = 0;
        this.head = null;
    }


    public void insert(int _data){
        System.out.println("=== Add data ===");
        if (this.head == null){
            this.head = new Node(_data);
        }
        else{
            Node cur = this.head;

            while (true){
                if (_data == cur.data){
                    System.out.println("Already in BST");
                    return;
                }
                else if (_data < cur.data){
                    if (cur.left == null){
                        cur.left = new Node(_data);
                        cur.left.parent = cur;
                        break;
                    }
                    cur = cur.left;
                }
                else{
                    if (cur.right == null){
                        cur.right = new Node(_data);
                        cur.right.parent = cur;
                        break;
                    }
                    cur = cur.right;
                }
            }

        }
        this.size++;
        System.out.println("Done");
    }


    public Node search(int _data){
        System.out.println("=== Search in BST ===");
        Node cur = this.head;

        while (cur != null){
            if (_data == cur.data){
                break;
            }
            else if (_data < cur.data){
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }

        if (cur != null){
            System.out.println("Value " + _data + " is in BST");
        }
        else {
            System.out.println("Value " + _data + " is not in BST");
        }

        return cur;
    }


    public void remove(int _data){
        Node cur = this.search(_data);

        //not found
        if (cur == null) return;

        //have 0,1 child
        if (cur.left == null || cur.right == null){
            //replace <cur> with <child>, even if child is null
            Node child = (cur.left != null) ? cur.left : cur.right;

            if (cur == this.head){ //has no parent
                head = child;
            }
            else{
                //parent's child = cur's child
                if (cur.parent.left == cur){
                    cur.parent.left = child;
                }
                else{
                    cur.parent.right = child;
                }
            }
        }
        else{ //have 2 child
            //take the smallest child <r> of right subtree
            Node r = cur.right;

            while (r.left != null){
                r = r.left;
            }

            //replace node with <r>
            cur.data = r.data;
            if (r.parent == cur){
                r.parent.right = r.right;
            }
            else{
                r.parent.left = r.right;
            }
        }

        System.out.println("Deleted");
        this.size--;
    }


    void printTree(Node currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(currPtr.data);
            printTree(currPtr.left, indent, false);
            printTree(currPtr.right, indent, true);
        }
    }


    public void printAll(){
        printTree(head, "", true);
    }


    public static void main(String[] args) {
        ClassicBST s = new ClassicBST();

        s.insert(7);
        s.insert(3);
        s.insert(11);
        s.insert(5);
        s.insert(9);
        s.insert(12);

//        s.remove(11);
        s.printAll();
//        s.search(3);
    }
}
