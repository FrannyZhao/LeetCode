package FaceBookQuestions;

/**
 * https://leetcode.com/problems/number-of-islands/
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
Example 1:
Input:
11110
11010
11000
00000
Output: 1
Example 2:
Input:
11000
11000
00100
00011
Output: 3
 */

public class LC200NumberOfIslands {
    public int numIslands(char[][] grid) {
        int num = 0;
        if (grid != null && grid.length != 0) {
            int row = grid.length;
            int column = grid[0].length;
            boolean[][] isVisited = new boolean[row][column];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (grid[i][j] == '1' && isVisited[i][j] == false) {
                        dfs(grid, isVisited, i, j);
                        num++;
                    }
                }
            }
        }
        return num;
    }
    
    private void dfs(char[][] grid, boolean[][] isVisited, int i, int j) {
        int row = grid.length;
        int column = grid[0].length;
        if (i < 0 || i >= row) {
            return;
        }
        if (j < 0 || j >= column) {
            return;
        }
        if (grid[i][j] != '1' || isVisited[i][j]) {
            return;
        }
        isVisited[i][j] = true;
        dfs(grid, isVisited, i - 1, j);
        dfs(grid, isVisited, i + 1, j);
        dfs(grid, isVisited, i, j - 1);
        dfs(grid, isVisited, i, j + 1);
    }
    
    
}
