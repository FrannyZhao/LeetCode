package string;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class LC681NextClosestTime {

    public String nextClosestTime(String time) {
        StringBuilder result = new StringBuilder();
        Set<Integer> digitSet = new TreeSet<>();
        int minDigit = 61;
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            if (c != ':') {
                int d = Integer.parseInt(Character.toString(c));
                digitSet.add(d);
                if (d < minDigit) {
                    minDigit = d;
                }
            }
        }
        for (int i : digitSet) {
            System.out.println(i);
        }
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        boolean found = false;
        DecimalFormat format = new DecimalFormat("00");
        for (int i = minute + 1; i < 60; i++) {
            if (digitSet.contains(i % 10) && digitSet.contains(i / 10)) {
                found = true;
                result.append(format.format(hour)).append(":").append(format.format(i));
                break;
            }
        }
        if (!found) {
            for (int i = hour + 1; i < 24; i++) {
                if (digitSet.contains(i % 10) && digitSet.contains(i / 10)) {
                    found = true;
                    result.append(format.format(i)).append(":").append(minDigit).append(minDigit);
                    break;
                }
            }
        }
        if (!found) {
            // next day
            result.append(minDigit).append(minDigit).append(":").append(minDigit).append(minDigit);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LC681NextClosestTime test = new LC681NextClosestTime();
        String result;

        result = test.nextClosestTime("19:34");
        System.out.println(result);
        assert result.equals("19:39");

        result = test.nextClosestTime("23:59");
        System.out.println(result);
        assert result.equals("22:22");

        result = test.nextClosestTime("01:32");
        System.out.println(result);
        assert result.equals("01:33");

        System.out.println(" ====== Success! =====");
    }
}
