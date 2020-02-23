package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class BucketSort {
    public int[] sort(int[] srcArr) {
        int[] arr = Arrays.copyOf(srcArr, srcArr.length);
        int bucketSize = 5;
        if (arr.length == 0) {
            return arr;
        }
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }
        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        
        /* 用ArrayList实现桶 
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize); 
            int originLength = bucketList.get(index).size();
            int j = originLength;
            bucketList.get(index).add(arr[i]);
            while (j > 0 && arr[i] < bucketList.get(index).get(j - 1)) {
                int value = bucketList.get(index).get(j - 1);
                bucketList.get(index).set(j, value);
                j--;
            }
            bucketList.get(index).set(j, arr[i]);
        }
        int arrIndex = 0;
        for (ArrayList<Integer> bucket : bucketList) {
            if (bucket.size() <= 0) {
                continue;
            }
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        
        /* 用数组实现桶 */
        int[][] buckets = new int[bucketCount][0];
        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize); 
            //自动扩容，并插入排序
            int originLength = buckets[index].length;
            buckets[index] = Arrays.copyOf(buckets[index], originLength + 1);
            int j = originLength;
            while (j > 0 && arr[i] < buckets[index][j - 1]) {
                buckets[index][j] = buckets[index][j - 1];
                j--;
            }
            buckets[index][j] = arr[i];
        }
        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        
        return arr;
    }
}
