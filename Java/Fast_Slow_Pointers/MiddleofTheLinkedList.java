/*
 * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList.

If the total number of nodes in the LinkedList is even, return the second middle node.

Example 1:

Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
Output: 3
Example 2:

Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
Output: 4
Example 3:

Input: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> null
Output: 4

 */

public class MiddleofTheLinkedList {

    class ListNode {
        int val = 0;
        ListNode next;

        ListNode(int value) {
            this.val = value;
            this.next = null;
        }
    }

    public static void main(String agrs[]) {
        ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    System.out.println("Middle Node: " + findMiddleUsingFastAndSlow(head).val);

    head.next.next.next.next.next = new ListNode(6);
    System.out.println("Middle Node: " + findMiddleUsingFastAndSlow(head).val);

    head.next.next.next.next.next.next = new ListNode(7);
    System.out.println("Middle Node: " + findMiddleUsingFastAndSlow(head).val);

    }

    public static ListNode findMiddleUsingFastAndSlow(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next != null)
        {
            slow= slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode findMiddle(ListNode head) {

        if (head == null)
            return head;
        ListNode current = head;
        int size = 0;
        int middle = 0;
        while (current != null) {
            current = current.next;
            size++;
        }
        current = head;
        if (isEven(size))
        {
            middle = size/2;
        } else {
            middle = size/2 +1;
        }

        for(int i = 1; i < middle ; i++)
        {
            current = current.next;
            i++;
        }

        return current;
    }

    public static boolean isEven(int number) {

        return number % 2 == 0;
    }
}
