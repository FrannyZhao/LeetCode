package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC163MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();


        return result;
    }

    public static void main(String[] args) {
        LC163MissingRanges test = new LC163MissingRanges();
        int[] nums = new int[]{0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        System.out.println(Arrays.toString(test.findMissingRanges(nums, lower, upper).toArray()));
    }
}
