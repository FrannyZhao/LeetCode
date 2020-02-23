package sort;

import java.util.Arrays;

public class TestSort {
    private static boolean isDebug = true;

    private static void print(String sort, int i, int[] result, int[] expect) {
        if (isDebug) {
            System.out.println(sort + " " + i + " result " + Arrays.toString(result));
            System.out.println(sort + " " + i + " expect " + Arrays.toString(expect));
        }
    }

    public static void main(String[] args) {
        int[][] srcArrs = {
                {},
                {0},
                {0,0},
                {6,4,3,7,5,1,2},
                {-8,2,5,0,-7,4,6,1},
                {8,2,5,0,7,4,6,1},
                {8,2,5,9,7},
                {4,3,2,1,1,2,3,4},
                {8,9,1,7,2,3,5,4,6,0},
                {6,42,-53,47,-5,-55,26},
                {-88808,252,525,0,-17,400,600,108}
        };

        int[][] results = {
                {},
                {0},
                {0,0},
                {1,2,3,4,5,6,7},
                {-8,-7,0,1,2,4,5,6},
                {0,1,2,4,5,6,7,8},
                {2,5,7,8,9},
                {1,1,2,2,3,3,4,4},
                {0,1,2,3,4,5,6,7,8,9},
                {-55,-53,-5,6,26,42,47},
                {-88808,-17,0,108,252,400,525,600}
        };
        BubbleSort bubbleSort = new BubbleSort();
        SelectionSort selectionSort = new SelectionSort();
        InsertSort insertSort = new InsertSort();
        ShellSort shellSort = new ShellSort();
        QuickSort quickSort = new QuickSort();
        MergeSort mergeSort = new MergeSort();
        HeapSort heapSort = new HeapSort();
        CoutingSort coutingSort = new CoutingSort();
        BucketSort bucketSort = new BucketSort();
        RadixSort radixSort = new RadixSort();
        int[] sortResult;
        for (int i = 0; i < srcArrs.length; i ++) {
            sortResult = bubbleSort.sort(srcArrs[i]);
            print("bubbleSort", i, sortResult, results[i]);
            assert Arrays.equals(sortResult, results[i]);

            sortResult = selectionSort.sort(srcArrs[i]);
            print("selectionSort", i, sortResult, results[i]);
            assert Arrays.equals(sortResult, results[i]);

            sortResult = insertSort.sort(srcArrs[i]);
            print("insertSort", i, sortResult, results[i]);
            assert Arrays.equals(sortResult, results[i]);

            sortResult = shellSort.sort(srcArrs[i]);
            print("shellSort", i, sortResult, results[i]);
            assert Arrays.equals(sortResult, results[i]);

            sortResult = quickSort.sort(srcArrs[i]);
            print("quickSort", i, sortResult, results[i]);
            assert Arrays.equals(sortResult, results[i]);

            sortResult = mergeSort.sort(srcArrs[i]);
            print("mergeSort", i, sortResult, results[i]);
            assert Arrays.equals(sortResult, results[i]);

            sortResult = heapSort.sort(srcArrs[i]);
            print("heapSort", i, sortResult, results[i]);
            assert Arrays.equals(sortResult, results[i]);

            sortResult = coutingSort.sort(srcArrs[i]);
            print("coutingSort", i, sortResult, results[i]);
            assert Arrays.equals(sortResult, results[i]);

            sortResult = bucketSort.sort(srcArrs[i]);
            print("bucketSort", i, sortResult, results[i]);
            assert Arrays.equals(sortResult, results[i]);

            sortResult = radixSort.sort(srcArrs[i]);
            print("radixSort", i, sortResult, results[i]);
            assert Arrays.equals(sortResult, results[i]);
        }
    }
}
