public class Solution {
    public int myAtoi(String str) {
         long value = 0;//��󷵻صĶ�Ӧ��ֵ
        //  int value = 0;
		 int max = 2147483647;
		 int min = -2147483648;
		 int sign = 1;//�����ţ���Ϊ1����Ϊ-1
		 
	     str = str.trim();//ʹ��trim����ɾ���ַ�����β�Ŀհ�
	     if(str.length() == 0){
	    	 return 0;
	     }
	     int i = 0;//����str�ĵ�ǰλ�õ��±�
	     if(str.charAt(i) == '-' || str.charAt(i) == '+'){
	         if(str.charAt(i) == '-')
	    	     sign = -1;
	    	 i++;
	     }
	   //  i++;
	   //  for (; i < str.length(); i++) {
	       for (int j = i ; j < str.length(); j++) {
			char a = str.charAt(j);//����ǰstrλ����ĸ����a
			if(a >= '0' && a <= '9'){//��ǰ��ĸΪ����
			    value = value * 10 + ( a - '0' );//�����Ӧ����ֵ
			}else //�����������˳�
			    break;
			
			if(sign == 1 && value > max)
			    return max;
			if(sign == -1 && -value < min)
			    return min;
			
// 		 value = value * sign;//����������
// 		 if(value > max)//����
			 //return max;
// 		 if(value < min)//����
			 //return min;
		}
		if(sign == -1 )
    	    value = value * sign;//��Ϊ�������ϸ���
		return (int)value;
    }
}