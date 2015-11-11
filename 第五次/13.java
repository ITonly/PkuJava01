public class Solution {
    public int romanToInt(String s) {
        	int result = 0;
	        System.out.println("given a roman numeral is:"+s);
	        char[] a = s.toCharArray();//把字符串转换为字符数组
	        int beforeI = 0;//前面是否有I；0为没有，否则有
	        int beforeX = 0;//前面是否有X；0为没有，否则有
	        int beforeC = 0;//前面是否有C；0为没有，否则有
	        for (int i = 0; i < a.length; i++) {//循环遍历
			  switch( a[i] ){
			  
				case 'I':	//为1
							beforeI++;
					 			break;
				case 'V':	//为5
							//前面没有I
							if (beforeI == 0) {
								result += 5;
							}//前面有I，且只能为1个I ( V左边的小数字只能用 Ⅰ)
							else{
								result += 4;	
							}	
								beforeI = 0;
								break;
				case 'X':	//为10
							//前面没有I
							if(beforeI == 0){
							 //   result += 10;
								beforeX++;
							}//前面有I，这种情况为I有且只有一个( X 左边的小数字只能用 Ⅰ)
							else{
								result += 9;	
							}
								beforeI = 0;
								break;
				case 'L':	//为50
							//前面没有X
							if (beforeX == 0) {
								result += 50;
							}//前面有X,且只有一个 ( L 左边的小数字只能用X )
							else{
								result += 40;
							}
								beforeX = 0;
								break;
				case 'C': 	//为100
							//前面没有X
							if (beforeX == 0) {
							//   result += 100;
							    beforeC ++;
							}//前面有X,且只有一个 ( C 左边的小数字只能用X )
							else{
								result += 90;
							}
								beforeX = 0;
								break;
				case 'D':	//为500
							//前面没有	C
							if (beforeC == 0) {
								result += 500;
							}//前面有C,且只有一个 ( D 左边的小数字只能用C )
							else {
								result += 400;
							}
							beforeC = 0;
								break;
				case 'M':	//为1000
							//前面没有C
							if (beforeC ==0 ) {
								result += 1000;
							}//前面有C,且只有一个 ( M 左边的小数字只能用C )
							else{
								result += 900;
							}
							beforeC = 0;
								break;
			}
		}
	        result = result + 100*beforeC + 10*beforeX + beforeI;

	        System.out.println("converted to an integer:"+result);
	        return result;
    }
}