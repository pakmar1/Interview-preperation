# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head = ListNode(0)  # dummy head
        current = head

        while l1 or l2:
            if current is None:
                break
            
            v1 = l1.val if l1 else 0
            v2 = l2.val if l2 else 0
            sum_ = v1 + v2 + current.val

            current.val = sum_ % 10
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None

            current.next = ListNode(sum_ // 10) if any([sum_ >= 10, l1, l2]) else None
            current = current.next

        return head
