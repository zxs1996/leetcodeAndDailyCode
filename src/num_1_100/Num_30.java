package num_1_100;

import java.util.*;

/**
 * Created by zxs666 on 2020/6/27.
 */
public class Num_30 {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String words[] = {"word", "good", "best", "good"};
        List<Integer> list = new Num_30().findSubstring2(s, words);
        for (Integer i : list)
            System.out.print(i + " ");
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        if (words.length == 0 || words[0].length() == 0)
            return ans;
        int wordLength = words[0].length();
        int arrayLength = words.length;
        boolean flag[] = new boolean[arrayLength];
        //计算每一个单词出现的位置,放入hashMap
        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < arrayLength; j++) {
                int index = s.indexOf(words[j], i);
                if (index != -1)
                    map.put(index, j);
            }
        for (Integer key : map.keySet()) {
            System.out.println(key + "--" + map.get(key));
        }
        for (Integer key : map.keySet()) {
            //初始标志数组flag
            Arrays.fill(flag, true);
            int temp = key;
            flag[map.get(key)] = false;
            //找剩下的单词
            for (int i = 0; i < arrayLength - 1; i++) {
                key = key + wordLength;
                if (map.containsKey(key))
                    flag[map.get(key)] = false;
            }
            int i;
            for (i = 0; i < arrayLength; i++) {
                if (flag[i])
                    break;
            }
            //说明全是false，即找到了一个起点
            if (i == arrayLength)
                ans.add(temp);
            Arrays.fill(flag, true);
        }


        return ans;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        if (words.length == 0 || words[0].length() == 0)
            return ans;
        int wordLength = words[0].length();//每个单词长度
        int arrayLength = words.length;//单词个数
        //将单词放到map里面去
        for (int i = 0; i < arrayLength; i++) {
            if (map.containsKey(words[i])) {
                int value = map.get(words[i]);
                map.replace(words[i], ++value);
            } else
                map.put(words[i], 1);
        }
        for (int i = 0; i < s.length(); i++) {
            int start = i;
            Map<String, Integer> map2 = new HashMap<String, Integer>();
            map2.putAll(map);
            int j = 0;
            for (j = 0; j < arrayLength; j++) {
                if (start + wordLength > s.length())
                    break;
                String str = s.substring(start, start + wordLength);
                if (map.containsKey(str)) {
                    start += wordLength;
                    int value = map.get(str);
                    if (value > 1)
                        map.replace(str, --value);
                    else
                        map.remove(str);
                } else
                    break;
            }
            if (j == arrayLength)
                ans.add(i);
            map = map2;
        }
        return ans;
    }
}
