package data_structure.HashTable;
import data_structure.StackLinkedList.*;

import javax.xml.crypto.Data;


public class HashTable {

    class DataNode{
        String id;
        int score;

        DataNode(String _id, int _score){
            id = _id;
            score = _score;
        }

        void printAll(){
            System.out.println(id + " " + score);
        }
    }

    StackLinkedList<DataNode>[] store;
    int hashLim = 3;

    HashTable(int n){
        store = new StackLinkedList[n];
        for (int i = 0 ; i < store.length; i++){
            store[i] = new StackLinkedList<DataNode>();
        }
    }


    void insertData(String _id, int _score){
        System.out.println("=== Insert data ===");
        DataNode data = new DataNode(_id, _score);

        //get hash from the first 4 letter
        int hash = 0;
        for (int i = 0; i < hashLim; i++){
            hash += _id.charAt(i) - 'a';
        }
        hash %= store.length;

        //insert (check valid)
        boolean valid = true;
        StackLinkedList.Node<DataNode> node = store[hash].head;
        while (node != null){
            if (node.data.id.equals(_id)){
                valid = false;
                break;
            }
            node = node.next;
        }

        if (valid){
            store[hash].push(data);
            System.out.println("Inserted at idx: " + hash);
        }
        else{
            System.out.println("Insert fail");
        }
    }


    void removeData(String _id){
        System.out.println("=== Remove data ===");
        //get hash
        int hash = 0;
        for (int i = 0 ; i < hashLim; i++){
            hash += _id.charAt(i) - 'a';
        }
        hash %= store.length;

        //retrieve
        boolean found = false;
        StackLinkedList.Node<DataNode> node = store[hash].head;
        while (node != null){
            if (node.data.id.equals(_id)){
                found = true;
                break;
            }
            node = node.next;
        }

        //remove
        if (found){
            System.out.println("Deleted");
            if (node == store[hash].head){
                store[hash].pop();
            }
            else{
                store[hash].size --;
                StackLinkedList.Node<DataNode> node1 = store[hash].head;
                while (node1.next != node){
                    node1 = node1.next;
                }
                node1.next = node1.next.next;
            }
        }
        else{
            System.out.println("Data not found");
        }
    }


    void findData(String _id){
        System.out.println("=== Find Data ===");
        //get hash
        int hash = 0;
        for (int i = 0 ; i < hashLim; i++){
            hash += _id.charAt(i) - 'a';
        }
        hash %= store.length;

        //retrieve
        StackLinkedList.Node<DataNode> node = store[hash].head;
        while (node != null){
            if (node.data.id.substring(0, _id.length()).equals(_id)){
                node.data.printAll();
            }
            node = node.next;
        }
    }


    void debugTable(int idx){
        System.out.println("=== Debug table ===");
        StackLinkedList.Node<DataNode> node = store[idx].head;
        DataNode[] dataStore = new DataNode[store[idx].size];

        for (int i = store[idx].size - 1 ; i >= 0 ; i--){
            dataStore[i] = node.data;
            node = node.next;
        }

        for (DataNode data : dataStore){
            data.printAll();
        }
    }


    public static void main(String[] args) {
        HashTable ex = new HashTable(10);

        ex.insertData("abcfdasf", 23);
        ex.insertData("cbacasdc", 42);
        ex.insertData("cbacdddf", 52);
        ex.insertData("cbadddfw", 52);


        ex.debugTable(3);
        ex.removeData("abcfdasf");
        ex.debugTable(3);

    }
}


