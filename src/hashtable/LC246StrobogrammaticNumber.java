package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LC246StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> mapSelf = new HashMap<>();
        mapSelf.put('0', '0');
        mapSelf.put('1', '1');
        mapSelf.put('8', '8');
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.putAll(mapSelf);
        while (num.length() > 1) {
            char head = num.charAt(0);
            char tail = num.charAt(num.length() - 1);
            if (map.get(head) == null || map.get(head) != tail) {
                return false;
            } else {
                num = num.substring(1, num.length() - 1);
            }
        }
        if (num.length() == 1) {
            return mapSelf.containsKey(num.charAt(0));
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        LC246StrobogrammaticNumber test = new LC246StrobogrammaticNumber();
        boolean result;

        result = test.isStrobogrammatic("69");
        System.out.println(result);
        assert result;

        result = test.isStrobogrammatic("88");
        System.out.println(result);
        assert result;

        result = test.isStrobogrammatic("962");
        System.out.println(result);
        assert !result;

        result = test.isStrobogrammatic("2");
        System.out.println(result);
        assert !result;

        result = test.isStrobogrammatic("1");
        System.out.println(result);
        assert result;

        result = test.isStrobogrammatic("25");
        System.out.println(result);
        assert !result;

        result = test.isStrobogrammatic("659");
        System.out.println(result);
        assert !result;

        result = test.isStrobogrammatic("101");
        System.out.println(result);
        assert result;

        result = test.isStrobogrammatic("9556");
        System.out.println(result);
        assert !result;

        System.out.println(" ====== Success! =====");
    }
}
