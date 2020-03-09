package hashtable;

import java.util.*;

public class LC299BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        TreeMap<Character, TreeSet<Integer>> maps = new TreeMap<>();
        char[] chars = guess.toCharArray();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            if (chars[i] == c) {
                bulls++;
                chars[i] = 'N';
            } else {
                if (maps.containsKey(c)) {
                    TreeSet<Integer> set = maps.get(c);
                    set.add(i);
                } else {
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(i);
                    maps.put(c, set);
                }
            }
        }
        for (char c : chars) {
            if (maps.containsKey(c)) {
                TreeSet<Integer> set = maps.get(c);
                if (!set.isEmpty()) {
                    cows++;
                    set.remove(set.first());
                }
                if (set.isEmpty()) {
                    maps.remove(c);
                }
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        LC299BullsAndCows test = new LC299BullsAndCows();
        String result1 = test.getHint("1807", "7810");
        System.out.println(result1);
        assert result1.equals("1A3B");

        String result2 = test.getHint("1123", "0111");
        System.out.println(result2);
        assert result2.equals("1A1B");

        String result3 = test.getHint("011", "110");
        System.out.println(result3);
        assert result3.equals("1A2B");

        String result4 = test.getHint("1122", "1222");
        System.out.println(result4);
        assert result4.equals("3A0B");

        System.out.println(" ====== Success! =====");
    }
}
