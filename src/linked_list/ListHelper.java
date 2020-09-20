package linked_list;

public class ListHelper {
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
}
