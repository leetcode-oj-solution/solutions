public class Solution {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			// if empty list or single item list, no cycle at all
			return null;
		}
		ListNode fast = head, slow = head, meetPoint = null;
		while (fast != null && fast.next != null && slow != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				// the two pointers meet together
				meetPoint = fast;
				break;
			}
		}
		// check if there is a cycle
		if (fast == null || fast.next == null || slow == null) {
			// natural stop of the above loop meaning no cycle
			return null;
		}
		// we found a cycle, let's find the start of the cycle
		ListNode p1 = head, p2 = meetPoint; // we can recycle fast, slow
											// pointer, but for clarity, let's
											// use some new pointers
		while (p1 != meetPoint) {
			p1 = p1.next;
			p2 = p2.next;
		}
		// when p1 reaches meetPoint, p2 should be at the start of the cycle
		return p2;
	}

	// Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}