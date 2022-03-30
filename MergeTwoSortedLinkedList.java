public class MergeTwoSortedLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {} // public class so if we want to manually add the val
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // both can be of different lengths, but sorted
        // edge cases:
        // 1. both null, 2. 1 of them is null

        if (list1 == null && list2 == null) {
            return new ListNode();
        }
        else if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode list1Prev = null;
        ListNode list2Prev = null;
        ListNode head = list1.val > list2.val ? list2 : list1;

        while(list1 != null || list2 != null) {
            
            // list 1 is shorter than list2
            if (list1 == null) {
                list1 = list2; 
            }
            else if (list2 == null) {
                list2 = list1; 
            }
            if (list1.val == list2.val || list1.val < list2.val) {
                head = list1;
                // cut out the current list2 node and advance list2
                ListNode list2CurrNode = list2;
                list2Prev = list2;
                list2 = list2.next;

                // make a copy of list1's next ref so list2's current can go next
                // Insert list2 into list1 and update the references
                ListNode list1NextRef = list1.next;
                list2CurrNode.next = list1NextRef;
                list1.next = list2CurrNode;
                
                // list1's new next node is the original list1's next node
                list1Prev = list1;
                list1 = list1NextRef;
            
            }
            else if (list1.val > list2.val) {
                ListNode list2OriginalNext = list2.next; // original next
                list2.next = list1; // update next to ref list1 because it is smaller
                list1Prev.next = list2; // list1's prev's next is no longer list1 but list2

                list2 = list2OriginalNext;
                list1Prev = list1;
                list1 = list1.next;
                list2Prev = null; 
                
            }

        }

        return list1;
    }

    public static void main(String[] args) {
        MergeTwoSortedLinkedList mergeTwo = new MergeTwoSortedLinkedList();
        ListNode list1 = mergeTwo.new ListNode(1);
        list1.next = mergeTwo.new ListNode(2);
        list1.next = mergeTwo.new ListNode(4);

        ListNode list2 = mergeTwo.new ListNode(1);
        list1.next = mergeTwo.new ListNode(3);
        list1.next = mergeTwo.new ListNode(4);

        ListNode merged = mergeTwo.mergeTwoLists(list1, list2);
        System.out.println(merged.val);
        System.out.println(merged.next.val);

    }
    
    
}
