package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class LC809ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int result = 0;
        int i = 0, j = 0;
        int referenceCount = 0, checkCount = 0;
        char referencePreChar, checkPreChar, referenceCurrentChar, checkCurrentChar;
        boolean isMatch;
        S = S + " ";
        for (String word : words) {
            word = word + " ";
            i = 1;
            j = 1;
            referenceCount = 1;
            checkCount = 1;
            referencePreChar = S.charAt(0);
            checkPreChar = word.charAt(0);
            isMatch = true;
            while (i < S.length() && j < word.length()) {
                referenceCurrentChar = S.charAt(i);
                checkCurrentChar = word.charAt(j);
                if (referencePreChar != checkPreChar) {
                    isMatch = false;
                    break;
                }
                if (referenceCurrentChar == referencePreChar || checkCurrentChar == checkPreChar) {
                    if (referenceCurrentChar == referencePreChar) {
                        referenceCount++;
                        i++;
                    }
                    if (checkCurrentChar == checkPreChar) {
                        checkCount++;
                        j++;
                    }
                    continue;
                }
                if (referenceCurrentChar != checkCurrentChar) {
                    isMatch = false;
                    break;
                }
                if (referenceCount != checkCount) {
                    if (referenceCount < checkCount) {
                        isMatch = false;
                    } else if (referenceCount < 3) {
                        isMatch = false;
                    }
                }
                if (!isMatch) {
                    break;
                } else {
                    referenceCount = 1;
                    i++;
                    referencePreChar = referenceCurrentChar;
                    checkCount = 1;
                    j++;
                    checkPreChar = checkCurrentChar;
                }
            }
            if (isMatch) {
                result++;
            }
        }
        return result;
    }

    public int expressiveWords2(String S, String[] words) {
        RLE R = new RLE(S);
        int ans = 0;
        search: for (String word: words) {
            RLE R2 = new RLE(word);
            if (!R.key.equals(R2.key)) continue;
            for (int i = 0; i < R.counts.size(); ++i) {
                int c1 = R.counts.get(i);
                int c2 = R2.counts.get(i);
                if (c1 < 3 && c1 != c2 || c1 < c2)
                    continue search;
            }
            ans++;
        }
        return ans;
    }

    class RLE {
        String key;
        List<Integer> counts;

        public RLE(String S) {
            StringBuilder sb = new StringBuilder();
            counts = new ArrayList();
            char[] ca = S.toCharArray();
            int N = ca.length;
            int prev = -1;
            for (int i = 0; i < N; ++i) {
                if (i == N-1 || ca[i] != ca[i+1]) {
                    sb.append(ca[i]);
                    counts.add(i - prev);
                    prev = i;
                }
            }
            key = sb.toString();
        }
    }

    public static void main(String[] args) {
        LC809ExpressiveWords test = new LC809ExpressiveWords();
        int result;

        result = test.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});
        System.out.println(result);
        assert result == 1;

        result = test.expressiveWords("zzzzzyyyyy", new String[]{"zzyy","zy","zyy"});
        System.out.println(result);
        assert result == 3;

        result = test.expressiveWords("lee", new String[]{"le"});
        System.out.println(result);
        assert result == 0;

        result = test.expressiveWords("yyrrrrrjaappoooyybbbebbbbriiiiiyyynnnvvwtwwwwwooeeexxxxxkkkkkaaaaauuuu", new String[]{
                "yrrjappoyybbeebrriiynvvwwtwwoeexxkauu",
                "yyrjaappoybbeebriynnvvwwtwwooeexkaauu",
                "yrrjaappoybbeebrriyynnvvwwtwwooeexxkaauu",
                "yyrjappooyybebbrriyynnvwttwwooeexxkkau"
        });
        System.out.println(result);
        assert result == 0;

        System.out.println(" ====== Success! =====");
    }
}
