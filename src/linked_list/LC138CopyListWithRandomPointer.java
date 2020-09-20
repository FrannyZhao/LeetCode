package linked_list;

import java.util.HashMap;
import java.util.Map;

public class LC138CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val);
        Map<Node, Node> map = new HashMap<>();
        map.putIfAbsent(head, newHead);
        Node originPointer = head;
        Node newPointer = newHead;
        Node originRandom, originNext, newRandom, newNext;
        while (originPointer != null) {
            originNext = originPointer.next;
            originRandom = originPointer.random;
            if (originNext == null) {
                newPointer.next = null;
            } else {
                if (!map.containsKey(originNext)) {
                    newNext = new Node(originNext.val);
                    map.put(originNext, newNext);
                }
                newPointer.next = map.get(originNext);
            }
            if (originRandom == null) {
                newPointer.random = null;
            } else {
                if (!map.containsKey(originRandom)) {
                    newRandom = new Node(originRandom.val);
                    map.put(originRandom, newRandom);
                }
                newPointer.random = map.get(originRandom);
            }
            newPointer = newPointer.next;
            originPointer = originPointer.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        LC138CopyListWithRandomPointer test = new LC138CopyListWithRandomPointer();

        System.out.println(" ====== Success! =====");
    }
}
