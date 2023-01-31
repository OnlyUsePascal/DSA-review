package data_structure.BinarySearchTree.BalancedBST;
import data_structure.BinarySearchTree.Classic.*;

//not reliable
public class DSW extends ClassicBST {
    DSW(){
//        super();
    }


    void leftRotate(Node cur){
        Node curRight = cur.right;
        cur.right = curRight.left;
        if (curRight.left != null){
            curRight.left.parent = cur;
        }
        curRight.left = cur;

        //handle parent
        curRight.parent = cur.parent;
        cur.parent = curRight;
        if (curRight.parent != null){
            if (curRight.parent.left == curRight){
                curRight.parent.left = curRight;
            }
            else{
                curRight.parent.right = curRight;
            }
        }
    }


    void rightRotate(Node cur){
        Node curLeft = cur.left;
        cur.left = curLeft.right;
        if (curLeft.right != null){
            curLeft.right.parent = cur;
        }
        curLeft.right = cur;

        //handle parent of cur
        curLeft.parent = cur.parent;
        cur.parent = curLeft;
        if (curLeft.parent != null){
            if (curLeft.parent.left == curLeft){
                curLeft.parent.left = curLeft;
            }
            else{
                curLeft.parent.right = curLeft;
            }
        }
    }


    void balanceBST(){
        System.out.println("=== Balance BST ===");
        if (this.size == 0){
            System.out.println("Done");
            return;
        }

        //1) convert tree to backbone
        Node cur = this.head;
        while (cur != null){
            if (cur.left != null){
                rightRotate(cur);
                cur = cur.parent;
            }
            else{
                cur = cur.right;
            }
        }
        while (this.head.parent != null) this.head = this.head.parent;


        //2) compress backbone to balanced BST
        int heightBST = (int) (Math.log(this.size) / Math.log(2));
        int completeSize = (int) Math.pow(2, heightBST) - 1;
        cur = this.head;

        //first left rotate for excessive leaves
        for (int i = 0 ; i < this.size - completeSize; i++){
            //rotate every 2 nodes from root
            leftRotate(cur);
            cur = cur.parent.right;
        }

        //left rotate for complete tree
        while (completeSize > 0){
            completeSize /= 2;
            //need to relocate <head>
            while (this.head.parent != null) this.head = this.head.parent;
            cur = this.head;

            for (int i = 0 ; i < completeSize; i++){
                //rotate every 2 nodes from root
                leftRotate(cur);
                cur = cur.parent.right;
            }
        }

        while (this.head.parent != null) this.head = this.head.parent;
        System.out.println("Done");
    }


    public static void main(String[] args) {
        DSW s = new DSW();
        s.insert(5);
        s.insert(1);
        s.insert(4);
        s.insert(9);
        s.insert(6);
        s.insert(7);
        s.insert(8);
        s.insert(3);



        s.balanceBST();
        s.printAll();
//        s.balanceBST();
//        Node t = s.search(5);
//        s.rightRotate(t);
//        System.out.print(t.data);
    }
}
