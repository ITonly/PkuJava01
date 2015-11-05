public class Solution {
    public int majorityElement(int[] nums) {
        
        if(nums.length == 1){
            return nums[0];
        }
        
        Arrays.sort(nums);
        //因为假设存在majorityElement，则这个majorityElement一定是中位数
        return nums[nums.length/2];
        
    }
}