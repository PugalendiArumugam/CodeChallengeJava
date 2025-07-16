package LeetCode.Easy;

import java.util.List;

public class PalindromeLinkedList3 {
    public static void main(String[] args) {
        PalindromeLinkedList3 pll = new PalindromeLinkedList3();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(7);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(2);
        head2.next.next.next.next.next.next = new ListNode(1);
//        head2.next.next.next.next.next.next.next = new ListNode(1);


        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);

        ListNode head4 = new ListNode(2);
        head4.next = new ListNode(1);

        ListNode head5 = new ListNode(1);
        ListNode head6 = new ListNode();


//        System.out.println(pll.isPalindrome(head1));
        System.out.println(pll.isPalindrome4(head2));
//        System.out.println(pll.isPalindrome(head3));
//        System.out.println(pll.isPalindrome(head4));
//        System.out.println(pll.isPalindrome(head5));
//        System.out.println(pll.isPalindrome(head6));
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode temp = head;
        ListNode f = head;
        ListNode s = head;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode shalf = s.next;
        s.next = null;
        ListNode sec = shalf;
        ListNode temp2 = null;
        while (sec != null) {
            ListNode nex = sec.next;
            sec.next = temp2;
            temp2 = sec;
            sec = nex;
        }
        while (temp != null && temp2 != null) {
            if (temp.val != temp2.val)
                return false;
            temp = temp.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public boolean isPalindrome4(ListNode head){
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode prev = null, curr = slow;
//        System.out.print("slow"+slow.val);
//        if(fast==null) System.out.println(" fast:null");
//        else System.out.println(" fast:"+fast.val);
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Compare the first half and the reversed second half
        while (prev != null) {
            if (head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        }
        return true;
    }



}
