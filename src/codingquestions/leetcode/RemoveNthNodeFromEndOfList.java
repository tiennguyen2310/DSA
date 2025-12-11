/*
19. Remove Nth Node From End of List
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 

Follow up: Could you do this in one pass?
*/
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int sz = 0;
        while(cur != null){
            sz++;
            cur = cur.next;
        }
        // System.out.println(sz);
        cur = head;
        if(sz == 1){
            head = null;
            return head;
        }

        if(n == 1){
            while(cur.next.next != null)
                cur = cur.next;
            
            cur.next = null;
            return head;
        }

        if(sz == n){
            head = head.next;
            return head;
        }

        n = sz - n - 1;
        System.out.println(n);
        while(n > 0){
            cur = cur.next;
            n--;
        }

        cur.next = cur.next.next;
        return head;
    }
}
