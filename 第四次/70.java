package ClimbStairs70;

import SingleNumber136.Solution;

public class Solution70 {
	public int climbStairs(int n) {
		 //쳲���������
		if(n == 0)//0��̨��ֱ�ӷ���
            return 0;
        // int sum = 0;//ǰ�������ֵĺ�
        int sum = 1;
        int a = 0;//��һ������
        int b = 1;//�ڶ�������
        for(int i = 1; i < n; i ++){//ѭ����Ӹ�ֵ
          // sum = a + b;
            a = b;
            b = sum;     
            sum = a + b;
        }
        System.out.println(sum+" distinct ways you can climb to the top");
        return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution70 solution = new Solution70();
		solution.climbStairs(6);
		
	}
}
