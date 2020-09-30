package linked_list;

import utils.LinkedListHelper;
import utils.ListNode;

public class LC21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null, pre = null, node = null;
        boolean isFirst = true;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node = new ListNode(l1.val);
                if (isFirst) {
                    root = node;
                    isFirst = false;
                } else {
                    pre.next = node;
                }
                pre = node;
                l1 = l1.next;
            } else {
                node = new ListNode(l2.val);
                if (isFirst) {
                    root = node;
                    isFirst = false;
                } else {
                    pre.next = node;
                }
                pre = node;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            node = new ListNode(l1.val);
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
            node = new ListNode(l2.val);
            if (isFirst) {
                root = node;
                isFirst = false;
            } else {
                pre.next = node;
            }
            pre = node;
            l2 = l2.next;
        }
        return root;
    }

    boolean isFirst = true;
    ListNode root = null, pre = null;
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l1 = createNode(l1);
            } else {
                l2 = createNode(l2);
            }
        }
        while (l1 != null) {
            l1 = createNode(l1);
        }
        while (l2 != null) {
            l2 = createNode(l2);
        }
        return root;
    }

    private ListNode createNode(ListNode node) {
        ListNode newNode = new ListNode(node.val);
        if (isFirst) {
            root = newNode;
            isFirst = false;
        } else {
            pre.next = newNode;
        }
        pre = newNode;
        return node.next;
    }

    public static void main(String[] args) {
        LC21MergeTwoSortedLists test = new LC21MergeTwoSortedLists();
        LinkedListHelper helper = new LinkedListHelper();
        String result;

        result = helper.toString(test.mergeTwoLists2(helper.toList("[1,2,4]"), helper.toList("[1,3,4]")));
        System.out.println(result);
        assert "[1,1,2,3,4,4]".equals(result);

        System.out.println(" ====== Success! =====");
    }
}
