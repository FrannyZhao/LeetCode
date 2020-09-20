package back_tracking;

import java.util.ArrayList;
import java.util.List;

public class LC401BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (num == Integer.bitCount(h) + Integer.bitCount(m)) {
                    result.add(String.format("%d:%02d", h, m));
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC401BinaryWatch test = new LC401BinaryWatch();
        List<String> result = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        answer.clear();
        answer.add("1:00");
        answer.add("2:00");
        answer.add("4:00");
        answer.add("8:00");
        answer.add("0:01");
        answer.add("0:02");
        answer.add("0:04");
        answer.add("0:08");
        answer.add("0:16");
        answer.add("0:32");
        result = test.readBinaryWatch(1);
        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();
        assert result.size() == answer.size();
        for (int i = 0; i < result.size(); i++) {
            assert answer.contains(result.get(i));
            assert result.contains(answer.get(i));
        }


        System.out.println(" ====== Success! =====");
    }
}
