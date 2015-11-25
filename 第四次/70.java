package ClimbStairs70;

import SingleNumber136.Solution;

public class Solution70 {
	public int climbStairs(int n) {
		 //斐波那契数列
		if(n == 0)//0个台阶直接返回
            return 0;
        // int sum = 0;//前两个数字的和
        int sum = 1;
        int a = 0;//第一个数字
        int b = 1;//第二个数字
        for(int i = 1; i < n; i ++){//循环相加赋值
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
