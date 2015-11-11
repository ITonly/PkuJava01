/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode current = head.next;
        while(current!=null){
            if(temp.val == current.val){
                current = current.next;
            }else{
                temp.next = current;
                temp = current;
                current = current.next;
            }
        }
        temp.next = null;
        return head;
    }
}