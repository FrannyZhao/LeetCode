package SnapchatQuestions;

import java.util.Arrays;

public class MergeSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int finalIndex = m + n - 1;
        m--;
        n--;
        while(m >= 0 || n >= 0) {
            //if no more nums2 then just copy remaining m elements
            if(n < 0 || (m >= 0 && nums1[m] > nums2[n])) {
                nums1[finalIndex] =  nums1[m];
                m--;
            } else { //m < 0 || nums1[m] < nums2[n]
                nums1[finalIndex] = nums2[n];
                n--;
            }
            finalIndex--;
        }
    }

    public void merge2(int[] A, int m, int[] B, int n) {
        int length = m + n - 1;
        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[length] = A[m - 1];
                m--;
            } else {
                A[length] = B[n - 1];
                n--;
            }
            length--;
        }
        while (m > 0) {
            A[length] = A[m - 1];
            m--;
            length--;
        }
        while (n > 0) {
            A[length] = B[n - 1];
            n--;
            length--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        int[] A = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] B = new int[]{2,5,6};
        int n = 3;
        mergeSortedArrays.merge2(A, m, B, n);
        System.out.println(Arrays.toString(A));
        int [] result = new int[]{1,2,2,3,5,6};
        assert Arrays.equals(A, result);
    }
}
