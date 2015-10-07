public class Solution {
    public int myAtoi(String str) {
         long value = 0;//最后返回的对应数值
        //  int value = 0;
		 int max = 2147483647;
		 int min = -2147483648;
		 int sign = 1;//正负号，正为1，负为-1
		 
	     str = str.trim();//使用trim函数删除字符串首尾的空白
	     if(str.length() == 0){
	    	 return 0;
	     }
	     int i = 0;//遍历str的当前位置的下标
	     if(str.charAt(i) == '-' || str.charAt(i) == '+'){
	         if(str.charAt(i) == '-')
	    	     sign = -1;
	    	 i++;
	     }
	   //  i++;
	   //  for (; i < str.length(); i++) {
	       for (int j = i ; j < str.length(); j++) {
			char a = str.charAt(j);//将当前str位置字母赋给a
			if(a >= '0' && a <= '9'){//当前字母为数字
			    value = value * 10 + ( a - '0' );//计算对应整数值
			}else //若非数字则退出
			    break;
			
			if(sign == 1 && value > max)
			    return max;
			if(sign == -1 && -value < min)
			    return min;
			
// 		 value = value * sign;//加上正负号
// 		 if(value > max)//上溢
			 //return max;
// 		 if(value < min)//下溢
			 //return min;
		}
		if(sign == -1 )
    	    value = value * sign;//若为负数加上负号
		return (int)value;
    }
}