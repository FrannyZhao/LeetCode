package test;

import java.util.Arrays;

public class TesFloyd {
    private float[][] mArr;

    public TesFloyd(float[][] arr) {
        mArr = Arrays.copyOf(arr, arr.length);
    }

    public void floyd() {
        System.out.println("origin: ");
        for (float[] arr : mArr) {
            System.out.println(Arrays.toString(arr));
        }
        for (int k = 0; k < mArr.length; k++) {
            for (int i = 0; i < mArr.length; i++) {
                for (int j = 0; j < mArr.length; j++) {
                    if (mArr[i][j] > mArr[i][k] + mArr[k][j]) {
                        mArr[i][j] = mArr[i][k] + mArr[k][j];
//                        System.out.println("+ i j k " + i + " " + j + " " + k
//                                + ", mArr[i][j] " + mArr[i][j] + ", mArr[i][k] " + mArr[i][k] + ", mArr[k][j] " + mArr[k][j]);
                    } else {
//                        System.out.println("- i j k " + i + " " + j + " " + k
//                                + ", mArr[i][j] " + mArr[i][j] + ", mArr[i][k] " + mArr[i][k] + ", mArr[k][j] " + mArr[k][j]);
                    }
                }
            }
        }
        System.out.println("result: ");
        for (float[] arr : mArr) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        System.out.println("begin test floyd");
        float[][] arr = new float[][]{
                {0, 2, 6, 4},
                {Float.POSITIVE_INFINITY, 0, 3, Float.POSITIVE_INFINITY},
                {7, Float.POSITIVE_INFINITY, 0, 1},
                {5, Float.POSITIVE_INFINITY, 12, 0}
        };
        TesFloyd t = new TesFloyd(arr);
        t.floyd();
    }
}
