package arrays;

public class LC1011CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        int max = 0;
        for (int weight : weights) {
            if (weight > max) {
                max = weight;
            }
            sum += weight;
        }
        int start = max, end = sum;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (canShipWithInDDays(weights, D, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (canShipWithInDDays(weights, D, start)) {
            return start;
        } else {
            return end;
        }
    }

    private boolean canShipWithInDDays(int[] weights, int D, int capacity) {
        int days = 0;
        int sum = 0;
        for (int i = 0; i < weights.length - 1; i++) {
            sum += weights[i];
            if (sum <= capacity && sum + weights[i + 1] > capacity) {
                days++;
                sum = 0;
            }
        }
        days++;
        return days <= D;
    }

    public static void main(String[] args) {
        LC1011CapacityToShipPackagesWithinDDays test = new LC1011CapacityToShipPackagesWithinDDays();
        int[] weight1 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int d1 = 5;
        int result1 = test.shipWithinDays(weight1, d1);
        System.out.println(result1);
        assert 15 == result1;
        int[] weight2 = new int[]{3,2,2,4,1,4};
        int d2 = 3;
        int result2 = test.shipWithinDays(weight2, d2);
        System.out.println(result2);
        assert 6 == result2;
        int[] weight3 = new int[]{1,2,3,1,1};
        int d3 = 4;
        int result3 = test.shipWithinDays(weight3, d3);
        System.out.println(result3);
        assert 3 == result3;
    }
}
