package arrays;

import java.util.Arrays;

public class LC66PlusOne {
    public int[] plusOne(int[] digits) {
        /*
        if (digits == null || digits.length == 0) {
            return digits;
        }
        boolean plusOne = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (plusOne) {
                digits[i]++;
            }
            if (digits[i] > 9 && i != 0) {
                digits[i] = 0;
                plusOne = true;
            } else {
                break;
            }
        }
        if (digits[0] == 10) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            result[1] = 0;
            for (int i = 1; i < digits.length; i++) {
                result[i+1] = digits[i];
            }
            return result;
        } else {
            return digits;
        }

         */
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        return newNumber;
    }

    public static void main(String[] args) {
        LC66PlusOne plusOne = new LC66PlusOne();
        int[] arr1 = new int[]{1,2,3};
        System.out.println(Arrays.toString(plusOne.plusOne(arr1)));
    }
}
