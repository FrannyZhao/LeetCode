package sort;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class LC1057CampusBikes {
    class WBDistance implements Comparable{
        int worker;
        int bike;
        int distance = Integer.MAX_VALUE;
        public String toString() {
            return "{worker " + worker + ", bike " + bike + ", distance " + distance + "}\n";
        }

        @Override
        public int compareTo(Object o) {
            return this.distance - ((WBDistance)o).distance;
        }
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] result = new int[workers.length];
        WBDistance[] wbDistances = new WBDistance[workers.length * bikes.length];
        int index = 0;
        WBDistance wbDistance;
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                wbDistance = new WBDistance();
                wbDistance.worker = i;
                wbDistance.bike = j;
                wbDistance.distance = Math.abs(bikes[j][0] - workers[i][0]) + Math.abs(bikes[j][1] - workers[i][1]);
                wbDistances[index++] = wbDistance;
            }
        }
        Arrays.sort(wbDistances);
//        System.out.println(Arrays.deepToString(wbDistances));
        Set<Integer> chosenWorkers = new TreeSet<>();
        Set<Integer> chosenBikers = new TreeSet<>();
        for (int i = 0; i < wbDistances.length; i++) {
            if (!chosenWorkers.contains(wbDistances[i].worker) && !chosenBikers.contains(wbDistances[i].bike)) {
                result[wbDistances[i].worker] = wbDistances[i].bike;
                chosenWorkers.add(wbDistances[i].worker);
                chosenBikers.add(wbDistances[i].bike);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC1057CampusBikes test = new LC1057CampusBikes();
        int[] result;

        result = test.assignBikes(new int[][]{
                {0,0},
                {1,1},
                {2,0}
        }, new int[][]{
                {1,0},
                {2,2},
                {2,1}
        });
        System.out.println(Arrays.toString(result));
        assert Arrays.equals(result, new int[]{0,2,1});

        result = test.assignBikes(new int[][]{
                {0,0},
                {2,1}
        }, new int[][]{
                {1,2},
                {3,3}
        });
        System.out.println(Arrays.toString(result));
        assert Arrays.equals(result, new int[]{1,0});

        System.out.println(" ====== Success! =====");
    }
}
