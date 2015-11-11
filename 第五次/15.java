//Àà±È18Ìâ 4sum
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> hashset = new HashSet<ArrayList<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0;i<nums.length;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum>0){
                    k--;
                }else if(sum<0){
                    j++;
                }else if(sum==0){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    if(!hashset.contains(temp)){
                        hashset.add(temp);
                        result.add(temp);
                    }
                    j++;
                    k--;
                }
               
            }
            
        }
        return result;
    }
}