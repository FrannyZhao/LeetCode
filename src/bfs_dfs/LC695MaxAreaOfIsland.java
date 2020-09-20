package bfs_dfs;

import java.util.LinkedList;
import java.util.List;

public class LC695MaxAreaOfIsland {
    int maxArea;
    int[][] mark;
    public int maxAreaOfIsland(int[][] grid) {
        mark = new int[grid.length][grid[0].length];
        maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && mark[i][j] == 0) {
                    maxArea = Math.max(dfs(grid, i, j), maxArea);
//                    System.out.println("island " + i + " " + j + ": " + maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int sr, int sc) {
        List<int[]> output = new LinkedList<>();
        int result = 0;
        if (sr >= 0 && sc >= 0 && sr < grid.length && sc < grid[0].length) {
            if (grid[sr][sc] == 1 && mark[sr][sc] == 0) {
                mark[sr][sc] = 1;
                result = 1;
                result += dfs(grid, sr - 1, sc);
                result += dfs(grid, sr + 1, sc);
                result += dfs(grid, sr, sc - 1);
                result += dfs(grid, sr, sc + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC695MaxAreaOfIsland test = new LC695MaxAreaOfIsland();
        int result;
        int[][] grid;

        grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        result = test.maxAreaOfIsland(grid);
        System.out.println(result);
        assert result == 6;

        grid = new int[][]{
                {0,0,0,0,0,0,0,0}
        };
        result = test.maxAreaOfIsland(grid);
        System.out.println(result);
        assert result == 0;

        System.out.println(" ====== Success! =====");
    }
}
