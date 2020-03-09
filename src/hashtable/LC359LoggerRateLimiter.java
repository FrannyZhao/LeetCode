package hashtable;

import java.util.HashMap;
import java.util.HashSet;

public class LC359LoggerRateLimiter {

    static class Logger {
        private HashMap<String, Integer> mTable;
        /** Initialize your data structure here. */
        public Logger() {
            mTable = new HashMap<>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (mTable.containsKey(message)) {
                if (timestamp - mTable.get(message) > 9) {
                    mTable.put(message, timestamp);
                    return true;
                } else {
                    return false;
                }
            } else {
                mTable.put(message, timestamp);
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        boolean result;
        result = logger.shouldPrintMessage(1, "foo");
        System.out.println(result);
        assert result == true;

        result = logger.shouldPrintMessage(2,"bar");
        System.out.println(result);
        assert result == true;

        result = logger.shouldPrintMessage(3,"foo");
        System.out.println(result);
        assert result == false;

        result = logger.shouldPrintMessage(8,"bar");;
        System.out.println(result);
        assert result == false;

        result = logger.shouldPrintMessage(10,"foo");
        System.out.println(result);
        assert result == false;

        result = logger.shouldPrintMessage(11,"foo");;
        System.out.println(result);
        assert result == true;

        System.out.println(" ====== Success! =====");
    }
}
