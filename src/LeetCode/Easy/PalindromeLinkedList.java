package LeetCode.Easy;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList pll = new PalindromeLinkedList();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(1);


        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);

        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(1);

        ListNode head5 = new ListNode(1);
        ListNode head6 = new ListNode();


        System.out.println(pll.isPalindrome(head1));
        System.out.println(pll.isPalindrome(head2));
        System.out.println(pll.isPalindrome(head3));
        System.out.println(pll.isPalindrome(head4));
        System.out.println(pll.isPalindrome(head5));
        System.out.println(pll.isPalindrome(head6));
    }


    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        int mid = size(head,0);
        if(mid==2) return (head.val==head.next.val);
        boolean odd=((mid&1)==1);   //odd or even
        mid = (mid/2)+1;
        int count=1;
        Stack<Integer> stack = new Stack<>();
        ListNode currnode = head;
        while(count<mid){
            stack.add(currnode.val);
            currnode = currnode.next;
            count++;
        }
        count--;
        if(odd) currnode=currnode.next;
        while (count>=1){
            int tempVal = stack.pop();
            if(tempVal!=currnode.val) return false;
            currnode=currnode.next;
            count--;
        }
        return true;
    }

    public int size(ListNode node,int count){
        if(node==null) return count;
        count=size(node.next,count);
        count++;
        return count;
    }

}
