package LeetCode.Medium;
/*
Example 1:        // 2nd from the last.
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
 */

public class RemoveNthNode {
    public static void main(String[] args) {
        RemoveNthNode rn = new RemoveNthNode();
        LeetCode.Medium.ListNode head2 = new LeetCode.Medium.ListNode(1);
        head2.next = new LeetCode.Medium.ListNode(2);
        head2.next.next = new LeetCode.Medium.ListNode(3);
        head2.next.next.next = new LeetCode.Medium.ListNode(4);
        head2.next.next.next.next = new LeetCode.Medium.ListNode(5);
        head2.next.next.next.next.next = new LeetCode.Medium.ListNode(6);


        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(4);
        head3.next.next.next.next = new ListNode(5);

//        ListNode res = rn.removeNthFromEnd(head2,2);
//        System.out.println(res.val);

        ListNode res = rn.removeNthFromEnd(head3,2);
        System.out.println(res.val);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sl = head;
        ListNode fs = head;

        for (int i = 0; i < n; i++)
            fs = fs.next;

        if (fs == null)
            return head.next;

        while (fs.next != null) {
            fs = fs.next;
            sl = sl.next;
        }

        sl.next = sl.next.next;
        return head;
    }
}
