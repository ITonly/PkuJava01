/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //前序遍历：根、左、右
    public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ls = new ArrayList<Integer>();
		if (root == null)
			return ls;
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);

		while (!st.isEmpty()) {
			TreeNode temp = st.pop();
            //输出根节点
			ls.add(temp.val);
			//右子树和左子树依次入栈
			if (temp.right != null)
				st.push(temp.right);
			if (temp.left != null)
				st.push(temp.left);
		}
		return ls;
	}
}
