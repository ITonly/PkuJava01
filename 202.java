import java.util.HashSet;
import java.util.Set;

//����û�뵽��set���ϣ��ٶ���һ��
public class Solution {
	public boolean isHappy(int n){
		//Set�ӿ���û���ظ�Ԫ��
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
	//������һ����
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
