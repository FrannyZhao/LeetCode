package linked_list;

public class LC23MergeKSortedLists {
    private boolean isFirst;
    private ListNode root, pre;
    public ListNode mergeKLists(ListNode[] lists) {
        isFirst = true;
        root = null;
        pre = null;
        if (lists.length == 0) {
            return null;
        }
        int emptyCount = 0;
        while (emptyCount < lists.length) {
            int minIndex = -1;
            emptyCount = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    emptyCount++;
                } else {
                    if (minIndex == -1) {
                        minIndex = i;
                    } else if (lists[i].val <= lists[minIndex].val) {
                        minIndex = i;
                    }
                }
            }
            if (emptyCount < lists.length) {
                lists[minIndex] = createNode(lists[minIndex]);
            }
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

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        LC21MergeTwoSortedLists mergeTwoSortedLists = new LC21MergeTwoSortedLists();
        ListNode mergedListNode = null;
        for (ListNode list: lists) {
            mergedListNode = mergeTwoSortedLists.mergeTwoLists(mergedListNode, list);
        }
        return mergedListNode;
    }

    public static void main(String[] args) {
        LC23MergeKSortedLists test = new LC23MergeKSortedLists();
        ListHelper helper = new ListHelper();
        String result;

        result = helper.toString(test.mergeKLists2(new ListNode[]{
                helper.toList("[1,4,5]"),
                helper.toList("[1,3,4]"),
                helper.toList("[2,6]")
        }));
        System.out.println(result);
        assert "[1,1,2,3,4,4,5,6]".equals(result);

        result = helper.toString(test.mergeKLists2(new ListNode[]{}));
        System.out.println(result);
        assert "[]".equals(result);

        result = helper.toString(test.mergeKLists2(new ListNode[]{
                helper.toList("[2]"),
                null,
                helper.toList("[-1]")
        }));
        System.out.println(result);
        assert "[-1,2]".equals(result);

        System.out.println(" ====== Success! =====");
    }
}
