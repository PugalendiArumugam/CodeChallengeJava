package LeetCode.Easy;
/*83
Remove Duplicates from Sorted List

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well

Input: head = [1,1,2]
Output: [1,2]

Input: head = [1,1,2,3,3]
Output: [1,2,3]
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);

        RemoveDuplicatesFromSortedList rd = new RemoveDuplicatesFromSortedList();
        System.out.println(rd.deleteDuplicates(head1));
        System.out.println(rd.deleteDuplicates(head2));

    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
