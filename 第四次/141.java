package LinkedListCycle141;
public class Solution14 {
	public boolean hasCycle(ListNode head){
		//��������ָ�룬һ��fast��һ��slow
        ListNode slow = head;
        ListNode fast = head;
        while(true){
        	//�������Ϊ��
        	if(fast == null || fast.next == null || slow == null){
        		return false;
        	}
        	fast = fast.next.next;//fast��ÿһ��step���ƶ�������
        	slow = slow.next;//slowÿ���ƶ�һ��
        	//���������������Ȼ�Ǵ��ڻ�
        	if(fast == slow){
        		return true;
        	}
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}
