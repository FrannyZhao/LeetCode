package utils;

public class LinkedListHelper {
    public String toString(ListNode node) {
        StringBuilder sb = new StringBuilder("[");
        while (node != null) {
            sb.append(node.val).append(",");
            node = node.next;
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }

    public ListNode toList(String s) {
        s = s.substring(1, s.length() - 1);
        if (s.equals("")) {
            return null;
        }
        String[] ss = s.split(",");
        ListNode root = null;
        ListNode pre = null;
        for (int i = 0; i < ss.length; i++) {
            String str = ss[i].trim();
            ListNode node = new ListNode(Integer.parseInt(str));
            if (i == 0) {
                root = node;
            } else {
                pre.next = node;
            }
            pre = node;
        }
        return root;
    }

    public ListNode toCycleList(String s, int pos) {
        s = s.substring(1, s.length() - 1);
        if (s.equals("")) {
            return null;
        }
        String[] ss = s.split(",");
        ListNode root = null;
        ListNode pre = null;
        ListNode posNode = null;
        for (int i = 0; i < ss.length; i++) {
            String str = ss[i].trim();
            ListNode node = new ListNode(Integer.parseInt(str));
            if (i == 0) {
                root = node;
            } else {
                pre.next = node;
            }
            pre = node;
            if (i == pos) {
                posNode = node;
            } else if (i == ss.length - 1 && pos != -1) {
                node.next = posNode;
            }
        }
        return root;
    }

    public ListNode getTail(ListNode head) {
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }
}
