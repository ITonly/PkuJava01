package MoveZeroes;

public class Solution283 {
	    public void moveZeroes(int[] nums) {
	        int a = 0 ;//�����������±�
	        for(int i = 0 ; i < nums.length ; i++){
	        	if(nums[i] != 0){//�������Ԫ�ز�Ϊ��
	        		nums[a] = nums[i];//����Ϊ�������Ԫ����ǰ��
	        		i ++;
	        	}
	        }
	        for (; a < nums.length; a++) {//�������������Ϊ��
				nums[a] = 0;
			}
	    }
	
}
