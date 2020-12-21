package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/21.
 * 买卖股票，最多k次
 * 跟买两次类似
 */
public class Num_188 {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0)
            return 0;
        //当k大于数组长度的一半的时候，因为最多交易次数也就是数组长度/2,这个时候就不考虑K了相当于可以无限次交易
        if (k > prices.length / 2)
            return maxProfitMaxK(prices);
        int dp[][][] = new int[prices.length][k + 1][2];
        for (int i = 0; i < prices.length; i++) {
            //这里做一个优化，最多交易次数小于等于prices.length/2
            for (int j = 1; j <= k; j++) {
                //如果第一天，那么单独处理
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                    continue;
                }
                //在前一个持有股票的状态下不做任何处理，
                // 或者买入股票，注意这里买入股票的话，j-1,表示增加了一次交易，记录交易次数
                //当j=1时，dp[i-1][j-1][0]=0,表示前面无交易
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                //当前状态为不持有股票，那么可由前一个不持有股票状态不做任何操作，
                // 或者在前一个持有股票的状态卖掉股票
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }

    public int maxProfitMaxK(int[] prices) {
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
