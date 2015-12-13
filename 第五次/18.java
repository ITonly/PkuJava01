package FourSum18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
      
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);//数组排序
		for (int i = 0; i < nums.length; i++) {//将nums[i]定为第一个数字
			for (int j = i + 1; j < nums.length; j++) {//将nums[i+1]初始定为第二个数字
				int k = j + 1;//将nums[i+2]初始定为第三个数字
				int l = nums.length - 1;//将数组最后一个数字初始定为第三个数字
	 
				while (k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
	 
					if (sum > target) {//四个数字之和比目标值大
						l--;//将最后一个数字下标减1
					} else if (sum < target) {//四个数字之和比目标值小
						k++;//第三个数字下标加1
					} else if (sum == target) {//得到目标值
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						temp.add(nums[l]);
						
						//避免重复
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
