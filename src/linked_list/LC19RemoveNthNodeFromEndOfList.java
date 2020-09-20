package linked_list;

public class LC19RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        while (n > 0) {
            pointer1 = pointer1.next;
            n--;
        }
        if (pointer1 == null) {
            if (pointer2.next == null) {
                return null;
            } else if (pointer2 == head) {
                return head.next;
            }
        } else {
            while (pointer1.next != null) {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
        }
        pointer2.next = pointer2.next.next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer1 = dummy;
        ListNode pointer2 = dummy;
        while (n >= 0) { // 走n+1步
            pointer1 = pointer1.next;
            n--;
        }
        while (pointer1 != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        pointer2.next = pointer2.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        LC19RemoveNthNodeFromEndOfList test = new LC19RemoveNthNodeFromEndOfList();
        ListHelper helper = new ListHelper();
        String result;

        result = helper.toString(test.removeNthFromEnd2(helper.toList("[1,2,3,4,5]"), 2));
        System.out.println(result);
        assert "[1,2,3,5]".equals(result);

        result = helper.toString(test.removeNthFromEnd2(helper.toList("[1]"), 1));
        System.out.println(result);
        assert "[]".equals(result);

        result = helper.toString(test.removeNthFromEnd2(helper.toList("[1,2]"), 2));
        System.out.println(result);
        assert "[2]".equals(result);

        System.out.println(" ====== Success! =====");
    }
}
