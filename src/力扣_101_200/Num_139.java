package 力扣_101_200;

import org.junit.Test;

import java.util.*;

public class Num_139 {
    @Test
    public void test(){
        List<String> list=new ArrayList<>();
    }
    public boolean wordBreak(String s, List<String> wordDict) {
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
