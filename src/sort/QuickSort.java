package sort;

import java.util.Arrays;

public class QuickSort {
    public int[] sort(int[] srcArr) {
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        return quickSort(arr, 0, arr.length - 1);
    }
    
    public int[] quickSort(int[] arr, int start, int end) {
        if (start < end) {
//            int pivotIndex = partitionSingleSide(arr, start, end);
            int pivotIndex = partitionDoubleSide(arr, start, end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
        return arr;
    }
    
    /**
     * 单边扫描
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partitionSingleSide(int[] arr, int start, int end) {
        int pivotValue = arr[start];
        int mark = start;
        int tmp;
        for (int i = mark + 1; i <= end; i++) {
            if (arr[i] < pivotValue) {
                mark++;
                if (mark != i) {
                    tmp = arr[i];
                    arr[i] = arr[mark];
                    arr[mark] = tmp;
                }
            }
        }
        if (mark != start) {
            arr[start] = arr[mark];
            arr[mark] = pivotValue;
        }
        return mark;
    }

    /**
     * 双边扫描
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private int partitionDoubleSide(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int pivotValue = arr[start];
        int tmp;
        while (left < right) {
            // 顺序很重要，要先从右往左扫描
            while (arr[right] >= pivotValue && left < right) {
                right--;
            }
            // 从左往右扫描
            while (arr[left] <= pivotValue && left < right) {
                left++;
            }
            // 交换左右数据
            if (left < right) {
                tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        // 此时left==right
        arr[start] = arr[left];
        arr[left] = pivotValue;
        return right;
    }
}
