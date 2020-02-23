package sort;

import java.util.Arrays;

public class TestTenClassicSorts {

    private static boolean isDebug = true;

    private static void print(String sort, int i, int[] result, int[] expect) {
        if (isDebug) {
            System.out.println(sort + " " + i + " result " + Arrays.toString(result));
            System.out.println(sort + " " + i + " expect " + Arrays.toString(expect));
        }
    }

    public static void main(String[] args) {
        int[][] srcArrs = {
                null,
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
                {-88808,252,525,0,-17,400,600,108},
                {-11111,252,525,0,-91111,400,600,108}
        };

        int[][] results = {
                null,
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
                {-88808,-17,0,108,252,400,525,600},
                {-91111,-11111,0,108,252,400,525,600}
        };
        TenClassicSorts sorts = new TenClassicSorts();
//        TenClassicSortsTestTemplate2 sorts = new TenClassicSortsTestTemplate2();

        int[] sortResult;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < srcArrs.length; i ++) {
//            sortResult = sorts.bubbleSort(srcArrs[i]);
//            print("bubbleSort", i, sortResult, results[i]);
//            assert Arrays.equals(sortResult, results[i]);

//            sortResult = sorts.selectionSort(srcArrs[i]);
//            print("selectionSort", i, sortResult, results[i]);
//            assert Arrays.equals(sortResult, results[i]);

//            sortResult = sorts.insertSort(srcArrs[i]);
//            print("insertSort", i, sortResult, results[i]);
//            assert Arrays.equals(sortResult, results[i]);

//            sortResult = sorts.shellSort(srcArrs[i]);
//            print("shellSort", i, sortResult, results[i]);
//            assert Arrays.equals(sortResult, results[i]);

//            System.out.println("begin sort " + i + " " + Arrays.toString(srcArrs[i]));
            sortResult = sorts.quickSort(srcArrs[i]);
            print("quickSort", i, sortResult, results[i]);
            assert Arrays.equals(sortResult, results[i]);

//            sortResult = sorts.mergeSort(srcArrs[i]);
//            print("mergeSort", i, sortResult, results[i]);
//            assert Arrays.equals(sortResult, results[i]);

//            sortResult = sorts.heapSort(srcArrs[i]);
//            print("heapSort", i, sortResult, results[i]);
//            assert Arrays.equals(sortResult, results[i]);

//            sortResult = sorts.countSort(srcArrs[i]);
//            print("coutingSort", i, sortResult, results[i]);
//            assert Arrays.equals(sortResult, results[i]);

//            sortResult = sorts.bucketSort(srcArrs[i]);
//            print("bucketSort", i, sortResult, results[i]);
//            assert Arrays.equals(sortResult, results[i]);

//            sortResult = sorts.radixSort(srcArrs[i]);
//            print("radixSort", i, sortResult, results[i]);
//            assert Arrays.equals(sortResult, results[i]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("=== Test end (" + (endTime - startTime) + ") ===");
    }
}
