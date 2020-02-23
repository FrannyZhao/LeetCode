package FaceBookQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int a = 0; a < nums.length - 2; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            int b = a + 1;
            int c = nums.length - 1;
            int target = -nums[a];
            while (b < c) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    b++;
                    continue;
                }
                if (c < nums.length - 1 && nums[c] == nums[c + 1]) {
                    c--;
                    continue;
                }
                if (nums[b] + nums[c] == target) {
                    result.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    b++;
                    c--;
                } else if (nums[b] + nums[c] > target) {
                    c--;
                } else {
                    b++;
                }
            }
        }
        return result;
    }
}
