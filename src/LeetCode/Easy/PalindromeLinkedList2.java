package LeetCode.Easy;

import java.util.Arrays;
import java.util.Stack;

public class PalindromeLinkedList2 {
    public static void main(String[] args) {
        PalindromeLinkedList2 pll = new PalindromeLinkedList2();
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

        ListNode head4 = new ListNode(2);
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

        StringBuilder sb = new StringBuilder();
        buildSb(head, sb);

        for(int i=0; i<sb.length()/2;i++){
            if(sb.charAt(i)!=sb.charAt(sb.length()-1-i)) return false;
        }
        return true;
//        StringBuilder reverseSb=new StringBuilder(sb);
//        reverseSb.reverse();
//        return sb.compareTo(reverseSb) == 0;
    }

    public void buildSb(ListNode node,StringBuilder sb){
        if(node==null) return;
        sb.append(node.val);
//        if(node.next!=null) sb.append("^");
        buildSb(node.next, sb);
    }

}
