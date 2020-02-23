package FaceBookQuestions;

/**
 * https://leetcode.com/problems/integer-to-english-words/
 * Convert a non-negative integer to its english words representation. 
 * Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class NumbersToWords {
    private final static String[] digits = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final static String[] tenToTwenty = new String[]{"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final static String[] tens = new String[]{"", "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final static String[] units = new String[]{"Hundred", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        String result = "";
        
        
        
        
        return result;
    }
    
    private String handleThousand(int num) {
        String result = "";
        if (num != 0) {
            if (num % 100 < 20) {
                result = digits[num % 100];
            } else {
                result = digits[num % 100];
            }
            
            
        }
        return result;
    }
}
