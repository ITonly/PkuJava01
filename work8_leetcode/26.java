public class Solution {
    public int removeDuplicates(int[] nums) {
        int l=nums.length;
        if(l<2){
            return l;
        }
        int count=1;//����ͬ������ĸ���
        for(int i=1;i<l;i++){
            if(nums[i]!=nums[i-1])
            nums[count++]=nums[i];//�͵�ɾ�����Ѳ���ͬ�Ķ�������ǰ��
        }
        return count;
        
        
    }
}