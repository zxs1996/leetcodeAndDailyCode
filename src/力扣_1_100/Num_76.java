package 力扣_1_100;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zxs666
 * @date 2021/2/8 19:26
 */
public class Num_76 {

    @Test
    public void test() {
        String s = "aaaaaaaaaaaabbbbbcdd";
        String t = "abcdd";
        System.out.println(minWindow(s, t));
    }


    public String minWindow(String s, String t) {

        String res = "";

        //记录哪些字符是需要考虑的，比如t是ABC字符，那么对于s中出现的其他字符我们直接跳过不处理就好
        Set<Character> set = new HashSet<>();

        //记录哪些字符是没有满足的
        Set<Character> checkSet = new HashSet<>();

        //记录每个字符的数量当前缺的数量，当为负数时说明有剩余
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            set.add(c);
            checkSet.add(c);
        }

        int start = 0, end = 0;
        while (start < s.length() && end <= s.length() + 1) {

            //checkSet为空，说明子串每个字符都出现了，更新res
            if (checkSet.isEmpty()) {
                if (res.equals("")||end - start < res.length())
                    res = s.substring(start, end);
            }

            char pre = s.charAt(start);
            //如果不是目标字符，那么直接continue
            if (!set.contains(pre)) {
                start++;
                continue;
            }

            //如果start对应的字符在后面还有出现，那么start++
            if (map.get(pre) < 0) {
                start++;
                map.put(pre, map.get(pre) + 1);
            }
            //不满足 ，那么end++
            else if (end < s.length()) {
                char next = s.charAt(end);
                if (set.contains(next)) {
                    map.put(next, map.getOrDefault(next, 0) - 1);
                    if (map.get(next) <= 0)
                        checkSet.remove(next);
                }
                end++;
            } else
                break;
        }
        return res;

    }


}
