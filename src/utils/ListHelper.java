package utils;

import java.util.ArrayList;
import java.util.List;

public class ListHelper {
    public List<Integer> str2List(String str) {
        List<Integer> list = new ArrayList<>();
        if (str != null && str.length() > 2) {
            String s = str.substring(1, str.length() - 1);
            String[] ss = s.split(",");
            for (String value : ss) {
                list.add(Integer.parseInt(value.trim()));
            }
        }
        return list;
    }

    public String listList2Str(List<List<Integer>> list) {
        StringBuilder result = new StringBuilder("[");
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                result.append(list2Str(list.get(i)));
                if (i != list.size() - 1) {
                    result.append(",");
                }
            }
        }
        result.append("]");
        return result.toString();
    }

    public String list2Str(List<Integer> list) {
        StringBuilder result = new StringBuilder("[");
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                result.append(list.get(i));
                if (i != list.size() - 1) {
                    result.append(",");
                }
            }
        }
        result.append("]");
        return result.toString();
    }
}
