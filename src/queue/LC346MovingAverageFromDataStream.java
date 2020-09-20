package queue;

import java.util.LinkedList;
import java.util.Queue;

public class LC346MovingAverageFromDataStream {
    /**
     * Initialize your data structure here.
     */
    private Queue<Integer> mQueue;
    private int mCapacity;
    private int sum;
    public LC346MovingAverageFromDataStream(int size) {
        mQueue = new LinkedList<>();
        mCapacity = size;
        sum = 0;
    }

    public double next(int val) {
        if (mCapacity == 0 && mQueue == null) {
            return 0d;
        }
        if (mQueue.size() == mCapacity) {
            int head = mQueue.poll();
            sum -= head;
        }
        mQueue.offer(val);
        sum += val;
//        int sum = 0;
//        for (int value : mQueue) {
//            sum += value;
//        }
        return sum / (double)mQueue.size();
    }

    public static void main(String[] args) {
        int size;
        double result;
        LC346MovingAverageFromDataStream test;

        size = 3;
        test = new LC346MovingAverageFromDataStream(size);
        result = test.next(1);
        System.out.println("result " + result);
        assert result == 1;
        result = test.next(10);
        System.out.println("result " + result);
        assert result == (1 + 10) / 2d;
        result = test.next(3);
        System.out.println("result " + result);
        assert result == (1 + 10 + 3) / 3d;
        result = test.next(5);
        System.out.println("result " + result);
        assert result == (10 + 3 + 5) / 3d;

        System.out.println(" ====== Success! =====");

    }
}
