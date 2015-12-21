package CountPrimes204;

public class Solution {
	 public int countPrimes(int n) {
		 if (n <= 1) {
	            return 0;
	        }
	 
	        int count = 0;
	        boolean[] arr = new boolean[n];//初始化都为false
	        for (int i = 2; i < n; i++) {
	             
	            //如果arr[i]是质数则将其倍数全部标记为合数，否则不予考虑
	            if (!arr[i]) {
	            	count++;
	            } else {
	                continue;
	            }
	 
	            int j = 2;
	            while (i * j < n) {
	                arr[i * j] = true;
	                j++;
	            }
	        }
	         
	        return count;
	 }
}
