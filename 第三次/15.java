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
	            // 将nums[i]定为第一个数字
	            int j = i + 1;//将nums[i+1]初始定为第二个数字
	            int k = len - 1;//将数组最后一个数字初始定为第三个数字
	            int other = 0 - nums[i];//因为三个数字和为0，第一个数字在循环开始时已经确定，故剩下两个数字和只需满足0减第一个数字即可
	            while (j < k) {  
	                if ( nums[j] + nums[k] < other) {  //如果第二个和第三个数字和小于应满足的数值则第二个数字下标加1
	                    j++;  
	                } else if ( nums[j] + nums[k] > other) {//如果第二个和第三个数字和小于应满足的数值则第三个数字下标减1
	                    k--;  
	                } else {  
	                	result.add(Arrays.asList(nums[i], nums[j], nums[k])); //asList可以自动更新 
	                    j++;  
	                    k--;  
	                    while (j < k && nums[j] == nums[j - 1])//避免重复
	                        j++;  
	                    while (j < k && nums[k] == nums[k + 1])//避免重复 
	                        k--;  
	                }  
	            }  
	            while (i <= len - 3 && nums[i] == nums[i + 1]) //避免重复 
	                i++;  
	        }  
	        return result;  
	  
	 }
}
