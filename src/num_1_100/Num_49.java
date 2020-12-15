package num_1_100;

import org.junit.Test;

import java.util.*;

/**
 * @author zxs666
 * @date 2020/12/14 10:08
 */
public class Num_49 {
    @Test
    public void test(){}

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String str2 =String.valueOf(arr);
            System.out.println(str2);
            List<String> list;
            if (map.containsKey(str2))
                list = map.get(str2);
            else
                list = new ArrayList<>();
            list.add(str);
            map.put(str2, list);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet())
            res.add(entry.getValue());
        return res;
    }
}
