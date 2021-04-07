package 力扣_1_100;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2021/2/3 15:16
 */
public class Num_72 {

    @Test
    public void test1() {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        //dp[i][j]表示word1 前i个字符串转换到word2 前j个字符串所需要的最小次数
        int[][] dp = new int[m + 1][n + 1];
        //初始化两个初值
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        //从1开始
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                //如果当前字符能够匹配，那么转为dp[i-1][j-1]
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                //word1删除一个，相当于word2新增一个，所以dp[i][j]相当于dp[i-1][j] 在word1上新增一个，dp[i][j]相当于dp[i][j-1]在word2上新增一个
                //否则，从三个操作里面选择最少的那个，以word1字符串为基准，三个操作分别为word1新增一个 word2新增（word1删除一个）  替换一个
                 else {
                    dp[i][j] =Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }

        return dp[m][n];

    }
}
