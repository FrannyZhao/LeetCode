package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TestBFS {
    private int[][] mArr;
    private int mBeginX, mBeginY, mEndX, mEndY, mNextX, mNextY;
    private int[][] mMark;
    private int[][] next = new int[][] {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

//    private class

    public TestBFS(int[][] arr, int beginX, int beginY, int endX, int endY) {
        mArr = Arrays.copyOf(arr, arr.length);
        mBeginX = beginX;
        mBeginY = beginY;
        mEndX = endX;
        mEndY = endY;
        mMark = new int[mArr.length][mArr[0].length];
        System.out.println(arr.length + " " + arr[0].length);
    }

    public void bfs() {
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{mBeginX, mBeginY});
        while (!q.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                int[] current = q.peek();
                if (current != null) {
                    mNextX = current[0] + next[i][0];
                    mNextY = current[1] + next[i][1];
                    if (mNextX < 0 || mNextX > mArr.length - 1
                        || mNextY < 0 || mNextY > mArr[0].length - 1) {
                        continue;
                    }
                    if (mArr[mNextX][mNextY] == 0 && mMark[mNextX][mNextY] == 0) {
                        q.offer(new int[]{mNextX, mNextY});
                        mMark[mNextX][mNextY] = 1;
                    }
                    if (mNextX == mEndX && mNextY == mEndY) {
                        System.out.println("done");
                        return;
                    }
                }
            }
            q.poll();
        }
    }

    public void bfs2() {
        ArrayList<int[]> arrayList = new ArrayList<>();
        int parentIndex = 0;
        int head = 0;
        int sum = 0;
        arrayList.add(new int[]{mBeginX, mBeginY, parentIndex, sum});
        while (head < arrayList.size()) {
            for (int i = 0; i < next.length; i++) {
                int[] current = arrayList.get(head);
                mNextX = current[0] + next[i][0];
                mNextY = current[1] + next[i][1];
                if (mNextX < 0 || mNextX > mArr.length - 1
                        || mNextY < 0 || mNextY > mArr[0].length - 1) {
                    continue;
                }
                if (mArr[mNextX][mNextY] == 0 && mMark[mNextX][mNextY] == 0) {
                    arrayList.add(new int[]{mNextX, mNextY, head, arrayList.get(head)[3] + 1});
                    mMark[mNextX][mNextY] = 1;
                }
                if (mNextX == mEndX && mNextY == mEndY) {
                    System.out.println("done, step " + arrayList.get(arrayList.size() - 1)[3]);
                    int j = arrayList.size() - 1;
                    while (j > 0) {
                        System.out.println(Arrays.toString(arrayList.get(j)));
                        j = arrayList.get(j)[2];
                    }
                    return;
                }
            }
            head++;
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 1}
        };
        int beginX = 0, beginY = 0;
        int endX = 3, endY = 2;
        TestBFS t = new TestBFS(arr, beginX, beginY, endX, endY);
        System.out.println("begin test dfs");
//        t.bfs();
        t.bfs2();
    }
}
