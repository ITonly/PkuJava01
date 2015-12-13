package FourSum18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
      
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);//��������
		for (int i = 0; i < nums.length; i++) {//��nums[i]��Ϊ��һ������
			for (int j = i + 1; j < nums.length; j++) {//��nums[i+1]��ʼ��Ϊ�ڶ�������
				int k = j + 1;//��nums[i+2]��ʼ��Ϊ����������
				int l = nums.length - 1;//���������һ�����ֳ�ʼ��Ϊ����������
	 
				while (k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
	 
					if (sum > target) {//�ĸ�����֮�ͱ�Ŀ��ֵ��
						l--;//�����һ�������±��1
					} else if (sum < target) {//�ĸ�����֮�ͱ�Ŀ��ֵС
						k++;//�����������±��1
					} else if (sum == target) {//�õ�Ŀ��ֵ
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						temp.add(nums[l]);
						
						//�����ظ�
	                    if (!hashSet.contains(temp)) {
							hashSet.add(temp);
							result.add(temp);
						}
					
						k++;
						l--;
					}
				}
			}
		}
	 
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
