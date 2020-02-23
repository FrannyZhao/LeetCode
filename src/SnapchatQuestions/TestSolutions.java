package SnapchatQuestions;

public class TestSolutions {
//    private static GameOfLife solution = new GameOfLife();
    private static MergeSortedArrays solution = new MergeSortedArrays();
    public static void main(String[] args) {
//        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
//        solution.gameOfLife(board);
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
        int[] nums1 = {0};
        int[] nums2 = {2};
        int n = nums2.length;
        int m = nums1.length - n;
        solution.merge(nums1, m, nums2, n);
    }

}
