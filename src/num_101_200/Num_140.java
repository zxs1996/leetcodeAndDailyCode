package num_101_200;

import org.junit.Test;

import java.util.*;

public class Num_140 {

    @Test
    public void test() {
        String s = "catsanddog";

        String[] strs = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = new ArrayList<>();
        for (String str : strs)
            wordDict.add(str);
        List<String> res = wordBreak(s, wordDict);
        for (String str : res)

            System.out.println(str);

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        //先判断能否拆分,如果不能拆分，那么直接返回空数组
        boolean isBreak = isBreak(s, wordDict);
        if (!isBreak)
            return new ArrayList<>();
        List<String> dp[] = new ArrayList[s.length()];
        Map<String, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (String str : wordDict) {
            map.put(str, 1);
            maxLength = Math.max(maxLength, str.length());
        }
        for (int i = 0; i < s.length(); i++)
            dp[i] = new ArrayList<String>();
        //初始化dp[0]
        if (map.containsKey(s.substring(0, 1)))
            dp[0].add(s.substring(0, 1));
        for (int i = 1; i < s.length(); i++) {
            //如果0~i刚好构成一个完整的单词
            if (map.containsKey(s.substring(0, i + 1)))
                dp[i].add(s.substring(0, i + 1));
            for (int j = 0; j < i; j++) {
                //如果i-j超过maxLength，那么一定找不到
                if ((i - j) > maxLength)
                    continue;
                String subStr = s.substring(j + 1, i + 1);
                if (!dp[j].isEmpty() && map.containsKey(subStr)) {
                    for (String sb : dp[j]) {
                        dp[i].add(sb + " " + subStr);
                    }
                }
            }
        }

        return dp[s.length() - 1];
    }

    public boolean isBreak(String s, List<String> wordDict) {
        //将字典中的单词放入map，方便比对
        Map<String, Integer> map = new HashMap<>();
        int maxLength = 0;//记录单个单词的最大长度，可以在时间复杂度上做优化
        for (String str : wordDict) {
            map.put(str, 1);
            maxLength = Math.max(maxLength, str.length());
        }

        //dp[i]表示前i个字符是不是字典拆分
        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, false);
        //初始化第一个字符的状态
        dp[0] = map.containsKey(s.substring(0, 1));
        for (int i = 1; i < s.length(); i++) {
            //先判断一下这个单词 整个是否出现在字典序列中，如果 出现直接设置为true，然后continue
            if (map.containsKey(s.substring(0, i + 1))) {
                dp[i] = true;
                continue;
            }
            //从后往前，并且切割的单词的长度不能大于maxLength
            for (int j = i - 1; j >= 0 && (i - j) <= maxLength; j--) {
                if (dp[j] && map.containsKey(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];

    }
}
