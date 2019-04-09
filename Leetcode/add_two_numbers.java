/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode answerRoot = null;

        int carry = 0;
        while(l1 != null || l2 != null || carry > 0) {
            ListNode next = new ListNode((l2 == null ? 0 : l2.val) + (l1 == null ? 0 : l1.val) + carry);
            carry = next.val / 10;
            next.val = next.val % 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            if(answer != null) {
                answer.next = next;
            }

            answer = next;

            if(answerRoot == null) {
                answerRoot = answer;
            }
        }

        if(answerRoot == null) {
            answerRoot = new ListNode(0);
        }

        return answerRoot;
    }
}
