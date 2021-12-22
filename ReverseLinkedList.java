// Leetcode 206



class ReverseLinkedList {
    // List node definition for LinkedList
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        
    }

    static ListNode reverseList(ListNode head) {

        // Edge case where head is the only node or null
        if (head.next == null || head == null) {
            return head; 
        }
        
        ListNode currNode = head;
        ListNode prevNode = null;
        ListNode nextNode;

        while(currNode != null) {
            nextNode = currNode.next; // ref next node
            currNode.next = prevNode; // curr next node is prev node
            prevNode = currNode; // prev node becomes the currnode
            currNode = nextNode; // go to next node and do the same
        }

        return prevNode; // prevNode is the last node before null, making it the new head
    }

    static void printNode(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head = ReverseLinkedList.reverseList(head);
        ReverseLinkedList.printNode(head);
        
    }


}