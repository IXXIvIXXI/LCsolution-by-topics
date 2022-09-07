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
    public ListNode sortList(ListNode head) {
        // break current list into two lists
        // sort each list and join them together
        
        // if there's only zero or one element in the list
        // you just return the list
        if (head == null || head.next == null) return head;
        
        ListNode prev = head;
        ListNode fast = head;
        ListNode slow = head;
        
        // apply Floyd's Tortoise and Hare algo to get
        // the mid-point of the list
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // seperate current list into two lists
        // list1: head -> ... -> null
        // list2: slow -> ... -> null
        prev.next = null;
        
        ListNode leftSide = sortList(head);
        ListNode rightSide = sortList(slow);
        
        return merge(leftSide, rightSide);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode sortedList = new ListNode(0);
        ListNode cur = sortedList;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            
            cur = cur.next;
        }
        
        if (l1 != null) {
            cur.next = l1;
        }
        
        if (l2 != null) {
            cur.next = l2;
        }
        
        return sortedList.next;
    }
}
