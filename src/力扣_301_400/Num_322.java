package 力扣_301_400;

import org.junit.Test;

import java.util.Arrays;

//这里使用动态规划做
public class Num_322 {
    @Test
    public void test1() {
        System.out.println(waysToChange(5));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        //开辟dp数组，dp[i]表示组成i所需要的最少的硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 100000);//初始成一个足够大的值
        //初始dp[0]=0，表示组合成0元面值，最少需要0枚硬币
        dp[0] = 0;
        //循环面值
        for (int i = 1; i <= amount; i++)
            //循环硬币
            for (int j = 0; j < coins.length; j++) {
                //当前硬币面值小于等于i，那么才进行判断
                if (coins[j] <= i && dp[i - coins[j]] + 1 < dp[i])
                    dp[i] = dp[i - coins[j]] + 1;
            }
        for (int i = 1; i <= amount; i++)
            System.out.print(dp[amount] + "  ");
        return dp[amount] == 100000 ? -1 : dp[amount];
    }


    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        //开辟dp数组，dp[i]表示组成i所需要的最少的硬币数
        int[] dp = new int[amount + 1];
        int  INIT_MAX=amount+1;
        Arrays.fill(dp, INIT_MAX);//初始成amout+1，这个值很大
        //初始dp[0]=0，表示组合成0元面值，最少需要0枚硬币
        dp[0] = 0;
        //循环硬币
        for (int i = 0; i < coins.length; i++)
            //循环面值
            for (int j = coins[i]; j <= amount; j++)
                dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);

        for (int i = 1; i <= amount; i++)
            System.out.print(dp[amount] + "  ");
        return dp[amount] == INIT_MAX ? -1 : dp[amount];
    }


    //两层循环,隐式的表达每种硬币的使用次数，比如当前使用币值为5时
    //dp[5]=dp[5]+dp[0]
    //dp[6]=dp[6]+dp[1]
    //dp[7]=dp[7]+dp[2]
    //dp[8]=dp[8]+dp[3]
    //dp[9]=dp[9]+dp[4]
    //dp[10]=dp[10]+dp[5]//这里的dp[5]已经使用了一次5面值的硬币
    public int waysToChange(int n) {
        int[] coins = {1, 5, 10, 25};
        //dp[i]表示组合成i面值的方案数
        int[] dp = new int[n + 1];
        //初始化dp[0],组合成0面值的有一种方案，即什么都不选,
        dp[0] = 1;

        //循环每一种面值硬币
        for (int i = 0; i < coins.length; i++) {
            //目标为j,这里一定要从前到后
            for (int j = coins[i]; j <= n; j++)
                dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;//当前的方案，加上j-coins[i]的方案

        }
        return dp[n] % 1000000007;
    }


    //里面三层嵌套循环，容易理解，但是时间复杂度高.会超时
    public int waysToChange3(int n) {
        int[] coins = {1, 5, 10, 25};
        int[][] dp = new int[coins.length][n + 1];
        //初始化dp[0][x]，初始化只用第一种硬币组合的情况
        for (int i = 0; i <= n; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = 1;
        }
        //前i种硬币
        for (int i = 1; i < coins.length; i++) {
            //组合的面额值
            for (int j = 0; j <= n; j++)
                //选择当前硬币i的数量
                for (int k = 0; k <= j / coins[i]; k++)
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k * coins[i]]) % 1000000007;
        }
        return dp[coins.length - 1][n] % 1000000007;
    }


}
