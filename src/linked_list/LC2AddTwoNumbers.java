package linked_list;

import utils.LinkedListHelper;
import utils.ListNode;

public class LC2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode root = null, pre = null, node = null;
        boolean carry = false;
        boolean isFirst = true;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + (carry ? 1 : 0);
            carry = (val / 10) >= 1;
            node = new ListNode(val % 10);
            if (isFirst) {
                root = node;
                isFirst = false;
            } else {
                pre.next = node;
            }
            pre = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + (carry ? 1 : 0);
            carry = (val / 10) >= 1;
            node = new ListNode(val % 10);
            if (isFirst) {
                root = node;
                isFirst = false;
            } else {
                pre.next = node;
            }
            pre = node;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val + (carry ? 1 : 0);
            carry = (val / 10) >= 1;
            node = new ListNode(val % 10);
            if (isFirst) {
                root = node;
                isFirst = false;
            } else {
                pre.next = node;
            }
            pre = node;
            l2 = l2.next;
        }
        if (carry) {
            node = new ListNode(1);
            pre.next = node;
        }
        return root;
    }

    public static void main(String[] args) {
        LC2AddTwoNumbers test = new LC2AddTwoNumbers();
        LinkedListHelper helper = new LinkedListHelper();
        String result;

        result = helper.toString(test.addTwoNumbers(helper.toList("[2,4,3]"), helper.toList("[5,6,4]")));
        System.out.println(result);
        assert "[7,0,8]".equals(result);

        System.out.println(" ====== Success! =====");
    }
}
