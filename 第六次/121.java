package BestTimetoBuyandSellStock121;

import ExcelSheetColumnNumber171.Solution171;

public class Solution121 {
	 public int maxProfit(int[] prices) {
		 int maxpro = 0;//�������
//		 int min = 0;//��͹ɼ�
		 int min =  2147483647;
		 int temp = 0;//��ǰ�ɼ�����͹ɼ۵Ĳ�ֵ
		 
		 for (int i = 0; i < prices.length; i++) {
			if (min > prices[i]) {//�Ƚϵ�ǰ�ɼۺ���͹ɼ��ĸ�����
				min = prices[i];
			}
			temp = prices[i] - min;
			if (temp > maxpro) {//Ѱ���������ֵ
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
