package week_doublecontest;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zxs666
 * @date 2020/12/12 22:30
 */
public class Num_5609 {

    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray())
            set.add(c);
        for (String str : words) {
            int i = 0;
            while (i < str.length() && set.contains(str.charAt(i)))
                i++;
            if (i == str.length())
                res++;
        }
        return res;
    }
}
