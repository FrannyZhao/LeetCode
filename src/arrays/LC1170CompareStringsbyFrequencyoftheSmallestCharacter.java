package arrays;

import java.util.Arrays;

public class LC1170CompareStringsbyFrequencyoftheSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queriesCount = new int[queries.length];
        int[] wordsCount = new int[words.length];
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queriesCount[i] = countChar(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            wordsCount[i] = countChar(words[i]);
        }
        for (int i = 0; i < queriesCount.length; i++) {
            int count = 0;
            for (int wordCount : wordsCount) {
                if (queriesCount[i] < wordCount) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    private int countChar(String str) {
        int minChar = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < minChar) {
                minChar = str.charAt(i);
                count = 1;
            }
            if (str.charAt(i) == minChar) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC1170CompareStringsbyFrequencyoftheSmallestCharacter test = new LC1170CompareStringsbyFrequencyoftheSmallestCharacter();
        String[] queries1 = new String[]{"bbb","cc"};
        String[] words1 = new String[]{"a","aa","aaa","aaaa"};
        System.out.println(Arrays.toString(test.numSmallerByFrequency(queries1, words1)));
        String[] queries2 = new String[]{"cbd"};
        String[] words2 = new String[]{"zaaaz"};
        System.out.println(Arrays.toString(test.numSmallerByFrequency(queries2, words2)));
    }
}
