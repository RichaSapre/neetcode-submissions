/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        ListNode p1= head;
        ListNode p2= head;

        //find middle of the list
        while(p2.next != null && p2.next.next !=null ){
            p1=p1.next;
            p2=p2.next.next;
        }


        // reverse second half
        ListNode preMiddle = p1;
        ListNode preCurr = p1.next;
        while(preCurr.next != null){
            ListNode current = preCurr.next;
            preCurr.next=current.next;
            current.next= preMiddle.next;
            preMiddle.next= current;
        }

        //reorder
        p1= head;
        p2= preMiddle.next;
        while(preMiddle != p1){
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next=p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
        
    }
}
