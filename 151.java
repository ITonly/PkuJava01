
public class Solution {
	public String reverseWords(String s) {
		if (s.length()==0) {
			return "";
		}
		//split方法将字符串划分为字符串数组
		String[] array = s.split(" ");
		//字符串变量
		StringBuilder sb = new StringBuilder();
		/*for (int i = array.length-1; i >= 0; i--) {
			sb.append(array[i]).append(" ");
		}*/
		for (int i = array.length-1; i >= 0; i--) {
			//if (!array[i].equals("")) {
				sb.append(array[i]).append(" ");
			//}
		}
		System.out.println(sb.length());
		
		//////////需加入以下代码，解决字符串为空字符
		if(sb.length()==0){
			return "";
		}
		////////////
		
		return sb.substring(0, sb.length()-1);
	}
		

	public static void main(String[] args) {
		String s = "  ";
		String newS = new Solution().reverseWords(s);
		for (int i = 0; i < newS.length(); i++) {
			System.out.println(newS.charAt(i));
		}
	}

}
