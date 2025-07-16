package DSA.Queue;

import java.util.PriorityQueue;

public class PriorityQueueStructure {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(1);
        pq.add(3);
        pq.add(2);
        pq.add(4);
        pq.add(0);
        pq.add(6);
        System.out.println("Priority Queue:"+pq);
//        System.out.println("Priority Queue:"+pq.peek());
//        System.out.println("Priority Queue:"+pq);
//        System.out.println("Priority Queue:"+pq.poll());
//        System.out.println("Priority Queue:"+pq);
        int size= pq.size();
        for(int i=1;i<=size;i++){
            System.out.print(pq.poll()+" ");
        }
        System.out.println();
        System.out.println(pq);

    }
}
