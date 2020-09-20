package linked_list;

public class LC25ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp;
        ListNode kNode;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        for (int i = 0; i < k; i++) {
            pointer = pointer.next;
        }


        return null;
    }

    public static void main(String[] args) {
        LC25ReverseNodesInKGroup test = new LC25ReverseNodesInKGroup();
        ListHelper helper = new ListHelper();
        String result;

        result = helper.toString(test.reverseKGroup(helper.toList("[1,2,3,4,5]"), 2));
        System.out.println(result);
        assert "[2,1,4,3,5]".equals(result);

        result = helper.toString(test.reverseKGroup(helper.toList("[1,2,3,4,5]"), 3));
        System.out.println(result);
        assert "[3,2,1,4,5]".equals(result);

    }
}
