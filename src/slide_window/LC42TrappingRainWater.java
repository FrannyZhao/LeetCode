package slide_window;

import java.util.Stack;

public class LC42TrappingRainWater {
    // use slide window
    public int trap1(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int sum = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    sum += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    sum += rightMax - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    // use dp
    public int trap2(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int sum = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }

    // use stack
    public int trap3(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int sum = 0;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        while (index < height.length) {
            while (!stack.isEmpty() && height[index] > height[stack.peek()]) {
                int peek = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = index - stack.peek() - 1;
                int boundedHeight = Math.min(height[index], height[stack.peek()] - height[peek]);
                sum += distance * boundedHeight;
            }
            stack.push(index++);
        }
        return sum;
    }

    public int trap(int[] height) {
        return trap3(height);
    }

    public static void main(String[] args) {
        LC42TrappingRainWater test = new LC42TrappingRainWater();
        int result;

        result = test.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(result);
        assert result == 6;

        result = test.trap(null);
        System.out.println(result);
        assert result == 0;

        result = test.trap(new int[]{0});
        System.out.println(result);
        assert result == 0;

        result = test.trap(new int[]{0,1});
        System.out.println(result);
        assert result == 0;

        result = test.trap(new int[]{2,0,1});
        System.out.println(result);
        assert result == 1;
    }
}
