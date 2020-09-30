package slide_window;

import java.util.Arrays;

public class LC16ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int targetSum = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int currentSum = nums[left] + nums[right];
                if (Math.abs(targetSum - currentSum) < delta) {
                    delta = Math.abs(targetSum - currentSum);
                    result = nums[i] + currentSum;
//                    System.out.println("delta " + delta + ":[" + nums[i] + "," + nums[left] + "," + nums[right] + "]");
                }
                if (currentSum <= targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC16ThreeSumClosest test = new LC16ThreeSumClosest();
        int result;

        result = test.threeSumClosest(new int[]{-1,2,1,-4}, 1);
        System.out.println(result);
        assert result == 2;

        result = test.threeSumClosest(new int[]{1,1,1,0}, 100);
        System.out.println(result);
        assert result == 3;

        result = test.threeSumClosest(new int[]{0,2,1,-3}, 1);
        System.out.println(result);
        assert result == 0;
    }
}
