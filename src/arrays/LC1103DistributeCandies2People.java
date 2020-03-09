package arrays;

import java.util.Arrays;

public class LC1103DistributeCandies2People {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int tmp = 1;
        int count;
        int index = 0;
        while (candies > 0) {
            if (candies > tmp) {
                count = tmp++;
            } else {
                count = candies;
            }
            result[index % num_people] += count;
            index++;
            candies -= count;
        }
        return result;
    }

    public static void main(String[] args) {
        LC1103DistributeCandies2People test = new LC1103DistributeCandies2People();
        int[] result = test.distributeCandies(7, 4);
        System.out.println(Arrays.toString(result));
        assert Arrays.equals(result, new int[]{1,2,3,1});

        result = test.distributeCandies(10, 3);
        System.out.println(Arrays.toString(result));
        assert Arrays.equals(result, new int[]{5,2,3});

        System.out.println(" ====== Success! =====");
    }
}
