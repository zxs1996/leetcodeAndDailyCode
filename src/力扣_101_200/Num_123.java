package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/21.
 */
public class Num_123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int max_k = 2;
        int dp[][][] = new int[prices.length][max_k + 1][2];

        for (int i = 0; i < prices.length; i++) {
            for (int k = 1; k <= max_k; k++) {
                //如果第一天，那么单独处理
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                    continue;
                }
                //当前状态为不持有股票，那么可由前一个不持有股票状态不做任何操作，
                // 或者在前一个持有股票的状态卖掉股票
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                //在前一个持有股票的状态下不做任何处理，
                // 或者买入股票，注意这里买入股票的话，k-1,表示增加了一次交易，记录交易次数
                //当k=1时，dp[i-1][k-1][0]=0,表示前面无交易
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][max_k][0];
    }

}
