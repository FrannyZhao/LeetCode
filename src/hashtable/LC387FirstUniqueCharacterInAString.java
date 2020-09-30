package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LC387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int result = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC387FirstUniqueCharacterInAString test = new LC387FirstUniqueCharacterInAString();
        int result;

        result = test.firstUniqChar("leetcode");
        System.out.println(result);
        assert result == 0;

        result = test.firstUniqChar("loveleetcode");
        System.out.println(result);
        assert result == 2;
    }
}
