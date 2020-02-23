package arrays;

public class LC766ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return true;
        }
        if (matrix[0].length == 0) {
            return true;
        }
        int[] check = new int[matrix[0].length];
        for (int i = 0; i < check.length; i++) {
            check[i] = Integer.MIN_VALUE;
        }
        for (int[] arr : matrix) {
            for (int i = 0; i < arr.length; i++) {
                if (check[i] != Integer.MIN_VALUE && check[i] != arr[i]) {
                    return false;
                }
            }
            check[0] = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length - 1; i++) {
                check[i + 1] = arr[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC766ToeplitzMatrix lc766ToeplitzMatrix = new LC766ToeplitzMatrix();
        int[][] arrs = new int[][]{
                {1, 2},
                {3, 1}
        };
        System.out.println(lc766ToeplitzMatrix.isToeplitzMatrix(arrs));
    }
}
