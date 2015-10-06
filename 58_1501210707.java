
public class Solution {
	public int lengthOfLastWord(String s){
		int length = s.length();
		/*int count = length-1;
		if (length==0) {
			return 0;
		}else {
			//while (s.charAt(count)!=' ') {
			//while (s.charAt(count)!=' '&&count!=0) {
			while (count>=0 && s.charAt(count)!=' ') {
				count--;
			}
			//return s.substring(count+1, length-1);
			return length-1-count;
		}*/
		int temp = length-1;
		if (length==0) {
			return 0;
		}else {
			while (temp>=0 && s.charAt(temp)==' ') {
				temp--;
			}
			int temp1 = temp;//temp1为最后一个字符的下标
			while (temp1>=0 && s.charAt(temp1)!=' ') {
				temp1--;
			}
			return temp-temp1;
		}

	}

	/*public static void main(String[] args) {
		String s = "Hello";
		System.out.println(" ".equals("  "));
		System.out.println(new Solution().lengthOfLastWord("aa sss"));
	}*/

}
