package _3_com.ds.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Example 1:
 * <p>
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * <p>
 * Example 2:
 * <p>
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * <p>
 * Example 3:
 * <p>
 * Input: s = "1111"
 * Output: ["1.1.1.1"]
 * <p>
 * Example 4:
 * <p>
 * Input: s = "010010"
 * Output: ["0.10.0.10","0.100.1.0"]
 *
 * https://www.youtube.com/watch?v=JfB3BugMht8
 */

public class _8_RestoreIP {

    List<String> ret = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        getAllPos(s, 0, "", 0);
        return ret;
    }

    public void getAllPos(String s, int index, String current, int count) {

        if (count > 4)
            return;

        if (index >= s.length()) {
            if (count == 4)
                ret.add(current.substring(0, current.length() - 1));
            return;
        }

        for (int i = index + 1; i <= index + 3 && i <= s.length(); i++) {

            String substr = s.substring(index, i);
            int val = Integer.valueOf(substr);

            if (val <= 255 && val >= 0) {
             //   if (substr.length() > 1 && substr.charAt(0) == '0')
                   // continue;
                getAllPos(s, i, current + substr + ".", count + 1);
            }
        }
    }

    public static void main(String[] args) {
        _8_RestoreIP restoreIP = new _8_RestoreIP();
    }
}
