package amino;

/**
 * Convert an IPv4 address in the format of null-terminated C string into a 32-bit integer. 
 * For example, given an IP address “172.168.5.1”, the output should be a 32-bit integer with 
 * “172” as the highest order 8 bit, 168 as the second highest order 8 bit, 
 * 5 as the second lowest order 8 bit, and 1 as the lowest order 8 bit. 
 * That is, "172.168.5.1" => 2896692481 
 * Requirements:
 * 1. You can only iterate the string once.
 * 2. You should handle spaces correctly: 
 *     a string with spaces between a digit and a dot is a valid input; 
 *     while a string with spaces between two digits is not.
 *     "172[Space].[Space]168.5.1" is a valid input. Should process the output normally.
 *     "1[Space]72.168.5.1" is not a valid input. Should report an error. 
 * 3. Please provide unit tests.
 */

public class IPtoNumber {
    public static final long INVALID_INPUT = -1;
    public long ip2Number(String ip) {
        if (ip == null || "".equals(ip)) {
            return INVALID_INPUT;
        }
        long result = 0l;
        int pace = 0;
        int ipLength = ip.length();
        String str = "";
        char preC = ' ';
        for (int i = ipLength - 1; i >= 0; i--) {
            char c = ip.charAt(i);
            if (Character.isDigit(c)) {
                preC = c;
                str = c + str;
            } else if (c == ' ') {
                if (i > 0 && Character.isDigit(preC) && Character.isDigit(ip.charAt(i - 1))) {
                    return INVALID_INPUT;
                }
                continue;
            } else if (c == '.') {
                preC = c;
                if (Long.valueOf(str) > 255) {
                    return INVALID_INPUT;
                }
                result = result | Long.valueOf(str) << (8 * pace);
                str = "";
                pace ++;
            }
        }
        if (Long.valueOf(str) > 255) {
            return INVALID_INPUT;
        }
        result = result | Long.valueOf(str) << (8 * pace);
        return result;
    }
}
