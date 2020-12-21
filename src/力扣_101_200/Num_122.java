package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/21.
 * 可以重复购买股票
 * 贪心算法：只要明天的价格比今天高，那么就买
 */
public class Num_122 {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i])
                max += prices[i + 1] - prices[i];
        }
        return max;
    }

    //dp 使用二维数组
    public int maxProfit2(int[] prices) {
        if (prices.length == 0)
            return 0;
        int dp[][] = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            //如果i==0,特殊处理
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);//保持之前的购买，或者在前一个的基础上买入，所以是-prices[i]
        }
        return dp[prices.length - 1][0];
    }

    //dp 使用常数空间
    public int maxProfit3(int[] prices) {
        if (prices.length == 0)
            return 0;
        int dp_0 = 0, dp_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = dp_0;//保存前面的dp_0
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, temp - prices[i]);//保持之前的购买，或者在前一个的基础上买入，所以是temp-prices[i]
        }
        return dp_0;
    }
}
