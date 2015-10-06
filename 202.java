import java.util.HashSet;
import java.util.Set;

//此题没想到用set集合，百度了一下
public class Solution {
	public boolean isHappy(int n){
		//Set接口中没有重复元素
		int temp = n;
		Set<Integer> set = new HashSet<Integer>();
		while(temp != 1){
			temp = next(temp);
			if (set.contains(temp)) {
				return false;
			}
			set.add(temp);
		}
		return true;
	}
	//计算下一个数
	public int next(int n){
		int sum = 0;
		int digit;
		while (n!=0) {
			digit = n % 10;
			sum += Math.pow(digit, 2);
			n = n / 10;
		}
		return sum;
	}

	/*public static void main(String[] args) {
		int num = 18;
		System.out.println(new Solution().isHappy(num));
	}*/

}
