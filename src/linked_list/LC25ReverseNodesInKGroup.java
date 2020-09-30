package linked_list;

import utils.LinkedListHelper;
import utils.ListNode;

public class LC25ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        boolean isReversed = false;
        ListNode result = head;
        ListNode tmpTail = null, tmpHead = null;
        ListNode kHeadNode = head;
        ListNode kTailNode = head;
        int count;
        while (kTailNode != null) {
            count = 1;
            while (count < k) {
                if (kTailNode.next == null) {
                    break;
                }
                kTailNode = kTailNode.next;
                count++;
            }
            if (count == k) {
                // find k tail node
                tmpTail = kTailNode.next;
                if (!isReversed) {
                    isReversed = true;
                    result = kTailNode;
                    tmpHead = kHeadNode;
                    reverse(kHeadNode, tmpTail);
                } else {
                    tmpHead.next = reverse(kHeadNode, tmpTail);
                    tmpHead = kHeadNode;
                }
                kHeadNode = tmpTail;
                kTailNode = tmpTail;
            } else {
                if (tmpHead != null) {
                    tmpHead.next = tmpTail;
                }
                break;
            }
        }
        return result;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode n1 = null;
        ListNode n2 = head;
        ListNode tmp;
        while (n2 != tail) {
            tmp = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = tmp;
        }
        return n1;
    }

    public static void main(String[] args) {
        LC25ReverseNodesInKGroup test = new LC25ReverseNodesInKGroup();
        LinkedListHelper helper = new LinkedListHelper();
        String result;

        result = helper.toString(test.reverseKGroup(helper.toList("[1,2,3,4,5]"), 2));
        System.out.println(result);
        assert "[2,1,4,3,5]".equals(result);

        result = helper.toString(test.reverseKGroup(helper.toList("[1,2,3,4,5]"), 3));
        System.out.println(result);
        assert "[3,2,1,4,5]".equals(result);

    }
}
