import data_structure.StackLinkedList.*;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

public class TestingSite {
    public static void main(String[] args) {
        StackLinkedList<Integer>[] s = new StackLinkedList[3];
        for (int i = 0 ; i < s.length; i++){
            s[i] = new StackLinkedList<Integer>();
        }

        System.out.println(s[0].head);
//        System.out.println(s[0].head.data);
//        String s = "";
        int s1 = 10;
//        System.out.println((Object) s1).getClass().getSimpleName());
    }
}
