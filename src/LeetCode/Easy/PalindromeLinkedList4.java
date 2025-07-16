package LeetCode.Easy;

public class PalindromeLinkedList4 {
    public static void main(String[] args) {
        PalindromeLinkedList4 pll = new PalindromeLinkedList4();
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
        System.out.println(pll.isPalindrome(head1));
        System.out.println(pll.isPalindrome(head2));
    }

    public boolean isPalindrome(ListNode head) {
        // Use two pointers: slow moves one step at a time and fast moves two steps at a time.
        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer to the end, and slow to the middle of the list
         while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode temp = current.next; // Stores the next node
            current.next = prev; // Reverses the link
            prev = current; // Moves prev to current node
            current = temp; // Move to the next node in the original list
        }

        // Compare the reversed second half with the first half
        ListNode firstHalfIterator = head;
        ListNode secondHalfIterator = prev;
        while (secondHalfIterator != null) {
            // If values are different, then it's not a palindrome
            if (secondHalfIterator.val != firstHalfIterator.val) {
                return false;
            }

            // Move to the next nodes in both halves
            secondHalfIterator = secondHalfIterator.next;
            firstHalfIterator = firstHalfIterator.next;
        }

        // All values matched, so it's a palindrome
        return true;
    }
}
