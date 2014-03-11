public class Solution {
    public void reorderList(ListNode head) {
        // initial check
        if (head == null || head.next == null || head.next.next == null) {
            // nothing need to be done, just return
            return;
        }
        
        // first find the middle node and half the list
        // example: 1->2->3 => 3; 1->2->3->4 => 3
        // 1->2->3->4->5 => 4; 1->2->3->4->5->6 => 4
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = slow.next; // second half list head
        slow.next = null; // terminate the first half list
        
        // then reverse order of the second half
        // example: 1->2->3 => 3->2->1
        ListNode newHead2 = head2; // the head of the reversed list
        while (head2.next != null) {
            ListNode p = head2.next;
            head2.next = p.next;
            p.next = newHead2;
            newHead2 = p;
        }
        
        // finally merge the two lists
        // example: 1->2 + 3->4 => 1->3->2->4; 1->2 + 3 => 1->3->2
        ListNode p1 = head;
        ListNode p2 = newHead2;
        while (p1 != null && p2 != null) {
            ListNode tmp = p1.next;
            p1.next = p2;
            p2 = p2.next;
            p1.next.next = tmp;
            p1 = tmp;
        }
        // done!
    }
    
    //* Definition for singly-linked list.
    class ListNode {     
        int val;         
        ListNode next;   
        ListNode(int x) {
            val = x;     
            next = null; 
        }                
    }                    
}