package BinaryTreeInorderTraversa94;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();//中序遍历结果
		if(root == null){//若树为空则直接返回
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();//定义一个栈，压栈顺序为 右、 根、左；因为中序遍历顺序为左、根、右
		HashSet<TreeNode> hashset = new HashSet<TreeNode>();//定义HashSet来判断是否已经访问过
		stack.push(root);//先将结点压栈
		while(!stack.isEmpty())//栈不为空
		{
			 TreeNode temp = stack.pop();//结点出栈
			 if(hashset.contains(temp))//判断hashset中有无该结点
			 {
				 result.add(temp.val);//有的话加到最后中序遍历结果中
			 	 continue;//直接进行下一轮循环
			 }
			 hashset.add(temp);//hashSet中无该结点
			 if(temp.right!=null)//有右子结点
			    stack.push(temp.right);//右子树压栈
			    stack.push(temp);//将该结点压栈
			 if(temp.left!=null)//有左子树
			    stack.push(temp.left);//左子树压栈
		}
		return result;
	}
}
