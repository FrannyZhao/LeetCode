package sort;

import java.util.Arrays;

public class RadixSort {
    public int[] sort(int[] srcArr) {
        if (srcArr.length <= 0) {
            return srcArr;
        }
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        // 找到最大值
        int maxValue = arr[0];
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        // 找到最大位数
        int numLength = 0;
        do {
            numLength++;
            maxValue /= 10;
        } while (maxValue != 0);
        // 开始排序
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < numLength; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[20][0];
            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + 10;
                counter[bucket] = Arrays.copyOf(counter[bucket], counter[bucket].length + 1);
                counter[bucket][counter[bucket].length - 1] = arr[j];
            }
            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }
        return arr;
    }
}
