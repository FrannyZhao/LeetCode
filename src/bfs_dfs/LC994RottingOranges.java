package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC994RottingOranges {
    public int orangesRotting(int[][] grid) {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }
        result = bfs(grid, queue);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result = -1;
                    break;
                }
            }
            if (result == -1) {
                break;
            }
        }

        return result;
    }

    private int bfs(int[][] grid, Queue<int[]> queue) {
        int days = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            int day = current[2];
            boolean spread = false;
            if (curX > 0 && grid[curX - 1][curY] == 1) {
                grid[curX - 1][curY] = 2;
                queue.offer(new int[]{curX - 1, curY, day + 1});
                spread = true;
            }
            if (curX < grid.length - 1 && grid[curX + 1][curY] == 1) {
                grid[curX + 1][curY] = 2;
                queue.offer(new int[]{curX + 1, curY, day + 1});
                spread = true;
            }
            if (curY > 0 && grid[curX][curY - 1] == 1) {
                grid[curX][curY - 1] = 2;
                queue.offer(new int[]{curX, curY - 1, day + 1});
                spread = true;
            }
            if (curY < grid[0].length - 1 && grid[curX][curY + 1] == 1) {
                grid[curX][curY + 1] = 2;
                queue.offer(new int[]{curX, curY + 1, day + 1});
                spread = true;
            }
            if (spread) {
                days = Math.max(days, day + 1);
            }
//            System.out.println("day " + days);
//            System.out.println(Arrays.deepToString(grid));
        }
        return days;
    }



    public static void main(String[] args) {
        LC994RottingOranges test = new LC994RottingOranges();
        int result;

        int[][] grid1 = new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        result = test.orangesRotting(grid1);
        System.out.println(result);
        assert result == 4;

        int[][] grid2 = new int[][]{
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };
        result = test.orangesRotting(grid2);
        System.out.println(result);
        assert result == -1;

        int[][] grid3 = new int[][]{
                {0,2}
        };
        result = test.orangesRotting(grid3);
        System.out.println(result);
        assert result == 0;

        int[][] grid4 = new int[][]{
                {0}
        };
        result = test.orangesRotting(grid4);
        System.out.println(result);
        assert result == 0;

        int[][] grid5 = new int[][]{
                {1,2,1,1}
        };
        result = test.orangesRotting(grid5);
        System.out.println(result);
        assert result == 2;

        int[][] grid6 = new int[][]{
                {2},
                {1},
                {1},
                {1},
                {2},
                {1},
                {1}
        };
        result = test.orangesRotting(grid6);
        System.out.println(result);
        assert result == 2;

        System.out.println(" ====== Success! =====");
    }
}
