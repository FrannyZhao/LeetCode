package classic_sort;

import java.util.Arrays;

public class SelectionSort {
    public int[] sort(int[] srcArr) {
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int min, tmp;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }
}
