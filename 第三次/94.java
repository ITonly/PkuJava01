package BinaryTreeInorderTraversa94;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();//����������
		if(root == null){//����Ϊ����ֱ�ӷ���
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();//����һ��ջ��ѹջ˳��Ϊ �ҡ� ��������Ϊ�������˳��Ϊ�󡢸�����
		HashSet<TreeNode> hashset = new HashSet<TreeNode>();//����HashSet���ж��Ƿ��Ѿ����ʹ�
		stack.push(root);//�Ƚ����ѹջ
		while(!stack.isEmpty())//ջ��Ϊ��
		{
			 TreeNode temp = stack.pop();//����ջ
			 if(hashset.contains(temp))//�ж�hashset�����޸ý��
			 {
				 result.add(temp.val);//�еĻ��ӵ����������������
			 	 continue;//ֱ�ӽ�����һ��ѭ��
			 }
			 hashset.add(temp);//hashSet���޸ý��
			 if(temp.right!=null)//�����ӽ��
			    stack.push(temp.right);//������ѹջ
			    stack.push(temp);//���ý��ѹջ
			 if(temp.left!=null)//��������
			    stack.push(temp.left);//������ѹջ
		}
		return result;
	}
}
