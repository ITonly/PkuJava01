
public class Solution {
	
	public int reverse(int x) {
        if(x > -10 && x < 10){
        	return x;
        }
        Boolean flag = true;
        if(x < 0){
        	flag = false;
        	x = -x;
        }
        long res = 0;//避免反转后溢出
        while(x != 0){
        	res = res*10 + x%10;
        	x /= 10;
        }
        if(flag == false){
        	res = -res;
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
        	return 0;
        }
		return (int)res;
    }

}
