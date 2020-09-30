package slide_window;

import utils.ListHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums != null && nums.length > 2) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (left > i + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    int sum = nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC15ThreeSum test = new LC15ThreeSum();
        ListHelper helper = new ListHelper();
        List<List<Integer>> reference = new ArrayList<>();
        List<List<Integer>> result;

        reference.clear();
        reference.add(helper.str2List("[-1,-1,2]"));
        reference.add(helper.str2List("[-1,0,1]"));
        result = test.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(helper.listList2Str(result));
        assert reference.equals(result);

        reference.clear();
        result = test.threeSum(new int[]{});
        System.out.println(helper.listList2Str(result));
        assert reference.equals(result);

        reference.clear();
        result = test.threeSum(new int[]{0});
        System.out.println(helper.listList2Str(result));
        assert reference.equals(result);

        reference.clear();
        reference.add(Arrays.asList(0,0,0));
        result = test.threeSum(new int[]{0,0,0,0});
        System.out.println(helper.listList2Str(result));
        assert reference.equals(result);

        reference.clear();
        reference.add(Arrays.asList(-2,0,2));
        result = test.threeSum(new int[]{-2,0,0,2,2});
        System.out.println(helper.listList2Str(result));
        assert reference.equals(result);

        reference.clear();
        reference.add(Arrays.asList(-2,0,2));
        reference.add(Arrays.asList(-2,1,1));
        result = test.threeSum(new int[]{-2,0,1,1,2});
        System.out.println(helper.listList2Str(result));
        assert reference.equals(result);

    }
}
