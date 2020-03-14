package bfs_dfs;

import java.util.Stack;

public class LC394DecodeString {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder itemSB = new StringBuilder();
                char cc;
                while (!stack.isEmpty()) {
                    cc = stack.pop();
                    if (cc != '[') {
                        itemSB.append(cc);
                    } else {
                        break;
                    }
                }
                StringBuilder subSB = new StringBuilder();
                subSB.append(result).append(itemSB.reverse());
                StringBuilder countSB = new StringBuilder();
                while (!stack.isEmpty()) {
                    cc = stack.peek();
                    if (cc <= '9' && cc >= '0') {
                        countSB.append(stack.pop());
                    } else {
                        break;
                    }
                }
                int count = Integer.parseInt(countSB.toString());
                StringBuilder sb = new StringBuilder();
                while (count > 0) {
                    sb.append(subSB);
                    count--;
                }
                result.append(sb);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LC394DecodeString test = new LC394DecodeString();
        String result;
        result = test.decodeString("3[a]2[bc]");
        System.out.println(result);
        assert "aaabcbc".equals(result);

        result = test.decodeString("3[a2[c]]");
        System.out.println(result);
        assert "accaccacc".equals(result);
//
//        result = test.decodeString("2[abc]3[cd]ef");
//        System.out.println(result);
//        assert "abcabccdcdcdef".equals(result);
        System.out.println(" ====== Success! =====");
    }
}
