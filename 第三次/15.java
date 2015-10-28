package ThreeSum15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
	 public List<List<Integer>> threeSum(int[] nums) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();  
	        int len = nums.length;  
	        if (len <= 2)  
	            return  result;  
	        Arrays.sort(nums);  
	        for (int i = 0; i <= len - 3; i++) {  
	            // ��nums[i]��Ϊ��һ������
	            int j = i + 1;//��nums[i+1]��ʼ��Ϊ�ڶ�������
	            int k = len - 1;//���������һ�����ֳ�ʼ��Ϊ����������
	            int other = 0 - nums[i];//��Ϊ�������ֺ�Ϊ0����һ��������ѭ����ʼʱ�Ѿ�ȷ������ʣ���������ֺ�ֻ������0����һ�����ּ���
	            while (j < k) {  
	                if ( nums[j] + nums[k] < other) {  //����ڶ����͵��������ֺ�С��Ӧ�������ֵ��ڶ��������±��1
	                    j++;  
	                } else if ( nums[j] + nums[k] > other) {//����ڶ����͵��������ֺ�С��Ӧ�������ֵ������������±��1
	                    k--;  
	                } else {  
	                	result.add(Arrays.asList(nums[i], nums[j], nums[k])); //asList�����Զ����� 
	                    j++;  
	                    k--;  
	                    while (j < k && nums[j] == nums[j - 1])//�����ظ�
	                        j++;  
	                    while (j < k && nums[k] == nums[k + 1])//�����ظ� 
	                        k--;  
	                }  
	            }  
	            while (i <= len - 3 && nums[i] == nums[i + 1]) //�����ظ� 
	                i++;  
	        }  
	        return result;  
	  
	 }
}
