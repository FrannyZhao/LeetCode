package sort;

import java.util.Arrays;

public class TenClassicSortsTestTemplate {
    public int[] bubbleSort(int[] srcArr) {
        if (srcArr == null || srcArr.length == 0) {
            return srcArr;
        }
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int tmp;
        boolean hasChanged;
        for (int i = arr.length - 1; i > 0; i--) {
            hasChanged = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    hasChanged = true;
                }
            }
            if (!hasChanged) {
                break;
            }
        }
        return arr;
    }

    public int[] selectionSort(int[] srcArr) {
        if (srcArr == null || srcArr.length == 0) {
            return srcArr;
        }
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int tmp, min;
        for (int i = 0; i < arr.length; i++) {
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

    public int[] insertSort(int[] srcArr) {
        if (srcArr == null || srcArr.length == 0) {
            return srcArr;
        }
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int tmp, j;
        for (int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
        }
        return arr;
    }

    public int[] shellSort(int[] srcArr) {
        if (srcArr == null || srcArr.length == 0) {
            return srcArr;
        }
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }
        int tmp, j;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                tmp = arr[i];
                j = i;
                while (j >= gap && tmp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        return arr;
    }

    public int[] quickSort(int[] srcArr) {
        if (srcArr == null || srcArr.length == 0) {
            return srcArr;
        }
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        return quick(arr, 0, arr.length - 1);
    }

    private int[] quick(int[] arr, int start, int end) {
        if (start < end) {
//            int pivot = partitionS(arr, start, end);
            int pivot = partitionD(arr, start, end);
            quick(arr, start, pivot - 1);
            quick(arr, pivot + 1, end);
        }
        return arr;
    }

    private int partitionS(int[] arr, int start, int end) {
        int mark = start;
        int pivotValue = arr[start];
        int tmp;
        for (int i = mark + 1; i <= end; i++) {
            if (arr[i] < pivotValue) {
                mark ++;
                if (mark != i) {
                    tmp = arr[mark];
                    arr[mark] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        if (mark != start) {
            arr[start] = arr[mark];
            arr[mark] = pivotValue;
        }
        return mark;
    }

    private int partitionD(int[] arr, int start, int end) {
        int tmp, left = start, right = end, pivotValue = arr[start];
        while (left < right) {
            while (left < right && arr[right] >= pivotValue) {
                right--;
            }
            while (left < right && arr[left] <= pivotValue) {
                left++;
            }
            if (left < right) {
                tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        arr[start] = arr[left];
        arr[left] = pivotValue;
        return left;
    }

    public int[] mergeSort(int[] srcArr) {
        if (srcArr == null || srcArr.length == 0 || srcArr.length == 1) {
            return srcArr;
        }
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int middle = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result =  new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }

    public int[] heapSort(int[] srcArr) {
        if (srcArr == null || srcArr.length == 0) {
            return srcArr;
        }
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        for (int i = (int) Math.floor(arr.length / 2); i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        int length = arr.length;
        int tmp;
        while (length > 0) {
            tmp = arr[0];
            arr[0] = arr[length - 1];
            arr[length - 1] = tmp;
            length--;
            heapify(arr, 0, length);
        }
        return arr;
    }

    private void heapify(int[] arr, int index, int length) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;
        int present = index;
        if (leftChild < length && arr[leftChild] > arr[present]) {
            present = leftChild;
        }
        if (rightChild < length && arr[rightChild] > arr[present]) {
            present = rightChild;
        }
        if (present != index) {
            int tmp = arr[present];
            arr[present] = arr[index];
            arr[index] = tmp;
            heapify(arr, present, length);
        }
    }

    public int[] countSort(int[] srcArr) {
        if (srcArr == null || srcArr.length == 0) {
            return srcArr;
        }
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int max = arr[0], min = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        int[] bucket = new int[max - min + 1];
        for (int value : arr) {
            bucket[value - min] ++;
        }
        int sortedIndex = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[sortedIndex++] = i + min;
                bucket[i]--;
            }
        }
        return arr;
    }

    public int[] bucketSort(int[] srcArr) {
        if (srcArr == null || srcArr.length == 0) {
            return srcArr;
        }
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int bucketSize = 5;
        int max = arr[0], min = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        int bucketCount = (int) Math.floor((max - min) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];
        for (int value : arr) {
            int index = (int) Math.floor(value - min) / bucketSize;
            buckets[index] = Arrays.copyOf(buckets[index], buckets[index].length + 1);
            int i = buckets[index].length - 1;
            while (i > 0 && value < buckets[index][i - 1]) {
                buckets[index][i] = buckets[index][i - 1];
                i--;
            }
            buckets[index][i] = value;
        }
        int sortedIndex = 0;
        for (int[] bucket : buckets) {
            for (int value : bucket) {
                arr[sortedIndex++] = value;
            }
        }
        return arr;
    }

    public int[] radixSort(int[] srcArr) {
        if (srcArr == null || srcArr.length == 0) {
            return srcArr;
        }
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int max = arr[0];
        for (int value : arr) {
            if (Math.abs(value) > max) {
                max = Math.abs(value);
            }
        }
        int numLen = 0;
        do {
            numLen ++;
            max /= 10;
        } while (max > 0);
        int dev = 1, mod = 10;
        for (int i = 0; i < numLen; i++, dev *= 10) {
            int[][] buckets = new int[20][0];
            for (int value : arr) {
                int index = value / dev % mod + 10;
                buckets[index] = Arrays.copyOf(buckets[index], buckets[index].length + 1);
                buckets[index][buckets[index].length - 1] = value;
            }
            int pos = 0;
            for (int[] bucket : buckets) {
                for (int value : bucket) {
                    arr[pos ++] = value;
                }
            }
        }
        return arr;
    }
}
