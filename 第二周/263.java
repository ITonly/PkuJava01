package UglyNumber263;

public class Solution {
	public boolean isUgly(int num) {
//        if(num %2 !=0 && num % 3 != 0 && num % 5 != 0){
//        	return false;
//        }else{
//        }
//        if(num % 2 == 0 || num %3 == 0 || num % 5 == 0){
//        	num = num
//        }
        int[] factor = {2,3,5};//UglyNumber��3��������
        if(num < 1){//�����������������һ������UglyNumber
        	System.out.println("is not a UglyNumber");
        	return false;
        }
        if(num == 1)//����ض�Ϊ1���������֪��
        {
        	System.out.println("is a UglyNumber");
        	return true;
        }
        for (int i = 0; i < factor.length; i++) {
        //num�ظ�����2��3��5����������������ֱ����������2��3��5����������Ϊֹ
			while(num % factor[i] == 0){
				num /= factor[i];
			}
		}
        if(num == 1)//�����Ϊ1����ΪUgly Number
        {
        	System.out.println("is a UglyNumber");
        	return true;
        }
        else {//�����1�����г�2,3,5֮������ӣ��ʲ���Ugly Number
        	System.out.println("is not a UglyNumber");
			return false;
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		solution.isUgly(14);
	}

}
