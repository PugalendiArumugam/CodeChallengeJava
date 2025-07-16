package LeetCode.Medium;
//143. Reorder List
//You are given the head of a singly linked-list. The list can be represented as:
//L0 → L1 → … → Ln - 1 → Ln
//Reorder the list to be on the following form:
//
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//You may not modify the values in the list's nodes. Only nodes themselves may be changed.
//
//Example 1:
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
//
//Example 2:
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]

public class ReorderList143 {
    public static void main(String[] args) {
        ReorderList143 rl = new ReorderList143();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        rl.reorderList2(head1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        rl.reorderList2(head2);

    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        current=head;
        while (prev != null) {
            ListNode temp = prev.next;
            prev.next = current.next;
            current.next = prev;
            current = prev.next;
            prev = temp;
        }
    }

    public void reorderList2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr = head;
        while (prev != null) {
            ListNode temp = prev.next;
            prev.next = curr.next;
            curr.next = prev;
            curr = prev.next;
            prev = temp;
        }
        System.out.println(head.val+" "+head.next.val);
    }
}
