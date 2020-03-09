package stack;

import java.util.LinkedList;
import java.util.Queue;

public class LC225ImplementStackUsingQueues {
    static class MyStack {
        private Queue<Integer> mQueue;
        /** Initialize your data structure here. */
        public MyStack() {
            mQueue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            mQueue.offer(x);
            for (int i = 0; i < mQueue.size() - 1; i++) {
                mQueue.offer(mQueue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return mQueue.poll();
        }

        /** Get the top element. */
        public int top() {
            return mQueue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return mQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        int result;
        boolean check;
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        result = stack.top();
        System.out.println(result);
        assert 2 == result;
        result = stack.pop();
        System.out.println(result);
        assert 2 == result;
        check = stack.empty();
        System.out.println(check);
        assert !check;
        System.out.println(" ====== Success! =====");
    }
}
