package 力扣_501_600;

import org.junit.Test;

/**
 * @author zxs666
 * @date 2020/12/15 23:24
 */
public class Num_518 {

    @Test
    public void test() {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        //各种硬币凑成0的种数为1
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        //不用任何硬币凑结果
        for (int j = 1; j <= amount; j++) dp[0][j] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                //从前一个基础上继承过来
                dp[i][j] = dp[i - 1][j];
                //如果满足
                if (j - coins[i - 1] >= 0) dp[i][j] += dp[i][j - coins[i - 1]];
            }
        }
        return dp[n][amount];
    }


}
