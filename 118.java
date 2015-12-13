public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(numRows <= 0)
        	return result;
        List<Integer> firstrow = new ArrayList<Integer>();
        firstrow.add(1);//第一行总为1
        result.add(firstrow);

//       for (int i = 0; i < numRows; i++) {
         for (int i = 1; i < numRows; i++) {    
            List<Integer> row = new ArrayList<Integer>();
            // List<Integer> prerow = new ArrayList<Integer>();
            // prerow = result.get(i-1);
			row.add(1);//每一行的第一个数总为1
// 			for(int j = 0; j < i; j++){
            for(int j = 1; j < i; j++){//计算除了第一行以外的行
//				row.add(row.get(i-1)+
                // row.add(prerow.get(j-1)+prerow.get(j));
				row.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));//这一行的第j个数字等于上一行第J个数字和第j-1个数字的和
			}
			row.add(1);////每一行的最后一个数总为1
			result.add(row);
		}
        return result;
    }
}