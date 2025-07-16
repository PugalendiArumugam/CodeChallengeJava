package LeetCode.Medium;

import java.util.List;

/*
147. Insertion Sort List
Input: head = [4,2,1,3]
Output: [1,2,3,4]

The steps of the insertion sort algorithm:
1) Insertion sort iterates, consuming one input element each repetition and growing a sorted output list.
2) At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list and inserts it there.
3) It repeats until no input elements remain.

 */
public class InsertionSortList {

    public static void main(String[] args) {
        InsertionSortList isl = new InsertionSortList();
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);

        printList(head1);
        System.out.println();
        ListNode res = isl.insertionSortList(head1);
        printList(res);
        System.out.println();

    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize the dummy node with an initial value.
        ListNode dummy = new ListNode(0);
        // Previous and current pointers for traversal.
        ListNode previous = dummy, current = head;

        // Iterate over the list to sort each element.
        while (current != null) {
            // If the value at previous is less than or equal to the current's value, move the pointers forward.
            if (previous.val <= current.val) {
                previous = current;
                current = current.next;
                continue;
            }
            // Find the correct position for the current node in the sorted part of the list
            ListNode position = dummy;
            while (position.next != null && position.next.val <= current.val) {
                position = position.next;
            }
            // Insert current node in the correct position.
            ListNode temp = current.next;
            current.next = position.next;
            position.next = current;

            // Move the previous pointer's next to temp and update current to temp.
            previous.next = temp;
            current = temp;
        }
        // Return the next node of dummy since the first node is a placeholder.
        ListNode result = mergeNode(dummy.next,previous);
        return result;
    }

    static ListNode mergeNode(ListNode mainNode,ListNode secondNode){
        ListNode result = mainNode;
        while (mainNode != null) {
            result.next=mainNode.next;
            mainNode = mainNode.next;
            if(mainNode.next==null){
                mainNode.next=secondNode;
            }
        }
        return result;
    }

}
