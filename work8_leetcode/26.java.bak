import java.util.Arrays;
public class Solution {
     public  boolean containsDuplicate(int[] nums) {
         Arrays.sort(nums);
         if(nums.length<2){
             return false;
         }
	        boolean result=true;
	        for(int i=0;i<nums.length-1;i++){
	            if(nums[i]==nums[i+1]){
	                result= true;
	                break;
	                
	            }
	            else{
	                if(i==nums.length-2){
	                   // return false;
	                	result=false;
	                }
	            }
	        }
	        return result;
	        
	    }
}