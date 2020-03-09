package bfs_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LC430FlattenAMultilevelDoublyLinkedList {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node(int val) {
            this.val = val;
        }
    }

    public Node flatten(Node head) {
        if (head == null || (head.child == null && head.next == null)) {
            return head;
        }
        Node oldHead = head;
        while (head.next != null || head.child != null) {
            if (head.child != null) {
                Node oldNext = head.next;
                head.next = head.child;
                head.child.prev = head;
                Node newPrev = dfs(head.child);
                if (oldNext != null) {
                    oldNext.prev = newPrev;
                    newPrev.next = oldNext;
                }
                head.child = null;
            }
            head = head.next;
        }
        return oldHead;
    }

    private Node dfs(Node cur) {
        while(cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    private int[] node2Arr(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list.add(head.val);
        while (head.next != null) {
            list.add(head.next.val);
            head = head.next;
        }
        while (head != null) {
            list2.add(head.val);
            head = head.prev;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        int[] result2 = new int[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            result2[i] = list2.get(i);
        }
//        System.out.println(Arrays.toString(result2));

        Collections.reverse(list2);
        for (int i = 0; i < list2.size(); i++) {
            result2[i] = list2.get(i);
        }
        assert Arrays.equals(result, result2);

        return result;
    }

    public Node flatten2(Node head) {
        return null;
    }

    public static void main(String[] args) {
        LC430FlattenAMultilevelDoublyLinkedList test = new LC430FlattenAMultilevelDoublyLinkedList();
//        int[] arr = new int[]{1,2,3,4,5,6,0,0,0,7,8,9,10,0,0,11,12};
        int[] result = new int[]{1,2,3,7,8,11,12,9,10,4,5,6};
        int[] flattenNode;
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;
        n3.next = n4;
        n4.prev = n3;
        n4.next = n5;
        n5.prev = n4;
        n5.next = n6;
        n6.prev = n5;

        n3.child = n7;
        n7.next = n8;
        n8.prev = n7;
        n8.next = n9;
        n9.prev = n8;
        n9.next = n10;
        n10.prev = n9;

        n8.child = n11;
        n11.next = n12;
        n12.prev = n11;

        test.flatten(n1);
        flattenNode = test.node2Arr(n1);
        System.out.println(Arrays.toString(flattenNode));
        assert Arrays.equals(flattenNode, result);

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.prev = node1;
        node1.child = node3;
        test.flatten(node1);
        result = new int[]{1,3,2};
        flattenNode = test.node2Arr(node1);
        System.out.println(Arrays.toString(flattenNode));
        assert Arrays.equals(result, flattenNode);

// 4201,null,1937,null,3203
        Node nd1 = new Node(4201);
        Node nd2 = new Node(1937);
        Node nd3 = new Node(3203);
        nd1.child = nd2;
        nd2.child = nd3;
        test.flatten(nd1);
        result = new int[]{4201,1937,3203};
        flattenNode = test.node2Arr(nd1);
        System.out.println(Arrays.toString(flattenNode));
        assert Arrays.equals(result, flattenNode);

        System.out.println(" ====== Success! =====");
    }
}
