package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LC459RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        String pattern;
        StringBuilder sb;
        for (int i = s.length() / 2; i > 0; i--) {
            if (s.length() % i == 0) {
                pattern = s.substring(0, i);
                sb = new StringBuilder();
                for (int j = 0; j < s.length() / i; j++) {
                    sb.append(pattern);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }


    /*
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        boolean result = true;
        HashMap<Character, ArrayList<Integer>> hashMap = new HashMap<>();
        ArrayList<Integer> list;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!hashMap.containsKey(c)) {
                list = new ArrayList<>();
                list.add(i);
                hashMap.put(c, list);
            } else {
                list = hashMap.get(c);
                list.add(i);
            }
        }
        int lastGap = -1;
        for (ArrayList<Integer> indexes : hashMap.values()) {
            if (indexes.size() < 2) {
                result = false;
                break;
            } else {
                int gap = getGap(indexes);
                if (gap == -2) {
                    result = false;
                    break;
                } else if (lastGap == -1) {
                    lastGap = gap;
                } else if (lastGap != gap) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    private int getGap(ArrayList<Integer> list) {
//        for (Integer integer : list) {
//            System.out.print(integer);
//        }
//        System.out.println();
        int result = -2;
        boolean found;
        for (int i = 1; i < list.size(); i++) {
            int gap = list.get(i) - list.get(0);
            found = true;
            for (int j = 0; j < i; j++) {
                if (j + i > list.size() - 1) {
                    found = false;
                    break;
                }

                int time = 1;
                while (j + i * time < list.size()) {
                    if (list.get(j) + gap * time != list.get(j + i * time)) {
                        found = false;
//                        System.out.println("not found: i, j, time " + i + " " + j + " " + time);
                        break;
                    }
                    time++;
                }
                if (found && time != 2) {
//                    System.out.println("gap " + gap + " found: i, j, time " + i + " " + j + " " + time);
                    if ((j + 1) * time < list.size()) {
//                        System.out.println("gap " + gap + " not found: i, j, time " + i + " " + j + " " + time);
                        found = false;
                    }
                }
            }
//            System.out.println("found? " + found + ", gap " + gap);
            if (found) {
                result = gap;
            }
        }
//        System.out.println("result " + result);
        return result;
    }
*/
    public static void main(String[] args) {
        LC459RepeatedSubstringPattern test = new LC459RepeatedSubstringPattern();
        boolean result;

        result = test.repeatedSubstringPattern("abab");
        System.out.println(result);
        assert result;

        result = test.repeatedSubstringPattern("aba");
        System.out.println(result);
        assert !result;

        result = test.repeatedSubstringPattern("abcabcabcabc");
        System.out.println(result);
        assert result;

        result = test.repeatedSubstringPattern("ababab");
        System.out.println(result);
        assert result;

        result = test.repeatedSubstringPattern("abacababacab");
        System.out.println(result);
        assert result;

        result = test.repeatedSubstringPattern("aabaaba");
        System.out.println(result);
        assert !result;

        System.out.println(" ====== Success! =====");
    }
}
