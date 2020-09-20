package string;

public class LC686RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int result = 0;
        while (sb.length() <= B.length()){
            result++;
            sb.append(A);
            if (sb.indexOf(B) != -1) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC686RepeatedStringMatch test = new LC686RepeatedStringMatch();
        int result;

        result = test.repeatedStringMatch("abcd", "cdabcdab");
        System.out.println(result);
        assert result == 3;
        System.out.println(" ====== Success! =====");
    }
}
