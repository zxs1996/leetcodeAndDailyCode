package 力扣_1_100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zxs666
 * @date 2021/1/29 15:52
 * 滑动窗口，左侧值每当出现重复的字符时，更新滑动窗口的左侧，注意更新的时候要取一个较大值
 */
public class Num_3 {

    @Test
    public void test() {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            //如果这个字符之前已经出现，那么起点需要修改为start和这个字符之前出现的位置的后一个里面选择一个较大值
            //更新滑动窗口，注意更新的时候要在start和map.get(c) + 1里面取较大值
            if (map.containsKey(c))
                start = Math.max(start, map.get(c) + 1);
            map.put(c, i);
            System.out.println(i + "---" + start);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
