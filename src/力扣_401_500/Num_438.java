package 力扣_401_500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zxs666
 * @date 2021/1/4 20:56
 */
public class Num_438 {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList();
        if(s.length()<p.length())
            return res;
        //用一个数组记录字符出现的次数，当次数为0的时候，表明两个字符串是错序的
        int[] arr = new int[26];
        int len2 = p.length();
        //用p初始arr
        for (char c : p.toCharArray())
            arr[c - 'a']++;

        //用s的前len2个元素更新arr
        for (int i = 0;  i < len2; i++)
            arr[s.charAt(i) - 'a']--;

        //开始循环
        for (int i = 0; ; i++) {
            //如果全部为0,那么匹配上
            if (check(arr))
                res.add(i);
            //如果超过了边界，退出
            if (i + len2 >= s.length())
                break;
            //将前面的字符移出去
            arr[s.charAt(i) - 'a']++;
            //将后面的字符加进来
            arr[s.charAt(i + len2) - 'a']--;
        }
        return res;

    }


    //用map来实现，理论应该更快，但是好慢啊。
    public List<Integer> findAnagrams2(String s, String p) {

        List<Integer> res = new ArrayList();
        Map<Character, Integer> map = new HashMap<>();
        int len2 = p.length();
        for (char c : p.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (int i = 0; i < s.length() && i < len2; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) == 0)
                map.remove(c);
        }



        for (int i = 0; ; i++) {
            //如果map为空，说明字符刚好匹配
            if (map.isEmpty())
                res.add(i);
            //如果超过了边界
            if (i + len2 >= s.length())
                break;

            char removeChar = s.charAt(i);
            char addChar = s.charAt(i + len2);
            //移除一个
            map.put(removeChar, map.getOrDefault(removeChar, 0) + 1);
            if (map.get(removeChar) == 0)
                map.remove(removeChar);
            //后面再加一个
            map.put(addChar, map.getOrDefault(addChar, 0) - 1);
            if (map.get(addChar) == 0)
                map.remove(addChar);
        }
        return res;

    }

    public boolean check(int[] arr) {
        for (int num : arr)
            if (num != 0)
                return false;
        return true;
    }
}
