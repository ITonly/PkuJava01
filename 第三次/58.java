package LengthofLastWord58;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class Solution {
	 public int lengthOfLastWord(String s) {
	     String[] ss = s.trim().split(" ");//ȥ���ַ���ǰ��Ŀո��Կո�ָ��ַ���
	     int len = ss.length;//�õ��ָ����ַ����鳤��
	     if(len == 0 || s.trim().equals("")){//��Ϊ��
	    	 return 0;
	     }else{
	    	 System.out.println(ss[len-1].length());//�����֤
	    	 return ss[len-1].length();//�����ַ��������һλ�ĳ���
	     }
	  }
	 public static void main(String[] args){
			// TODO Auto-generated method stub
		Solution s1= new Solution();
		String a= "hello worlddd ";
		s1.lengthOfLastWord(a); 
	 }
}
