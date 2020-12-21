package 力扣_201_300;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zxs666 on 2020/8/1.
 */
public class Num_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            //如果两个字符都没有出现过
            if (!map.containsKey(c1) && !map2.containsKey(c2)) {
                map.put(c1, i);
                map2.put(c2, i);
            }
            //两个字符均出现
            else if (map.containsKey(c1) && map2.containsKey(c2)) {
                //如果结构不同
                if (map.get(c1) != map2.get(c2))
                    return false;
            } else
                return false;
        }
        return true;

    }
}
