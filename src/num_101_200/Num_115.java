package num_101_200;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/11/7 22:27
 * 动态规划
 * dp[i][j]的含义：截取t从0到j的子串t1，截取s从0到i的子串s1
 * dp[i][j]表示t1在s1中的子序列的个数。
 * 状态转换：
 * 每一次循环：dp[i][j]=dp[i-1][j]
 * 如果s[i]==t[j]，那么可以用前面的状态来转移，
 *                   --当j==1的时候，这是一个边界条件 dp[i][j]=1
 *                   --否则 dp[i][j]=dp[i][j]+dp[i-1][j-1]
 */
public class Num_115 {


    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];//开辟dp数组
        for (int j = 1; j <= n; j++)
            for (int i = 1; i <= m; i++) {
                dp[i][j] = dp[i - 1][j];//dp[i-1][j]的结果一定包含在dp[i][j]里面
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    if (j == 1)
                        dp[i][j] +=1;//一定是+1，不是等于1
                    else
                        dp[i][j] += dp[i - 1][j - 1];
                }
            }
        return dp[m][n];
    }

    @Test
    public void test() {
        int res = numDistinct("", "a");
        System.out.println(res);
    }
}
