package string;

import java.util.ArrayList;
import java.util.List;

public class LC68TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int count = 0;
        int lastIndex = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (count + word.length() > maxWidth) {
                int spaceCount = maxWidth - count + i - lastIndex;
                result.add(generateLine(words, lastIndex, i, spaceCount));
                lastIndex = i;
                count = word.length() + 1;
            } else {
                count += word.length() + 1;
            }
        }
        if (lastIndex < words.length) {
            result.add(generateLastLine(words, lastIndex, maxWidth));
        }
        return result;
    }

    /**
     * @param from inclusive
     * @param to exclusive
     */
    private String generateLine(String[] words, int from, int to, int spaceCount) {
//        System.out.println("from " + from + ", to " + to + ", spaceCount " + spaceCount);
        int dividSpace;
        float divideCount = 1f;
        StringBuilder sb = new StringBuilder();
        if (to == from + 1) {
            sb.append(words[from]);
            for (int i = 0; i < spaceCount; i++) {
                sb.append(" ");
            }
        } else {
            for (int i = from; i < to; i++) {
                sb.append(words[i]);
                if (i != to - 1) {
                    dividSpace = (int) Math.ceil(spaceCount / (to - from - divideCount));
//                    System.out.println("dividSpace " + dividSpace);
                    for (int j = 0; j < dividSpace; j++) {
                        sb.append(" ");
                    }
                    spaceCount -= dividSpace;
                    divideCount++;
                }
            }
        }
        return sb.toString();
    }

    private String generateLastLine(String[] words, int from, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = from; i < words.length; i++) {
            sb.append(words[i]);
            if (i != words.length - 1) {
                sb.append(" ");
                count += words[i].length() + 1;
            } else {
                count += words[i].length();
            }
        }
        for (int i = count; i < maxWidth; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC68TextJustification test = new LC68TextJustification();
        List<String> result;
        List<String> answer = new ArrayList<>();

        result = test.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        answer.clear();
        answer.add("This    is    an");
        answer.add("example  of text");
        answer.add("justification.  ");
        assert result.size() == answer.size();
        for (int i = 0; i < answer.size(); i++) {
            assert result.get(i).equals(answer.get(i));
        }

        result = test.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
        for (String s : result) {
            System.out.println(s);
        }
        answer.clear();
        answer.add("What   must   be");
        answer.add("acknowledgment  ");
        answer.add("shall be        ");
        assert result.size() == answer.size();
        for (int i = 0; i < answer.size(); i++) {
            assert result.get(i).equals(answer.get(i));
        }

        result = test.fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"}, 20);
        for (String s : result) {
            System.out.println(s);
        }
        answer.clear();
        answer.add("Science  is  what we");
        answer.add("understand      well");
        answer.add("enough to explain to");
        answer.add("a  computer.  Art is");
        answer.add("everything  else  we");
        answer.add("do                  ");
        assert result.size() == answer.size();
        for (int i = 0; i < answer.size(); i++) {
            assert result.get(i).equals(answer.get(i));
        }

        System.out.println(" ====== Success! =====");
    }
}
