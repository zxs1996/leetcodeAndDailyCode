package 力扣_501_600;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zxs666
 * @date 2020/12/15 23:24
 */
public class Num_518 {

    @Test
    public void test() {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }

    /**
     * 使用二维背包
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        //dp[i][j]表示使用i种硬币凑成j块钱的组合数
        int[][] dp = new int[n + 1][amount + 1];
        //各种硬币凑成0的种数为1
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        //不用任何硬币凑结果，初始化
        for (int j = 1; j <= amount; j++) dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            //从coins[j-1]开始往后循环
            for (int j = coins[i-1]; j <= amount; j++) {
                //从前一个基础上继承过来
                dp[i][j] = dp[i - 1][j];

                dp[i][j] += dp[i][j - coins[i - 1]];
            }
        }
        return dp[n][amount];

    }

    /**
     * 使用一维背包
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change2(int amount, int[] coins) {
        int n = coins.length;
        //dp[j]表示使用当前硬币凑成j块钱的方法数
        int[] dp = new int[amount + 1];
        //各种硬币凑成0的种数为1
        dp[0] = 1;

        //外层循环硬币数，内层循环钱数
        for (int i = 0; i < n; i++) {
            //j一定是从前到后，并且j从coins[i]开始，因为j<coins[i]时，一定不能使用这个硬币
            for (int j = coins[i]; j <= amount; j++) {
                //等于之前的组合数+使用当前硬币的，注意这里硬币的使用次数隐式给出
                //比如使用5的时候，
                // dp[5]=dp[5]+dp[0]
                // dp[10]=dp[10]+dp[5],相当于使用了2次5块硬币
                // dp[15]=dp[15]+dp[10],相当于使用了3次5块硬币
                dp[j] +=  dp[j - coins[i]];
            }
        }
        return dp[amount];
    }


}
