package binary_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LC528RandomPickWithWeight {
    List<Integer> psum = new ArrayList<>();
    int tot = 0;
    Random rand = new Random();

    public LC528RandomPickWithWeight(int[] w) {
        for (int x : w) {
            tot += x;
            psum.add(tot);
        }
    }

    public int pickIndex() {
        int targ = rand.nextInt(tot);
        int lo = 0;
        int hi = psum.size() - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (targ >= psum.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        LC528RandomPickWithWeight test;
        int result;
//        test = new LC528RandomPickWithWeight(new int[]{1});
//        result = test.pickIndex();
//        System.out.println(result);
//        assert result == 0;

        test = new LC528RandomPickWithWeight(new int[]{1,3,1});
        result = test.pickIndex();
        System.out.println(result);
        assert result == 0;
        result = test.pickIndex();
        System.out.println(result);
        assert result == 1;
        result = test.pickIndex();
        System.out.println(result);
        assert result == 1;
        result = test.pickIndex();
        System.out.println(result);
        assert result == 1;
        result = test.pickIndex();
        System.out.println(result);
        assert result == 0;

        System.out.println(" ====== Success! =====");
    }
}
