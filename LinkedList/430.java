/*
Flatten a Multilevel Doubly Linked List
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head != null) {
            flattenHelper(head);
        }
        return head;
    }

    private void flattenHelper(Node node) {
        if (node.next == null && node.child == null) {
            return;
        }

        if (node.child == null) {
            flattenHelper(node.next);
        } else{
            // remove child
            Node child = node.child;
            node.child = null;

            // get reference of next and set next pointer to child
            // child prev pointer t current node
            Node next = node.next;
            node.next = child;
            child.prev = node;

            // get reference of the last node in child linkedlist
            Node childTail = child;
            while (childTail.next != null) {
                childTail = childTail.next;
            }

            // set next pointer to next node
            childTail.next = next;
            if (next != null) next.prev = childTail;
            if (node.next != null) flattenHelper(node.next);
        }
    }
}
