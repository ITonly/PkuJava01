/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//import java.util.ArrayList;
//import java.util.Vector;
public class Solution {
    
    //[-16557,-8725,-29125,28873,-21702,15483,-28441,-17845,-4317,-10914,-10914,-4317,-17845,-28441,15483,-21702,28873,-29125,-8725,-16557] 
    /*public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
        	return true;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        //Vector<Integer> list = new Vector<Integer>();
        while(head != null){
        	list.add(head.val);
        	head = head.next;
        }
        int i = 0;
        int j = list.size()-1;
        while(i<j){
        	if(list.get(i) != list.get(j)){
        		return false;
        	}
        	i++;
        	j--;
        }
        return true;
    }*/
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
        	return true;
        }
        ListNode latter = theLatterPart(head);
        ListNode sec = reverse(latter);
        while(head != null && sec != null){
            if(head.val != sec.val){
                return false;
            }
            head = head.next;
            sec = sec.next;
        }
        return true;
    }
    //abcba，获得ba
    public ListNode theLatterPart(ListNode head){
        ListNode second = head;
        //while(second.next.next != null){    空指针
        while(second.next != null && second.next.next != null){
            second = second.next.next;
            head = head.next;
        }
        head = head.next;
        return head;
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head; 
        }

        ListNode pre = head;
        ListNode current = pre.next;
        pre.next = null;//断开第一个与之后的链接
        ListNode next;
        while(current != null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
}



