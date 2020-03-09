package arrays;

public class LC835ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int[][] count = new int[2*N+1][2*N+1];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (A[i][j] == 1)
                    for (int i2 = 0; i2 < N; ++i2)
                        for (int j2 = 0; j2 < N; ++j2)
                            if (B[i2][j2] == 1)
                                count[i-i2 +N][j-j2 +N] += 1;

        int ans = 0;
        for (int[] row: count)
            for (int v: row)
                ans = Math.max(ans, v);
        return ans;
    }

    public static void main(String[] args) {
        LC835ImageOverlap test = new LC835ImageOverlap();
        int[][] A1 = new int[][]{
                {1,1,0},
                {0,1,0},
                {0,1,0}
        };
        int[][] B1 = new int[][]{
                {0,0,0},
                {0,1,1},
                {0,0,1}
        };
        int result1 = test.largestOverlap(A1, B1);
        System.out.println(result1);
        assert 3 == result1;

        System.out.println(" ====== Success! =====");
    }
}
