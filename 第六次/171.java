package ExcelSheetColumnNumber171;

public class Solution171 {
	public int titleToNumber(String s) {
		
	    //int shang = 0;
	    //int yu = 0;
	    int res = 0;
	    for(int i = 0; i < s.length(); i++)
	     //   shang = s[i] - 'A' + 1;
	     //   yu = 
	     //   res = res * 26 + (s[i]-'A'+1);
	   	    res = res * 26 + (s.charAt(i)-'A'+1);//26进制转换，对应从1开始没有0
	    return res;
    }
	public static void main(String[] args)
	{
		Solution171 so = new Solution171();
		String s = "AAA";
		System.out.println(s);
		System.out.println(so.titleToNumber(s));
	}
}
