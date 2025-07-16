package LeetCode.Medium;

public class SwapNodesInPairs {
    public static void main(String[] args) {
     SwapNodesInPairs sn = new SwapNodesInPairs();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        printList(sn.swapPairs(head1));
//        System.out.println( sn.swapPairs(head1));    //[2,1,4,3]

        ListNode head2 = new ListNode();
        printList(sn.swapPairs(head2));
//        System.out.println(sn.swapPairs(head2));   //[]

        ListNode head3 = new ListNode(1);
        printList(sn.swapPairs(head3));
//        System.out.println(sn.swapPairs(head3)); //[1]

        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(3);
        printList(sn.swapPairs(head4));
//        System.out.println(sn.swapPairs(head4));  //[2,1,3]

    }

    public ListNode swapPairs(ListNode head) {
        ListNode tempNode = new ListNode(0);
        tempNode.next = head;

        ListNode prevNode = tempNode;
        ListNode currentNode = head;

        while (currentNode != null && currentNode.next != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = nextNode.next;
            nextNode.next = currentNode;
            prevNode.next = nextNode;

            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        return tempNode.next;

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

    public ListNode swapPairs2(ListNode head) {
        // The dummy node is used to simplify the edge case where the list might contain only one node.
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        // 'previousNode' always points to the node before the pair that needs to be swapped.
        ListNode previousNode = dummyNode;
        // 'currentNode' is the first node in the pair that needs to be swapped.
        ListNode currentNode = head;

        // Iterate over the list in steps of two nodes at a time.
        while (currentNode != null && currentNode.next != null) {
            // 'nextNode' is the second node in the pair that needs to be swapped.
            ListNode nextNode = currentNode.next;
            // Swap the pair by adjusting the pointers.
            currentNode.next = nextNode.next;
            nextNode.next = currentNode;
            previousNode.next = nextNode;

            // Move 'previousNode' pointer two nodes ahead to the last node of the swapped pair.
            previousNode = currentNode;
            // Advance 'currentNode' to the next pair of nodes to swap.
            currentNode = currentNode.next;
        }

        // The 'next' of dummy node points to the new head after swapping pairs.
        return dummyNode.next;
    }
}
