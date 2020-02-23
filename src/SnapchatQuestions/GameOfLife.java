package SnapchatQuestions;

/**
 * https://leetcode.com/problems/game-of-life/
Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
 */

public class GameOfLife {
    int rowLength, columnLength;
    public void gameOfLife(int[][] board) {
        printArray(board);
        rowLength = board.length;
        columnLength = board[0].length;
        int[][] result = new int[rowLength][columnLength];
        if (board.length != 0 && board[0].length != 0) {
            for (int i = 0; i < rowLength; i ++) {
                for (int j = 0; j < columnLength; j ++) {
                    int liveCount = countLiveNeighbors(board, i, j);
                    if (board[i][j] == 0) {
                        if (liveCount == 3) {
                            result[i][j] = 1;
                        }
                    } else {
                        if (liveCount < 2 || liveCount > 3) {
                            result[i][j] = 0;
                        } else {
                            result[i][j] = 1;
                        }
                    }
                }
            }
        }
        printArray(result);
        board = result;
        printArray(board);
    }
    
    private void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i ++) {
            for (int j = 0; j < arr[0].length; j ++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("\n");
        }
    }
    
    private int countLiveNeighbors(int[][] board, int i, int j) {
        int count = 0;
        if (i - 1 >= 0) {
            if (j - 1 >= 0 && board[i - 1][j - 1] == 1) {
                count ++;
            }
            if (board[i - 1][j] == 1) {
                count ++;
            }
            if (j + 1 < columnLength && board[i - 1][j + 1] == 1) {
                count ++;
            }
        }
        if (j - 1 >= 0 && board[i][j - 1] == 1) {
            count ++;
        }
        if (j + 1 < columnLength && board[i][j + 1] == 1) {
            count ++;
        }
        if (i + 1 < rowLength) {
            if (j - 1 >= 0 && board[i + 1][j - 1] == 1) {
                count ++;
            }
            if (board[i + 1][j] == 1) {
                count ++;
            }
            if (j + 1 < columnLength && board[i + 1][j + 1] == 1) {
                count ++;
            }
        }
        System.out.println("i,j,count" + i + j + count);
        return count;
    }

}
