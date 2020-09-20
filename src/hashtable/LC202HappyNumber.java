package hashtable;

import java.util.HashSet;
import java.util.Set;

public class LC202HappyNumber {
    Set<Integer> result = new HashSet<>();

    public boolean isHappy(int n) {
        if (result.contains(n)) {
            return false;
        }
        result.add(n);
        if (n == 1) {
            return true;
        }
        int sum = 0;
        int mod = 10;
        for (int dividor = 1, i = 0; i < String.valueOf(n).length(); dividor *= 10, i++) {
            int digit = n / dividor % mod;
            sum += digit * digit;
        }
        return isHappy(sum);
    }



    public static void main(String[] args) {
        LC202HappyNumber test = new LC202HappyNumber();
        boolean result;

        result = test.isHappy(19);
        System.out.println(result);
        assert result;



        System.out.println(" ====== Success! =====");
    }
}
