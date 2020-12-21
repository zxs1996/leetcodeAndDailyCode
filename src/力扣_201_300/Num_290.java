package 力扣_201_300;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num_290 {
    @Test
    public void demo() {
        String pattern = "abba";
        String s = "cat dog dog cat";
        System.out.println(wordPattern(pattern, s));
    }

    public boolean wordPattern(String pattern, String s) {

        String[] strs = s.split(" ");
        System.out.println(Arrays.toString(strs));
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> mapCheck = new HashMap<>();
        if (pattern.length() != strs.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            //如果这个规律字符已经出现过
            if (map.containsKey(c)) {
                if (strs[i].equals(map.get(c)))
                    continue;
                else
                    return false;
            } else {
                if(mapCheck.containsKey(strs[i]))
                    return false;
                map.put(c, strs[i]);
                mapCheck.put(strs[i],c);

            }

        }
        return true;
    }
}
