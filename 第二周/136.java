package SingleNumber136;

public class Solution {
	
	public int singleNumber(int[] nums) {
		//������������У�һ���������䱾�����֮��õ�ֵ��0,��0���֮��Ϊ�䱾��
        int single = 0;
        if(nums.length == 1) //�������ֻ��һ��������ֱ�ӷ��ظ���
        	return nums[0];
        for(int i = 0; i < nums.length; i++) {//���������е���������0��������
        	single ^= nums[i]; 
        }     
        System.out.println(single);//���õ������е�������
        return single;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] a = {6,2,3,2,3};
		solution.singleNumber(a);
		
	}

}
