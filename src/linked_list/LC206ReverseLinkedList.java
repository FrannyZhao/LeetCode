package linked_list;

import utils.LinkedListHelper;
import utils.ListNode;

public class LC206ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode n1 = null;
        ListNode n2 = head;
        ListNode tmp;
        while (n2 != null) {
            tmp = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = tmp;
        }
        return n1;
    }

    public static void main(String[] args) {
        LC206ReverseLinkedList test = new LC206ReverseLinkedList();
        LinkedListHelper helper = new LinkedListHelper();
        String result;

        result = helper.toString(test.reverseList(helper.toList("[1,2,3,4,5]")));
        System.out.println(result);
        assert "[5,4,3,2,1]".equals(result);

        result = helper.toString(test.reverseList(helper.toList("[]")));
        System.out.println(result);
        assert "[]".equals(result);
    }
}
