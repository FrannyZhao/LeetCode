package arrays;

import java.util.Arrays;

public class CountinousNumbersSumS {
    public int[][] findContinuousSequence(int target) {
        int[][] result = new int[][]{};
        int[] tmp;
        // target * 2 = (2n + m)(m + 1)
        float fn;
        int n;
        for (int m = target; m > 0; m--) {
            fn = target / (m + 1f) - m / 2f;
            n = target / (m + 1) - m / 2;
            if (n > 0 && fn == n) {
                result = Arrays.copyOf(result, result.length + 1);
                tmp = new int[m + 1];
                for (int i = 0; i <= m; i++) {
                    tmp[i] = n + i;
                }
                result[result.length - 1] = tmp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountinousNumbersSumS test = new CountinousNumbersSumS();
        int[][] result = test.findContinuousSequence(9);
        System.out.println(Arrays.deepToString(result));
        assert Arrays.deepEquals(result, new int[][]{
                {2,3,4},
                {4,5}
        });

        result = test.findContinuousSequence(15);
        System.out.println(Arrays.deepToString(result));
        assert Arrays.deepEquals(result, new int[][]{
                {1,2,3,4,5},
                {4,5,6},
                {7,8}});

        System.out.println(" ====== Success! =====");
    }
}
