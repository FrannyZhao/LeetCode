package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC163MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(getRangeForEmptyNums(lower, upper));
        } else {
            if (lower < nums[0]) {
                result.add(getRangeForFirstNum(lower, nums[0]));
            }
            int start = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > start && nums[i] > start + 1) {
                    result.add(getRange(start, nums[i]));
                }
                start = nums[i];
            }
            if (start < upper) {
                result.add(getRange(start, upper + 1));
            }
        }
        return result;
    }

    private String getRangeForFirstNum(int start, int end) {
        if (start == end - 1) {
            return String.valueOf(start);
        }
        return start + "->" + (end - 1);
    }

    private String getRange(int start, int end) {
        if (start == end - 2) {
            return String.valueOf(start + 1);
        }
        return (start + 1) + "->" + (end - 1);
    }

    private String getRangeForEmptyNums(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        }
        return start + "->" + end;
    }

    public static void main(String[] args) {
        LC163MissingRanges test = new LC163MissingRanges();
        int[] nums = new int[]{0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        System.out.println(Arrays.toString(test.findMissingRanges(nums, lower, upper).toArray()));
        int[] nums2 = new int[]{-1};
        int lower2 = -2;
        int upper2 = -1;
        System.out.println(Arrays.toString(test.findMissingRanges(nums2, lower2, upper2).toArray()));
        int[] nums3 = new int[]{-2147483648,-2147483648,0,2147483647,2147483647};
        int lower3 = -2147483648;
        int upper3 = 2147483647;
        System.out.println(Arrays.toString(test.findMissingRanges(nums3, lower3, upper3).toArray()));
    }
}
