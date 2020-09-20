package string;

import java.util.Set;
import java.util.TreeSet;

public class LC929UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> dict = new TreeSet<>();
        String localName, domainName;
        String[] names;
        for (String email : emails) {
            names = email.split("@");
            localName = names[0];
            domainName = names[1];
            localName = localName.split("\\+")[0];
            localName = localName.replace(".", "");
            email = localName + "@" + domainName;
            dict.add(email);
        }
        for (String s : dict) {
            System.out.println(s);
        }
        return dict.size();
    }

    public static void main(String[] args) {
        LC929UniqueEmailAddresses test = new LC929UniqueEmailAddresses();
        int result;

        result = test.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
        System.out.println("result " + result);
        assert result == 2;

        result = test.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"});
        System.out.println("result " + result);
        assert result == 2;
        System.out.println(" ====== Success! =====");
    }
}
