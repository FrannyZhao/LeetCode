package hashtable;

import java.util.*;

public class LC939MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> datas = new TreeMap<>();
        for (int[] point : points) {
            datas.computeIfAbsent(point[0], x -> new ArrayList<>()).add(point[1]);
        }
        int result = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : datas.keySet()) {
            List<Integer> ys = datas.get(x);
            Collections.sort(ys);
            for (int i = 0; i < ys.size(); i++) {
                for (int j = i + 1; j < ys.size(); j++) {
                    int y1 = ys.get(i);
                    int y2 = ys.get(j);
                    int key = y1 * 40001 + y2;
                    if (map.containsKey(key)) {
                        int area = (x - map.get(key)) * (y2 - y1);
                        result = Math.min(area, result);
                    }
                    map.put(key, x);
                }
            }
        }
        return result < Integer.MAX_VALUE ? result : 0;
    }

    public int minAreaRect2(int[][] points) {
        HashSet<Integer> set = new HashSet<>();
        for (int[] point : points) {
            set.add(point[0] * 40001 + point[1]);
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                    if (set.contains(points[i][0] * 40001 + points[j][1]) &&
                            set.contains(points[j][0] * 40001 + points[i][1])) {
                        int area = Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]);
                        result = Math.min(result, area);
                    }
                }
            }
        }
        return result < Integer.MAX_VALUE ? result : 0;
    }

    public static void main(String[] args) {
        LC939MinimumAreaRectangle test = new LC939MinimumAreaRectangle();
        int result;
        int[][] arr1 = new int[][]{
                {1,1},
                {1,3},
                {3,1},
                {3,3},
                {2,2}
        };
        result = test.minAreaRect2(arr1);
        System.out.println(result);
        assert result == 4;

        int[][] arr2 = new int[][]{
                {1,1},
                {1,3},
                {3,1},
                {3,3},
                {4,1},
                {4,3}
        };
        result = test.minAreaRect2(arr2);
        System.out.println(result);
        assert result == 2;

        System.out.println(" ====== Success! =====");
    }
}
