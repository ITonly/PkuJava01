package UglyNumber263;

public class Solution {
	public boolean isUgly(int num) {
//        if(num %2 !=0 && num % 3 != 0 && num % 5 != 0){
//        	return false;
//        }else{
//        }
//        if(num % 2 == 0 || num %3 == 0 || num % 5 == 0){
//        	num = num
//        }
        int[] factor = {2,3,5};//UglyNumber的3个公因子
        if(num < 1){//如果不是正整数，则一定不是UglyNumber
        	System.out.println("is not a UglyNumber");
        	return false;
        }
        if(num == 1)//如果特定为1，由题意可知是
        {
        	System.out.println("is a UglyNumber");
        	return true;
        }
        for (int i = 0; i < factor.length; i++) {
        //num重复除以2，3，5这三个公因子数，直到不能整除2，3，5这三个因子为止
			while(num % factor[i] == 0){
				num /= factor[i];
			}
		}
        if(num == 1)//若最后为1，则为Ugly Number
        {
        	System.out.println("is a UglyNumber");
        	return true;
        }
        else {//最后不是1，则含有除2,3,5之外的因子，故不是Ugly Number
        	System.out.println("is not a UglyNumber");
			return false;
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		solution.isUgly(14);
	}

}
