package test;

public class Test {
    
    class ChangeValue {
        
    }

    private int test(int a, Integer returnValue) {
        returnValue = Integer.valueOf(3);
        return a;
    }

    public static void main(String[] args) {
        Test t = new Test();
        int a = 1234567890;
        int numLen = 0;
        int tmp = a;
        do {
            numLen ++;
            tmp /= 10;
        } while (tmp != 0);
        int mod = 10, dev = 1;
        for (int i = 0; i < numLen; i++, dev *= 10) {
            int index = a % mod / dev;
//            int index = a / dev % mod;
            System.out.println(index);
        }
    }

}
