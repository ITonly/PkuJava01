public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(numRows <= 0)
        	return result;
        List<Integer> firstrow = new ArrayList<Integer>();
        firstrow.add(1);//��һ����Ϊ1
        result.add(firstrow);

//       for (int i = 0; i < numRows; i++) {
         for (int i = 1; i < numRows; i++) {    
            List<Integer> row = new ArrayList<Integer>();
            // List<Integer> prerow = new ArrayList<Integer>();
            // prerow = result.get(i-1);
			row.add(1);//ÿһ�еĵ�һ������Ϊ1
// 			for(int j = 0; j < i; j++){
            for(int j = 1; j < i; j++){//������˵�һ���������
//				row.add(row.get(i-1)+
                // row.add(prerow.get(j-1)+prerow.get(j));
				row.add(result.get(i-1).get(j-1)+result.get(i-1).get(j));//��һ�еĵ�j�����ֵ�����һ�е�J�����ֺ͵�j-1�����ֵĺ�
			}
			row.add(1);////ÿһ�е����һ������Ϊ1
			result.add(row);
		}
        return result;
    }
}