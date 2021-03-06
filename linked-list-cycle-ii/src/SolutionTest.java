import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution.ListNode node1 = new Solution.ListNode(3);
		Solution.ListNode node2 = new Solution.ListNode(2);
		Solution.ListNode node3 = new Solution.ListNode(0);
		Solution.ListNode node4 = new Solution.ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node1;
		Solution sol = new Solution();
		int val = sol.detectCycle(node1).val;
		System.out.println(val);
		assertEquals(3, val);
	}

}
