package LinkedListCycle141;
public class Solution14 {
	public boolean hasCycle(ListNode head){
		//设立两个指针，一个fast，一个slow
        ListNode slow = head;
        ListNode fast = head;
        while(true){
        	//如果链表为空
        	if(fast == null || fast.next == null || slow == null){
        		return false;
        	}
        	fast = fast.next.next;//fast在每一个step中移动两步，
        	slow = slow.next;//slow每次移动一步
        	//如果两者相遇，必然是存在环
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
