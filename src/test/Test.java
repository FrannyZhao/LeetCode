package test;

import utils.ListNode;

public class Test {
    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode new_head = null;
        ListNode ptr = head;
        while (k > 0) {
            ListNode next_node = ptr.next;
            ptr.next = new_head;
            new_head = ptr;
            ptr = next_node;
            k--;
        }
        return new_head;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode ktail = null;
        ListNode new_head = null;
        while (ptr != null) {
            int count = 0;
            ptr = head;
            while (count < k && ptr != null) {
                ptr = ptr.next;
                count += 1;
            }
            if (count == k) {
                ListNode revHead = reverseLinkedList(head, k);
                if (new_head == null) {
                    new_head = revHead;
                }
                if (ktail != null) {
                    ktail.next = revHead;
                }
                ktail = head;
                head = ptr;
            }
        }
        if (ktail != null) {
            ktail.next = head;
        }
        return new_head == null ? head : new_head;
    }

    public ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;
        // close the linked list into the ring
        ListNode old_tail = head;
        int length;
        for(length = 1; old_tail.next != null; length++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;
        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < length - (k % length) - 1; i++) {
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;
        // break the ring
        new_tail.next = null;
        return new_head;
    }
}
