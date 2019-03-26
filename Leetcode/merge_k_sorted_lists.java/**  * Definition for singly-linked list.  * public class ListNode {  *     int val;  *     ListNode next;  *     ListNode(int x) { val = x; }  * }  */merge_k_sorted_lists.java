/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(ListNode node : lists ){
            while(node!=null){
                pq.add(node.val);
                node=node.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(!pq.isEmpty()){
            current.next = new ListNode(pq.poll());
            current=current.next;
        }
        return dummy.next;
    }
}
