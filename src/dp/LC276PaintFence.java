package dp;

public class LC276PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        return (numWays(n - 1, k) - 1) * k;
    }

    public static void main(String[] args) {
        LC276PaintFence test = new LC276PaintFence();
        int result;

        result = test.numWays(3, 2);
        System.out.println(result);
        assert result == 6;

        System.out.println(" ====== Success! =====");
    }
}
