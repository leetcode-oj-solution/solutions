import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Boolean> isFromRightStack = new Stack<Boolean>();

		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				isFromRightStack.push(false);
				p = p.left;
			} else {
				TreeNode tmp = stack.pop();
				boolean isFromRight = isFromRightStack.pop();
				if (isFromRight) {
					list.add(tmp.val);
				} else {
					stack.push(tmp);
					isFromRightStack.push(true);
					p = tmp.right;
				}
			}
		}
		return list;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}