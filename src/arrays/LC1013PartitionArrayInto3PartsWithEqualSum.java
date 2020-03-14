package arrays;

public class LC1013PartitionArrayInto3PartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        boolean result = false;
        float partSumF = sum / 3f;
        int partSum = (int)partSumF;
        if (partSum == partSumF) {
            int curSum = 0;
            int left = -1;
            for (int i = 0; i < A.length; i++) {
                curSum += A[i];
                if (curSum == partSum) {
                    left = i;
                    break;
                }
            }
            int right = A.length;
            curSum = 0;
            for (int i = A.length - 1; i >= 0; i--) {
                curSum += A[i];
                if (curSum == partSum) {
                    right = i;
                    break;
                }
            }
            System.out.println("left " + left + ", right " + right);
            if (left >= 0 && left < A.length - 2 && right > 1 && right < A.length && left < right - 1) {
                curSum = 0;
                for (int i = left + 1; i < right; i++) {
                    curSum += A[i];
                }
                if (curSum == partSum) {
                    result = true;

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC1013PartitionArrayInto3PartsWithEqualSum test = new LC1013PartitionArrayInto3PartsWithEqualSum();
        boolean result;

//        result = test.canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1});
//        System.out.println(result);
//        assert result;
//
//        result = test.canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1});
//        System.out.println(result);
//        assert !result;
//
//        result = test.canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4});
//        System.out.println(result);
//        assert result;

        result = test.canThreePartsEqualSum(new int[]{12,-4,16,-5,9,-3,3,8,0});
        System.out.println(result);
        assert result;

        System.out.println(" ====== Success! =====");
    }
}
