package SnapchatQuestions;

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
        printArray(nums1);
    }

    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i]);
        }
        System.out.println("\n");
    }
}
