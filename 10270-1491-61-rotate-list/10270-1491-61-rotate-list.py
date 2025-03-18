from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:  
        if not head or not head.next or k == 0:
            return head  # Edge cases
        
        # Step 1: Find length of the list and last node
        length = 1
        tail = head
        while tail.next:
            tail = tail.next
            length += 1
        
        # Step 2: Compute effective k
        k = k % length
        if k == 0:
            return head  # No rotation needed
        
        # Step 3: Find new tail (length - k - 1) and new head (length - k)
        new_tail = head
        for _ in range(length - k - 1):
            new_tail = new_tail.next
        
        new_head = new_tail.next  # New head starts from here
        new_tail.next = None  # Break the link
        
        # Step 4: Connect old tail to old head
        tail.next = head
        
        return new_head
