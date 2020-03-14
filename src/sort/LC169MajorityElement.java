package sort;

import java.util.Arrays;

public class LC169MajorityElement {
    public int majorityElement(int[] nums) {
        return quickSort(0, nums.length - 1, nums);
    }

    private int quickSort(int start, int end, int[] nums) {
        int pivot = partition3(start, end, nums);
        System.out.println("pivot " + pivot);
        if (pivot > nums.length / 2) {
            return quickSort(start, pivot - 1, nums);
        } else if (pivot < nums.length / 2) {
            return quickSort(pivot + 1, end, nums);
        } else {
            return nums[nums.length / 2];
        }
    }

    private int partition(int start, int end, int[] nums) {
        int left = start;
        int right = end;
        int pivotValue = nums[start];
        int tmp;
        while (left < right) {
            while (nums[right] >= pivotValue && left < right) {
                right--;
            }
            while (nums[left] <= pivotValue && left < right) {
                left++;
            }
            if (left < right) {
                tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        if (left != start) {
            nums[start] = nums[left];
            nums[left] = pivotValue;
        }
        return left;
    }

    private int partition3(int start, int end, int[] nums) {
        int pivotValue = nums[start];
        int left = start, right = end + 1, tmp;
        while (true) {
            while (++left <= end && nums[left] < pivotValue);
            while (--right >= start && nums[right] > pivotValue);
            if (left >= right) {
                break;
            }
            tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
        }
        nums[start] = nums[right];
        nums[right] = pivotValue;
        return right;
    }

    private int quickSort2(int start, int end, int[] nums) {
        int[] pivots = partition2(start, end, nums);
        System.out.println("pivots " + Arrays.toString(pivots));
        if (pivots[0] <= nums.length / 2 && pivots[1] >= nums.length / 2) {
            return nums[nums.length / 2];
        } else if (pivots[0] > nums.length / 2) {
            return quickSort(start, pivots[0] - 1, nums);
        } else if (pivots[1] < nums.length / 2) {
            return quickSort(pivots[0] + 1, end, nums);
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private int[] partition2(int start, int end, int[] nums) {
        int left = start;
        int right = end;
        int pivotValue = nums[start];
        int i = left;
        int tmp;
        while (i <= right) {
            if (nums[i] < pivotValue) {
                tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
                i++;
                left++;
            } else if (nums[i] > pivotValue) {
                tmp = nums[i];
                nums[i] = nums[right];
                nums[right] = tmp;
                right--;
            } else {
                i++;
            }
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        LC169MajorityElement test = new LC169MajorityElement();
        int result;
        result = test.majorityElement(new int[]{3,2,3});
        System.out.println(result);
        assert result == 3;

        result = test.majorityElement(new int[]{2,2,1,1,1,2,2});
        System.out.println(result);
        assert result == 2;

        result = test.majorityElement(new int[]{-1,100,2,100,100,4,100});
        System.out.println(result);
        assert result == 100;
        System.out.println(" ====== Success! =====");
    }
}
