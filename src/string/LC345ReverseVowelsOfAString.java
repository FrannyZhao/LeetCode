package string;

public class LC345ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int head = 0;
        int tail = chars.length - 1;
        while (head < tail) {
            while (!isVowel(chars[head]) && head < tail) {
                head++;
            }
            while (!isVowel(chars[tail]) && head < tail) {
                tail--;
            }
            if (head < tail) {
                char tmp = chars[head];
                chars[head] = chars[tail];
                chars[tail] = tmp;
                head++;
                tail--;
            }
        }
        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        return "aoeiuAOEIU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        LC345ReverseVowelsOfAString test = new LC345ReverseVowelsOfAString();
        String result;

        result = test.reverseVowels("hello");
        System.out.println(result);
        assert "holle".equals(result);

        result = test.reverseVowels("leetcode");
        System.out.println(result);
        assert "leotcede".equals(result);

        System.out.println(" ====== Success! =====");
    }
}
