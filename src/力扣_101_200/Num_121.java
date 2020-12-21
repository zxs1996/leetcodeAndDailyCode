package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/21.
 */
public class Num_121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int max = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            //如果当天价格比买入价格高
            if (prices[i] > buyPrice) {
                max = Math.max(max, prices[i] - buyPrice);
            }
            //如果更低，那么刷新买入价格
            else
                buyPrice = prices[i];
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
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);//只能买入一次，所以是-prices[i]
        }
        return dp[prices.length - 1][0];
    }


    //dp 使用O（1）
    public int maxProfit3(int[] prices) {
        if (prices.length == 0)
            return 0;
        int dp_0 = 0, dp_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //如果i==0,特殊处理
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, -prices[i]);//只能买入一次，所以是-prices[i]
        }
        return dp_0;
    }
}
