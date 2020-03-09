package arrays;

import java.util.Arrays;

public class LC289GameofLife {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = countLife(board, i, j);
                if (board[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 2;
                    } else {
                        board[i][j] = 0;
                    }
                } else {
                    if (count == 2 || count == 3) {
                        board[i][j] = 3;
                    } else {
                        board[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private int countLife(int[][] board, int i, int j) {
        return getLife(board, i - 1, j - 1)
                + getLife(board, i - 1, j)
                + getLife(board, i - 1, j + 1)
                + getLife(board, i, j - 1)
                + getLife(board, i, j + 1)
                + getLife(board, i + 1, j - 1)
                + getLife(board, i + 1, j)
                + getLife(board, i + 1, j + 1);
    }

    private int getLife(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return 0;
        } else {
            return board[i][j] & 1;
        }
    }

    public static void main(String[] args) {
        LC289GameofLife test = new LC289GameofLife();
        int[][] arr1 = new int[][]{
            {0,1,0},
            {0,0,1},
            {1,1,1},
            {0,0,0}
        };
        test.gameOfLife(arr1);
        for (int[] arr : arr1) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("-----------");
        /*
        System.out.println("result " + (0 >> 1));
        System.out.println("result " + (1 >> 1));
        System.out.println("result " + (2 >> 1));
        System.out.println("result " + (3 >> 1));
        System.out.println("-----------");
        System.out.println("result " + (0 & 1));
        System.out.println("result " + (1 & 1));
        System.out.println("result " + (2 & 1));
        System.out.println("result " + (3 & 1));
*/

    }
}
