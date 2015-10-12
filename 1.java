
import java.util.Arrays;
 
public class Solution {
     public static int[] twoSum(int[] numbers, int target) 
     {
            int[] num = numbers.clone();
            Arrays.sort(num);
            int size = num.length;
            int[] answers = new int[2];
            for(int i=0;i<size;i++)
            {
                if(Arrays.binarySearch(num, target-num[i])>0)
                {
                        int count=0,index1 = 0,index2=0;
                        for(int j=0;j<size;j++)
                        {
                            if(numbers[j]==num[i]||numbers[j]==target-num[i])
                            {
                                count++;
                                if(count==2)
                                {
                                    index2=j;
                                    answers[0] = (index1<index2?index1:index2)+1;
                                    answers[1] = (index1>index2?index1:index2)+1;
                                    break;
                                }
                                else 
                                {
                                    index1=j;
                                }
                                 
                            }
                        }
                     
                     
                }
            }
            return answers;
        }
       
}