public class Solution {
    public void sortColors(int[] nums) {
    	 int count0 = 0;//记录数组中为0的个数
         int count1 = 0;//记录数组中为1的个数
         int count2 = 0;//记录数组中为2的个数
        //  int[] nums2;//排序之后的数组
         for (int i = 0; i < nums.length; i++) {//循环，查询0,1,2数组的个数
			if(nums[i] == 0)
				count0 ++;
// 			else if(nums[i] == 1)
            if(nums[i] == 1)
				count1 ++;
// 			else count2 ++;
            if(nums[i] == 2)
                count2 ++;
		}
        //  nums2 = new int[nums.length];//为排序后的数组开辟空间，长度与初始数组一致
         for (int j = 0; j < count0; j++) {//按0，1,2顺序直接为新数组赋值
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
        //  for (int k = 0; k < nums2.length; k++) {//输出排序后数组以便查看
// 			System.out.println(nums2[k]);
// 		}
    }
}