
public class Solution {
	public void rotate(int[] nums,int k){
		/*if(k < 0){
			k = nums.length+k;
		}*/
		if(k>=0){
			k = k % nums.length;
		}else{
			k = (nums.length+k)%nums.length;
		}
		System.out.println("k:"+k);
		//����洢k����ǰ�Ƶ�Ԫ��
		int[] temp = new int[k]; 
		for (int i = 0; i < k; i++) {
			temp[i] = nums[nums.length-k+i];
		}
		//��ǰ�ߵ�Ԫ�غ���
		int temp1 = nums.length-temp.length-1;//����Ƶ����һ��Ԫ�ص��±�
		for (int i = nums.length-temp.length-1; i >= 0; i--) {
			nums[i+k] = nums[i];
		}
		
		//��k��Ԫ�ش洢������ǰk��λ��
		for (int i = 0; i < k; i++) {
			nums[i] = temp[i];
		}
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		Solution test = new Solution();
		test.rotate(a, 5);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}		
	}

}
