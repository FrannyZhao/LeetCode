package sort;

import java.util.Arrays;

/**
 * 计数排序只适用于正整数, 并且取值范围相差不大的数组排序使用，它的排序的速度是非常可观的。
 * @author zhaofengyi
 *
 */
public class CoutingSort {
    public int[] sort(int[] srcArr) {
        if (srcArr.length <= 0) {
            return srcArr;
        }
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        //找到最大值和最小值
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
            if (minValue > value) {
                minValue = value;
            }
        }
        //创建计数数组
        int[] bucket = new int[maxValue - minValue + 1];
        for (int value : arr) {
            bucket[value - minValue]++;
        }
        int sortedIndex = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j + minValue;
                bucket[j]--;
            }
        }
        return arr;
    }
}
