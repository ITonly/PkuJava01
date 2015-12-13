package LengthofLastWord58;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class Solution {
	 public int lengthOfLastWord(String s) {
	     String[] ss = s.trim().split(" ");//去除字符串前后的空格并以空格分割字符串
	     int len = ss.length;//得到分割后的字符数组长度
	     if(len == 0 || s.trim().equals("")){//若为空
	    	 return 0;
	     }else{
	    	 System.out.println(ss[len-1].length());//输出验证
	    	 return ss[len-1].length();//返回字符数组最后一位的长度
	     }
	  }
	 public static void main(String[] args){
			// TODO Auto-generated method stub
		Solution s1= new Solution();
		String a= "hello worlddd ";
		s1.lengthOfLastWord(a); 
	 }
}
