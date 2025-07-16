package DSA;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkListDS {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        long startTime;
        long endTime;
        long elapsedTime;

        for(int i =0; i<1000000; i++){
            linkedList.add(i);
            arrayList.add(i);
        }

        startTime = System.nanoTime();
//        linkedList.get(0);
//        linkedList.get(500000);
        linkedList.remove(0);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Linked list :\t" + elapsedTime);

        startTime = System.nanoTime();
//        arrayList.get(0);
//        arrayList.get(500000);
        arrayList.remove(0);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Array list :\t" + elapsedTime);


    }
}
