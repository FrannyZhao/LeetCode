package linked_list;

import utils.LinkedListHelper;
import utils.ListNode;

public class LC141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC141LinkedListCycle test = new LC141LinkedListCycle();
        LinkedListHelper helper = new LinkedListHelper();
        boolean result;

        result = test.hasCycle(helper.toCycleList("[3,2,0,-4]", 1));
        System.out.println(result);
        assert result;

        result = test.hasCycle(helper.toCycleList("[1,2]", 0));
        System.out.println(result);
        assert result;

        result = test.hasCycle(helper.toCycleList("[1]", -1));
        System.out.println(result);
        assert !result;
    }
}
