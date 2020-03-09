package arrays;

import java.util.*;

public class LC1146SnapshotArray {

    static class SnapshotArray {
        private TreeMap<Integer, Integer>[] mArr;
        private int snapCount = 0;

        public SnapshotArray(int length) {
            mArr = new TreeMap[length];
            for (int i = 0; i < length; i++) {
                mArr[i] = new TreeMap<>();
                mArr[i].put(0,0);
            }
        }

        public void set(int index, int val) {
            TreeMap<Integer, Integer> map = mArr[index];
            map.put(snapCount, val);
        }

        public int snap() {
            snapCount++;
            return snapCount - 1;
        }

        public int get(int index, int snap_id) {
            TreeMap<Integer, Integer> map = mArr[index];
            return map.floorEntry(snap_id).getValue();
        }
    }

    /*
    static class SnapshotArray {
        private int[][] mData = new int[][]{};
        private int[] mArr;
        private int snapCount = 0;
        public SnapshotArray(int length) {
            mArr = new int[length];
        }

        public void set(int index, int val) {
            mArr[index] = val;
        }

        public int snap() {

            mData = Arrays.copyOf(mData, mData.length + 1);
            mData[mData.length - 1] = Arrays.copyOf(mArr, mArr.length);
            snapCount++;
//            System.out.println(Arrays.deepToString(mData));
            return snapCount - 1;
        }

        public int get(int index, int snap_id) {
//            System.out.println(Arrays.deepToString(mData));
            return mData[snap_id][index];
        }
    }
/*
    static class SnapshotArray {
        TreeMap<Integer, Integer>[] A;
        int snap_id = 0;
        public SnapshotArray(int length) {
            A = new TreeMap[length];
            for (int i = 0; i < length; i++) {
                A[i] = new TreeMap<Integer, Integer>();
                A[i].put(0, 0);
            }
        }

        public void set(int index, int val) {
            A[index].put(snap_id, val);
        }

        public int snap() {
            return snap_id++;
        }

        public int get(int index, int snap_id) {
            return A[index].floorEntry(snap_id).getValue();
        }
    }
*/

    public static void main(String[] args) {
        LC1146SnapshotArray test = new LC1146SnapshotArray();
        SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
        snapshotArr.set(0,5);  // Set array[0] = 5
        snapshotArr.snap();  // Take a snapshot, return snap_id = 0
        snapshotArr.set(0,6);
        int result = snapshotArr.get(0,0);
        System.out.println(result);
        assert result == 5;
        System.out.println(" ====== Success! =====");
    }
}
