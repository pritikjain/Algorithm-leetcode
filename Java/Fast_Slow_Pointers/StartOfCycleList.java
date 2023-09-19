
/*
 * Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.
 */
public class StartOfCycleList {

    class ListNode {
        int val = 0;
        ListNode next;
      
        ListNode(int value) {
          this.val = value;
        }
      }


      public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
    
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + 
                                findCycleStart(head).val);
    
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + 
                                findCycleStart(head).val);
    
        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + 
                                findCycleStart(head).val);
      }

    public static ListNode findCycleStart(ListNode head) {
       
        int cycleLength =0;
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next!=null)
        {
            slow= slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                cycleLength = calculateCycleLength(slow);
                break;
            }
        }
        return findStart(head, cycleLength);

      }

      private static int calculateCycleLength(ListNode slow) {
        ListNode current = slow;
        int cycleLength = 0;
        do {
          current = current.next;
          cycleLength++;
        } while (current != slow);
        
        return cycleLength;
      }

      private static ListNode findStart(ListNode head, int cycleLength) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;

        // move poimnter 2 ahead "cyclelength" nodes
        while(cycleLength > 0)
        {
            pointer2 = pointer2.next;
            cycleLength--;
        }

        // increment both pointers until they meet at the start of the cycle
        while(pointer1 != pointer2)
        {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
      }

    }

