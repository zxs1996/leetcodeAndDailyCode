package 力扣_301_400;


import org.junit.Test;

import java.util.Arrays;

//使用贪心加+dfs做
public class Num_322_2 {
    int res;
    int[] coins;

    @Test
    public void test() {
        int[] coins = {470, 18, 66, 301, 403, 112, 360};
        System.out.println(coinChange(coins, 8235));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        this.coins = coins;
        this.res = Integer.MAX_VALUE;
        dfs(coins.length - 1, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void dfs(int start, int amount, int count) {
        //这个在start判断之前执行
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (start < 0)
            return;

        //注意这里做一个剪枝，当i+count<res的情况才往下递归，不然就直接结束
        for (int i = amount / coins[start]; i >= 0 && i + count < res; i--) {
            //找更小面值的硬币
            dfs(start - 1, amount - i * coins[start], count + i);
        }


    }


    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        //dp[amount]表示凑amount需要的最少硬币
        int[] dp = new int[amount + 1];
        int INIT_MAX = amount + 1;
        Arrays.fill(dp, INIT_MAX);//初始成amout+1，这个值很大
        dp[0] = 0;//凑0块钱需要0块硬币
        //使用前i种硬币
        for (int i = 1; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++)
                dp[j] = Math.min(dp[j], dp[i - coins[j]] + 1);
        }
        return dp[amount] == INIT_MAX ? -1 : dp[amount];

    }


}
