package linked_list;

import utils.LinkedListHelper;
import utils.ListNode;

public class LC876MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LC876MiddleOfTheLinkedList test = new LC876MiddleOfTheLinkedList();
        LinkedListHelper helper = new LinkedListHelper();
        int result;

        result = test.middleNode(helper.toList("[1,2,3,4,5]")).val;
        System.out.println(result);
        assert result == 3;

        result = test.middleNode(helper.toList("[1,2,3,4,5,6]")).val;
        System.out.println(result);
        assert result == 4;
    }
}
