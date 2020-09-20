package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LC205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0 ; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a).equals(b)) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (!map.containsValue(b)) {
                    map.put(a, b);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC205IsomorphicStrings test = new LC205IsomorphicStrings();
        boolean result;

        result = test.isIsomorphic("egg", "add");
        System.out.println(result);
        assert result;

        result = test.isIsomorphic("foo", "bar");
        System.out.println(result);
        assert !result;

        result = test.isIsomorphic("paper", "title");
        System.out.println(result);
        assert result;

        result = test.isIsomorphic("ab", "aa");
        System.out.println(result);
        assert !result;

        System.out.println(" ====== Success! =====");
    }
}
