/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    /*
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head.next;
        ListNode slow = head;
        Set<ListNode> nodeSet = new HashSet<>();
        
        while (fast != slow) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return null;
            }
        }
        
        ListNode start = fast;
        nodeSet.add(fast);
        fast = fast.next;
        while (fast != start) {
            nodeSet.add(fast);
            fast = fast.next;
        }
        
        while (!nodeSet.contains(head)) {
            head = head.next;
        }
        
        return head;
    }
    */
    
    // optimized Floyd's Tortoise and Hare
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode intersection = null;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                intersection = slow;
                break;
            }
        }
        
        if (intersection == null) return null;
        
        // a -> b -> ... -> c -> ... -> d -> .. -> e
        //                   |     (intersection)  |  
        //                   |_ _ _ _ _ _ _ _ _ _ _|
        
        // from a to c there are f nodes in total
        // from c to d there are x nodes in total
        // from d to e there are y nodes in total
        
        // we know that nodes travelled by fast == 2(slow)
        // nodes travelled by slow = (f + x)
        // nodes travelled by fast = f + 2x + y
        // Thus f + 2x + y = 2(f + x) -> f = y
        
        // Therefore, if we start from the begining we can reach
        // the same point as we start from the intersection by travelling
        // f nodes which is the same distance we need to travel to the 
        // start of the cycle from the head node
        
        
        while (head != intersection) {
            head = head.next;
            intersection = intersection.next;
        }
        
        return intersection;
        
    }
}
