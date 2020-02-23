package test;

import java.util.Arrays;

public class TestDFS {
    private int[] mArr, result, mark;

    public void testDFS(int[] arr) {
        mArr = Arrays.copyOf(arr, arr.length);
        result = new int[mArr.length];
        mark = new int[mArr.length];
        dfs(0);
    }

    private void dfs(int step) {
        if (step == mArr.length) {
//            System.out.println("====== result:");
            System.out.println(Arrays.toString(result));
//            System.out.println("====== end");
            return;
        }
        for (int i = 0; i < mArr.length; i++) {
            if (mark[i] == 0) {
                result[step] = mArr[i];
                mark[i] = 1;
                dfs(step + 1);
                mark[i] = 0;
            }
            //System.out.println("step " + step + ", mark: " + Arrays.toString(mark));
        }
//		return;
    }

    public static void main(String[] args) {
        TestDFS t = new TestDFS();
        int[] arr = new int[]{1,2,3};
        System.out.println("begin test dfs");
        t.testDFS(arr);
    }
}

