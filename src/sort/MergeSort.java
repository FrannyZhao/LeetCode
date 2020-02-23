package sort;

import java.util.Arrays;

public class MergeSort {

    public int[] sort(int[] srcArr) {
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(sort(left), sort(right));
    }
    
    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (j < left.length && k < right.length) {
            if (left[j] <= right[k]) {
                result[i++] = left[j++];
            } else {
                result[i++] = right[k++];
            }
        }
        while(j < left.length) {
            result[i++] = left[j++];
        }
        while(k < right.length) {
            result[i++] = right[k++];
        }
        return result;
    }
}
