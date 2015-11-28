package BestTimetoBuyandSellStock121;

import ExcelSheetColumnNumber171.Solution171;

public class Solution121 {
	 public int maxProfit(int[] prices) {
		 int maxpro = 0;//最大利润
//		 int min = 0;//最低股价
		 int min =  2147483647;
		 int temp = 0;//当前股价与最低股价的差值
		 
		 for (int i = 0; i < prices.length; i++) {
			if (min > prices[i]) {//比较当前股价和最低股价哪个更低
				min = prices[i];
			}
			temp = prices[i] - min;
			if (temp > maxpro) {//寻找最大利润值
				maxpro = temp;
			}
		}
		return maxpro; 
	 }
	 public static void main(String[] args)
		{
			Solution121 so = new Solution121();
			int pri[] = {2,4,12};
			System.out.println(so.maxProfit(pri));
		}
}
