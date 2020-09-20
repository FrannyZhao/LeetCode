package linked_list;

public class LC61RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int length = 0;
        ListNode end = head;
        while (end.next != null) {
            length++;
            end = end.next;
        }
        if (length == 0) {
            return head;
        }
        int rotateCount = k % ++length;
        if (rotateCount == 0) {
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        while (rotateCount > 0) {
            first = first.next;
            rotateCount--;
        }
        while (first.next != null) {
            second = second.next;
            first = first.next;
        }
        ListNode newHead = second.next;
        second.next = null;
        end.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        LC61RotateList test = new LC61RotateList();
        ListHelper helper = new ListHelper();
        String result;

//        result = helper.toString(test.rotateRight(helper.toList("[1,2,3,4,5]"), 2));
//        System.out.println(result);
//        assert "[4,5,1,2,3]".equals(result);

//        result = helper.toString(test.rotateRight(helper.toList("[0,1,2]"), 4));
//        System.out.println(result);
//        assert "[2,0,1]".equals(result);

//        result = helper.toString(test.rotateRight(helper.toList("[]"), 0));
//        System.out.println(result);
//        assert "[]".equals(result);

//        result = helper.toString(test.rotateRight(helper.toList("[1,2]"), 0));
//        System.out.println(result);
//        assert "[1,2]".equals(result);

        result = helper.toString(test.rotateRight(helper.toList("[1,2]"), 2));
        System.out.println(result);
        assert "[1,2]".equals(result);

        System.out.println(" ====== Success! =====");
    }
}
