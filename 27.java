public class Solution {
    public int removeElement(int[] nums, int val) {
        int size=0;
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]!=val){
                nums[size++]=nums[i];
            }
        }
        return size;
        
    }
}