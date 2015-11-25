package SingleNumber136;

public class Solution {
	
	public int singleNumber(int[] nums) {
		//根据异或运算有：一个整数和其本身异或之后得到值是0,与0异或之后为其本身
        int single = 0;
        if(nums.length == 1) //如果数组只有一个整数，直接返回该数
        	return nums[0];
        for(int i = 0; i < nums.length; i++) {//对数组所有的数进行与0的异或计算
        	single ^= nums[i]; 
        }     
        System.out.println(single);//最后得到数组中单个的数
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
