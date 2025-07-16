package LeetCode.Medium;

//***************************************
//***************************************
//  fastest solution
//***************************************
//***************************************

public class MinStackII {
    private Node head;

    public void push(int val) {
        if(head==null){
            head=new Node(val,val,null);
        }else{
            head=new Node(val,Math.min(val,head.min),head);
        }
    }

    public void pop() {
        head=head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
    private class Node{
        int val;
        int min;
        Node next;
        Node(int val, int min ,Node next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
    }

    public static void main(String[] args) {
        MinStackII ms = new MinStackII();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        System.out.println(ms.getMin());
    }
}
