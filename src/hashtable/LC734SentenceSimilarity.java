package hashtable;

import java.util.*;

public class LC734SentenceSimilarity {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : pairs) {
            String key = pair.get(0);
            String value = pair.get(1);
            Set<String> set;
            if (map.containsKey(key)) {
                set = map.get(key);
                set.add(value);
            } else {
                set = new HashSet<>();
                set.add(value);
                map.put(key, set);
            }
            key = pair.get(1);
            value = pair.get(0);
            if (map.containsKey(key)) {
                set = map.get(key);
                set.add(value);
            } else {
                set = new HashSet<>();
                set.add(value);
                map.put(key, set);
            }
        }
        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            if (!word1.equals(word2)) {
                Set<String> pair = map.get(word1);
                if (pair == null) {
                    return false;
                }
                if (!pair.contains(word2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC734SentenceSimilarity test = new LC734SentenceSimilarity();
        boolean result;
        List<List<String>> pairs = new ArrayList<>();

        pairs.clear();
        List<String> pair1 = new ArrayList<>();
        pair1.add("great");
        pair1.add("fine");
        pairs.add(pair1);
        List<String> pair2 = new ArrayList<>();
        pair2.add("acting");
        pair2.add("drama");
        pairs.add(pair2);
        List<String> pair3 = new ArrayList<>();
        pair3.add("skills");
        pair3.add("talent");
        pairs.add(pair3);

        result = test.areSentencesSimilar(new String[]{"great", "acting", "skills"},
                new String[]{"fine", "drama", "talent"}, pairs);
        System.out.println(result);
        assert result;


        System.out.println(" ====== Success! =====");
    }
}
