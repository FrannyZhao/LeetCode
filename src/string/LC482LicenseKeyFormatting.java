package string;

public class LC482LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c != '-') {
                sb.append(c);
                count ++;
                if (count == K) {
                    sb.append("-");
                    count = 0;
                }
            }
        }
        String result = sb.reverse().toString().toUpperCase();
        if (result.startsWith("-")) {
            result = result.substring(1);
        }
        return result;
    }

    public static void main(String[] args) {
        LC482LicenseKeyFormatting test = new LC482LicenseKeyFormatting();
        String result;

        result = test.licenseKeyFormatting("5F3Z-2e-9-w", 4);
        System.out.println(result);
        assert result.equals("5F3Z-2E9W");

        result = test.licenseKeyFormatting("2-5g-3-J", 2);
        System.out.println(result);
        assert result.equals("2-5G-3J");

        result = test.licenseKeyFormatting("--a-a-a-a--", 2);
        System.out.println(result);
        assert result.equals("AA-AA");

        result = test.licenseKeyFormatting("---", 3);
        System.out.println(result);
        assert result.equals("");

        System.out.println(" ====== Success! =====");
    }
}
