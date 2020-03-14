package bfs_dfs;

import java.util.Arrays;

public class LC733FloodFill {
    int oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        oldColor = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor) {
//        if (sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length) {
            if (image[sr][sc] == oldColor) {
                image[sr][sc] = newColor;
                if (sr > 0 && image[sr - 1][sc] != newColor) {
                    dfs(image, sr - 1, sc, newColor);
                }
                if (sr < image.length - 1 && image[sr + 1][sc] != newColor) {
                    dfs(image, sr + 1, sc, newColor);
                }
                if (sc > 0 && image[sr][sc - 1] != newColor) {
                    dfs(image, sr, sc - 1, newColor);
                }
                if (sc < image[0].length - 1 && image[sr][sc + 1] != newColor) {
                    dfs(image, sr, sc + 1, newColor);
                }
            }
//        }
    }

    public static void main(String[] args) {
        LC733FloodFill test = new LC733FloodFill();
        int[][] img, answer, result;
        img= new int[][]{
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        answer = new int[][]{
                {2,2,2},
                {2,2,0},
                {2,0,1}
        };
        result = test.floodFill(img, 1, 1, 2);
        System.out.println(Arrays.deepToString(result));
        assert Arrays.deepEquals(result, answer);

        System.out.println(" ====== Success! =====");
    }
}
