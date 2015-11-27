public class Solution {
    public int removeDuplicates(int[] nums) {
        int l=nums.length;
        if(l<2){
            return l;
        }
        int count=1;//不相同的数组的个数
        for(int i=1;i<l;i++){
            if(nums[i]!=nums[i-1])
            nums[count++]=nums[i];//就地删除，把不相同的都放在最前面
        }
        return count;
        
        
    }
}