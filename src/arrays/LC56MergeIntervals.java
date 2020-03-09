package arrays;

import java.util.Arrays;

public class LC56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        quickSort(intervals);
        int[][] result = new int[][]{};
        int[] check = intervals[0];
        for (int[] interval : intervals) {
            if (check[1] >= interval[0]) {
                check = new int[]{Math.min(check[0], interval[0]), Math.max(check[1], interval[1])};
            } else {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = check;
                check = interval;
            }
        }
        result = Arrays.copyOf(result, result.length + 1);
        result[result.length - 1] = check;
        return result;
    }

    public void quickSort(int[][] nums) {
        quick(nums, 0, nums.length - 1);
    }

    private void quick(int[][] nums, int start, int end) {
        if (start < end) {
            int pivot = partition(nums, start, end);
            quick(nums, start, pivot - 1);
            quick(nums, pivot + 1, end);
        }
    }

    private int partition(int[][] nums, int start, int end) {
        int left = start;
        int right = end;
        int pivot = nums[start][0];
        int[] tmp;
        while (left < right) {
            while (left < right && nums[right][0] >= pivot) {
                right--;
            }
            while (left < right && nums[left][0] <= pivot) {
                left++;
            }
            if (left < right) {
                tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        if (left != start) {
            tmp = nums[left];
            nums[left] = nums[start];
            nums[start] = tmp;
        }
        return left;
    }

    public static void main(String[] args) {
        LC56MergeIntervals test = new LC56MergeIntervals();
        int[][] intervals = new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        };
        System.out.println(Arrays.deepToString(test.merge(intervals)));
        int[][] intervals2 = new int[][]{
                {1,4},{4,5}
        };
        System.out.println(Arrays.deepToString(test.merge(intervals2)));
        int[][] intervals3 = new int[][]{
                {1,4},{0,4}
        };
        System.out.println(Arrays.deepToString(test.merge(intervals3)));
        int[][] intervals4 = new int[][]{
                {1,4},{0,0}
        };
        System.out.println(Arrays.deepToString(test.merge(intervals4)));
        int[][] intervals5 = new int[][]{
                {1,4},{5,6}
        };
        System.out.println(Arrays.deepToString(test.merge(intervals5)));
    }
}
