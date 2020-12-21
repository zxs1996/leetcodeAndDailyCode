package 力扣_1_100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxs666
 * @date 2020/11/13 19:14
 * <p>
 * 递归思路：将每个字符串分别切割成两个子串，然后比较这个子串，这个过程一直递归地执行下去
 */
public class Num_87 {


    @Test
    public void test() {
        String s1 = "abcdbdacbdac";
        String s2 = "bdacabcdbdac";
        System.out.println(isScramble(s1, s2));
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        return recurse(s1, s2);
    }

    public boolean recurse(String s1, String s2) {
        //System.out.println(s1 + "--" + s2);
        if (s1.equals(s2))
            return true;

        //如果串他们的字符数量都不等，那么一定不可能是打乱的。直接返回false
        if (!compare(s1, s2))
            return false;
        //按照长度从1到length划分成两半
        for (int i = 1; i < s1.length(); i++) {

            /*
            每种划分有两种可能情况，只要任意一种情况成立那么就可以
                    --前前 后后
                    --前后 前后
             */
            boolean res1 = recurse(s1.substring(0, i), s2.substring(0, i)) && recurse(s1.substring(i), s2.substring(i));
            boolean res2 = recurse(s1.substring(0, i), s2.substring(s1.length() - i)) && recurse(s1.substring(i), s2.substring(0, s1.length() - i));
            if (res1 || res2)
                return true;
        }
        return false;

    }


    public boolean compare(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : s1.toCharArray())
            map1.put(c, map1.getOrDefault(c, 0) + 1);

        for (char c : s2.toCharArray())
            map2.put(c, map2.getOrDefault(c, 0) + 1);

        for (Character c : map1.keySet()) {
            if (!map2.containsKey(c) || map2.get(c) != map1.get(c))
                return false;
        }
        return true;

    }


}
