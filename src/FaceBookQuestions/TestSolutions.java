package FaceBookQuestions;

public class TestSolutions {
//    private static TwoSum solution = new TwoSum();
    private static LC200NumberOfIslands solution = new LC200NumberOfIslands();

    public static void main(String[] args) {
//        System.out.println();
        /*
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
        */
        
        /*
        int[][] dd = new int[3][5];
        System.out.println(dd.length);
        System.out.println(dd[0].length);
        System.out.println(dd[0][0]);
        boolean[][] bb = new boolean[1][1];
        System.out.println(bb[0][0]);
*/
        char grid[][] = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char grid2[][] = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(solution.numIslands(grid2));
    }

}
