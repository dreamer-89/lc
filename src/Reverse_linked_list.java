// Problem statement: Given the head of a singly linked list, reverse the list, and return the reversed list.

// Approach 1: Iterative solution. Use two pointers, keep reversing the next pointer as you traverse through the list
public class Reverse_linked_list {
    // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode reverseList(ListNode head) {
        ListNode current = head, previous = null;
        while(current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
}
