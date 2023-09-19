/*Problem Statement
Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 */
public class LinkedListCycle {

    class ListNode {
        int val = 0;
        ListNode next;

        ListNode(int value) {
            this.val = value;
        }
    }

    public static void main(String agrs[])
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("LinkedList has cycle: " + hasCycle(head));
    
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));
    
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
       
        ListNode fast=head;
        ListNode slow =head;
       
        while(fast !=null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
            {
                calculateLength(slow);
                return true;
            }

        }
        return false;
    }

    private static int calculateLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do{
            current = current.next;
            cycleLength++;

        }while ( current != slow);
        return cycleLength;
    }

}
