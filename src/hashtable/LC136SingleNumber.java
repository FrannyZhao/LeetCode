package hashtable;

public class LC136SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        LC136SingleNumber test = new LC136SingleNumber();
        int result;

        result = test.singleNumber(new int[]{2,2,1});
        System.out.println(result);
        assert result == 1;

        result = test.singleNumber(new int[]{4,1,2,1,2});
        System.out.println(result);
        assert result == 4;

        System.out.println(" ====== Success! =====");
    }
}
