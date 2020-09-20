package stack;

import java.util.Stack;

public class LC844BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '#') {
                if (!stack1.empty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(c);
            }
        }

        for (Character c : T.toCharArray()) {
            if (c == '#') {
                if (!stack2.empty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(c);
            }
        }
        boolean result = true;
        while (!stack1.empty() && !stack2.empty()) {
            if (stack1.pop() != stack2.pop()) {
                result = false;
                break;
            }
        }
        if (result) {
            if (stack1.empty() && stack2.empty()) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC844BackspaceStringCompare test = new LC844BackspaceStringCompare();
        boolean result;

        result = test.backspaceCompare("ab#c", "ad#c");
        System.out.println(result);
        assert result;

        result = test.backspaceCompare("ab##", "c#d#");
        System.out.println(result);
        assert result;

        result = test.backspaceCompare("a##c", "#a#c");
        System.out.println(result);
        assert result;

        result = test.backspaceCompare("a#c", "b");
        System.out.println(result);
        assert !result;

        System.out.println(" ====== Success! =====");
    }
}
