package CountPrimes204;

public class Solution {
	 public int countPrimes(int n) {
		 if (n <= 1) {
	            return 0;
	        }
	 
	        int count = 0;
	        boolean[] arr = new boolean[n];//��ʼ����Ϊfalse
	        for (int i = 2; i < n; i++) {
	             
	            //���arr[i]���������䱶��ȫ�����Ϊ�����������迼��
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
