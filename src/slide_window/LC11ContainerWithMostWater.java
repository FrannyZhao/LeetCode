package slide_window;

public class LC11ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            System.out.println("left " + left + ", right " + right);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LC11ContainerWithMostWater test = new LC11ContainerWithMostWater();
        int result;

        result = test.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(result);
        assert result == 49;

        result = test.maxArea(new int[]{2,3,10,5,7,8,9});
        System.out.println(result);
        assert result == 36;
    }
}
