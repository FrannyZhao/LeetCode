package sort;

import java.util.Arrays;

public class ShellSort {
    public int[] sort(int[] srcArr) {
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && tmp < arr[j]) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        return arr;
    }

    public int[] sort2(int[] srcArr) {
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i;
                while (j >= gap && tmp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                if (j != i) {
                    arr[j] = tmp;
                }
            }
            gap = (int) Math.floor(gap / 3);
        }
        return arr;
    }
}
