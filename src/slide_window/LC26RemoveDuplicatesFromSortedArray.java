package slide_window;

public class LC26RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int length = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                length++;
                nums[length] = nums[i];
            }
        }
        return length + 1;
    }

    public static void main(String[] args) {
        LC26RemoveDuplicatesFromSortedArray test = new LC26RemoveDuplicatesFromSortedArray();
        int result;

        result = test.removeDuplicates(new int[]{1,1,2});
        System.out.println(result);
        assert result == 2;

        result = test.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(result);
        assert result == 5;
    }
}
