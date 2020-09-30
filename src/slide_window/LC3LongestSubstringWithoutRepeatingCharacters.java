package slide_window;

import java.util.HashMap;
import java.util.Map;

public class LC3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int left = 0, right = 0;
        int result = 1;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length() || (right == s.length() && right - left > result)) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            result = Math.max(result, right - left + 1);
            right++;
//            System.out.println("left " + left + ", right " + right + ", result " + result);
        }
        return result;
    }

    public static void main(String[] args) {
        LC3LongestSubstringWithoutRepeatingCharacters test = new LC3LongestSubstringWithoutRepeatingCharacters();
        int result;

        result = test.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
        assert result == 3;

        result = test.lengthOfLongestSubstring("bbbbb");
        System.out.println(result);
        assert result == 1;

        result = test.lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
        assert result == 3;

        result = test.lengthOfLongestSubstring("");
        System.out.println(result);
        assert result == 0;

        result = test.lengthOfLongestSubstring("au");
        System.out.println(result);
        assert result == 2;

        result = test.lengthOfLongestSubstring("abba");
        System.out.println(result);
        assert result == 2;
    }
}
