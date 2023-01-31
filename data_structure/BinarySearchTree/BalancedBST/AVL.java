package data_structure.BinarySearchTree.BalancedBST;


import algo.ArrayGen;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;

public class AVL {
    class Node{
        int data, height;
        Node left, right, parent;

        Node(int _data){
            data = _data;
            height = 1;
            left = null;
            right = null;
            parent = null;
        }


        void printAll(){
            System.out.println("(" + data + "," + height + ")");
        }
    }


    Node root;


    AVL(){
        root = null;
    }


    //=== balance area ===
    int getHeight(Node node){
        return (node == null) ? 0 : node.height;
    }


    void updateHeight(Node curNode){
        if (curNode == null) return;
        curNode.height = 1 + Math.max(getHeight(curNode.left),
                                getHeight(curNode.right));
    }


    int getBalanceFactor(Node node){
        System.out.println("* balance factor *");
        System.out.println(node.data + " " + (getHeight(node.left) - getHeight(node.right)));
        return getHeight(node.left) - getHeight(node.right);
    }


    Node rightRotate(Node node){
        System.out.println("* right rotate *");
        Node curNode = node,
                leftChild = curNode.left,
                curParent = curNode.parent;

        if (leftChild == null) return null;

        //parent
        leftChild.parent = curParent;
        curNode.parent = leftChild;
        if (curNode == root){
            //parent = null
            root = leftChild;
        }
        else{
            if (curParent.right == curNode)
                curParent.right = leftChild;
            else
                curParent.left = leftChild;
        }

        //child of curNode & leftChild
        curNode.left = leftChild.right;
        if (leftChild.right != null) leftChild.right.parent = curNode;
        leftChild.right = curNode;

        //update height
        updateHeight(curNode);
        updateHeight(leftChild);

        //node is now leftChild
        System.out.println("done");
        return leftChild;
    }


    Node leftRotate(Node node){
        System.out.println("* left rotate *");
        Node curNode = node,
                rightChild = curNode.right,
                curParent = curNode.parent;

        if (rightChild == null) return null;

        //parent
        rightChild.parent = curParent;
        curNode.parent = rightChild;
        if (curNode == root){
            //parent = null
            root = rightChild;
        }
        else{
            if (curParent.right == curNode)
                curParent.right = rightChild;
            else
                curParent.left = rightChild;
        }

        //child of curNode & leftChild
        curNode.right = rightChild.left;
        if (rightChild.left != null) rightChild.left.parent = curNode;
        rightChild.left = curNode;

        //update height
        updateHeight(curNode);
        updateHeight(rightChild);

        //node is now rightChild
        System.out.println("done");
        return rightChild;
    }


    void balanceTree(Node node){
        System.out.println("* balance tree *");
        while (node != null){
            updateHeight(node);
            int balanceFactor = getBalanceFactor(node);

            if (balanceFactor > 1){
                //left subtree is higher
                int subBalanceFactor = getBalanceFactor(node.left);
                if (subBalanceFactor < 0){
                    //right subtree of left child is higher
                    leftRotate(node.left);
                }

                //right rotate
                node = rightRotate(node);
            }
            else if (balanceFactor < -1){
                //right subtree is higher
                int subBalanceFactor = getBalanceFactor(node.right);
                if (subBalanceFactor > 0){
                    //left subtree of right child is higher
                    rightRotate(node.right);
                }

                //left rotate
                node = leftRotate(node);
            }

            node = node.parent;
        }

        System.out.println("done");
    }


    //==== operation ===
    void removeData(int data){
        System.out.println("=== remove data ===");
        System.out.println("data = " + data);

        //find data node
        Node curNode = findData(data);
        if (curNode == null) return;

        //remove
        Node curParent = curNode.parent;
        //if it has 0,1 child
        if (curNode.left == null || curNode.right == null){
            //take a child, even it is null
            Node child = (curNode.left != null) ? curNode.left : curNode.right;

            if (child != null) child.parent = curParent;
            if (curNode == root)
                //not have parent
                root = child;
            else{
                //have parent
                if (curParent.right == curNode)
                    curParent.right = child;
                else
                    curParent.left = child;
            }
        }
        else{
            //it has 2 child
            //take leftmost child of right subtree
            Node child = curNode.right;

            while (child.left != null)
                child = child.left;

            //replace curNode data with child's
            curNode.data = child.data;

            if (curNode.right == child){
                //connect curNode -- child.right
                curNode.right = child.right;
            }
            else{
                //connect child.parent -- child.right
                child.parent.left = child.right;
            }
            if (child.right != null) child.right.parent = child.parent;

        }

        //balance tree after removal
        balanceTree(curParent);
        System.out.println("done");
    }


    Node findData(int data){
        System.out.println("=== find data ===");
        System.out.println("data = " + data);

        Node tempNode = root;

        while (tempNode != null){
            if (tempNode.data == data) break;
            else if (tempNode.data > data) tempNode = tempNode.left;
            else tempNode = tempNode.right;
        }

        if (tempNode == null) System.out.println("not found");
        else System.out.println("found");

        return tempNode;
    }


    void insertTree(int data){
        System.out.println("=== insert tree ===");
        System.out.println("data = " + data);

        //insert node
        Node tempNode = root,
                newNode = new Node(data);

        if (tempNode == null){
            root = newNode;
        }
        else{
            while(true){
                if (tempNode.data == data){
                    System.out.println("Already in tree");
                    return;
                }
                else if (tempNode.data < data){
                    if (tempNode.right == null){
                        tempNode.right = newNode;
                        newNode.parent = tempNode;
                        break;
                    }
                    tempNode = tempNode.right;
                }
                else {
                    if (tempNode.left == null){
                        tempNode.left = newNode;
                        newNode.parent = tempNode;
                        break;
                    }
                    tempNode = tempNode.left;
                }
            }
        }

        //update height from parent to root
        balanceTree(newNode.parent);
        System.out.println("done");
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
//            System.out.println(currPtr.data);
            currPtr.printAll();
            printTree(currPtr.left, indent, false);
            printTree(currPtr.right, indent, true);
        }
    }

    public void printAll(){
        System.out.println("=== print tree ===");
        printTree(root, "", true);
    }


    public static void main(String[] args) {
        AVL ex = new AVL();

//        int[] arr = (new ArrayGen()).getArr(10);
        int[] arr = new int[]{11,4,7,12,13,3,10};

        for (int ele : arr){
            ex.insertTree(ele);
            ex.printAll();
        }

        ex.removeData(4);
        ex.printAll();
    }


















}
