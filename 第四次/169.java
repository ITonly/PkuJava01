public class Solution {
    public int majorityElement(int[] nums) {
        
        if(nums.length == 1){
            return nums[0];
        }
        
        Arrays.sort(nums);
        //��Ϊ�������majorityElement�������majorityElementһ������λ��
        return nums[nums.length/2];
        
    }
}