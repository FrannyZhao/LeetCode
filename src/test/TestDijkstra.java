package test;

import java.util.Arrays;

public class TestDijkstra {
    private float[][] mArr;

    public TestDijkstra(float[][] arr) {
        mArr = Arrays.copyOf(arr, arr.length);
    }

    public void dijkstra() {

    }

    public static void main(String[] args) {
        System.out.println("begin test dijkstra");
        float[][] arr = new float[][]{
                {0, 2, 6, 4},
                {Float.POSITIVE_INFINITY, 0, 3, Float.POSITIVE_INFINITY},
                {7, Float.POSITIVE_INFINITY, 0, 1},
                {5, Float.POSITIVE_INFINITY, 12, 0}
        };
        TestDijkstra t = new TestDijkstra(arr);
        t.dijkstra();
    }
}
