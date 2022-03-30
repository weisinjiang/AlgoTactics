public class LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    public static boolean solution(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head.next;

        while(fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
           
        }

        return true; // fast == slow, so true

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = head.next;

        boolean hasCycle = LinkedListCycle.solution(head);
        System.out.println(hasCycle);


    }
    
}
