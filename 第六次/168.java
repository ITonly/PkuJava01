package ExcelSheetColumnTitle168;

import ExcelSheetColumnNumber171.Solution171;

public class Solution168 {
    public String convertToTitle(int n) {
        String ret = "";
        while(n > 0)//26进制转换，从1开始转换没有0
        {
            ret = (char)((n-1)%26+'A') + ret;//先减1，因为没有0，除以26取余
            n = (n-1)/26;
        }
        return ret;  
    }
    public static void main(String[] args)
	{
		Solution168 so = new Solution168();
		int n = 27;
		System.out.println(n);
		System.out.println(so.convertToTitle(n));
	}
}
