package MoveZeroes;

public class Solution283 {
	    public void moveZeroes(int[] nums) {
	        int a = 0 ;//数组排序后的下标
	        for(int i = 0 ; i < nums.length ; i++){
	        	if(nums[i] != 0){//如果数组元素不为零
	        		nums[a] = nums[i];//将不为零的数组元素往前提
	        		i ++;
	        	}
	        }
	        for (; a < nums.length; a++) {//将后面的数都置为零
				nums[a] = 0;
			}
	    }
	
}
