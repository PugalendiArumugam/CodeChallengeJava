package LeetCode;
/*
ex 1
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

ex 2
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbersListNode {

    public static void main(String[] args) {
//        ListNode head1 = new ListNode(2);
//        head1.next = new ListNode(4);
//        head1.next.next = new ListNode(3);
//
//        ListNode head2 = new ListNode(5);
//        head2.next = new ListNode(6);
//        head2.next.next = new ListNode(4);

        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(9);
        head1.next.next.next = new ListNode(9);
        head1.next.next.next.next = new ListNode(9);
        head1.next.next.next.next.next = new ListNode(9);
        head1.next.next.next.next.next.next = new ListNode(9);

        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9, new ListNode(9,new ListNode(9)));


        ListNode res = addTwoNumbers(head1,head2);
        MergeTwoSortedList.printList(res);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        StringBuilder sb= new StringBuilder();

        while(l1 != null || l2 !=null) {
            int v1=0,v2=0,total=0;
            if (l1!=null){
                v1=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                v2=l2.val;
                l2=l2.next;
            }
            total = v1+v2+carry;
            carry=total/10;
            curr.next = new ListNode(total%10);
            curr = curr.next;
        }
        if(carry!=0){
            curr.next = new ListNode(carry);
        }
        return result.next;
    }
}
