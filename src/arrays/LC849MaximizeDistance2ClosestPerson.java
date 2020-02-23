package arrays;

public class LC849MaximizeDistance2ClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int maxZeros = 0;
        int tmp = 0;
        boolean isEdge = false;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                if (i == 0) {
                    isEdge = true;
                }
                tmp++;
                if (isEdge && i < seats.length - 1 && seats[i + 1] == 1 || i == seats.length - 1) {
                    tmp *= 2;
                }
                if (tmp > maxZeros) {
                    maxZeros = tmp;
                }
            } else if (seats[i] == 1) {
                tmp = 0;
                isEdge = false;
            }
        }
        return (int)Math.ceil(maxZeros / 2f);
    }

    public static void main(String[] args) {
        LC849MaximizeDistance2ClosestPerson lc849MaximizeDistance2ClosestPerson = new LC849MaximizeDistance2ClosestPerson();
        int[] arr1 = new int[]{1,0,0,0,1,0,1};
        System.out.println(lc849MaximizeDistance2ClosestPerson.maxDistToClosest(arr1));
        int[] arr2 = new int[]{1,0,0,0};
        System.out.println(lc849MaximizeDistance2ClosestPerson.maxDistToClosest(arr2));
        int[] arr3 = new int[]{0,1,1,1,0,0,1,0,0};
        System.out.println(lc849MaximizeDistance2ClosestPerson.maxDistToClosest(arr3));
    }
}
