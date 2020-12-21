package 力扣_301_400;

/**
 * Created by zxs666 on 2020/7/21.
 */
public class Num_309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int[][] dp = new int[prices.length][3];
        //dp[i][j]表示第i天j状态的最大利益。
        //j =0 表示未持股，j=1 持股 j=2 冷冻期
        dp[0][0] = 0;//第一天不持有股票
        dp[0][1] = -prices[0];//第一天购入股票
        dp[0][2] = 0;//刚开始冷冻期
        for (int i = 1; i < prices.length; i++) {
            //不持有股票只能从前一天不持有得到或者卖出股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //持股要么从前面保持，要么从冷冻期来
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = dp[i - 1][0];//冷冻期只能从不持股状态得来
        }
        //返回冷冻期和不持股的最大值
        return Math.max(dp[prices.length - 1][0],dp[prices.length-1][2]);
    }
}
