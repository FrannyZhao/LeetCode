package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC271EncodeAndDecodeStrings {

    static class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder header = new StringBuilder();
            StringBuilder content = new StringBuilder();
            for (String str : strs) {
                header.append(str.length()).append(" ");
                content.append(str);
            }
            header.append("E");
            return header.toString() + content.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            System.out.println(s);
            List<String> result = new ArrayList<>();
            String header = "";
            String content = "";
            for (int i = 0; i < s.length(); i++) {
                if ('E' == s.charAt(i)) {
                    header = s.substring(0, i);
                    content = s.substring(i + 1, s.length());
                    break;
                }
            }
            System.out.println("header: " + header);
            System.out.println("content: " + content);
            if (!header.equals("")) {
                int from = 0;
                for (String splitIndex : header.split(" ")) {
                    int index = Integer.parseInt(splitIndex);
                    System.out.println("index: " + index);
                    result.add(content.substring(from, index + from));
                    from += index;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        /*
        String s = "E";
        String header = null;
        String content = null;
        for (int i = 0; i < s.length(); i++) {
            if ('E' == s.charAt(i)) {
                header = s.substring(0, i);
                content = s.substring(i + 1, s.length());
            }
        }
        if (header != null && content != null) {
            System.out.println(header.equals(""));
            System.out.println(content);
            System.out.println(header.length());
            System.out.println(content.length());
        }
         */


        Codec codec = new Codec();
        List<String> strs = new ArrayList<>();
        List<String> result;
        /*
        strs.clear();
        strs.add("Hello");
        strs.add("World");
        result = codec.decode(codec.encode(strs));
        for (int i = 0; i < result.size(); i++) {
            System.out.println("result[" + i + "]: " + result.get(i));
        }
        System.out.println("-----" + result.size() + "-------");
        assert result.size() == strs.size();
        for (int i = 0; i < result.size(); i++) {
            assert result.get(i).equals(strs.get(i));
        }
*/
        strs.clear();
        strs.add("");
        result = codec.decode(codec.encode(strs));
        for (int i = 0; i < result.size(); i++) {
            System.out.println("result[" + i + "]: " + result.get(i));
        }
        System.out.println("-----" + result.size() + "-------");
        assert result.size() == strs.size();
        for (int i = 0; i < result.size(); i++) {
            assert result.get(i).equals(strs.get(i));
        }


        System.out.println(" ====== Success! =====");
    }
}
