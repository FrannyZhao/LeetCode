package arrays;

public class LC1007MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int minCount = -1, count;
        for (int i = 0; i < A.length; i++) {
            count = 0;
            for (int j = 0; j < A.length; j++) {
                if (j != i && A[j] != A[i]) {
                    if (B[j] != A[i]) {
                        count = -1;
                        break;
                    } else {
                        count++;
                    }
                }
            }
            if (minCount == -1) {
                minCount = count;
            } else if (count != -1 && count < minCount) {
                minCount = count;
            }
        }
        for (int i = 0; i < B.length; i++) {
            count = 0;
            for (int j = 0; j < B.length; j++) {
                if (j != i && B[j] != B[i]) {
                    if (A[j] != B[i]) {
                        count = -1;
                        break;
                    } else {
                        count++;
                    }
                }
            }
            if (minCount == -1) {
                minCount = count;
            } else if (count != -1 && count < minCount) {
                minCount = count;
            }
        }
        return minCount;
    }

    /**
     * 两个难点：
     * 只用检查A[0]和B[0]即可，因为要对齐的数要么等于A[0]要么等于B[0];
     * 考虑两个count, 因为可以是把A换到B也可以是把B换到A。
     * @param A
     * @param B
     * @return
     */
    public int minDominoRotations3(int[] A, int[] B) {
        int minCount = -1, countA = 0, countB = 0, check = A[0];
        boolean pass = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != check && B[i] != check) {
                pass = false;
                break;
            } else if (A[i] != check && B[i] == check) {
                countA++;
            } else if (A[i] == check && B[i] != check) {
                countB++;
            }
        }
        if (pass) {
            minCount = Math.min(countA, countB);
        }
        System.out.println("count 1 " + minCount);
        if (A[0] == B[0]) {
            return minCount;
        }
        check = B[0];
        countA = 0;
        countB = 0;
        pass = true;
        for (int i = 0; i < B.length; i++) {
            if (A[i] != check && B[i] != check) {
                pass = false;
                break;
            } else if (B[i] != check && A[i] == check) {
                countB++;
            } else if (B[i] == check && A[i] != check) {
                countA++;
            }
        }
        if (pass) {
            if (minCount == -1) {
                minCount = Math.min(countA, countB);
            } else {
                minCount = Math.min(minCount, Math.min(countA, countB));
            }
        }
        System.out.println("count 2 " + Math.min(countA, countB));
        return minCount;
    }

    public int check(int x, int[] A, int[] B, int n) {
        // how many rotations should be done
        // to have all elements in A equal to x
        // and to have all elements in B equal to x
        int rotations_a = 0, rotations_b = 0;
        for (int i = 0; i < n; i++) {
            // rotations coudn't be done
            if (A[i] != x && B[i] != x) return -1;
                // A[i] != x and B[i] == x
            else if (A[i] != x) rotations_a++;
                // A[i] == x and B[i] != x
            else if (B[i] != x) rotations_b++;
        }
        // min number of rotations to have all
        // elements equal to x in A or B
        return Math.min(rotations_a, rotations_b);
    }

    public int minDominoRotations2(int[] A, int[] B) {
        int n = A.length;
        int rotations = check(A[0], B, A, n);
        // If one could make all elements in A or B equal to A[0]
        if (rotations != -1 || A[0] == B[0]) return rotations;
            // If one could make all elements in A or B equal to B[0]
        else return check(B[0], B, A, n);
    }

    public static void main(String[] args) {
        LC1007MinimumDominoRotationsForEqualRow test = new LC1007MinimumDominoRotationsForEqualRow();
        int[] arrA = new int[]{2,1,2,4,2,2};
        int[] arrB = new int[]{5,2,6,2,3,2};
        System.out.println(test.minDominoRotations3(arrA, arrB));
        int[] arrA2 = new int[]{3,5,1,2,3};
        int[] arrB2 = new int[]{3,6,3,3,4};
        System.out.println(test.minDominoRotations3(arrA2, arrB2));
        int[] arrA3 = new int[]{1,1,1,2,1,1,1,2,1,1,2,1,1,2,2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,2,1,1,2,1,1,1,2,1,1,1,1,1,1,1,2,1,2,2,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,2,1,1,1,1,1,1,2,1,1,2,2,1,1,1,1,1,1,2,1,1,1,2,1,1,1,2,1,2,1,2,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,2,2,1,2,1,1,1,1,1,2,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,2,1,1,2,2,1,1,1,1,2,1,1,1,1,1,1,1,1,2,1,2,2,1,1,1,1,2,2,1,2,1,2,1,1,1,1,1,1,1,1,2,1,2,1,2,1,1,1,1,2,1,1,1,1,1,1,1,2,2,1,1,1,1,2,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,2,2,2,1,2,1,1,2,1,2,1,1,2,2,2,1,1,1,1,2,2,1,1,1,1,1,1,1,1,2,1,1,1,1,2,2,2,1,1,1,1,2,2,2,2,1,2,1,1,2,1,1,2,1,2,2,1,1,2,2,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,2,1,2,2,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,1,1,1,1,2,1,1,2,1,1,2,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,2,2,1,1,2,1,1,1,1,1,1,2,1,1,2,2,2,2,1,2,1,1,1,1,2,1,1,1,1,2,1,1,1,2,1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2,1,1,1,2,1,2,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,2,1,1,2,1,1,2,1,1,2,1,2,2,1,2,1,1,1,1,1,1,2,1,2,2,1,1,1,1,2,2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,2,2,1,1,1,2,1,1,2,1,1,2,1,2,1,1,1,1,1,1,2,1,1,2,1,1,1,1,2,2,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,1,2,1,1,1,2,1,1,1,2,2,1,1,2,1,1,2,2,1,1,1,2,1,2,2,1,2,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,2,1,2,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,2,1,1,2,1,1,1,2,1,2,1,2,1,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,2,1,1,1,1,2,1,2,2,1,1,2,2,2,1,1,1,1,1,2,2,2,1,2,1,1,1,2,2,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,2,1,2,1,2,1,1,1,1,2,1,1,1,2,1,1,1,2,2,1,1,2,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,1,2,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,2,2,1,1,2,1,2,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,2,1,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,2,1,1,1,1,2,1,1,1,2,1,2,2,1,1,2,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,2,1,1,2,1,1,1,1,2,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,2,1,1,1,1,2,1,2,1,2,1,2,1,2,2,1,1,2,1,2,1,2,1,2,1,1,1,1,2,1,2,1,1,1,1,1,2,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,2,1,1,1,1,1,2,2,1,2,1,2,1,2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,2,2,2,1,1,1,1,2,1,1,1,2,1,2,1,2,2,1,1,2,2,1,1,1,1,2,2,2,1,2,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,2,2,1,1,1,2,2,2,1,2,1,2,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,2,2,1,1,1,1,2,2,2,1,1,1,1,2,1,1,1,2,1,1,1,2,2,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,2,1,1,1,1,2,2,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,2,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,2,2,1,1,1,2,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,2,1,1,1,1,2,2,1,2,1,1,2,1,1,1,1,1,1,2,2,2,1,1,2,1,2,1,1,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,2,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,2,2,1,2,1,1,1,2,1,2,1,1,1,2,1,1,2,1,2,1,1,1,2,1,2,2,1,1,1,2,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1,1,1,2,2,1,1,2,1,1,2,2,1,1,2,1,2,1,2,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,1,2,1,2,1,1,1,2,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,2,1,1,1,2,2,1,1,1,1,1,2,1,2,1,2,2,1,1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,2,2,1,1,1,1,2,1,2,1,2,1,1,2,2,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,2,1,1,1,1,2,2,1,1,1,1,1,1,2,1,1,1,2,1,2,1,1,1,1,1,2,1,2,1,1,2,2,1,1,1,1,1,1,2,1,2,1,1,1,1,1,2,2,2,1,1,1,1,1,1,2,2,1,1,2,1,2,1,2,2,1,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,2,1,1,1,2,1,1,2,1,2,1,2,1,2,1,2,2,1,2,1,1,1,1,1,2,1,1,1,2,1,2,1,1,2,1,1,2,1,2,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,2,1,2,2,2,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,2,2,1,1,2,2,1,2,1,2,2,1,1,1,1,1,2,1,1,1,1,1,1,2,2,1,1,1,2,1,2,1,1,1,2,1,1,1,1,1,2,1,2,1,1,1,1,2,2,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,2,1,1,1,1,2,1,1,1,1,2,2,1,1,2,1,2,1,1,1,1,1,2,2,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,1,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,2,1,2,2,1,2,2,2,2,1,2,2,1,2,1,1,2,2,2,1,2,1,1,2,2,2,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,1,1,1,2,2,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,2,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,2,1,2,1,1,1,1,1,1,2,1,2,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,1,1,1,1,2,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,2,2,1,2,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,2,2,1,2,1,1,1,1,1,1,2,1,2,1,1,1,2,1,2,2,1,2,2,1,1,2,2,1,1,1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,2,1,2,1,2,2,1,1,2,1,1,2,1,1,1,1,2,1,2,1,2,1,1,1,1,2,1,1,2,1,2,2,1,1,1,2,1,2,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,2,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,2,1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,2,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,2,2,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,2,2,2,1,1,2,1,1,1,1,2,1,1,1,1,1,1,2,1,2,1,1,2,1,2,1,1,1,2,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,2,1,2,2,2,1,2,1,1,1,2,1,2,2,1,1,2,1,2,1,1,1,1,2,1,1,2,2,1,1,1,1,1,1,1,1,2,2,1,2,1,1,2,1,1,1,1,1,2,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,2,1,2,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2,2,2,2,2,1,1,1,1,2,1,1,1,2,1,1,1,1,2,2,1,1,2,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,2,1,1,1,2,2,1,1,2,1,1,1,2,1,2,1,2,1,1,1,1,2,1,1,1,2,1,2,2,1,1,1,1,1,1,2,2,1,1,1,1,2,1,1,2,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,2,1,1,2,2,1,1,2,1,2,2,2,1,2,1,1,1,1,1,1,1,1,2,1,2,2,1,1,2,2,1,1,2,1,1,1,1,1,1,2,2,1,1,1,1,1,1,2,1,1,1,1,1,2,1,2,2,1,1,2,2,1,1,1,1,1,2,1,1,1,2,1,1,2,1,2,1,1,2,1,1,1,1,1,2,2,1,1,1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,2,2,1,1,1,1,1,1,2,2,1,2,1,1,1,1,2,1,1,2,1,1,2,1,2,1,1,1,1,1,1,1,2,1,1,2,2,2,1,1,2,1,1,1,1,1,2,1,2,2,2,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,2,1,1,1,2,2,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,2,1,2,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,2,1,2,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,2,2,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,2,2,1,2,1,2,1,1,1,1,2,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,1,2,1,1,2,1,2,2,2,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,2,1,1,1,2,1,1,2,1,1,2,2,1,1,1,1,1,1,2,1,2,2,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,2,2,1,2,1,1,1,1,1,1,1,1,2,2,2,1,2,1,1,2,1,1,1,2,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,2,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,2,1,1,1,1,1,1,1,1,1,2,1,2,2,1,1,1,1,1,2,1,2,1,1,1,2,1,1,2,1,1,1,1,2,1,2,2,1,2,1,1,1,1,1,1,1,1,2,2,1,2,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,2,1,1,1,1,2,1,2,2,2,2,1,1,1,1,2,1,1,2,1,2,2,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,2,1,2,2,1,2,1,2,1,2,1,1,1,1,2,1,1,2,2,2,1,1,1,1,1,2,1,1,1,1,2,2,1,1,1,2,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,2,1,1,2,1,1,1,2,1,1,1,1,1,2,1,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,2,1,2,2,2,1,2,1,2,1,1,1,2,1,1,1,2,1,2,1,2,2,2,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,2,2,1,1,1,1,1,1,1,1,2,1,1,1,2,1,2,1,1,1,1,2,1,2,2,1,1,1,2,1,1,1,1,1,2,2,2,1,1,1,2,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2,2,2,2,1,2,2,1,1,1,2,2,1,1,1,1,1,2,2,1,1,1,1,1,2,2,1,1,1,1,1,1,1,2,1,2,1,1,1,2,2,2,2,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,2,1,1,2,1,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,2,2,1,1,1,2,1,2,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,1,2,1,1,1,1,2,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,2,1,1,2,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,2,2,2,2,1,1,2,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,2,1,1,2,2,1,1,2,1,1,1,1,1,1,1,2,1,1,2,2,1,1,1,1,2,1,1,1,1,1,1,1,1,2,2,1,2,1,1,1,2,1,1,2,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,2,2,1,1,2,1,1,2,1,2,2,1,1,1,1,1,1,1,2,1,1,1,1,1,2,2,1,2,1,1,2,1,1,1,1,2,1,2,2,1,2,1,1,1,2,2,2,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1,2,1,1,2,2,1,1,2,2,1,2,1,1,1,1,1,1,2,2,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1};
        int[] arrB3 = new int[]{2,2,1,1,1,1,2,1,2,2,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,2,2,1,2,1,1,1,1,2,1,1,1,2,1,1,1,1,1,2,1,2,1,1,1,1,2,1,1,2,2,1,1,2,1,1,1,1,2,1,1,1,1,1,2,1,2,1,1,2,1,1,1,2,1,2,1,2,1,2,2,1,1,2,1,1,1,2,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,2,1,2,1,2,2,1,1,1,2,1,1,2,2,2,1,1,1,2,2,1,2,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,2,2,2,1,2,2,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1,1,2,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,2,2,2,2,1,1,1,2,1,2,1,1,1,1,1,2,1,1,1,2,2,2,1,1,1,1,1,2,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1,2,2,1,2,1,1,1,1,1,1,2,2,2,1,1,1,1,1,2,2,1,1,2,1,1,1,1,1,1,1,2,1,1,2,1,1,2,1,1,1,1,2,1,1,1,1,2,1,1,2,2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,2,1,2,1,2,1,2,1,2,1,1,1,2,1,2,1,1,2,1,2,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,2,2,2,1,1,1,1,1,2,1,1,1,1,1,1,2,2,1,1,1,2,1,1,1,2,2,1,2,1,2,1,1,1,2,2,1,1,1,1,1,1,1,2,2,2,1,1,2,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,2,1,1,1,2,1,2,2,1,1,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,2,2,1,1,1,2,1,1,1,2,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,2,2,1,2,1,2,2,1,1,1,2,2,1,1,2,1,2,1,1,1,1,2,1,2,1,1,1,2,1,2,1,2,1,2,2,1,2,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1,1,2,1,1,1,2,2,1,1,1,2,1,1,1,1,1,2,2,1,2,1,1,2,2,1,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,2,1,1,1,1,2,1,2,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,2,2,1,2,1,1,1,1,1,1,1,2,1,1,1,2,1,2,1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,2,1,1,1,1,1,2,1,2,2,2,1,1,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,2,2,1,1,2,1,1,2,2,1,1,2,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,2,1,1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,1,1,2,2,1,2,1,1,2,1,2,2,1,1,2,1,2,1,1,1,1,1,1,2,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,1,1,1,1,2,2,1,1,2,1,1,2,1,1,1,2,1,1,1,1,1,2,2,1,1,2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1,1,1,2,2,2,1,1,1,2,2,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,2,1,1,2,1,1,1,1,2,1,2,1,1,1,2,1,2,2,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,2,2,1,2,1,1,1,1,2,1,1,1,2,1,2,1,2,1,2,2,1,1,1,1,1,2,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,2,1,2,1,2,1,1,2,1,1,1,1,1,2,1,2,1,1,2,2,2,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,2,2,1,1,2,2,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,2,1,2,2,2,1,1,2,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,2,1,1,1,1,1,2,1,1,2,1,1,1,2,2,2,1,2,2,1,1,2,2,1,1,1,1,1,2,1,1,1,1,1,2,2,1,2,1,1,1,1,1,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,2,2,2,2,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,2,1,1,1,2,2,2,1,1,2,2,2,1,1,1,2,1,1,1,2,2,1,1,2,2,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,2,1,1,1,1,2,2,1,2,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,2,1,1,2,1,1,1,1,2,1,1,1,2,1,2,2,2,1,1,1,2,2,1,1,2,1,1,1,1,1,1,2,1,2,1,1,1,2,1,2,1,2,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,2,1,2,1,1,1,2,1,1,2,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,2,2,1,1,1,1,1,2,2,2,1,1,1,1,2,1,2,1,2,2,1,1,1,1,2,1,1,1,2,1,1,1,1,2,1,2,2,1,1,1,1,1,1,2,2,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,2,2,2,1,1,1,1,1,1,2,2,1,1,1,2,1,1,1,1,2,1,1,1,2,2,2,2,1,2,1,1,1,2,1,1,1,2,1,2,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,2,2,1,1,1,1,2,1,2,1,1,2,1,1,1,1,1,1,2,1,1,2,1,2,1,1,1,1,2,1,1,1,1,1,1,2,1,1,1,2,1,1,1,1,2,1,1,1,1,2,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,2,1,2,1,2,1,1,2,1,1,2,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,2,2,1,1,1,1,1,1,1,1,1,1,2,2,2,2,1,1,2,1,2,2,2,1,1,1,1,1,2,1,1,1,1,2,2,1,1,2,2,1,1,2,1,1,1,2,2,2,1,1,1,2,1,1,1,2,1,2,1,2,2,1,1,2,2,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,2,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,2,2,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2,1,1,1,1,1,2,1,2,1,2,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,2,1,1,1,1,1,2,2,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,2,1,1,2,2,2,1,1,1,1,2,1,2,1,1,1,2,2,1,1,1,1,2,1,2,2,1,1,1,2,1,2,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,2,1,1,1,1,2,2,1,1,1,1,1,2,1,2,1,1,1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,2,2,1,1,1,1,2,1,1,1,1,2,1,2,1,1,1,2,1,1,2,1,1,1,2,2,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,2,2,1,2,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,2,1,1,2,1,1,1,2,2,1,1,1,1,1,1,1,2,1,2,2,1,1,1,1,2,1,1,1,1,2,1,1,1,2,1,1,2,2,2,1,1,1,1,1,2,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1,1,1,1,1,2,2,2,1,2,1,1,1,1,1,2,1,2,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,2,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,2,2,1,1,2,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,2,1,2,2,2,1,2,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,2,1,2,1,1,2,1,1,1,1,1,2,2,1,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,2,2,1,1,2,1,1,2,1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,2,1,1,1,1,1,2,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,2,1,2,2,1,2,1,1,2,1,1,1,1,2,1,2,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,2,2,1,1,1,1,1,2,1,2,2,1,2,1,2,1,1,1,1,1,2,2,1,2,2,2,1,1,1,2,1,1,2,1,2,1,1,2,1,1,2,1,2,1,2,1,1,1,1,1,1,1,1,1,2,1,2,2,1,2,1,1,1,1,2,1,2,2,1,1,1,2,1,1,1,2,1,1,2,1,1,1,2,1,1,2,2,1,1,1,2,1,1,2,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1,1,2,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,2,1,1,2,1,1,1,2,2,1,2,1,1,2,2,2,2,1,1,2,1,1,1,1,1,1,2,2,1,1,2,2,1,1,1,1,1,1,2,1,1,2,2,2,2,1,1,1,1,1,2,1,2,1,2,1,1,1,2,1,2,1,1,2,1,1,1,1,2,2,1,1,1,1,1,2,2,1,1,1,2,1,1,1,1,1,1,1,2,1,2,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,2,2,2,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1,1,2,1,1,2,2,2,2,1,2,1,1,2,1,1,2,1,2,2,2,1,1,1,1,2,2,1,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,2,2,2,2,1,2,2,1,2,1,2,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,2,2,1,1,2,1,1,1,2,2,1,1,2,1,1,1,1,2,2,1,1,2,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,2,1,2,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,2,2,2,1,1,2,1,2,1,1,2,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1,1,2,1,2,1,2,1,1,1,2,1,1,1,2,1,1,1,1,2,2,2,1,1,1,2,2,2,1,1,1,1,2,1,1,2,2,1,1,1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,2,1,1,2,2,2,1,1,2,1,2,1,2,1,1,2,1,1,1,1,1,1,2,1,1,1,1,2,2,2,1,1,1,1,1,2,2,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,1,1,1,2,1,1,1,1,1,2,1,2,1,1,2,1,1,1,1,1,2,1,1,1,2,2,2,1,2,1,1,1,1,2,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1,1,2,2,1,1,1,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,2,1,2,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,2,1,2,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,1,1,1,2,1,2,1,1,1,2,2,1,2,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,2,1,1,2,1,1,1,1,1,2,1,2,1,1,1,2,1,1,1,2,2,2,1,1,2,2,1,1,2,1,1,2,1,1,1,2,2,1,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,2,2,1,2,2,1,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,2,1,1,2,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,2,2,1,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,2,2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,1,1,2,1,2,2,2,1,1,1,2,1,1,1,2,1,1,1,1,1,1,2,1,1,2,1,1,2,2,1,2,1,1,1,1,1,1,1,2,2,1,1,1,1,2,2,2,1,1,1,1,2,1,1,1,2,1,2,2,1,1,1,1,1,2,2,1,1,2,1,1,1,1,1,2,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,2,2,1,2,1,1,2,1,1,1,1,1,1,2,1,1,1,1,2,1,2,2,1,2,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,2,1,1,1,2,1,1,2,2,1,2,2,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,2,2,1,1,1,1,1,1,2,1,1,1,1,1,1,1,2,1,1,2,2,1,1,1,1,2,1,2,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1};
        System.out.println(test.minDominoRotations3(arrA3, arrB3));
    }
}
