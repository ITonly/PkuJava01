package Adddigits258;

public class Solution {
	public int addDigits(int num) {
        int result = 0;
        result = num%9;
        if(num > 0 && result == 0){
        	result += 9;
        }
        System.out.println(result);
        return result;
    }
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		solution.addDigits(0);
	}

}
