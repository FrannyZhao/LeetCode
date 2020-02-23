package arrays;

import java.util.Arrays;

public class LC283MoveZeroes {
    /**
     * 自创，挫
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int lastZeroIndex = nums.length;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] == 0) {
                lastZeroIndex = i;
            } else {
                break;
            }
        }
        for (int i = 0; i < lastZeroIndex - 1; i++) {
            while (nums[i] == 0) {
                for (int j = i; j < lastZeroIndex - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[lastZeroIndex - 1] = 0;
                lastZeroIndex--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 用双指针
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int lastNotZeroIndex = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[lastNotZeroIndex] = num;
                lastNotZeroIndex++;
            }
        }
        for (int i = lastNotZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        LC283MoveZeroes lc283MoveZeroes = new LC283MoveZeroes();
        int[] arr = new int[]{0,1,0,3,12,0};
        lc283MoveZeroes.moveZeroes2(arr);
    }
}
