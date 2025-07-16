package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode res = mergeTwoLists(head1, head2);
        printList(res);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

//        ArrayList<Integer> arr = new ArrayList<>();
//
//        while (list1 != null) {
//            arr.add(list1.val);
//            list1 = list1.next;
//        }
//
//        while (list2 != null) {
//            arr.add(list2.val);
//            list2 = list2.next;
//        }
//
//        Collections.sort(arr);
//
//        ListNode result = new ListNode(-1);
//        ListNode curr = result;
//
//        for (int i = 0; i < arr.size(); i++) {
//            curr.next = new ListNode(arr.get(i));
//            curr = curr.next;
//        }
//
//        return result.next;

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                node.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 == null) {
            node.next = list2;
        } else {
            node.next = list1;
        }

        return dummy.next;


    }

    static void printList(ListNode curr) {
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" ");
            }
            curr = curr.next;
        }
        System.out.println();
    }
}
