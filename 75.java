public class Solution {
    public void sortColors(int[] nums) {
    	 int count0 = 0;//��¼������Ϊ0�ĸ���
         int count1 = 0;//��¼������Ϊ1�ĸ���
         int count2 = 0;//��¼������Ϊ2�ĸ���
        //  int[] nums2;//����֮�������
         for (int i = 0; i < nums.length; i++) {//ѭ������ѯ0,1,2����ĸ���
			if(nums[i] == 0)
				count0 ++;
// 			else if(nums[i] == 1)
            if(nums[i] == 1)
				count1 ++;
// 			else count2 ++;
            if(nums[i] == 2)
                count2 ++;
		}
        //  nums2 = new int[nums.length];//Ϊ���������鿪�ٿռ䣬�������ʼ����һ��
         for (int j = 0; j < count0; j++) {//��0��1,2˳��ֱ��Ϊ�����鸳ֵ
       //  	nums2[j] = 0;
			nums[j] = 0;
		}
//       for (int j = count0+1; j < count0+count1; j++) {
         for (int j = count0; j < count0+count1; j++) {
    //  	nums2[j] = 1;  
 			nums[j] = 1;
 		}
//       for (int j = count0+count1+1; j < count0+count1+count2; j++) {
         for (int j = count0+count1; j < count0+count1+count2; j++) {
     //  	nums2[j] = 2;
  			nums[j] = 2;
  		}
        //  for (int k = 0; k < nums2.length; k++) {//�������������Ա�鿴
// 			System.out.println(nums2[k]);
// 		}
    }
}