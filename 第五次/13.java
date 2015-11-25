public class Solution {
    public int romanToInt(String s) {
        	int result = 0;
	        System.out.println("given a roman numeral is:"+s);
	        char[] a = s.toCharArray();//���ַ���ת��Ϊ�ַ�����
	        int beforeI = 0;//ǰ���Ƿ���I��0Ϊû�У�������
	        int beforeX = 0;//ǰ���Ƿ���X��0Ϊû�У�������
	        int beforeC = 0;//ǰ���Ƿ���C��0Ϊû�У�������
	        for (int i = 0; i < a.length; i++) {//ѭ������
			  switch( a[i] ){
			  
				case 'I':	//Ϊ1
							beforeI++;
					 			break;
				case 'V':	//Ϊ5
							//ǰ��û��I
							if (beforeI == 0) {
								result += 5;
							}//ǰ����I����ֻ��Ϊ1��I ( V��ߵ�С����ֻ���� ��)
							else{
								result += 4;	
							}	
								beforeI = 0;
								break;
				case 'X':	//Ϊ10
							//ǰ��û��I
							if(beforeI == 0){
							 //   result += 10;
								beforeX++;
							}//ǰ����I���������ΪI����ֻ��һ��( X ��ߵ�С����ֻ���� ��)
							else{
								result += 9;	
							}
								beforeI = 0;
								break;
				case 'L':	//Ϊ50
							//ǰ��û��X
							if (beforeX == 0) {
								result += 50;
							}//ǰ����X,��ֻ��һ�� ( L ��ߵ�С����ֻ����X )
							else{
								result += 40;
							}
								beforeX = 0;
								break;
				case 'C': 	//Ϊ100
							//ǰ��û��X
							if (beforeX == 0) {
							//   result += 100;
							    beforeC ++;
							}//ǰ����X,��ֻ��һ�� ( C ��ߵ�С����ֻ����X )
							else{
								result += 90;
							}
								beforeX = 0;
								break;
				case 'D':	//Ϊ500
							//ǰ��û��	C
							if (beforeC == 0) {
								result += 500;
							}//ǰ����C,��ֻ��һ�� ( D ��ߵ�С����ֻ����C )
							else {
								result += 400;
							}
							beforeC = 0;
								break;
				case 'M':	//Ϊ1000
							//ǰ��û��C
							if (beforeC ==0 ) {
								result += 1000;
							}//ǰ����C,��ֻ��һ�� ( M ��ߵ�С����ֻ����C )
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